/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hive.ql.exec.vector.mapjoin;

import org.apache.hadoop.hive.ql.CompilationOpContext;
import org.apache.hadoop.hive.ql.exec.JoinUtil;
import org.apache.hadoop.hive.ql.exec.vector.LongColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.VectorizationContext;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.apache.hadoop.hive.ql.exec.vector.expressions.VectorExpression;
import org.apache.hadoop.hive.ql.exec.vector.mapjoin.hashtable.VectorMapJoinLongHashSet;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.plan.OperatorDesc;
import org.apache.hadoop.hive.ql.plan.VectorDesc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

// TODO : Duplicate codes need to merge with semi join.
// Single-Column Long hash table import.
// Single-Column Long specific imports.

/*
 * Specialized class for doing a vectorized map join that is an anti join on a Single-Column Long
 * using a hash set.
 */
public class VectorMapJoinAntiJoinLongOperator extends VectorMapJoinAntiJoinGenerateResultOperator {

  private static final long serialVersionUID = 1L;
  private static final String CLASS_NAME = VectorMapJoinAntiJoinLongOperator.class.getName();
  private static final Logger LOG = LoggerFactory.getLogger(CLASS_NAME);
  protected String getLoggingPrefix() {
    return super.getLoggingPrefix(CLASS_NAME);
  }

  // The above members are initialized by the constructor and must not be
  // transient.

  // The hash map for this specialized class.
  private transient VectorMapJoinLongHashSet hashSet;

  // Single-Column Long specific members.
  // For integers, we have optional min/max filtering.
  private transient boolean useMinMax;
  private transient long min;
  private transient long max;

  // The column number for this one column join specialization.
  private transient int singleJoinColumn;

  // Pass-thru constructors.
  /** Kryo ctor. */
  protected VectorMapJoinAntiJoinLongOperator() {
    super();
  }

  public VectorMapJoinAntiJoinLongOperator(CompilationOpContext ctx) {
    super(ctx);
  }

  public VectorMapJoinAntiJoinLongOperator(CompilationOpContext ctx, OperatorDesc conf,
                                           VectorizationContext vContext, VectorDesc vectorDesc) throws HiveException {
    super(ctx, conf, vContext, vectorDesc);
  }

  // Process Single-Column Long Anti Join on a vectorized row batch.
  @Override
  protected void commonSetup() throws HiveException {
    super.commonSetup();

    // Initialize Single-Column Long members for this specialized class.
    singleJoinColumn = bigTableKeyColumnMap[0];
  }

  @Override
  public void hashTableSetup() throws HiveException {
    super.hashTableSetup();

    // Get our Single-Column Long hash set information for this specialized class.
    hashSet = (VectorMapJoinLongHashSet) vectorMapJoinHashTable;
    useMinMax = hashSet.useMinMax();
    if (useMinMax) {
      min = hashSet.min();
      max = hashSet.max();
    }
  }

  @Override
  public void processBatch(VectorizedRowBatch batch) throws HiveException {

    try {
      // (Currently none)
      // antiPerBatchSetup(batch);

      // For anti joins, we may apply the filter(s) now.
      for(VectorExpression ve : bigTableFilterExpressions) {
        ve.evaluate(batch);
      }

      final int inputLogicalSize = batch.size;
      if (inputLogicalSize == 0) {
        return;
      }

      // Perform any key expressions.  Results will go into scratch columns.
      if (bigTableKeyExpressions != null) {
        for (VectorExpression ve : bigTableKeyExpressions) {
          ve.evaluate(batch);
        }
      }

      // The one join column for this specialized class.
      LongColumnVector joinColVector = (LongColumnVector) batch.cols[singleJoinColumn];
      long[] vector = joinColVector.vector;

      // Check single column for repeating.
      boolean allKeyInputColumnsRepeating = joinColVector.isRepeating;

      if (allKeyInputColumnsRepeating) {
        // All key input columns are repeating.  Generate key once.  Lookup once.
        // Since the key is repeated, we must use entry 0 regardless of selectedInUse.
        JoinUtil.JoinResult joinResult;
        if (!joinColVector.noNulls && joinColVector.isNull[0]) {
          // For anti join, if the right side is null then its a match.
          joinResult = JoinUtil.JoinResult.MATCH;
        } else {
          long key = vector[0];
          if (useMinMax && (key < min || key > max)) {
            // Out of range for whole batch. Its a match for anti join. We can emit the row.
            joinResult = JoinUtil.JoinResult.MATCH;
          } else {
            joinResult = hashSet.contains(key, hashSetResults[0]);
            // reverse the join result for anti join.
            if (joinResult == JoinUtil.JoinResult.NOMATCH) {
              joinResult = JoinUtil.JoinResult.MATCH;
            } else if (joinResult == JoinUtil.JoinResult.MATCH) {
              joinResult = JoinUtil.JoinResult.NOMATCH;
            }
          }
        }

        // Common repeated join result processing.
        if (LOG.isDebugEnabled()) {
          LOG.debug(CLASS_NAME + " batch #" + batchCounter + " repeated joinResult " + joinResult.name());
        }
        finishAntiRepeated(batch, joinResult, hashSetResults[0]);
      } else {
        // NOT Repeating.

        if (LOG.isDebugEnabled()) {
          LOG.debug(CLASS_NAME + " batch #" + batchCounter + " non-repeated");
        }

        // We remember any matching rows in matches / matchSize.  At the end of the loop,
        // selected / batch.size will represent both matching and non-matching rows for outer join.
        // Only deferred rows will have been removed from selected.
        int selected[] = batch.selected;
        boolean selectedInUse = batch.selectedInUse;

        int hashSetResultCount = 0;
        int allMatchCount = 0;
        int spillCount = 0;
        long saveKey = 0;

        // We optimize performance by only looking up the first key in a series of equal keys.
        boolean haveSaveKey = false;
        JoinUtil.JoinResult saveJoinResult = JoinUtil.JoinResult.NOMATCH;

        // Logical loop over the rows in the batch since the batch may have selected in use.
        for (int logical = 0; logical < inputLogicalSize; logical++) {
          int batchIndex = (selectedInUse ? selected[logical] : logical);

          // Single-Column Long get key.
          long currentKey;
          boolean isNull;
          if (!joinColVector.noNulls && joinColVector.isNull[batchIndex]) {
            currentKey = 0;
            isNull = true;
          } else {
            currentKey = vector[batchIndex];
            isNull = false;
          }

          // Equal key series checking.
          if (isNull || !haveSaveKey || currentKey != saveKey) {
            // New key.
            if (haveSaveKey) {
              // Move on with our counts.
              switch (saveJoinResult) {
              case MATCH:
                // We have extracted the existence from the hash set result, so we don't keep it.
                break;
              case SPILL:
                // We keep the hash set result for its spill information.
                hashSetResultCount++;
                break;
              case NOMATCH:
                break;
              }
            }

            if (isNull) {
              saveJoinResult = JoinUtil.JoinResult.MATCH;
              haveSaveKey = false;
            } else {
              // Regardless of our matching result, we keep that information to make multiple use
              // of it for a possible series of equal keys.
              haveSaveKey = true;
              saveKey = currentKey;
              if (useMinMax && (currentKey < min || currentKey > max)) {
                // Key out of range for whole hash table, is a valid match for anti join.
                saveJoinResult = JoinUtil.JoinResult.NOMATCH;
              } else {
                saveJoinResult = hashSet.contains(currentKey, hashSetResults[hashSetResultCount]);
              }

              // Reverse the match result for anti join.
              if (saveJoinResult == JoinUtil.JoinResult.NOMATCH) {
                saveJoinResult = JoinUtil.JoinResult.MATCH;
              } else if (saveJoinResult == JoinUtil.JoinResult.MATCH) {
                saveJoinResult = JoinUtil.JoinResult.NOMATCH;
              }
            }

            // Common anti join result processing.
            switch (saveJoinResult) {
            case MATCH:
              allMatchs[allMatchCount++] = batchIndex;
              // VectorizedBatchUtil.debugDisplayOneRow(batch, batchIndex, CLASS_NAME + " MATCH isSingleValue " + equalKeySeriesIsSingleValue[equalKeySeriesCount] + " currentKey " + currentKey);
              break;

            case SPILL:
              spills[spillCount] = batchIndex;
              spillHashMapResultIndices[spillCount] = hashSetResultCount;
              spillCount++;
              break;

            case NOMATCH:
              // VectorizedBatchUtil.debugDisplayOneRow(batch, batchIndex, CLASS_NAME + " NOMATCH" + " currentKey " + currentKey);
              break;
            }
          } else {
            // Series of equal keys.
            switch (saveJoinResult) {
            case MATCH:
              allMatchs[allMatchCount++] = batchIndex;
              // VectorizedBatchUtil.debugDisplayOneRow(batch, batchIndex, CLASS_NAME + " MATCH duplicate");
              break;

            case SPILL:
              spills[spillCount] = batchIndex;
              spillHashMapResultIndices[spillCount] = hashSetResultCount;
              spillCount++;
              break;

            case NOMATCH:
              // VectorizedBatchUtil.debugDisplayOneRow(batch, batchIndex, CLASS_NAME + " NOMATCH duplicate");
              break;
            }
          }
        }

        if (haveSaveKey) {
          // Update our counts for the last key.
          switch (saveJoinResult) {
          case MATCH:
            // We have extracted the existence from the hash set result, so we don't keep it.
            break;
          case SPILL:
            // We keep the hash set result for its spill information.
            hashSetResultCount++;
            break;
          case NOMATCH:
            break;
          }
        }

        if (LOG.isDebugEnabled()) {
          LOG.debug(CLASS_NAME +
              " allMatchs " + intArrayToRangesString(allMatchs, allMatchCount) +
              " spills " + intArrayToRangesString(spills, spillCount) +
              " spillHashMapResultIndices " + intArrayToRangesString(spillHashMapResultIndices, spillCount) +
              " hashMapResults " + Arrays.toString(Arrays.copyOfRange(hashSetResults, 0, hashSetResultCount)));
        }

        finishAnti(batch, allMatchCount, spillCount, hashSetResults);
      }

      if (batch.size > 0) {
        // Forward any remaining selected rows.
        forwardBigTableBatch(batch);
      }

    } catch (Exception e) {
      throw new HiveException(e);
    }
  }
}
