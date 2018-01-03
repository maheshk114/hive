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
@org.apache.hadoop.classification.InterfaceAudience.Public @org.apache.hadoop.classification.InterfaceStability.Stable public class AllocateTableWriteIdResponse implements org.apache.thrift.TBase<AllocateTableWriteIdResponse, AllocateTableWriteIdResponse._Fields>, java.io.Serializable, Cloneable, Comparable<AllocateTableWriteIdResponse> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("AllocateTableWriteIdResponse");

  private static final org.apache.thrift.protocol.TField WRITE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("writeId", org.apache.thrift.protocol.TType.I64, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new AllocateTableWriteIdResponseStandardSchemeFactory());
    schemes.put(TupleScheme.class, new AllocateTableWriteIdResponseTupleSchemeFactory());
  }

  private long writeId; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    WRITE_ID((short)1, "writeId");

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
        case 1: // WRITE_ID
          return WRITE_ID;
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
  private static final int __WRITEID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.WRITE_ID, new org.apache.thrift.meta_data.FieldMetaData("writeId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(AllocateTableWriteIdResponse.class, metaDataMap);
  }

  public AllocateTableWriteIdResponse() {
  }

  public AllocateTableWriteIdResponse(
    long writeId)
  {
    this();
    this.writeId = writeId;
    setWriteIdIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public AllocateTableWriteIdResponse(AllocateTableWriteIdResponse other) {
    __isset_bitfield = other.__isset_bitfield;
    this.writeId = other.writeId;
  }

  public AllocateTableWriteIdResponse deepCopy() {
    return new AllocateTableWriteIdResponse(this);
  }

  @Override
  public void clear() {
    setWriteIdIsSet(false);
    this.writeId = 0;
  }

  public long getWriteId() {
    return this.writeId;
  }

  public void setWriteId(long writeId) {
    this.writeId = writeId;
    setWriteIdIsSet(true);
  }

  public void unsetWriteId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __WRITEID_ISSET_ID);
  }

  /** Returns true if field writeId is set (has been assigned a value) and false otherwise */
  public boolean isSetWriteId() {
    return EncodingUtils.testBit(__isset_bitfield, __WRITEID_ISSET_ID);
  }

  public void setWriteIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __WRITEID_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case WRITE_ID:
      if (value == null) {
        unsetWriteId();
      } else {
        setWriteId((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case WRITE_ID:
      return getWriteId();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case WRITE_ID:
      return isSetWriteId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof AllocateTableWriteIdResponse)
      return this.equals((AllocateTableWriteIdResponse)that);
    return false;
  }

  public boolean equals(AllocateTableWriteIdResponse that) {
    if (that == null)
      return false;

    boolean this_present_writeId = true;
    boolean that_present_writeId = true;
    if (this_present_writeId || that_present_writeId) {
      if (!(this_present_writeId && that_present_writeId))
        return false;
      if (this.writeId != that.writeId)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_writeId = true;
    list.add(present_writeId);
    if (present_writeId)
      list.add(writeId);

    return list.hashCode();
  }

  @Override
  public int compareTo(AllocateTableWriteIdResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetWriteId()).compareTo(other.isSetWriteId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetWriteId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.writeId, other.writeId);
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
    StringBuilder sb = new StringBuilder("AllocateTableWriteIdResponse(");
    boolean first = true;

    sb.append("writeId:");
    sb.append(this.writeId);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetWriteId()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'writeId' is unset! Struct:" + toString());
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

  private static class AllocateTableWriteIdResponseStandardSchemeFactory implements SchemeFactory {
    public AllocateTableWriteIdResponseStandardScheme getScheme() {
      return new AllocateTableWriteIdResponseStandardScheme();
    }
  }

  private static class AllocateTableWriteIdResponseStandardScheme extends StandardScheme<AllocateTableWriteIdResponse> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, AllocateTableWriteIdResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // WRITE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.writeId = iprot.readI64();
              struct.setWriteIdIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, AllocateTableWriteIdResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(WRITE_ID_FIELD_DESC);
      oprot.writeI64(struct.writeId);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class AllocateTableWriteIdResponseTupleSchemeFactory implements SchemeFactory {
    public AllocateTableWriteIdResponseTupleScheme getScheme() {
      return new AllocateTableWriteIdResponseTupleScheme();
    }
  }

  private static class AllocateTableWriteIdResponseTupleScheme extends TupleScheme<AllocateTableWriteIdResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, AllocateTableWriteIdResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI64(struct.writeId);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, AllocateTableWriteIdResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.writeId = iprot.readI64();
      struct.setWriteIdIsSet(true);
    }
  }

}

