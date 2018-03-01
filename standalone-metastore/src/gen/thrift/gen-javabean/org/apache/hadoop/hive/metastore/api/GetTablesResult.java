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
@org.apache.hadoop.classification.InterfaceAudience.Public @org.apache.hadoop.classification.InterfaceStability.Stable public class GetTablesResult implements org.apache.thrift.TBase<GetTablesResult, GetTablesResult._Fields>, java.io.Serializable, Cloneable, Comparable<GetTablesResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("GetTablesResult");

  private static final org.apache.thrift.protocol.TField TABLES_FIELD_DESC = new org.apache.thrift.protocol.TField("tables", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new GetTablesResultStandardSchemeFactory());
    schemes.put(TupleScheme.class, new GetTablesResultTupleSchemeFactory());
  }

  private List<Table> tables; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TABLES((short)1, "tables");

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
        case 1: // TABLES
          return TABLES;
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
    tmpMap.put(_Fields.TABLES, new org.apache.thrift.meta_data.FieldMetaData("tables", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Table.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(GetTablesResult.class, metaDataMap);
  }

  public GetTablesResult() {
  }

  public GetTablesResult(
    List<Table> tables)
  {
    this();
    this.tables = tables;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public GetTablesResult(GetTablesResult other) {
    if (other.isSetTables()) {
      List<Table> __this__tables = new ArrayList<Table>(other.tables.size());
      for (Table other_element : other.tables) {
        __this__tables.add(new Table(other_element));
      }
      this.tables = __this__tables;
    }
  }

  public GetTablesResult deepCopy() {
    return new GetTablesResult(this);
  }

  @Override
  public void clear() {
    this.tables = null;
  }

  public int getTablesSize() {
    return (this.tables == null) ? 0 : this.tables.size();
  }

  public java.util.Iterator<Table> getTablesIterator() {
    return (this.tables == null) ? null : this.tables.iterator();
  }

  public void addToTables(Table elem) {
    if (this.tables == null) {
      this.tables = new ArrayList<Table>();
    }
    this.tables.add(elem);
  }

  public List<Table> getTables() {
    return this.tables;
  }

  public void setTables(List<Table> tables) {
    this.tables = tables;
  }

  public void unsetTables() {
    this.tables = null;
  }

  /** Returns true if field tables is set (has been assigned a value) and false otherwise */
  public boolean isSetTables() {
    return this.tables != null;
  }

  public void setTablesIsSet(boolean value) {
    if (!value) {
      this.tables = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TABLES:
      if (value == null) {
        unsetTables();
      } else {
        setTables((List<Table>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TABLES:
      return getTables();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TABLES:
      return isSetTables();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof GetTablesResult)
      return this.equals((GetTablesResult)that);
    return false;
  }

  public boolean equals(GetTablesResult that) {
    if (that == null)
      return false;

    boolean this_present_tables = true && this.isSetTables();
    boolean that_present_tables = true && that.isSetTables();
    if (this_present_tables || that_present_tables) {
      if (!(this_present_tables && that_present_tables))
        return false;
      if (!this.tables.equals(that.tables))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_tables = true && (isSetTables());
    list.add(present_tables);
    if (present_tables)
      list.add(tables);

    return list.hashCode();
  }

  @Override
  public int compareTo(GetTablesResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetTables()).compareTo(other.isSetTables());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTables()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tables, other.tables);
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
    StringBuilder sb = new StringBuilder("GetTablesResult(");
    boolean first = true;

    sb.append("tables:");
    if (this.tables == null) {
      sb.append("null");
    } else {
      sb.append(this.tables);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetTables()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'tables' is unset! Struct:" + toString());
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

  private static class GetTablesResultStandardSchemeFactory implements SchemeFactory {
    public GetTablesResultStandardScheme getScheme() {
      return new GetTablesResultStandardScheme();
    }
  }

  private static class GetTablesResultStandardScheme extends StandardScheme<GetTablesResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, GetTablesResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TABLES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                org.apache.thrift.protocol.TList _list808 = iprot.readListBegin();
                struct.tables = new ArrayList<Table>(_list808.size);
                Table _elem809;
                for (int _i810 = 0; _i810 < _list808.size; ++_i810)
                {
                  _elem809 = new Table();
                  _elem809.read(iprot);
                  struct.tables.add(_elem809);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
<<<<<<< HEAD
                org.apache.thrift.protocol.TList _list800 = iprot.readListBegin();
                struct.tables = new ArrayList<Table>(_list800.size);
                Table _elem801;
                for (int _i802 = 0; _i802 < _list800.size; ++_i802)
                {
                  _elem801 = new Table();
                  _elem801.read(iprot);
                  struct.tables.add(_elem801);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
<<<<<<< HEAD
                org.apache.thrift.protocol.TList _list784 = iprot.readListBegin();
                struct.tables = new ArrayList<Table>(_list784.size);
                Table _elem785;
                for (int _i786 = 0; _i786 < _list784.size; ++_i786)
                {
                  _elem785 = new Table();
                  _elem785.read(iprot);
                  struct.tables.add(_elem785);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
                org.apache.thrift.protocol.TList _list802 = iprot.readListBegin();
                struct.tables = new ArrayList<Table>(_list802.size);
                Table _elem803;
                for (int _i804 = 0; _i804 < _list802.size; ++_i804)
                {
                  _elem803 = new Table();
                  _elem803.read(iprot);
                  struct.tables.add(_elem803);
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
                org.apache.thrift.protocol.TList _list786 = iprot.readListBegin();
                struct.tables = new ArrayList<Table>(_list786.size);
                Table _elem787;
                for (int _i788 = 0; _i788 < _list786.size; ++_i788)
                {
                  _elem787 = new Table();
                  _elem787.read(iprot);
                  struct.tables.add(_elem787);
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
<<<<<<< HEAD
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
=======
=======
                org.apache.thrift.protocol.TList _list792 = iprot.readListBegin();
                struct.tables = new ArrayList<Table>(_list792.size);
                Table _elem793;
                for (int _i794 = 0; _i794 < _list792.size; ++_i794)
                {
                  _elem793 = new Table();
                  _elem793.read(iprot);
                  struct.tables.add(_elem793);
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
                }
                iprot.readListEnd();
              }
              struct.setTablesIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, GetTablesResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.tables != null) {
        oprot.writeFieldBegin(TABLES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.tables.size()));
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
          for (Table _iter811 : struct.tables)
          {
            _iter811.write(oprot);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
<<<<<<< HEAD
          for (Table _iter803 : struct.tables)
          {
            _iter803.write(oprot);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
<<<<<<< HEAD
          for (Table _iter787 : struct.tables)
          {
            _iter787.write(oprot);
=======
          for (Table _iter805 : struct.tables)
          {
            _iter805.write(oprot);
>>>>>>> HIVE-18679 : create/replicate open transaction event
<<<<<<< HEAD
>>>>>>> HIVE-18679 : create/replicate open transaction event
<<<<<<< HEAD
>>>>>>> HIVE-18679 : create/replicate open transaction event
=======
=======
=======
          for (Table _iter805 : struct.tables)
          {
            _iter805.write(oprot);
=======
          for (Table _iter789 : struct.tables)
          {
            _iter789.write(oprot);
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
<<<<<<< HEAD
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
=======
=======
          for (Table _iter795 : struct.tables)
          {
            _iter795.write(oprot);
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class GetTablesResultTupleSchemeFactory implements SchemeFactory {
    public GetTablesResultTupleScheme getScheme() {
      return new GetTablesResultTupleScheme();
    }
  }

  private static class GetTablesResultTupleScheme extends TupleScheme<GetTablesResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, GetTablesResult struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      {
        oprot.writeI32(struct.tables.size());
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        for (Table _iter812 : struct.tables)
        {
          _iter812.write(oprot);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
<<<<<<< HEAD
        for (Table _iter804 : struct.tables)
        {
          _iter804.write(oprot);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
<<<<<<< HEAD
        for (Table _iter788 : struct.tables)
        {
          _iter788.write(oprot);
=======
        for (Table _iter806 : struct.tables)
        {
          _iter806.write(oprot);
>>>>>>> HIVE-18679 : create/replicate open transaction event
<<<<<<< HEAD
>>>>>>> HIVE-18679 : create/replicate open transaction event
<<<<<<< HEAD
>>>>>>> HIVE-18679 : create/replicate open transaction event
=======
=======
=======
        for (Table _iter806 : struct.tables)
        {
          _iter806.write(oprot);
=======
        for (Table _iter790 : struct.tables)
        {
          _iter790.write(oprot);
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
<<<<<<< HEAD
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
=======
=======
        for (Table _iter796 : struct.tables)
        {
          _iter796.write(oprot);
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, GetTablesResult struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        org.apache.thrift.protocol.TList _list813 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.tables = new ArrayList<Table>(_list813.size);
        Table _elem814;
        for (int _i815 = 0; _i815 < _list813.size; ++_i815)
        {
          _elem814 = new Table();
          _elem814.read(iprot);
          struct.tables.add(_elem814);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
<<<<<<< HEAD
        org.apache.thrift.protocol.TList _list805 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.tables = new ArrayList<Table>(_list805.size);
        Table _elem806;
        for (int _i807 = 0; _i807 < _list805.size; ++_i807)
        {
          _elem806 = new Table();
          _elem806.read(iprot);
          struct.tables.add(_elem806);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
<<<<<<< HEAD
        org.apache.thrift.protocol.TList _list789 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.tables = new ArrayList<Table>(_list789.size);
        Table _elem790;
        for (int _i791 = 0; _i791 < _list789.size; ++_i791)
        {
          _elem790 = new Table();
          _elem790.read(iprot);
          struct.tables.add(_elem790);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
        org.apache.thrift.protocol.TList _list807 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.tables = new ArrayList<Table>(_list807.size);
        Table _elem808;
        for (int _i809 = 0; _i809 < _list807.size; ++_i809)
        {
          _elem808 = new Table();
          _elem808.read(iprot);
          struct.tables.add(_elem808);
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
        org.apache.thrift.protocol.TList _list791 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.tables = new ArrayList<Table>(_list791.size);
        Table _elem792;
        for (int _i793 = 0; _i793 < _list791.size; ++_i793)
        {
          _elem792 = new Table();
          _elem792.read(iprot);
          struct.tables.add(_elem792);
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
<<<<<<< HEAD
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
=======
=======
        org.apache.thrift.protocol.TList _list797 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.tables = new ArrayList<Table>(_list797.size);
        Table _elem798;
        for (int _i799 = 0; _i799 < _list797.size; ++_i799)
        {
          _elem798 = new Table();
          _elem798.read(iprot);
          struct.tables.add(_elem798);
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event : After fixing review comments and test failures
        }
      }
      struct.setTablesIsSet(true);
    }
  }

}

