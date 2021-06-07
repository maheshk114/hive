/**
 * Autogenerated by Thrift Compiler (0.13.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.hadoop.hive.metastore.api;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)")
@org.apache.hadoop.classification.InterfaceAudience.Public @org.apache.hadoop.classification.InterfaceStability.Stable public class WMFullResourcePlan implements org.apache.thrift.TBase<WMFullResourcePlan, WMFullResourcePlan._Fields>, java.io.Serializable, Cloneable, Comparable<WMFullResourcePlan> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("WMFullResourcePlan");

  private static final org.apache.thrift.protocol.TField PLAN_FIELD_DESC = new org.apache.thrift.protocol.TField("plan", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField POOLS_FIELD_DESC = new org.apache.thrift.protocol.TField("pools", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField MAPPINGS_FIELD_DESC = new org.apache.thrift.protocol.TField("mappings", org.apache.thrift.protocol.TType.LIST, (short)3);
  private static final org.apache.thrift.protocol.TField TRIGGERS_FIELD_DESC = new org.apache.thrift.protocol.TField("triggers", org.apache.thrift.protocol.TType.LIST, (short)4);
  private static final org.apache.thrift.protocol.TField POOL_TRIGGERS_FIELD_DESC = new org.apache.thrift.protocol.TField("poolTriggers", org.apache.thrift.protocol.TType.LIST, (short)5);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new WMFullResourcePlanStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new WMFullResourcePlanTupleSchemeFactory();

  private @org.apache.thrift.annotation.Nullable WMResourcePlan plan; // required
  private @org.apache.thrift.annotation.Nullable java.util.List<WMPool> pools; // required
  private @org.apache.thrift.annotation.Nullable java.util.List<WMMapping> mappings; // optional
  private @org.apache.thrift.annotation.Nullable java.util.List<WMTrigger> triggers; // optional
  private @org.apache.thrift.annotation.Nullable java.util.List<WMPoolTrigger> poolTriggers; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PLAN((short)1, "plan"),
    POOLS((short)2, "pools"),
    MAPPINGS((short)3, "mappings"),
    TRIGGERS((short)4, "triggers"),
    POOL_TRIGGERS((short)5, "poolTriggers");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // PLAN
          return PLAN;
        case 2: // POOLS
          return POOLS;
        case 3: // MAPPINGS
          return MAPPINGS;
        case 4: // TRIGGERS
          return TRIGGERS;
        case 5: // POOL_TRIGGERS
          return POOL_TRIGGERS;
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
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.MAPPINGS,_Fields.TRIGGERS,_Fields.POOL_TRIGGERS};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PLAN, new org.apache.thrift.meta_data.FieldMetaData("plan", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, WMResourcePlan.class)));
    tmpMap.put(_Fields.POOLS, new org.apache.thrift.meta_data.FieldMetaData("pools", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, WMPool.class))));
    tmpMap.put(_Fields.MAPPINGS, new org.apache.thrift.meta_data.FieldMetaData("mappings", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, WMMapping.class))));
    tmpMap.put(_Fields.TRIGGERS, new org.apache.thrift.meta_data.FieldMetaData("triggers", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, WMTrigger.class))));
    tmpMap.put(_Fields.POOL_TRIGGERS, new org.apache.thrift.meta_data.FieldMetaData("poolTriggers", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, WMPoolTrigger.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(WMFullResourcePlan.class, metaDataMap);
  }

  public WMFullResourcePlan() {
  }

  public WMFullResourcePlan(
    WMResourcePlan plan,
    java.util.List<WMPool> pools)
  {
    this();
    this.plan = plan;
    this.pools = pools;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public WMFullResourcePlan(WMFullResourcePlan other) {
    if (other.isSetPlan()) {
      this.plan = new WMResourcePlan(other.plan);
    }
    if (other.isSetPools()) {
      java.util.List<WMPool> __this__pools = new java.util.ArrayList<WMPool>(other.pools.size());
      for (WMPool other_element : other.pools) {
        __this__pools.add(new WMPool(other_element));
      }
      this.pools = __this__pools;
    }
    if (other.isSetMappings()) {
      java.util.List<WMMapping> __this__mappings = new java.util.ArrayList<WMMapping>(other.mappings.size());
      for (WMMapping other_element : other.mappings) {
        __this__mappings.add(new WMMapping(other_element));
      }
      this.mappings = __this__mappings;
    }
    if (other.isSetTriggers()) {
      java.util.List<WMTrigger> __this__triggers = new java.util.ArrayList<WMTrigger>(other.triggers.size());
      for (WMTrigger other_element : other.triggers) {
        __this__triggers.add(new WMTrigger(other_element));
      }
      this.triggers = __this__triggers;
    }
    if (other.isSetPoolTriggers()) {
      java.util.List<WMPoolTrigger> __this__poolTriggers = new java.util.ArrayList<WMPoolTrigger>(other.poolTriggers.size());
      for (WMPoolTrigger other_element : other.poolTriggers) {
        __this__poolTriggers.add(new WMPoolTrigger(other_element));
      }
      this.poolTriggers = __this__poolTriggers;
    }
  }

  public WMFullResourcePlan deepCopy() {
    return new WMFullResourcePlan(this);
  }

  @Override
  public void clear() {
    this.plan = null;
    this.pools = null;
    this.mappings = null;
    this.triggers = null;
    this.poolTriggers = null;
  }

  @org.apache.thrift.annotation.Nullable
  public WMResourcePlan getPlan() {
    return this.plan;
  }

  public void setPlan(@org.apache.thrift.annotation.Nullable WMResourcePlan plan) {
    this.plan = plan;
  }

  public void unsetPlan() {
    this.plan = null;
  }

  /** Returns true if field plan is set (has been assigned a value) and false otherwise */
  public boolean isSetPlan() {
    return this.plan != null;
  }

  public void setPlanIsSet(boolean value) {
    if (!value) {
      this.plan = null;
    }
  }

  public int getPoolsSize() {
    return (this.pools == null) ? 0 : this.pools.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<WMPool> getPoolsIterator() {
    return (this.pools == null) ? null : this.pools.iterator();
  }

  public void addToPools(WMPool elem) {
    if (this.pools == null) {
      this.pools = new java.util.ArrayList<WMPool>();
    }
    this.pools.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<WMPool> getPools() {
    return this.pools;
  }

  public void setPools(@org.apache.thrift.annotation.Nullable java.util.List<WMPool> pools) {
    this.pools = pools;
  }

  public void unsetPools() {
    this.pools = null;
  }

  /** Returns true if field pools is set (has been assigned a value) and false otherwise */
  public boolean isSetPools() {
    return this.pools != null;
  }

  public void setPoolsIsSet(boolean value) {
    if (!value) {
      this.pools = null;
    }
  }

  public int getMappingsSize() {
    return (this.mappings == null) ? 0 : this.mappings.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<WMMapping> getMappingsIterator() {
    return (this.mappings == null) ? null : this.mappings.iterator();
  }

  public void addToMappings(WMMapping elem) {
    if (this.mappings == null) {
      this.mappings = new java.util.ArrayList<WMMapping>();
    }
    this.mappings.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<WMMapping> getMappings() {
    return this.mappings;
  }

  public void setMappings(@org.apache.thrift.annotation.Nullable java.util.List<WMMapping> mappings) {
    this.mappings = mappings;
  }

  public void unsetMappings() {
    this.mappings = null;
  }

  /** Returns true if field mappings is set (has been assigned a value) and false otherwise */
  public boolean isSetMappings() {
    return this.mappings != null;
  }

  public void setMappingsIsSet(boolean value) {
    if (!value) {
      this.mappings = null;
    }
  }

  public int getTriggersSize() {
    return (this.triggers == null) ? 0 : this.triggers.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<WMTrigger> getTriggersIterator() {
    return (this.triggers == null) ? null : this.triggers.iterator();
  }

  public void addToTriggers(WMTrigger elem) {
    if (this.triggers == null) {
      this.triggers = new java.util.ArrayList<WMTrigger>();
    }
    this.triggers.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<WMTrigger> getTriggers() {
    return this.triggers;
  }

  public void setTriggers(@org.apache.thrift.annotation.Nullable java.util.List<WMTrigger> triggers) {
    this.triggers = triggers;
  }

  public void unsetTriggers() {
    this.triggers = null;
  }

  /** Returns true if field triggers is set (has been assigned a value) and false otherwise */
  public boolean isSetTriggers() {
    return this.triggers != null;
  }

  public void setTriggersIsSet(boolean value) {
    if (!value) {
      this.triggers = null;
    }
  }

  public int getPoolTriggersSize() {
    return (this.poolTriggers == null) ? 0 : this.poolTriggers.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<WMPoolTrigger> getPoolTriggersIterator() {
    return (this.poolTriggers == null) ? null : this.poolTriggers.iterator();
  }

  public void addToPoolTriggers(WMPoolTrigger elem) {
    if (this.poolTriggers == null) {
      this.poolTriggers = new java.util.ArrayList<WMPoolTrigger>();
    }
    this.poolTriggers.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<WMPoolTrigger> getPoolTriggers() {
    return this.poolTriggers;
  }

  public void setPoolTriggers(@org.apache.thrift.annotation.Nullable java.util.List<WMPoolTrigger> poolTriggers) {
    this.poolTriggers = poolTriggers;
  }

  public void unsetPoolTriggers() {
    this.poolTriggers = null;
  }

  /** Returns true if field poolTriggers is set (has been assigned a value) and false otherwise */
  public boolean isSetPoolTriggers() {
    return this.poolTriggers != null;
  }

  public void setPoolTriggersIsSet(boolean value) {
    if (!value) {
      this.poolTriggers = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case PLAN:
      if (value == null) {
        unsetPlan();
      } else {
        setPlan((WMResourcePlan)value);
      }
      break;

    case POOLS:
      if (value == null) {
        unsetPools();
      } else {
        setPools((java.util.List<WMPool>)value);
      }
      break;

    case MAPPINGS:
      if (value == null) {
        unsetMappings();
      } else {
        setMappings((java.util.List<WMMapping>)value);
      }
      break;

    case TRIGGERS:
      if (value == null) {
        unsetTriggers();
      } else {
        setTriggers((java.util.List<WMTrigger>)value);
      }
      break;

    case POOL_TRIGGERS:
      if (value == null) {
        unsetPoolTriggers();
      } else {
        setPoolTriggers((java.util.List<WMPoolTrigger>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case PLAN:
      return getPlan();

    case POOLS:
      return getPools();

    case MAPPINGS:
      return getMappings();

    case TRIGGERS:
      return getTriggers();

    case POOL_TRIGGERS:
      return getPoolTriggers();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case PLAN:
      return isSetPlan();
    case POOLS:
      return isSetPools();
    case MAPPINGS:
      return isSetMappings();
    case TRIGGERS:
      return isSetTriggers();
    case POOL_TRIGGERS:
      return isSetPoolTriggers();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof WMFullResourcePlan)
      return this.equals((WMFullResourcePlan)that);
    return false;
  }

  public boolean equals(WMFullResourcePlan that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_plan = true && this.isSetPlan();
    boolean that_present_plan = true && that.isSetPlan();
    if (this_present_plan || that_present_plan) {
      if (!(this_present_plan && that_present_plan))
        return false;
      if (!this.plan.equals(that.plan))
        return false;
    }

    boolean this_present_pools = true && this.isSetPools();
    boolean that_present_pools = true && that.isSetPools();
    if (this_present_pools || that_present_pools) {
      if (!(this_present_pools && that_present_pools))
        return false;
      if (!this.pools.equals(that.pools))
        return false;
    }

    boolean this_present_mappings = true && this.isSetMappings();
    boolean that_present_mappings = true && that.isSetMappings();
    if (this_present_mappings || that_present_mappings) {
      if (!(this_present_mappings && that_present_mappings))
        return false;
      if (!this.mappings.equals(that.mappings))
        return false;
    }

    boolean this_present_triggers = true && this.isSetTriggers();
    boolean that_present_triggers = true && that.isSetTriggers();
    if (this_present_triggers || that_present_triggers) {
      if (!(this_present_triggers && that_present_triggers))
        return false;
      if (!this.triggers.equals(that.triggers))
        return false;
    }

    boolean this_present_poolTriggers = true && this.isSetPoolTriggers();
    boolean that_present_poolTriggers = true && that.isSetPoolTriggers();
    if (this_present_poolTriggers || that_present_poolTriggers) {
      if (!(this_present_poolTriggers && that_present_poolTriggers))
        return false;
      if (!this.poolTriggers.equals(that.poolTriggers))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetPlan()) ? 131071 : 524287);
    if (isSetPlan())
      hashCode = hashCode * 8191 + plan.hashCode();

    hashCode = hashCode * 8191 + ((isSetPools()) ? 131071 : 524287);
    if (isSetPools())
      hashCode = hashCode * 8191 + pools.hashCode();

    hashCode = hashCode * 8191 + ((isSetMappings()) ? 131071 : 524287);
    if (isSetMappings())
      hashCode = hashCode * 8191 + mappings.hashCode();

    hashCode = hashCode * 8191 + ((isSetTriggers()) ? 131071 : 524287);
    if (isSetTriggers())
      hashCode = hashCode * 8191 + triggers.hashCode();

    hashCode = hashCode * 8191 + ((isSetPoolTriggers()) ? 131071 : 524287);
    if (isSetPoolTriggers())
      hashCode = hashCode * 8191 + poolTriggers.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(WMFullResourcePlan other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetPlan()).compareTo(other.isSetPlan());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPlan()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.plan, other.plan);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetPools()).compareTo(other.isSetPools());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPools()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pools, other.pools);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetMappings()).compareTo(other.isSetMappings());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMappings()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mappings, other.mappings);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetTriggers()).compareTo(other.isSetTriggers());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTriggers()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.triggers, other.triggers);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetPoolTriggers()).compareTo(other.isSetPoolTriggers());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPoolTriggers()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.poolTriggers, other.poolTriggers);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("WMFullResourcePlan(");
    boolean first = true;

    sb.append("plan:");
    if (this.plan == null) {
      sb.append("null");
    } else {
      sb.append(this.plan);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("pools:");
    if (this.pools == null) {
      sb.append("null");
    } else {
      sb.append(this.pools);
    }
    first = false;
    if (isSetMappings()) {
      if (!first) sb.append(", ");
      sb.append("mappings:");
      if (this.mappings == null) {
        sb.append("null");
      } else {
        sb.append(this.mappings);
      }
      first = false;
    }
    if (isSetTriggers()) {
      if (!first) sb.append(", ");
      sb.append("triggers:");
      if (this.triggers == null) {
        sb.append("null");
      } else {
        sb.append(this.triggers);
      }
      first = false;
    }
    if (isSetPoolTriggers()) {
      if (!first) sb.append(", ");
      sb.append("poolTriggers:");
      if (this.poolTriggers == null) {
        sb.append("null");
      } else {
        sb.append(this.poolTriggers);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetPlan()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'plan' is unset! Struct:" + toString());
    }

    if (!isSetPools()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'pools' is unset! Struct:" + toString());
    }

    // check for sub-struct validity
    if (plan != null) {
      plan.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class WMFullResourcePlanStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public WMFullResourcePlanStandardScheme getScheme() {
      return new WMFullResourcePlanStandardScheme();
    }
  }

  private static class WMFullResourcePlanStandardScheme extends org.apache.thrift.scheme.StandardScheme<WMFullResourcePlan> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, WMFullResourcePlan struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PLAN
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.plan = new WMResourcePlan();
              struct.plan.read(iprot);
              struct.setPlanIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // POOLS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list1098 = iprot.readListBegin();
                struct.pools = new java.util.ArrayList<WMPool>(_list1098.size);
                @org.apache.thrift.annotation.Nullable WMPool _elem1099;
                for (int _i1100 = 0; _i1100 < _list1098.size; ++_i1100)
                {
                  _elem1099 = new WMPool();
                  _elem1099.read(iprot);
                  struct.pools.add(_elem1099);
                }
                iprot.readListEnd();
              }
              struct.setPoolsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // MAPPINGS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list1101 = iprot.readListBegin();
                struct.mappings = new java.util.ArrayList<WMMapping>(_list1101.size);
                @org.apache.thrift.annotation.Nullable WMMapping _elem1102;
                for (int _i1103 = 0; _i1103 < _list1101.size; ++_i1103)
                {
                  _elem1102 = new WMMapping();
                  _elem1102.read(iprot);
                  struct.mappings.add(_elem1102);
                }
                iprot.readListEnd();
              }
              struct.setMappingsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TRIGGERS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list1104 = iprot.readListBegin();
                struct.triggers = new java.util.ArrayList<WMTrigger>(_list1104.size);
                @org.apache.thrift.annotation.Nullable WMTrigger _elem1105;
                for (int _i1106 = 0; _i1106 < _list1104.size; ++_i1106)
                {
                  _elem1105 = new WMTrigger();
                  _elem1105.read(iprot);
                  struct.triggers.add(_elem1105);
                }
                iprot.readListEnd();
              }
              struct.setTriggersIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // POOL_TRIGGERS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list1107 = iprot.readListBegin();
                struct.poolTriggers = new java.util.ArrayList<WMPoolTrigger>(_list1107.size);
                @org.apache.thrift.annotation.Nullable WMPoolTrigger _elem1108;
                for (int _i1109 = 0; _i1109 < _list1107.size; ++_i1109)
                {
                  _elem1108 = new WMPoolTrigger();
                  _elem1108.read(iprot);
                  struct.poolTriggers.add(_elem1108);
                }
                iprot.readListEnd();
              }
              struct.setPoolTriggersIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, WMFullResourcePlan struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.plan != null) {
        oprot.writeFieldBegin(PLAN_FIELD_DESC);
        struct.plan.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.pools != null) {
        oprot.writeFieldBegin(POOLS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.pools.size()));
          for (WMPool _iter1110 : struct.pools)
          {
            _iter1110.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.mappings != null) {
        if (struct.isSetMappings()) {
          oprot.writeFieldBegin(MAPPINGS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.mappings.size()));
            for (WMMapping _iter1111 : struct.mappings)
            {
              _iter1111.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.triggers != null) {
        if (struct.isSetTriggers()) {
          oprot.writeFieldBegin(TRIGGERS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.triggers.size()));
            for (WMTrigger _iter1112 : struct.triggers)
            {
              _iter1112.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.poolTriggers != null) {
        if (struct.isSetPoolTriggers()) {
          oprot.writeFieldBegin(POOL_TRIGGERS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.poolTriggers.size()));
            for (WMPoolTrigger _iter1113 : struct.poolTriggers)
            {
              _iter1113.write(oprot);
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

  private static class WMFullResourcePlanTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public WMFullResourcePlanTupleScheme getScheme() {
      return new WMFullResourcePlanTupleScheme();
    }
  }

  private static class WMFullResourcePlanTupleScheme extends org.apache.thrift.scheme.TupleScheme<WMFullResourcePlan> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, WMFullResourcePlan struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.plan.write(oprot);
      {
        oprot.writeI32(struct.pools.size());
        for (WMPool _iter1114 : struct.pools)
        {
          _iter1114.write(oprot);
        }
      }
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetMappings()) {
        optionals.set(0);
      }
      if (struct.isSetTriggers()) {
        optionals.set(1);
      }
      if (struct.isSetPoolTriggers()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetMappings()) {
        {
          oprot.writeI32(struct.mappings.size());
          for (WMMapping _iter1115 : struct.mappings)
          {
            _iter1115.write(oprot);
          }
        }
      }
      if (struct.isSetTriggers()) {
        {
          oprot.writeI32(struct.triggers.size());
          for (WMTrigger _iter1116 : struct.triggers)
          {
            _iter1116.write(oprot);
          }
        }
      }
      if (struct.isSetPoolTriggers()) {
        {
          oprot.writeI32(struct.poolTriggers.size());
          for (WMPoolTrigger _iter1117 : struct.poolTriggers)
          {
            _iter1117.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, WMFullResourcePlan struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.plan = new WMResourcePlan();
      struct.plan.read(iprot);
      struct.setPlanIsSet(true);
      {
        org.apache.thrift.protocol.TList _list1118 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.pools = new java.util.ArrayList<WMPool>(_list1118.size);
        @org.apache.thrift.annotation.Nullable WMPool _elem1119;
        for (int _i1120 = 0; _i1120 < _list1118.size; ++_i1120)
        {
          _elem1119 = new WMPool();
          _elem1119.read(iprot);
          struct.pools.add(_elem1119);
        }
      }
      struct.setPoolsIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list1121 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.mappings = new java.util.ArrayList<WMMapping>(_list1121.size);
          @org.apache.thrift.annotation.Nullable WMMapping _elem1122;
          for (int _i1123 = 0; _i1123 < _list1121.size; ++_i1123)
          {
            _elem1122 = new WMMapping();
            _elem1122.read(iprot);
            struct.mappings.add(_elem1122);
          }
        }
        struct.setMappingsIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list1124 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.triggers = new java.util.ArrayList<WMTrigger>(_list1124.size);
          @org.apache.thrift.annotation.Nullable WMTrigger _elem1125;
          for (int _i1126 = 0; _i1126 < _list1124.size; ++_i1126)
          {
            _elem1125 = new WMTrigger();
            _elem1125.read(iprot);
            struct.triggers.add(_elem1125);
          }
        }
        struct.setTriggersIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list1127 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.poolTriggers = new java.util.ArrayList<WMPoolTrigger>(_list1127.size);
          @org.apache.thrift.annotation.Nullable WMPoolTrigger _elem1128;
          for (int _i1129 = 0; _i1129 < _list1127.size; ++_i1129)
          {
            _elem1128 = new WMPoolTrigger();
            _elem1128.read(iprot);
            struct.poolTriggers.add(_elem1128);
          }
        }
        struct.setPoolTriggersIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

