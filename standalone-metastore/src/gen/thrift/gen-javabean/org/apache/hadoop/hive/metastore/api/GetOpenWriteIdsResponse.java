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
@org.apache.hadoop.classification.InterfaceAudience.Public @org.apache.hadoop.classification.InterfaceStability.Stable public class GetOpenWriteIdsResponse implements org.apache.thrift.TBase<GetOpenWriteIdsResponse, GetOpenWriteIdsResponse._Fields>, java.io.Serializable, Cloneable, Comparable<GetOpenWriteIdsResponse> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("GetOpenWriteIdsResponse");

  private static final org.apache.thrift.protocol.TField OPEN_WRITE_IDS_FIELD_DESC = new org.apache.thrift.protocol.TField("openWriteIds", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new GetOpenWriteIdsResponseStandardSchemeFactory());
    schemes.put(TupleScheme.class, new GetOpenWriteIdsResponseTupleSchemeFactory());
  }

  private List<OpenWriteIds> openWriteIds; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    OPEN_WRITE_IDS((short)1, "openWriteIds");

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
        case 1: // OPEN_WRITE_IDS
          return OPEN_WRITE_IDS;
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
    tmpMap.put(_Fields.OPEN_WRITE_IDS, new org.apache.thrift.meta_data.FieldMetaData("openWriteIds", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, OpenWriteIds.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(GetOpenWriteIdsResponse.class, metaDataMap);
  }

  public GetOpenWriteIdsResponse() {
  }

  public GetOpenWriteIdsResponse(
    List<OpenWriteIds> openWriteIds)
  {
    this();
    this.openWriteIds = openWriteIds;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public GetOpenWriteIdsResponse(GetOpenWriteIdsResponse other) {
    if (other.isSetOpenWriteIds()) {
      List<OpenWriteIds> __this__openWriteIds = new ArrayList<OpenWriteIds>(other.openWriteIds.size());
      for (OpenWriteIds other_element : other.openWriteIds) {
        __this__openWriteIds.add(new OpenWriteIds(other_element));
      }
      this.openWriteIds = __this__openWriteIds;
    }
  }

  public GetOpenWriteIdsResponse deepCopy() {
    return new GetOpenWriteIdsResponse(this);
  }

  @Override
  public void clear() {
    this.openWriteIds = null;
  }

  public int getOpenWriteIdsSize() {
    return (this.openWriteIds == null) ? 0 : this.openWriteIds.size();
  }

  public java.util.Iterator<OpenWriteIds> getOpenWriteIdsIterator() {
    return (this.openWriteIds == null) ? null : this.openWriteIds.iterator();
  }

  public void addToOpenWriteIds(OpenWriteIds elem) {
    if (this.openWriteIds == null) {
      this.openWriteIds = new ArrayList<OpenWriteIds>();
    }
    this.openWriteIds.add(elem);
  }

  public List<OpenWriteIds> getOpenWriteIds() {
    return this.openWriteIds;
  }

  public void setOpenWriteIds(List<OpenWriteIds> openWriteIds) {
    this.openWriteIds = openWriteIds;
  }

  public void unsetOpenWriteIds() {
    this.openWriteIds = null;
  }

  /** Returns true if field openWriteIds is set (has been assigned a value) and false otherwise */
  public boolean isSetOpenWriteIds() {
    return this.openWriteIds != null;
  }

  public void setOpenWriteIdsIsSet(boolean value) {
    if (!value) {
      this.openWriteIds = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case OPEN_WRITE_IDS:
      if (value == null) {
        unsetOpenWriteIds();
      } else {
        setOpenWriteIds((List<OpenWriteIds>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case OPEN_WRITE_IDS:
      return getOpenWriteIds();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case OPEN_WRITE_IDS:
      return isSetOpenWriteIds();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof GetOpenWriteIdsResponse)
      return this.equals((GetOpenWriteIdsResponse)that);
    return false;
  }

  public boolean equals(GetOpenWriteIdsResponse that) {
    if (that == null)
      return false;

    boolean this_present_openWriteIds = true && this.isSetOpenWriteIds();
    boolean that_present_openWriteIds = true && that.isSetOpenWriteIds();
    if (this_present_openWriteIds || that_present_openWriteIds) {
      if (!(this_present_openWriteIds && that_present_openWriteIds))
        return false;
      if (!this.openWriteIds.equals(that.openWriteIds))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_openWriteIds = true && (isSetOpenWriteIds());
    list.add(present_openWriteIds);
    if (present_openWriteIds)
      list.add(openWriteIds);

    return list.hashCode();
  }

  @Override
  public int compareTo(GetOpenWriteIdsResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetOpenWriteIds()).compareTo(other.isSetOpenWriteIds());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOpenWriteIds()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.openWriteIds, other.openWriteIds);
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
    StringBuilder sb = new StringBuilder("GetOpenWriteIdsResponse(");
    boolean first = true;

    sb.append("openWriteIds:");
    if (this.openWriteIds == null) {
      sb.append("null");
    } else {
      sb.append(this.openWriteIds);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetOpenWriteIds()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'openWriteIds' is unset! Struct:" + toString());
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

  private static class GetOpenWriteIdsResponseStandardSchemeFactory implements SchemeFactory {
    public GetOpenWriteIdsResponseStandardScheme getScheme() {
      return new GetOpenWriteIdsResponseStandardScheme();
    }
  }

  private static class GetOpenWriteIdsResponseStandardScheme extends StandardScheme<GetOpenWriteIdsResponse> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, GetOpenWriteIdsResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // OPEN_WRITE_IDS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list582 = iprot.readListBegin();
                struct.openWriteIds = new ArrayList<OpenWriteIds>(_list582.size);
                OpenWriteIds _elem583;
                for (int _i584 = 0; _i584 < _list582.size; ++_i584)
                {
                  _elem583 = new OpenWriteIds();
                  _elem583.read(iprot);
                  struct.openWriteIds.add(_elem583);
                }
                iprot.readListEnd();
              }
              struct.setOpenWriteIdsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, GetOpenWriteIdsResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.openWriteIds != null) {
        oprot.writeFieldBegin(OPEN_WRITE_IDS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.openWriteIds.size()));
          for (OpenWriteIds _iter585 : struct.openWriteIds)
          {
            _iter585.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class GetOpenWriteIdsResponseTupleSchemeFactory implements SchemeFactory {
    public GetOpenWriteIdsResponseTupleScheme getScheme() {
      return new GetOpenWriteIdsResponseTupleScheme();
    }
  }

  private static class GetOpenWriteIdsResponseTupleScheme extends TupleScheme<GetOpenWriteIdsResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, GetOpenWriteIdsResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      {
        oprot.writeI32(struct.openWriteIds.size());
        for (OpenWriteIds _iter586 : struct.openWriteIds)
        {
          _iter586.write(oprot);
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, GetOpenWriteIdsResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TList _list587 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.openWriteIds = new ArrayList<OpenWriteIds>(_list587.size);
        OpenWriteIds _elem588;
        for (int _i589 = 0; _i589 < _list587.size; ++_i589)
        {
          _elem588 = new OpenWriteIds();
          _elem588.read(iprot);
          struct.openWriteIds.add(_elem588);
        }
      }
      struct.setOpenWriteIdsIsSet(true);
    }
  }

}
