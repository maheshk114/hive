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
@org.apache.hadoop.classification.InterfaceAudience.Public @org.apache.hadoop.classification.InterfaceStability.Stable public class NotificationEventResponse implements org.apache.thrift.TBase<NotificationEventResponse, NotificationEventResponse._Fields>, java.io.Serializable, Cloneable, Comparable<NotificationEventResponse> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("NotificationEventResponse");

  private static final org.apache.thrift.protocol.TField EVENTS_FIELD_DESC = new org.apache.thrift.protocol.TField("events", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new NotificationEventResponseStandardSchemeFactory());
    schemes.put(TupleScheme.class, new NotificationEventResponseTupleSchemeFactory());
  }

  private List<NotificationEvent> events; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    EVENTS((short)1, "events");

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
        case 1: // EVENTS
          return EVENTS;
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
    tmpMap.put(_Fields.EVENTS, new org.apache.thrift.meta_data.FieldMetaData("events", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, NotificationEvent.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(NotificationEventResponse.class, metaDataMap);
  }

  public NotificationEventResponse() {
  }

  public NotificationEventResponse(
    List<NotificationEvent> events)
  {
    this();
    this.events = events;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public NotificationEventResponse(NotificationEventResponse other) {
    if (other.isSetEvents()) {
      List<NotificationEvent> __this__events = new ArrayList<NotificationEvent>(other.events.size());
      for (NotificationEvent other_element : other.events) {
        __this__events.add(new NotificationEvent(other_element));
      }
      this.events = __this__events;
    }
  }

  public NotificationEventResponse deepCopy() {
    return new NotificationEventResponse(this);
  }

  @Override
  public void clear() {
    this.events = null;
  }

  public int getEventsSize() {
    return (this.events == null) ? 0 : this.events.size();
  }

  public java.util.Iterator<NotificationEvent> getEventsIterator() {
    return (this.events == null) ? null : this.events.iterator();
  }

  public void addToEvents(NotificationEvent elem) {
    if (this.events == null) {
      this.events = new ArrayList<NotificationEvent>();
    }
    this.events.add(elem);
  }

  public List<NotificationEvent> getEvents() {
    return this.events;
  }

  public void setEvents(List<NotificationEvent> events) {
    this.events = events;
  }

  public void unsetEvents() {
    this.events = null;
  }

  /** Returns true if field events is set (has been assigned a value) and false otherwise */
  public boolean isSetEvents() {
    return this.events != null;
  }

  public void setEventsIsSet(boolean value) {
    if (!value) {
      this.events = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case EVENTS:
      if (value == null) {
        unsetEvents();
      } else {
        setEvents((List<NotificationEvent>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case EVENTS:
      return getEvents();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case EVENTS:
      return isSetEvents();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof NotificationEventResponse)
      return this.equals((NotificationEventResponse)that);
    return false;
  }

  public boolean equals(NotificationEventResponse that) {
    if (that == null)
      return false;

    boolean this_present_events = true && this.isSetEvents();
    boolean that_present_events = true && that.isSetEvents();
    if (this_present_events || that_present_events) {
      if (!(this_present_events && that_present_events))
        return false;
      if (!this.events.equals(that.events))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_events = true && (isSetEvents());
    list.add(present_events);
    if (present_events)
      list.add(events);

    return list.hashCode();
  }

  @Override
  public int compareTo(NotificationEventResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetEvents()).compareTo(other.isSetEvents());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEvents()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.events, other.events);
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
    StringBuilder sb = new StringBuilder("NotificationEventResponse(");
    boolean first = true;

    sb.append("events:");
    if (this.events == null) {
      sb.append("null");
    } else {
      sb.append(this.events);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetEvents()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'events' is unset! Struct:" + toString());
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

  private static class NotificationEventResponseStandardSchemeFactory implements SchemeFactory {
    public NotificationEventResponseStandardScheme getScheme() {
      return new NotificationEventResponseStandardScheme();
    }
  }

  private static class NotificationEventResponseStandardScheme extends StandardScheme<NotificationEventResponse> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, NotificationEventResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // EVENTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
<<<<<<< HEAD
<<<<<<< HEAD
                org.apache.thrift.protocol.TList _list692 = iprot.readListBegin();
                struct.events = new ArrayList<NotificationEvent>(_list692.size);
                NotificationEvent _elem693;
                for (int _i694 = 0; _i694 < _list692.size; ++_i694)
                {
                  _elem693 = new NotificationEvent();
                  _elem693.read(iprot);
                  struct.events.add(_elem693);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
<<<<<<< HEAD
                org.apache.thrift.protocol.TList _list684 = iprot.readListBegin();
                struct.events = new ArrayList<NotificationEvent>(_list684.size);
                NotificationEvent _elem685;
                for (int _i686 = 0; _i686 < _list684.size; ++_i686)
                {
                  _elem685 = new NotificationEvent();
                  _elem685.read(iprot);
                  struct.events.add(_elem685);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
<<<<<<< HEAD
                org.apache.thrift.protocol.TList _list668 = iprot.readListBegin();
                struct.events = new ArrayList<NotificationEvent>(_list668.size);
                NotificationEvent _elem669;
                for (int _i670 = 0; _i670 < _list668.size; ++_i670)
                {
                  _elem669 = new NotificationEvent();
                  _elem669.read(iprot);
                  struct.events.add(_elem669);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
                org.apache.thrift.protocol.TList _list686 = iprot.readListBegin();
                struct.events = new ArrayList<NotificationEvent>(_list686.size);
                NotificationEvent _elem687;
                for (int _i688 = 0; _i688 < _list686.size; ++_i688)
                {
                  _elem687 = new NotificationEvent();
                  _elem687.read(iprot);
                  struct.events.add(_elem687);
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
                org.apache.thrift.protocol.TList _list670 = iprot.readListBegin();
                struct.events = new ArrayList<NotificationEvent>(_list670.size);
                NotificationEvent _elem671;
                for (int _i672 = 0; _i672 < _list670.size; ++_i672)
                {
                  _elem671 = new NotificationEvent();
                  _elem671.read(iprot);
                  struct.events.add(_elem671);
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
                }
                iprot.readListEnd();
              }
              struct.setEventsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, NotificationEventResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.events != null) {
        oprot.writeFieldBegin(EVENTS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.events.size()));
<<<<<<< HEAD
<<<<<<< HEAD
          for (NotificationEvent _iter695 : struct.events)
          {
            _iter695.write(oprot);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
<<<<<<< HEAD
          for (NotificationEvent _iter687 : struct.events)
          {
            _iter687.write(oprot);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
<<<<<<< HEAD
          for (NotificationEvent _iter671 : struct.events)
          {
            _iter671.write(oprot);
=======
          for (NotificationEvent _iter689 : struct.events)
          {
            _iter689.write(oprot);
>>>>>>> HIVE-18679 : create/replicate open transaction event
<<<<<<< HEAD
>>>>>>> HIVE-18679 : create/replicate open transaction event
<<<<<<< HEAD
>>>>>>> HIVE-18679 : create/replicate open transaction event
=======
=======
=======
          for (NotificationEvent _iter689 : struct.events)
          {
            _iter689.write(oprot);
=======
          for (NotificationEvent _iter673 : struct.events)
          {
            _iter673.write(oprot);
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class NotificationEventResponseTupleSchemeFactory implements SchemeFactory {
    public NotificationEventResponseTupleScheme getScheme() {
      return new NotificationEventResponseTupleScheme();
    }
  }

  private static class NotificationEventResponseTupleScheme extends TupleScheme<NotificationEventResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, NotificationEventResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      {
        oprot.writeI32(struct.events.size());
<<<<<<< HEAD
<<<<<<< HEAD
        for (NotificationEvent _iter696 : struct.events)
        {
          _iter696.write(oprot);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
<<<<<<< HEAD
        for (NotificationEvent _iter688 : struct.events)
        {
          _iter688.write(oprot);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
<<<<<<< HEAD
        for (NotificationEvent _iter672 : struct.events)
        {
          _iter672.write(oprot);
=======
        for (NotificationEvent _iter690 : struct.events)
        {
          _iter690.write(oprot);
>>>>>>> HIVE-18679 : create/replicate open transaction event
<<<<<<< HEAD
>>>>>>> HIVE-18679 : create/replicate open transaction event
<<<<<<< HEAD
>>>>>>> HIVE-18679 : create/replicate open transaction event
=======
=======
=======
        for (NotificationEvent _iter690 : struct.events)
        {
          _iter690.write(oprot);
=======
        for (NotificationEvent _iter674 : struct.events)
        {
          _iter674.write(oprot);
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, NotificationEventResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      {
<<<<<<< HEAD
<<<<<<< HEAD
        org.apache.thrift.protocol.TList _list697 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.events = new ArrayList<NotificationEvent>(_list697.size);
        NotificationEvent _elem698;
        for (int _i699 = 0; _i699 < _list697.size; ++_i699)
        {
          _elem698 = new NotificationEvent();
          _elem698.read(iprot);
          struct.events.add(_elem698);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
<<<<<<< HEAD
        org.apache.thrift.protocol.TList _list689 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.events = new ArrayList<NotificationEvent>(_list689.size);
        NotificationEvent _elem690;
        for (int _i691 = 0; _i691 < _list689.size; ++_i691)
        {
          _elem690 = new NotificationEvent();
          _elem690.read(iprot);
          struct.events.add(_elem690);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
<<<<<<< HEAD
        org.apache.thrift.protocol.TList _list673 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.events = new ArrayList<NotificationEvent>(_list673.size);
        NotificationEvent _elem674;
        for (int _i675 = 0; _i675 < _list673.size; ++_i675)
        {
          _elem674 = new NotificationEvent();
          _elem674.read(iprot);
          struct.events.add(_elem674);
=======
=======
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
        org.apache.thrift.protocol.TList _list691 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.events = new ArrayList<NotificationEvent>(_list691.size);
        NotificationEvent _elem692;
        for (int _i693 = 0; _i693 < _list691.size; ++_i693)
        {
          _elem692 = new NotificationEvent();
          _elem692.read(iprot);
          struct.events.add(_elem692);
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
        org.apache.thrift.protocol.TList _list675 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.events = new ArrayList<NotificationEvent>(_list675.size);
        NotificationEvent _elem676;
        for (int _i677 = 0; _i677 < _list675.size; ++_i677)
        {
          _elem676 = new NotificationEvent();
          _elem676.read(iprot);
          struct.events.add(_elem676);
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
>>>>>>> HIVE-18781 : Create/Replicate Abort Txn event
        }
      }
      struct.setEventsIsSet(true);
    }
  }

}

