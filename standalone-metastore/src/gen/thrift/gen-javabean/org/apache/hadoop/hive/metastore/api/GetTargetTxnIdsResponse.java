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
@org.apache.hadoop.classification.InterfaceAudience.Public @org.apache.hadoop.classification.InterfaceStability.Stable public class GetTargetTxnIdsResponse implements org.apache.thrift.TBase<GetTargetTxnIdsResponse, GetTargetTxnIdsResponse._Fields>, java.io.Serializable, Cloneable, Comparable<GetTargetTxnIdsResponse> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("GetTargetTxnIdsResponse");

  private static final org.apache.thrift.protocol.TField TXNID_FIELD_DESC = new org.apache.thrift.protocol.TField("txnid", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new GetTargetTxnIdsResponseStandardSchemeFactory());
    schemes.put(TupleScheme.class, new GetTargetTxnIdsResponseTupleSchemeFactory());
  }

  private List<Long> txnid; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TXNID((short)1, "txnid");

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
        case 1: // TXNID
          return TXNID;
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
    tmpMap.put(_Fields.TXNID, new org.apache.thrift.meta_data.FieldMetaData("txnid", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(GetTargetTxnIdsResponse.class, metaDataMap);
  }

  public GetTargetTxnIdsResponse() {
  }

  public GetTargetTxnIdsResponse(
    List<Long> txnid)
  {
    this();
    this.txnid = txnid;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public GetTargetTxnIdsResponse(GetTargetTxnIdsResponse other) {
    if (other.isSetTxnid()) {
      List<Long> __this__txnid = new ArrayList<Long>(other.txnid);
      this.txnid = __this__txnid;
    }
  }

  public GetTargetTxnIdsResponse deepCopy() {
    return new GetTargetTxnIdsResponse(this);
  }

  @Override
  public void clear() {
    this.txnid = null;
  }

  public int getTxnidSize() {
    return (this.txnid == null) ? 0 : this.txnid.size();
  }

  public java.util.Iterator<Long> getTxnidIterator() {
    return (this.txnid == null) ? null : this.txnid.iterator();
  }

  public void addToTxnid(long elem) {
    if (this.txnid == null) {
      this.txnid = new ArrayList<Long>();
    }
    this.txnid.add(elem);
  }

  public List<Long> getTxnid() {
    return this.txnid;
  }

  public void setTxnid(List<Long> txnid) {
    this.txnid = txnid;
  }

  public void unsetTxnid() {
    this.txnid = null;
  }

  /** Returns true if field txnid is set (has been assigned a value) and false otherwise */
  public boolean isSetTxnid() {
    return this.txnid != null;
  }

  public void setTxnidIsSet(boolean value) {
    if (!value) {
      this.txnid = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TXNID:
      if (value == null) {
        unsetTxnid();
      } else {
        setTxnid((List<Long>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TXNID:
      return getTxnid();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TXNID:
      return isSetTxnid();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof GetTargetTxnIdsResponse)
      return this.equals((GetTargetTxnIdsResponse)that);
    return false;
  }

  public boolean equals(GetTargetTxnIdsResponse that) {
    if (that == null)
      return false;

    boolean this_present_txnid = true && this.isSetTxnid();
    boolean that_present_txnid = true && that.isSetTxnid();
    if (this_present_txnid || that_present_txnid) {
      if (!(this_present_txnid && that_present_txnid))
        return false;
      if (!this.txnid.equals(that.txnid))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_txnid = true && (isSetTxnid());
    list.add(present_txnid);
    if (present_txnid)
      list.add(txnid);

    return list.hashCode();
  }

  @Override
  public int compareTo(GetTargetTxnIdsResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetTxnid()).compareTo(other.isSetTxnid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTxnid()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.txnid, other.txnid);
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
    StringBuilder sb = new StringBuilder("GetTargetTxnIdsResponse(");
    boolean first = true;

    sb.append("txnid:");
    if (this.txnid == null) {
      sb.append("null");
    } else {
      sb.append(this.txnid);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetTxnid()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'txnid' is unset! Struct:" + toString());
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

  private static class GetTargetTxnIdsResponseStandardSchemeFactory implements SchemeFactory {
    public GetTargetTxnIdsResponseStandardScheme getScheme() {
      return new GetTargetTxnIdsResponseStandardScheme();
    }
  }

  private static class GetTargetTxnIdsResponseStandardScheme extends StandardScheme<GetTargetTxnIdsResponse> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, GetTargetTxnIdsResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TXNID
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list572 = iprot.readListBegin();
                struct.txnid = new ArrayList<Long>(_list572.size);
                long _elem573;
                for (int _i574 = 0; _i574 < _list572.size; ++_i574)
                {
                  _elem573 = iprot.readI64();
                  struct.txnid.add(_elem573);
                }
                iprot.readListEnd();
              }
              struct.setTxnidIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, GetTargetTxnIdsResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.txnid != null) {
        oprot.writeFieldBegin(TXNID_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I64, struct.txnid.size()));
          for (long _iter575 : struct.txnid)
          {
            oprot.writeI64(_iter575);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class GetTargetTxnIdsResponseTupleSchemeFactory implements SchemeFactory {
    public GetTargetTxnIdsResponseTupleScheme getScheme() {
      return new GetTargetTxnIdsResponseTupleScheme();
    }
  }

  private static class GetTargetTxnIdsResponseTupleScheme extends TupleScheme<GetTargetTxnIdsResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, GetTargetTxnIdsResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      {
        oprot.writeI32(struct.txnid.size());
        for (long _iter576 : struct.txnid)
        {
          oprot.writeI64(_iter576);
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, GetTargetTxnIdsResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TList _list577 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I64, iprot.readI32());
        struct.txnid = new ArrayList<Long>(_list577.size);
        long _elem578;
        for (int _i579 = 0; _i579 < _list577.size; ++_i579)
        {
          _elem578 = iprot.readI64();
          struct.txnid.add(_elem578);
        }
      }
      struct.setTxnidIsSet(true);
    }
  }

}

