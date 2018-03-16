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
@org.apache.hadoop.classification.InterfaceAudience.Public @org.apache.hadoop.classification.InterfaceStability.Stable public class FireEventRequest implements org.apache.thrift.TBase<FireEventRequest, FireEventRequest._Fields>, java.io.Serializable, Cloneable, Comparable<FireEventRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("FireEventRequest");

  private static final org.apache.thrift.protocol.TField SUCCESSFUL_FIELD_DESC = new org.apache.thrift.protocol.TField("successful", org.apache.thrift.protocol.TType.BOOL, (short)1);
  private static final org.apache.thrift.protocol.TField DATA_FIELD_DESC = new org.apache.thrift.protocol.TField("data", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField DB_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("dbName", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField TABLE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("tableName", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField PARTITION_VALS_FIELD_DESC = new org.apache.thrift.protocol.TField("partitionVals", org.apache.thrift.protocol.TType.LIST, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new FireEventRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new FireEventRequestTupleSchemeFactory());
  }

  private boolean successful; // required
  private FireEventRequestData data; // required
  private String dbName; // optional
  private String tableName; // optional
  private List<String> partitionVals; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SUCCESSFUL((short)1, "successful"),
    DATA((short)2, "data"),
    DB_NAME((short)3, "dbName"),
    TABLE_NAME((short)4, "tableName"),
    PARTITION_VALS((short)5, "partitionVals");

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
        case 1: // SUCCESSFUL
          return SUCCESSFUL;
        case 2: // DATA
          return DATA;
        case 3: // DB_NAME
          return DB_NAME;
        case 4: // TABLE_NAME
          return TABLE_NAME;
        case 5: // PARTITION_VALS
          return PARTITION_VALS;
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
  private static final int __SUCCESSFUL_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.DB_NAME,_Fields.TABLE_NAME,_Fields.PARTITION_VALS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SUCCESSFUL, new org.apache.thrift.meta_data.FieldMetaData("successful", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.DATA, new org.apache.thrift.meta_data.FieldMetaData("data", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, FireEventRequestData.class)));
    tmpMap.put(_Fields.DB_NAME, new org.apache.thrift.meta_data.FieldMetaData("dbName", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TABLE_NAME, new org.apache.thrift.meta_data.FieldMetaData("tableName", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PARTITION_VALS, new org.apache.thrift.meta_data.FieldMetaData("partitionVals", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(FireEventRequest.class, metaDataMap);
  }

  public FireEventRequest() {
  }

  public FireEventRequest(
    boolean successful,
    FireEventRequestData data)
  {
    this();
    this.successful = successful;
    setSuccessfulIsSet(true);
    this.data = data;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public FireEventRequest(FireEventRequest other) {
    __isset_bitfield = other.__isset_bitfield;
    this.successful = other.successful;
    if (other.isSetData()) {
      this.data = new FireEventRequestData(other.data);
    }
    if (other.isSetDbName()) {
      this.dbName = other.dbName;
    }
    if (other.isSetTableName()) {
      this.tableName = other.tableName;
    }
    if (other.isSetPartitionVals()) {
      List<String> __this__partitionVals = new ArrayList<String>(other.partitionVals);
      this.partitionVals = __this__partitionVals;
    }
  }

  public FireEventRequest deepCopy() {
    return new FireEventRequest(this);
  }

  @Override
  public void clear() {
    setSuccessfulIsSet(false);
    this.successful = false;
    this.data = null;
    this.dbName = null;
    this.tableName = null;
    this.partitionVals = null;
  }

  public boolean isSuccessful() {
    return this.successful;
  }

  public void setSuccessful(boolean successful) {
    this.successful = successful;
    setSuccessfulIsSet(true);
  }

  public void unsetSuccessful() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SUCCESSFUL_ISSET_ID);
  }

  /** Returns true if field successful is set (has been assigned a value) and false otherwise */
  public boolean isSetSuccessful() {
    return EncodingUtils.testBit(__isset_bitfield, __SUCCESSFUL_ISSET_ID);
  }

  public void setSuccessfulIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SUCCESSFUL_ISSET_ID, value);
  }

  public FireEventRequestData getData() {
    return this.data;
  }

  public void setData(FireEventRequestData data) {
    this.data = data;
  }

  public void unsetData() {
    this.data = null;
  }

  /** Returns true if field data is set (has been assigned a value) and false otherwise */
  public boolean isSetData() {
    return this.data != null;
  }

  public void setDataIsSet(boolean value) {
    if (!value) {
      this.data = null;
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

  public int getPartitionValsSize() {
    return (this.partitionVals == null) ? 0 : this.partitionVals.size();
  }

  public java.util.Iterator<String> getPartitionValsIterator() {
    return (this.partitionVals == null) ? null : this.partitionVals.iterator();
  }

  public void addToPartitionVals(String elem) {
    if (this.partitionVals == null) {
      this.partitionVals = new ArrayList<String>();
    }
    this.partitionVals.add(elem);
  }

  public List<String> getPartitionVals() {
    return this.partitionVals;
  }

  public void setPartitionVals(List<String> partitionVals) {
    this.partitionVals = partitionVals;
  }

  public void unsetPartitionVals() {
    this.partitionVals = null;
  }

  /** Returns true if field partitionVals is set (has been assigned a value) and false otherwise */
  public boolean isSetPartitionVals() {
    return this.partitionVals != null;
  }

  public void setPartitionValsIsSet(boolean value) {
    if (!value) {
      this.partitionVals = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SUCCESSFUL:
      if (value == null) {
        unsetSuccessful();
      } else {
        setSuccessful((Boolean)value);
      }
      break;

    case DATA:
      if (value == null) {
        unsetData();
      } else {
        setData((FireEventRequestData)value);
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

    case PARTITION_VALS:
      if (value == null) {
        unsetPartitionVals();
      } else {
        setPartitionVals((List<String>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SUCCESSFUL:
      return isSuccessful();

    case DATA:
      return getData();

    case DB_NAME:
      return getDbName();

    case TABLE_NAME:
      return getTableName();

    case PARTITION_VALS:
      return getPartitionVals();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SUCCESSFUL:
      return isSetSuccessful();
    case DATA:
      return isSetData();
    case DB_NAME:
      return isSetDbName();
    case TABLE_NAME:
      return isSetTableName();
    case PARTITION_VALS:
      return isSetPartitionVals();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof FireEventRequest)
      return this.equals((FireEventRequest)that);
    return false;
  }

  public boolean equals(FireEventRequest that) {
    if (that == null)
      return false;

    boolean this_present_successful = true;
    boolean that_present_successful = true;
    if (this_present_successful || that_present_successful) {
      if (!(this_present_successful && that_present_successful))
        return false;
      if (this.successful != that.successful)
        return false;
    }

    boolean this_present_data = true && this.isSetData();
    boolean that_present_data = true && that.isSetData();
    if (this_present_data || that_present_data) {
      if (!(this_present_data && that_present_data))
        return false;
      if (!this.data.equals(that.data))
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

    boolean this_present_partitionVals = true && this.isSetPartitionVals();
    boolean that_present_partitionVals = true && that.isSetPartitionVals();
    if (this_present_partitionVals || that_present_partitionVals) {
      if (!(this_present_partitionVals && that_present_partitionVals))
        return false;
      if (!this.partitionVals.equals(that.partitionVals))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_successful = true;
    list.add(present_successful);
    if (present_successful)
      list.add(successful);

    boolean present_data = true && (isSetData());
    list.add(present_data);
    if (present_data)
      list.add(data);

    boolean present_dbName = true && (isSetDbName());
    list.add(present_dbName);
    if (present_dbName)
      list.add(dbName);

    boolean present_tableName = true && (isSetTableName());
    list.add(present_tableName);
    if (present_tableName)
      list.add(tableName);

    boolean present_partitionVals = true && (isSetPartitionVals());
    list.add(present_partitionVals);
    if (present_partitionVals)
      list.add(partitionVals);

    return list.hashCode();
  }

  @Override
  public int compareTo(FireEventRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSuccessful()).compareTo(other.isSetSuccessful());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSuccessful()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.successful, other.successful);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetData()).compareTo(other.isSetData());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetData()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.data, other.data);
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
    lastComparison = Boolean.valueOf(isSetPartitionVals()).compareTo(other.isSetPartitionVals());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPartitionVals()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.partitionVals, other.partitionVals);
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
    StringBuilder sb = new StringBuilder("FireEventRequest(");
    boolean first = true;

    sb.append("successful:");
    sb.append(this.successful);
    first = false;
    if (!first) sb.append(", ");
    sb.append("data:");
    if (this.data == null) {
      sb.append("null");
    } else {
      sb.append(this.data);
    }
    first = false;
    if (isSetDbName()) {
      if (!first) sb.append(", ");
      sb.append("dbName:");
      if (this.dbName == null) {
        sb.append("null");
      } else {
        sb.append(this.dbName);
      }
      first = false;
    }
    if (isSetTableName()) {
      if (!first) sb.append(", ");
      sb.append("tableName:");
      if (this.tableName == null) {
        sb.append("null");
      } else {
        sb.append(this.tableName);
      }
      first = false;
    }
    if (isSetPartitionVals()) {
      if (!first) sb.append(", ");
      sb.append("partitionVals:");
      if (this.partitionVals == null) {
        sb.append("null");
      } else {
        sb.append(this.partitionVals);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetSuccessful()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'successful' is unset! Struct:" + toString());
    }

    if (!isSetData()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'data' is unset! Struct:" + toString());
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class FireEventRequestStandardSchemeFactory implements SchemeFactory {
    public FireEventRequestStandardScheme getScheme() {
      return new FireEventRequestStandardScheme();
    }
  }

  private static class FireEventRequestStandardScheme extends StandardScheme<FireEventRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, FireEventRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SUCCESSFUL
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.successful = iprot.readBool();
              struct.setSuccessfulIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DATA
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.data = new FireEventRequestData();
              struct.data.read(iprot);
              struct.setDataIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DB_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.dbName = iprot.readString();
              struct.setDbNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TABLE_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.tableName = iprot.readString();
              struct.setTableNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // PARTITION_VALS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list726 = iprot.readListBegin();
                struct.partitionVals = new ArrayList<String>(_list726.size);
                String _elem727;
                for (int _i728 = 0; _i728 < _list726.size; ++_i728)
                {
                  _elem727 = iprot.readString();
                  struct.partitionVals.add(_elem727);
                }
                iprot.readListEnd();
              }
              struct.setPartitionValsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, FireEventRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(SUCCESSFUL_FIELD_DESC);
      oprot.writeBool(struct.successful);
      oprot.writeFieldEnd();
      if (struct.data != null) {
        oprot.writeFieldBegin(DATA_FIELD_DESC);
        struct.data.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.dbName != null) {
        if (struct.isSetDbName()) {
          oprot.writeFieldBegin(DB_NAME_FIELD_DESC);
          oprot.writeString(struct.dbName);
          oprot.writeFieldEnd();
        }
      }
      if (struct.tableName != null) {
        if (struct.isSetTableName()) {
          oprot.writeFieldBegin(TABLE_NAME_FIELD_DESC);
          oprot.writeString(struct.tableName);
          oprot.writeFieldEnd();
        }
      }
      if (struct.partitionVals != null) {
        if (struct.isSetPartitionVals()) {
          oprot.writeFieldBegin(PARTITION_VALS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.partitionVals.size()));
            for (String _iter729 : struct.partitionVals)
            {
              oprot.writeString(_iter729);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class FireEventRequestTupleSchemeFactory implements SchemeFactory {
    public FireEventRequestTupleScheme getScheme() {
      return new FireEventRequestTupleScheme();
    }
  }

  private static class FireEventRequestTupleScheme extends TupleScheme<FireEventRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, FireEventRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeBool(struct.successful);
      struct.data.write(oprot);
      BitSet optionals = new BitSet();
      if (struct.isSetDbName()) {
        optionals.set(0);
      }
      if (struct.isSetTableName()) {
        optionals.set(1);
      }
      if (struct.isSetPartitionVals()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetDbName()) {
        oprot.writeString(struct.dbName);
      }
      if (struct.isSetTableName()) {
        oprot.writeString(struct.tableName);
      }
      if (struct.isSetPartitionVals()) {
        {
          oprot.writeI32(struct.partitionVals.size());
          for (String _iter730 : struct.partitionVals)
          {
            oprot.writeString(_iter730);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, FireEventRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.successful = iprot.readBool();
      struct.setSuccessfulIsSet(true);
      struct.data = new FireEventRequestData();
      struct.data.read(iprot);
      struct.setDataIsSet(true);
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.dbName = iprot.readString();
        struct.setDbNameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.tableName = iprot.readString();
        struct.setTableNameIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list731 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.partitionVals = new ArrayList<String>(_list731.size);
          String _elem732;
          for (int _i733 = 0; _i733 < _list731.size; ++_i733)
          {
            _elem732 = iprot.readString();
            struct.partitionVals.add(_elem732);
          }
        }
        struct.setPartitionValsIsSet(true);
      }
    }
  }

}

