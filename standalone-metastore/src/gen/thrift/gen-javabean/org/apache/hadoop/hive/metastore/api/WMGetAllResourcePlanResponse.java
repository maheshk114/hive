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
@org.apache.hadoop.classification.InterfaceAudience.Public @org.apache.hadoop.classification.InterfaceStability.Stable public class WMGetAllResourcePlanResponse implements org.apache.thrift.TBase<WMGetAllResourcePlanResponse, WMGetAllResourcePlanResponse._Fields>, java.io.Serializable, Cloneable, Comparable<WMGetAllResourcePlanResponse> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("WMGetAllResourcePlanResponse");

  private static final org.apache.thrift.protocol.TField RESOURCE_PLANS_FIELD_DESC = new org.apache.thrift.protocol.TField("resourcePlans", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new WMGetAllResourcePlanResponseStandardSchemeFactory());
    schemes.put(TupleScheme.class, new WMGetAllResourcePlanResponseTupleSchemeFactory());
  }

  private List<WMResourcePlan> resourcePlans; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RESOURCE_PLANS((short)1, "resourcePlans");

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
        case 1: // RESOURCE_PLANS
          return RESOURCE_PLANS;
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
  private static final _Fields optionals[] = {_Fields.RESOURCE_PLANS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RESOURCE_PLANS, new org.apache.thrift.meta_data.FieldMetaData("resourcePlans", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, WMResourcePlan.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(WMGetAllResourcePlanResponse.class, metaDataMap);
  }

  public WMGetAllResourcePlanResponse() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public WMGetAllResourcePlanResponse(WMGetAllResourcePlanResponse other) {
    if (other.isSetResourcePlans()) {
      List<WMResourcePlan> __this__resourcePlans = new ArrayList<WMResourcePlan>(other.resourcePlans.size());
      for (WMResourcePlan other_element : other.resourcePlans) {
        __this__resourcePlans.add(new WMResourcePlan(other_element));
      }
      this.resourcePlans = __this__resourcePlans;
    }
  }

  public WMGetAllResourcePlanResponse deepCopy() {
    return new WMGetAllResourcePlanResponse(this);
  }

  @Override
  public void clear() {
    this.resourcePlans = null;
  }

  public int getResourcePlansSize() {
    return (this.resourcePlans == null) ? 0 : this.resourcePlans.size();
  }

  public java.util.Iterator<WMResourcePlan> getResourcePlansIterator() {
    return (this.resourcePlans == null) ? null : this.resourcePlans.iterator();
  }

  public void addToResourcePlans(WMResourcePlan elem) {
    if (this.resourcePlans == null) {
      this.resourcePlans = new ArrayList<WMResourcePlan>();
    }
    this.resourcePlans.add(elem);
  }

  public List<WMResourcePlan> getResourcePlans() {
    return this.resourcePlans;
  }

  public void setResourcePlans(List<WMResourcePlan> resourcePlans) {
    this.resourcePlans = resourcePlans;
  }

  public void unsetResourcePlans() {
    this.resourcePlans = null;
  }

  /** Returns true if field resourcePlans is set (has been assigned a value) and false otherwise */
  public boolean isSetResourcePlans() {
    return this.resourcePlans != null;
  }

  public void setResourcePlansIsSet(boolean value) {
    if (!value) {
      this.resourcePlans = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RESOURCE_PLANS:
      if (value == null) {
        unsetResourcePlans();
      } else {
        setResourcePlans((List<WMResourcePlan>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RESOURCE_PLANS:
      return getResourcePlans();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RESOURCE_PLANS:
      return isSetResourcePlans();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof WMGetAllResourcePlanResponse)
      return this.equals((WMGetAllResourcePlanResponse)that);
    return false;
  }

  public boolean equals(WMGetAllResourcePlanResponse that) {
    if (that == null)
      return false;

    boolean this_present_resourcePlans = true && this.isSetResourcePlans();
    boolean that_present_resourcePlans = true && that.isSetResourcePlans();
    if (this_present_resourcePlans || that_present_resourcePlans) {
      if (!(this_present_resourcePlans && that_present_resourcePlans))
        return false;
      if (!this.resourcePlans.equals(that.resourcePlans))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_resourcePlans = true && (isSetResourcePlans());
    list.add(present_resourcePlans);
    if (present_resourcePlans)
      list.add(resourcePlans);

    return list.hashCode();
  }

  @Override
  public int compareTo(WMGetAllResourcePlanResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetResourcePlans()).compareTo(other.isSetResourcePlans());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResourcePlans()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.resourcePlans, other.resourcePlans);
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
    StringBuilder sb = new StringBuilder("WMGetAllResourcePlanResponse(");
    boolean first = true;

    if (isSetResourcePlans()) {
      sb.append("resourcePlans:");
      if (this.resourcePlans == null) {
        sb.append("null");
      } else {
        sb.append(this.resourcePlans);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
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

  private static class WMGetAllResourcePlanResponseStandardSchemeFactory implements SchemeFactory {
    public WMGetAllResourcePlanResponseStandardScheme getScheme() {
      return new WMGetAllResourcePlanResponseStandardScheme();
    }
  }

  private static class WMGetAllResourcePlanResponseStandardScheme extends StandardScheme<WMGetAllResourcePlanResponse> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, WMGetAllResourcePlanResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // RESOURCE_PLANS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> HIVE-18781 : Create/Replicate Open, Commit(without write) and Abort Txn event : Thrift changes
                org.apache.thrift.protocol.TList _list856 = iprot.readListBegin();
                struct.resourcePlans = new ArrayList<WMResourcePlan>(_list856.size);
                WMResourcePlan _elem857;
                for (int _i858 = 0; _i858 < _list856.size; ++_i858)
<<<<<<< HEAD
                {
                  _elem857 = new WMResourcePlan();
                  _elem857.read(iprot);
                  struct.resourcePlans.add(_elem857);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
<<<<<<< HEAD
                org.apache.thrift.protocol.TList _list848 = iprot.readListBegin();
                struct.resourcePlans = new ArrayList<WMResourcePlan>(_list848.size);
                WMResourcePlan _elem849;
                for (int _i850 = 0; _i850 < _list848.size; ++_i850)
                {
                  _elem849 = new WMResourcePlan();
                  _elem849.read(iprot);
                  struct.resourcePlans.add(_elem849);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
<<<<<<< HEAD
                org.apache.thrift.protocol.TList _list832 = iprot.readListBegin();
                struct.resourcePlans = new ArrayList<WMResourcePlan>(_list832.size);
                WMResourcePlan _elem833;
                for (int _i834 = 0; _i834 < _list832.size; ++_i834)
                {
                  _elem833 = new WMResourcePlan();
                  _elem833.read(iprot);
                  struct.resourcePlans.add(_elem833);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
                org.apache.thrift.protocol.TList _list850 = iprot.readListBegin();
                struct.resourcePlans = new ArrayList<WMResourcePlan>(_list850.size);
                WMResourcePlan _elem851;
                for (int _i852 = 0; _i852 < _list850.size; ++_i852)
                {
                  _elem851 = new WMResourcePlan();
                  _elem851.read(iprot);
                  struct.resourcePlans.add(_elem851);
<<<<<<< HEAD
>>>>>>> HIVE-18679 : create/replicate open transaction event
<<<<<<< HEAD
>>>>>>> HIVE-18679 : create/replicate open transaction event
<<<<<<< HEAD
>>>>>>> HIVE-18679 : create/replicate open transaction event
=======
=======
=======
=======
                org.apache.thrift.protocol.TList _list834 = iprot.readListBegin();
                struct.resourcePlans = new ArrayList<WMResourcePlan>(_list834.size);
                WMResourcePlan _elem835;
                for (int _i836 = 0; _i836 < _list834.size; ++_i836)
                {
                  _elem835 = new WMResourcePlan();
                  _elem835.read(iprot);
                  struct.resourcePlans.add(_elem835);
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
<<<<<<< HEAD
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
=======
=======
                org.apache.thrift.protocol.TList _list840 = iprot.readListBegin();
                struct.resourcePlans = new ArrayList<WMResourcePlan>(_list840.size);
                WMResourcePlan _elem841;
                for (int _i842 = 0; _i842 < _list840.size; ++_i842)
                {
                  _elem841 = new WMResourcePlan();
                  _elem841.read(iprot);
                  struct.resourcePlans.add(_elem841);
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
=======
                {
                  _elem857 = new WMResourcePlan();
                  _elem857.read(iprot);
                  struct.resourcePlans.add(_elem857);
>>>>>>> HIVE-18781 : Create/Replicate Open, Commit(without write) and Abort Txn event : Thrift changes
                }
                iprot.readListEnd();
              }
              struct.setResourcePlansIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, WMGetAllResourcePlanResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.resourcePlans != null) {
        if (struct.isSetResourcePlans()) {
          oprot.writeFieldBegin(RESOURCE_PLANS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.resourcePlans.size()));
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
            for (WMResourcePlan _iter859 : struct.resourcePlans)
            {
              _iter859.write(oprot);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
<<<<<<< HEAD
            for (WMResourcePlan _iter851 : struct.resourcePlans)
            {
              _iter851.write(oprot);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
<<<<<<< HEAD
            for (WMResourcePlan _iter835 : struct.resourcePlans)
            {
              _iter835.write(oprot);
=======
            for (WMResourcePlan _iter853 : struct.resourcePlans)
            {
              _iter853.write(oprot);
>>>>>>> HIVE-18679 : create/replicate open transaction event
<<<<<<< HEAD
>>>>>>> HIVE-18679 : create/replicate open transaction event
<<<<<<< HEAD
>>>>>>> HIVE-18679 : create/replicate open transaction event
=======
=======
=======
            for (WMResourcePlan _iter853 : struct.resourcePlans)
            {
              _iter853.write(oprot);
=======
            for (WMResourcePlan _iter837 : struct.resourcePlans)
            {
              _iter837.write(oprot);
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
<<<<<<< HEAD
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
=======
=======
            for (WMResourcePlan _iter843 : struct.resourcePlans)
            {
              _iter843.write(oprot);
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
=======
            for (WMResourcePlan _iter859 : struct.resourcePlans)
            {
              _iter859.write(oprot);
>>>>>>> HIVE-18781 : Create/Replicate Open, Commit(without write) and Abort Txn event : Thrift changes
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

  private static class WMGetAllResourcePlanResponseTupleSchemeFactory implements SchemeFactory {
    public WMGetAllResourcePlanResponseTupleScheme getScheme() {
      return new WMGetAllResourcePlanResponseTupleScheme();
    }
  }

  private static class WMGetAllResourcePlanResponseTupleScheme extends TupleScheme<WMGetAllResourcePlanResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, WMGetAllResourcePlanResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetResourcePlans()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetResourcePlans()) {
        {
          oprot.writeI32(struct.resourcePlans.size());
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
          for (WMResourcePlan _iter860 : struct.resourcePlans)
          {
            _iter860.write(oprot);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
<<<<<<< HEAD
          for (WMResourcePlan _iter852 : struct.resourcePlans)
          {
            _iter852.write(oprot);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
<<<<<<< HEAD
          for (WMResourcePlan _iter836 : struct.resourcePlans)
          {
            _iter836.write(oprot);
=======
          for (WMResourcePlan _iter854 : struct.resourcePlans)
          {
            _iter854.write(oprot);
>>>>>>> HIVE-18679 : create/replicate open transaction event
<<<<<<< HEAD
>>>>>>> HIVE-18679 : create/replicate open transaction event
<<<<<<< HEAD
>>>>>>> HIVE-18679 : create/replicate open transaction event
=======
=======
=======
          for (WMResourcePlan _iter854 : struct.resourcePlans)
          {
            _iter854.write(oprot);
=======
          for (WMResourcePlan _iter838 : struct.resourcePlans)
          {
            _iter838.write(oprot);
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
<<<<<<< HEAD
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
=======
=======
          for (WMResourcePlan _iter844 : struct.resourcePlans)
          {
            _iter844.write(oprot);
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
=======
          for (WMResourcePlan _iter860 : struct.resourcePlans)
          {
            _iter860.write(oprot);
>>>>>>> HIVE-18781 : Create/Replicate Open, Commit(without write) and Abort Txn event : Thrift changes
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, WMGetAllResourcePlanResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> HIVE-18781 : Create/Replicate Open, Commit(without write) and Abort Txn event : Thrift changes
          org.apache.thrift.protocol.TList _list861 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.resourcePlans = new ArrayList<WMResourcePlan>(_list861.size);
          WMResourcePlan _elem862;
          for (int _i863 = 0; _i863 < _list861.size; ++_i863)
<<<<<<< HEAD
          {
            _elem862 = new WMResourcePlan();
            _elem862.read(iprot);
            struct.resourcePlans.add(_elem862);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
<<<<<<< HEAD
          org.apache.thrift.protocol.TList _list853 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.resourcePlans = new ArrayList<WMResourcePlan>(_list853.size);
          WMResourcePlan _elem854;
          for (int _i855 = 0; _i855 < _list853.size; ++_i855)
          {
            _elem854 = new WMResourcePlan();
            _elem854.read(iprot);
            struct.resourcePlans.add(_elem854);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
<<<<<<< HEAD
          org.apache.thrift.protocol.TList _list837 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.resourcePlans = new ArrayList<WMResourcePlan>(_list837.size);
          WMResourcePlan _elem838;
          for (int _i839 = 0; _i839 < _list837.size; ++_i839)
          {
            _elem838 = new WMResourcePlan();
            _elem838.read(iprot);
            struct.resourcePlans.add(_elem838);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
          org.apache.thrift.protocol.TList _list855 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.resourcePlans = new ArrayList<WMResourcePlan>(_list855.size);
          WMResourcePlan _elem856;
          for (int _i857 = 0; _i857 < _list855.size; ++_i857)
          {
            _elem856 = new WMResourcePlan();
            _elem856.read(iprot);
            struct.resourcePlans.add(_elem856);
<<<<<<< HEAD
>>>>>>> HIVE-18679 : create/replicate open transaction event
<<<<<<< HEAD
>>>>>>> HIVE-18679 : create/replicate open transaction event
<<<<<<< HEAD
>>>>>>> HIVE-18679 : create/replicate open transaction event
=======
=======
=======
=======
          org.apache.thrift.protocol.TList _list839 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.resourcePlans = new ArrayList<WMResourcePlan>(_list839.size);
          WMResourcePlan _elem840;
          for (int _i841 = 0; _i841 < _list839.size; ++_i841)
          {
            _elem840 = new WMResourcePlan();
            _elem840.read(iprot);
            struct.resourcePlans.add(_elem840);
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
<<<<<<< HEAD
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
=======
=======
          org.apache.thrift.protocol.TList _list845 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.resourcePlans = new ArrayList<WMResourcePlan>(_list845.size);
          WMResourcePlan _elem846;
          for (int _i847 = 0; _i847 < _list845.size; ++_i847)
          {
            _elem846 = new WMResourcePlan();
            _elem846.read(iprot);
            struct.resourcePlans.add(_elem846);
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
=======
          {
            _elem862 = new WMResourcePlan();
            _elem862.read(iprot);
            struct.resourcePlans.add(_elem862);
>>>>>>> HIVE-18781 : Create/Replicate Open, Commit(without write) and Abort Txn event : Thrift changes
          }
        }
        struct.setResourcePlansIsSet(true);
      }
    }
  }

}

