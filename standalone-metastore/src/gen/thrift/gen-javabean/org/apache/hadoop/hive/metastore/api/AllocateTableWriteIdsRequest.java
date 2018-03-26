/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.hadoop.hive.metastore.api;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)")
@org.apache.hadoop.classification.InterfaceAudience.Public @org.apache.hadoop.classification.InterfaceStability.Stable public class AllocateTableWriteIdsRequest implements org.apache.thrift.TBase<AllocateTableWriteIdsRequest, AllocateTableWriteIdsRequest._Fields>, java.io.Serializable, Cloneable, Comparable<AllocateTableWriteIdsRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("AllocateTableWriteIdsRequest");

  private static final org.apache.thrift.protocol.TField TXN_IDS_FIELD_DESC = new org.apache.thrift.protocol.TField("txnIds", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField DB_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("dbName", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField TABLE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("tableName", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new AllocateTableWriteIdsRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new AllocateTableWriteIdsRequestTupleSchemeFactory());
  }

  private List<Long> txnIds; // required
  private String dbName; // required
  private String tableName; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TXN_IDS((short)1, "txnIds"),
    DB_NAME((short)2, "dbName"),
    TABLE_NAME((short)3, "tableName");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TXN_IDS
          return TXN_IDS;
        case 2: // DB_NAME
          return DB_NAME;
        case 3: // TABLE_NAME
          return TABLE_NAME;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TXN_IDS, new org.apache.thrift.meta_data.FieldMetaData("txnIds", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64))));
    tmpMap.put(_Fields.DB_NAME, new org.apache.thrift.meta_data.FieldMetaData("dbName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TABLE_NAME, new org.apache.thrift.meta_data.FieldMetaData("tableName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(AllocateTableWriteIdsRequest.class, metaDataMap);
  }

  public AllocateTableWriteIdsRequest() {
  }

  public AllocateTableWriteIdsRequest(
    List<Long> txnIds,
    String dbName,
    String tableName)
  {
    this();
    this.txnIds = txnIds;
    this.dbName = dbName;
    this.tableName = tableName;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public AllocateTableWriteIdsRequest(AllocateTableWriteIdsRequest other) {
    if (other.isSetTxnIds()) {
      List<Long> __this__txnIds = new ArrayList<Long>(other.txnIds);
      this.txnIds = __this__txnIds;
    }
    if (other.isSetDbName()) {
      this.dbName = other.dbName;
    }
    if (other.isSetTableName()) {
      this.tableName = other.tableName;
    }
  }

  public AllocateTableWriteIdsRequest deepCopy() {
    return new AllocateTableWriteIdsRequest(this);
  }

  @Override
  public void clear() {
    this.txnIds = null;
    this.dbName = null;
    this.tableName = null;
  }

  public int getTxnIdsSize() {
    return (this.txnIds == null) ? 0 : this.txnIds.size();
  }

  public java.util.Iterator<Long> getTxnIdsIterator() {
    return (this.txnIds == null) ? null : this.txnIds.iterator();
  }

  public void addToTxnIds(long elem) {
    if (this.txnIds == null) {
      this.txnIds = new ArrayList<Long>();
    }
    this.txnIds.add(elem);
  }

  public List<Long> getTxnIds() {
    return this.txnIds;
  }

  public void setTxnIds(List<Long> txnIds) {
    this.txnIds = txnIds;
  }

  public void unsetTxnIds() {
    this.txnIds = null;
  }

  /** Returns true if field txnIds is set (has been assigned a value) and false otherwise */
  public boolean isSetTxnIds() {
    return this.txnIds != null;
  }

  public void setTxnIdsIsSet(boolean value) {
    if (!value) {
      this.txnIds = null;
    }
  }

  public String getDbName() {
    return this.dbName;
  }

  public void setDbName(String dbName) {
    this.dbName = dbName;
  }

  public void unsetDbName() {
    this.dbName = null;
  }

  /** Returns true if field dbName is set (has been assigned a value) and false otherwise */
  public boolean isSetDbName() {
    return this.dbName != null;
  }

  public void setDbNameIsSet(boolean value) {
    if (!value) {
      this.dbName = null;
    }
  }

  public String getTableName() {
    return this.tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public void unsetTableName() {
    this.tableName = null;
  }

  /** Returns true if field tableName is set (has been assigned a value) and false otherwise */
  public boolean isSetTableName() {
    return this.tableName != null;
  }

  public void setTableNameIsSet(boolean value) {
    if (!value) {
      this.tableName = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TXN_IDS:
      if (value == null) {
        unsetTxnIds();
      } else {
        setTxnIds((List<Long>)value);
      }
      break;

    case DB_NAME:
      if (value == null) {
        unsetDbName();
      } else {
        setDbName((String)value);
      }
      break;

    case TABLE_NAME:
      if (value == null) {
        unsetTableName();
      } else {
        setTableName((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TXN_IDS:
      return getTxnIds();

    case DB_NAME:
      return getDbName();

    case TABLE_NAME:
      return getTableName();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TXN_IDS:
      return isSetTxnIds();
    case DB_NAME:
      return isSetDbName();
    case TABLE_NAME:
      return isSetTableName();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof AllocateTableWriteIdsRequest)
      return this.equals((AllocateTableWriteIdsRequest)that);
    return false;
  }

  public boolean equals(AllocateTableWriteIdsRequest that) {
    if (that == null)
      return false;

    boolean this_present_txnIds = true && this.isSetTxnIds();
    boolean that_present_txnIds = true && that.isSetTxnIds();
    if (this_present_txnIds || that_present_txnIds) {
      if (!(this_present_txnIds && that_present_txnIds))
        return false;
      if (!this.txnIds.equals(that.txnIds))
        return false;
    }

    boolean this_present_dbName = true && this.isSetDbName();
    boolean that_present_dbName = true && that.isSetDbName();
    if (this_present_dbName || that_present_dbName) {
      if (!(this_present_dbName && that_present_dbName))
        return false;
      if (!this.dbName.equals(that.dbName))
        return false;
    }

    boolean this_present_tableName = true && this.isSetTableName();
    boolean that_present_tableName = true && that.isSetTableName();
    if (this_present_tableName || that_present_tableName) {
      if (!(this_present_tableName && that_present_tableName))
        return false;
      if (!this.tableName.equals(that.tableName))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_txnIds = true && (isSetTxnIds());
    list.add(present_txnIds);
    if (present_txnIds)
      list.add(txnIds);

    boolean present_dbName = true && (isSetDbName());
    list.add(present_dbName);
    if (present_dbName)
      list.add(dbName);

    boolean present_tableName = true && (isSetTableName());
    list.add(present_tableName);
    if (present_tableName)
      list.add(tableName);

    return list.hashCode();
  }

  @Override
  public int compareTo(AllocateTableWriteIdsRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetTxnIds()).compareTo(other.isSetTxnIds());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTxnIds()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.txnIds, other.txnIds);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDbName()).compareTo(other.isSetDbName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDbName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dbName, other.dbName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTableName()).compareTo(other.isSetTableName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTableName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tableName, other.tableName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("AllocateTableWriteIdsRequest(");
    boolean first = true;

    sb.append("txnIds:");
    if (this.txnIds == null) {
      sb.append("null");
    } else {
      sb.append(this.txnIds);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("dbName:");
    if (this.dbName == null) {
      sb.append("null");
    } else {
      sb.append(this.dbName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("tableName:");
    if (this.tableName == null) {
      sb.append("null");
    } else {
      sb.append(this.tableName);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetTxnIds()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'txnIds' is unset! Struct:" + toString());
    }

    if (!isSetDbName()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'dbName' is unset! Struct:" + toString());
    }

    if (!isSetTableName()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'tableName' is unset! Struct:" + toString());
    }

    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class AllocateTableWriteIdsRequestStandardSchemeFactory implements SchemeFactory {
    public AllocateTableWriteIdsRequestStandardScheme getScheme() {
      return new AllocateTableWriteIdsRequestStandardScheme();
    }
  }

  private static class AllocateTableWriteIdsRequestStandardScheme extends StandardScheme<AllocateTableWriteIdsRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, AllocateTableWriteIdsRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TXN_IDS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> HIVE-18781 : Create/Replicate Open, Commit(without write) and Abort Txn event : Thrift changes
                org.apache.thrift.protocol.TList _list610 = iprot.readListBegin();
                struct.txnIds = new ArrayList<Long>(_list610.size);
                long _elem611;
                for (int _i612 = 0; _i612 < _list610.size; ++_i612)
<<<<<<< HEAD
                {
                  _elem611 = iprot.readI64();
                  struct.txnIds.add(_elem611);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
<<<<<<< HEAD
                org.apache.thrift.protocol.TList _list602 = iprot.readListBegin();
                struct.txnIds = new ArrayList<Long>(_list602.size);
                long _elem603;
                for (int _i604 = 0; _i604 < _list602.size; ++_i604)
                {
                  _elem603 = iprot.readI64();
                  struct.txnIds.add(_elem603);
=======
<<<<<<< HEAD
                org.apache.thrift.protocol.TList _list586 = iprot.readListBegin();
                struct.txnIds = new ArrayList<Long>(_list586.size);
                long _elem587;
                for (int _i588 = 0; _i588 < _list586.size; ++_i588)
                {
                  _elem587 = iprot.readI64();
                  struct.txnIds.add(_elem587);
=======
                org.apache.thrift.protocol.TList _list604 = iprot.readListBegin();
                struct.txnIds = new ArrayList<Long>(_list604.size);
                long _elem605;
                for (int _i606 = 0; _i606 < _list604.size; ++_i606)
                {
                  _elem605 = iprot.readI64();
                  struct.txnIds.add(_elem605);
>>>>>>> HIVE-18679 : create/replicate open transaction event
>>>>>>> HIVE-18679 : create/replicate open transaction event
<<<<<<< HEAD
>>>>>>> HIVE-18679 : create/replicate open transaction event
=======
=======
                org.apache.thrift.protocol.TList _list594 = iprot.readListBegin();
                struct.txnIds = new ArrayList<Long>(_list594.size);
                long _elem595;
                for (int _i596 = 0; _i596 < _list594.size; ++_i596)
                {
                  _elem595 = iprot.readI64();
                  struct.txnIds.add(_elem595);
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
=======
                {
                  _elem611 = iprot.readI64();
                  struct.txnIds.add(_elem611);
>>>>>>> HIVE-18781 : Create/Replicate Open, Commit(without write) and Abort Txn event : Thrift changes
                }
                iprot.readListEnd();
              }
              struct.setTxnIdsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DB_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.dbName = iprot.readString();
              struct.setDbNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TABLE_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.tableName = iprot.readString();
              struct.setTableNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, AllocateTableWriteIdsRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.txnIds != null) {
        oprot.writeFieldBegin(TXN_IDS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I64, struct.txnIds.size()));
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
          for (long _iter613 : struct.txnIds)
          {
            oprot.writeI64(_iter613);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
<<<<<<< HEAD
          for (long _iter605 : struct.txnIds)
          {
            oprot.writeI64(_iter605);
=======
<<<<<<< HEAD
          for (long _iter589 : struct.txnIds)
          {
            oprot.writeI64(_iter589);
=======
          for (long _iter607 : struct.txnIds)
          {
            oprot.writeI64(_iter607);
>>>>>>> HIVE-18679 : create/replicate open transaction event
>>>>>>> HIVE-18679 : create/replicate open transaction event
<<<<<<< HEAD
>>>>>>> HIVE-18679 : create/replicate open transaction event
=======
=======
          for (long _iter597 : struct.txnIds)
          {
            oprot.writeI64(_iter597);
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
=======
          for (long _iter613 : struct.txnIds)
          {
            oprot.writeI64(_iter613);
>>>>>>> HIVE-18781 : Create/Replicate Open, Commit(without write) and Abort Txn event : Thrift changes
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.dbName != null) {
        oprot.writeFieldBegin(DB_NAME_FIELD_DESC);
        oprot.writeString(struct.dbName);
        oprot.writeFieldEnd();
      }
      if (struct.tableName != null) {
        oprot.writeFieldBegin(TABLE_NAME_FIELD_DESC);
        oprot.writeString(struct.tableName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class AllocateTableWriteIdsRequestTupleSchemeFactory implements SchemeFactory {
    public AllocateTableWriteIdsRequestTupleScheme getScheme() {
      return new AllocateTableWriteIdsRequestTupleScheme();
    }
  }

  private static class AllocateTableWriteIdsRequestTupleScheme extends TupleScheme<AllocateTableWriteIdsRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, AllocateTableWriteIdsRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      {
        oprot.writeI32(struct.txnIds.size());
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        for (long _iter614 : struct.txnIds)
        {
          oprot.writeI64(_iter614);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
<<<<<<< HEAD
        for (long _iter606 : struct.txnIds)
        {
          oprot.writeI64(_iter606);
=======
<<<<<<< HEAD
        for (long _iter590 : struct.txnIds)
        {
          oprot.writeI64(_iter590);
=======
        for (long _iter608 : struct.txnIds)
        {
          oprot.writeI64(_iter608);
>>>>>>> HIVE-18679 : create/replicate open transaction event
>>>>>>> HIVE-18679 : create/replicate open transaction event
<<<<<<< HEAD
>>>>>>> HIVE-18679 : create/replicate open transaction event
=======
=======
        for (long _iter598 : struct.txnIds)
        {
          oprot.writeI64(_iter598);
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
=======
        for (long _iter614 : struct.txnIds)
        {
          oprot.writeI64(_iter614);
>>>>>>> HIVE-18781 : Create/Replicate Open, Commit(without write) and Abort Txn event : Thrift changes
        }
      }
      oprot.writeString(struct.dbName);
      oprot.writeString(struct.tableName);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, AllocateTableWriteIdsRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> HIVE-18781 : Create/Replicate Open, Commit(without write) and Abort Txn event : Thrift changes
        org.apache.thrift.protocol.TList _list615 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I64, iprot.readI32());
        struct.txnIds = new ArrayList<Long>(_list615.size);
        long _elem616;
        for (int _i617 = 0; _i617 < _list615.size; ++_i617)
<<<<<<< HEAD
        {
          _elem616 = iprot.readI64();
          struct.txnIds.add(_elem616);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
<<<<<<< HEAD
        org.apache.thrift.protocol.TList _list607 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I64, iprot.readI32());
        struct.txnIds = new ArrayList<Long>(_list607.size);
        long _elem608;
        for (int _i609 = 0; _i609 < _list607.size; ++_i609)
        {
          _elem608 = iprot.readI64();
          struct.txnIds.add(_elem608);
=======
<<<<<<< HEAD
        org.apache.thrift.protocol.TList _list591 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I64, iprot.readI32());
        struct.txnIds = new ArrayList<Long>(_list591.size);
        long _elem592;
        for (int _i593 = 0; _i593 < _list591.size; ++_i593)
        {
          _elem592 = iprot.readI64();
          struct.txnIds.add(_elem592);
=======
        org.apache.thrift.protocol.TList _list609 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I64, iprot.readI32());
        struct.txnIds = new ArrayList<Long>(_list609.size);
        long _elem610;
        for (int _i611 = 0; _i611 < _list609.size; ++_i611)
        {
          _elem610 = iprot.readI64();
          struct.txnIds.add(_elem610);
>>>>>>> HIVE-18679 : create/replicate open transaction event
>>>>>>> HIVE-18679 : create/replicate open transaction event
<<<<<<< HEAD
>>>>>>> HIVE-18679 : create/replicate open transaction event
=======
=======
        org.apache.thrift.protocol.TList _list599 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I64, iprot.readI32());
        struct.txnIds = new ArrayList<Long>(_list599.size);
        long _elem600;
        for (int _i601 = 0; _i601 < _list599.size; ++_i601)
        {
          _elem600 = iprot.readI64();
          struct.txnIds.add(_elem600);
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
=======
        {
          _elem616 = iprot.readI64();
          struct.txnIds.add(_elem616);
>>>>>>> HIVE-18781 : Create/Replicate Open, Commit(without write) and Abort Txn event : Thrift changes
        }
      }
      struct.setTxnIdsIsSet(true);
      struct.dbName = iprot.readString();
      struct.setDbNameIsSet(true);
      struct.tableName = iprot.readString();
      struct.setTableNameIsSet(true);
    }
  }

}

