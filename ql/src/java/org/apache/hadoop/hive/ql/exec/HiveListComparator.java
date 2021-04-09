/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hive.ql.exec;


import org.apache.hadoop.hive.ql.util.NullOrdering;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;
import java.util.ArrayList;

public class HiveListComparator extends HiveWritableComparator {
    // For List, all elements will have same type, so only one comparator is sufficient.
    WritableComparator comparator = null;

    HiveListComparator(boolean nullSafe, NullOrdering nullOrdering) {
        super(nullSafe, nullOrdering);
    }

    @Override
    public int compare(Object key1, Object key2) {
        int result = checkNull(key1, key2);
        if (result != not_null) {
            return result;
        }
        ArrayList a1 = (ArrayList) key1;
        ArrayList a2 = (ArrayList) key2;
        if (a1.size() != a2.size()) {
            return a1.size() > a2.size() ? 1 : -1;
        }
        if (a1.size() == 0) {
            return 0;
        }

        if (comparator == null) {
            // For List, all elements should be of same type.
            comparator = WritableComparatorFactory.get(a1.get(0), nullSafe, nullOrdering);
        }

        result = 0;
        for (int i = 0; i < a1.size(); i++) {
            result = comparator.compare(a1.get(i), a2.get(i));
            if (result != 0) {
                return result;
            }
        }
        return result;
    }
}

