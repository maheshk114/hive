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
@org.apache.hadoop.classification.InterfaceAudience.Public @org.apache.hadoop.classification.InterfaceStability.Stable public class ClientCapabilities implements org.apache.thrift.TBase<ClientCapabilities, ClientCapabilities._Fields>, java.io.Serializable, Cloneable, Comparable<ClientCapabilities> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ClientCapabilities");

  private static final org.apache.thrift.protocol.TField VALUES_FIELD_DESC = new org.apache.thrift.protocol.TField("values", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ClientCapabilitiesStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ClientCapabilitiesTupleSchemeFactory());
  }

  private List<ClientCapability> values; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    VALUES((short)1, "values");

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
        case 1: // VALUES
          return VALUES;
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
    tmpMap.put(_Fields.VALUES, new org.apache.thrift.meta_data.FieldMetaData("values", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, ClientCapability.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ClientCapabilities.class, metaDataMap);
  }

  public ClientCapabilities() {
  }

  public ClientCapabilities(
    List<ClientCapability> values)
  {
    this();
    this.values = values;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ClientCapabilities(ClientCapabilities other) {
    if (other.isSetValues()) {
      List<ClientCapability> __this__values = new ArrayList<ClientCapability>(other.values.size());
      for (ClientCapability other_element : other.values) {
        __this__values.add(other_element);
      }
      this.values = __this__values;
    }
  }

  public ClientCapabilities deepCopy() {
    return new ClientCapabilities(this);
  }

  @Override
  public void clear() {
    this.values = null;
  }

  public int getValuesSize() {
    return (this.values == null) ? 0 : this.values.size();
  }

  public java.util.Iterator<ClientCapability> getValuesIterator() {
    return (this.values == null) ? null : this.values.iterator();
  }

  public void addToValues(ClientCapability elem) {
    if (this.values == null) {
      this.values = new ArrayList<ClientCapability>();
    }
    this.values.add(elem);
  }

  public List<ClientCapability> getValues() {
    return this.values;
  }

  public void setValues(List<ClientCapability> values) {
    this.values = values;
  }

  public void unsetValues() {
    this.values = null;
  }

  /** Returns true if field values is set (has been assigned a value) and false otherwise */
  public boolean isSetValues() {
    return this.values != null;
  }

  public void setValuesIsSet(boolean value) {
    if (!value) {
      this.values = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case VALUES:
      if (value == null) {
        unsetValues();
      } else {
        setValues((List<ClientCapability>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case VALUES:
      return getValues();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case VALUES:
      return isSetValues();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ClientCapabilities)
      return this.equals((ClientCapabilities)that);
    return false;
  }

  public boolean equals(ClientCapabilities that) {
    if (that == null)
      return false;

    boolean this_present_values = true && this.isSetValues();
    boolean that_present_values = true && that.isSetValues();
    if (this_present_values || that_present_values) {
      if (!(this_present_values && that_present_values))
        return false;
      if (!this.values.equals(that.values))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_values = true && (isSetValues());
    list.add(present_values);
    if (present_values)
      list.add(values);

    return list.hashCode();
  }

  @Override
  public int compareTo(ClientCapabilities other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetValues()).compareTo(other.isSetValues());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetValues()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.values, other.values);
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
    StringBuilder sb = new StringBuilder("ClientCapabilities(");
    boolean first = true;

    sb.append("values:");
    if (this.values == null) {
      sb.append("null");
    } else {
      sb.append(this.values);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetValues()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'values' is unset! Struct:" + toString());
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

  private static class ClientCapabilitiesStandardSchemeFactory implements SchemeFactory {
    public ClientCapabilitiesStandardScheme getScheme() {
      return new ClientCapabilitiesStandardScheme();
    }
  }

  private static class ClientCapabilitiesStandardScheme extends StandardScheme<ClientCapabilities> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ClientCapabilities struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // VALUES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> alloc write id event changes
                org.apache.thrift.protocol.TList _list786 = iprot.readListBegin();
                struct.values = new ArrayList<ClientCapability>(_list786.size);
                ClientCapability _elem787;
                for (int _i788 = 0; _i788 < _list786.size; ++_i788)
<<<<<<< HEAD
                {
                  _elem787 = org.apache.hadoop.hive.metastore.api.ClientCapability.findByValue(iprot.readI32());
                  struct.values.add(_elem787);
=======
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> HIVE-18781: Create/Replicate Abort Txn event
                org.apache.thrift.protocol.TList _list770 = iprot.readListBegin();
                struct.values = new ArrayList<ClientCapability>(_list770.size);
                ClientCapability _elem771;
                for (int _i772 = 0; _i772 < _list770.size; ++_i772)
                {
                  _elem771 = org.apache.hadoop.hive.metastore.api.ClientCapability.findByValue(iprot.readI32());
                  struct.values.add(_elem771);
<<<<<<< HEAD
=======
                org.apache.thrift.protocol.TList _list730 = iprot.readListBegin();
                struct.values = new ArrayList<ClientCapability>(_list730.size);
                ClientCapability _elem731;
                for (int _i732 = 0; _i732 < _list730.size; ++_i732)
                {
                  _elem731 = org.apache.hadoop.hive.metastore.api.ClientCapability.findByValue(iprot.readI32());
                  struct.values.add(_elem731);
>>>>>>> HIVE-18679 : create/replicate open transaction event : After Sankar's review comment fix
=======
                org.apache.thrift.protocol.TList _list730 = iprot.readListBegin();
                struct.values = new ArrayList<ClientCapability>(_list730.size);
                ClientCapability _elem731;
                for (int _i732 = 0; _i732 < _list730.size; ++_i732)
                {
                  _elem731 = org.apache.hadoop.hive.metastore.api.ClientCapability.findByValue(iprot.readI32());
                  struct.values.add(_elem731);
>>>>>>> HIVE-18679 : create/replicate open transaction event : After Sankar's review comment fix
>>>>>>> HIVE-18679 : create/replicate open transaction event
=======
>>>>>>> HIVE-18781: Create/Replicate Abort Txn event
=======
                {
                  _elem787 = org.apache.hadoop.hive.metastore.api.ClientCapability.findByValue(iprot.readI32());
                  struct.values.add(_elem787);
>>>>>>> alloc write id event changes
                }
                iprot.readListEnd();
              }
              struct.setValuesIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ClientCapabilities struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.values != null) {
        oprot.writeFieldBegin(VALUES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.values.size()));
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
          for (ClientCapability _iter789 : struct.values)
          {
            oprot.writeI32(_iter789.getValue());
=======
<<<<<<< HEAD
<<<<<<< HEAD
          for (ClientCapability _iter773 : struct.values)
          {
            oprot.writeI32(_iter773.getValue());
=======
          for (ClientCapability _iter733 : struct.values)
          {
            oprot.writeI32(_iter733.getValue());
>>>>>>> HIVE-18679 : create/replicate open transaction event : After Sankar's review comment fix
=======
          for (ClientCapability _iter733 : struct.values)
          {
            oprot.writeI32(_iter733.getValue());
>>>>>>> HIVE-18679 : create/replicate open transaction event : After Sankar's review comment fix
>>>>>>> HIVE-18679 : create/replicate open transaction event
=======
          for (ClientCapability _iter773 : struct.values)
          {
            oprot.writeI32(_iter773.getValue());
>>>>>>> HIVE-18781: Create/Replicate Abort Txn event
=======
          for (ClientCapability _iter789 : struct.values)
          {
            oprot.writeI32(_iter789.getValue());
>>>>>>> alloc write id event changes
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ClientCapabilitiesTupleSchemeFactory implements SchemeFactory {
    public ClientCapabilitiesTupleScheme getScheme() {
      return new ClientCapabilitiesTupleScheme();
    }
  }

  private static class ClientCapabilitiesTupleScheme extends TupleScheme<ClientCapabilities> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ClientCapabilities struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      {
        oprot.writeI32(struct.values.size());
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        for (ClientCapability _iter790 : struct.values)
        {
          oprot.writeI32(_iter790.getValue());
=======
<<<<<<< HEAD
<<<<<<< HEAD
        for (ClientCapability _iter774 : struct.values)
        {
          oprot.writeI32(_iter774.getValue());
=======
        for (ClientCapability _iter734 : struct.values)
        {
          oprot.writeI32(_iter734.getValue());
>>>>>>> HIVE-18679 : create/replicate open transaction event : After Sankar's review comment fix
=======
        for (ClientCapability _iter734 : struct.values)
        {
          oprot.writeI32(_iter734.getValue());
>>>>>>> HIVE-18679 : create/replicate open transaction event : After Sankar's review comment fix
>>>>>>> HIVE-18679 : create/replicate open transaction event
=======
        for (ClientCapability _iter774 : struct.values)
        {
          oprot.writeI32(_iter774.getValue());
>>>>>>> HIVE-18781: Create/Replicate Abort Txn event
=======
        for (ClientCapability _iter790 : struct.values)
        {
          oprot.writeI32(_iter790.getValue());
>>>>>>> alloc write id event changes
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ClientCapabilities struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> alloc write id event changes
        org.apache.thrift.protocol.TList _list791 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
        struct.values = new ArrayList<ClientCapability>(_list791.size);
        ClientCapability _elem792;
        for (int _i793 = 0; _i793 < _list791.size; ++_i793)
<<<<<<< HEAD
        {
          _elem792 = org.apache.hadoop.hive.metastore.api.ClientCapability.findByValue(iprot.readI32());
          struct.values.add(_elem792);
=======
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> HIVE-18781: Create/Replicate Abort Txn event
        org.apache.thrift.protocol.TList _list775 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
        struct.values = new ArrayList<ClientCapability>(_list775.size);
        ClientCapability _elem776;
        for (int _i777 = 0; _i777 < _list775.size; ++_i777)
        {
          _elem776 = org.apache.hadoop.hive.metastore.api.ClientCapability.findByValue(iprot.readI32());
          struct.values.add(_elem776);
<<<<<<< HEAD
=======
=======
>>>>>>> HIVE-18679 : create/replicate open transaction event : After Sankar's review comment fix
        org.apache.thrift.protocol.TList _list735 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
        struct.values = new ArrayList<ClientCapability>(_list735.size);
        ClientCapability _elem736;
        for (int _i737 = 0; _i737 < _list735.size; ++_i737)
        {
          _elem736 = org.apache.hadoop.hive.metastore.api.ClientCapability.findByValue(iprot.readI32());
          struct.values.add(_elem736);
<<<<<<< HEAD
>>>>>>> HIVE-18679 : create/replicate open transaction event : After Sankar's review comment fix
=======
>>>>>>> HIVE-18679 : create/replicate open transaction event : After Sankar's review comment fix
>>>>>>> HIVE-18679 : create/replicate open transaction event
=======
>>>>>>> HIVE-18781: Create/Replicate Abort Txn event
=======
        {
          _elem792 = org.apache.hadoop.hive.metastore.api.ClientCapability.findByValue(iprot.readI32());
          struct.values.add(_elem792);
>>>>>>> alloc write id event changes
        }
      }
      struct.setValuesIsSet(true);
    }
  }

}

