/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package openstars.base.monitor;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
/**
 * Memory usage
 */
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2019-08-24")
public class memoryStat implements org.apache.thrift.TBase<memoryStat, memoryStat._Fields>, java.io.Serializable, Cloneable, Comparable<memoryStat> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("memoryStat");

  private static final org.apache.thrift.protocol.TField TOTAL_MEM_FIELD_DESC = new org.apache.thrift.protocol.TField("totalMem", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField FREE_MEM_FIELD_DESC = new org.apache.thrift.protocol.TField("freeMem", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField USED_MEM_FIELD_DESC = new org.apache.thrift.protocol.TField("usedMem", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField CACHE_MEM_FIELD_DESC = new org.apache.thrift.protocol.TField("cacheMem", org.apache.thrift.protocol.TType.I64, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new memoryStatStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new memoryStatTupleSchemeFactory();

  public long totalMem; // required
  public long freeMem; // required
  public long usedMem; // required
  public long cacheMem; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TOTAL_MEM((short)1, "totalMem"),
    FREE_MEM((short)2, "freeMem"),
    USED_MEM((short)3, "usedMem"),
    CACHE_MEM((short)4, "cacheMem");

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
        case 1: // TOTAL_MEM
          return TOTAL_MEM;
        case 2: // FREE_MEM
          return FREE_MEM;
        case 3: // USED_MEM
          return USED_MEM;
        case 4: // CACHE_MEM
          return CACHE_MEM;
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
  private static final int __TOTALMEM_ISSET_ID = 0;
  private static final int __FREEMEM_ISSET_ID = 1;
  private static final int __USEDMEM_ISSET_ID = 2;
  private static final int __CACHEMEM_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TOTAL_MEM, new org.apache.thrift.meta_data.FieldMetaData("totalMem", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.FREE_MEM, new org.apache.thrift.meta_data.FieldMetaData("freeMem", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.USED_MEM, new org.apache.thrift.meta_data.FieldMetaData("usedMem", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.CACHE_MEM, new org.apache.thrift.meta_data.FieldMetaData("cacheMem", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(memoryStat.class, metaDataMap);
  }

  public memoryStat() {
  }

  public memoryStat(
    long totalMem,
    long freeMem,
    long usedMem,
    long cacheMem)
  {
    this();
    this.totalMem = totalMem;
    setTotalMemIsSet(true);
    this.freeMem = freeMem;
    setFreeMemIsSet(true);
    this.usedMem = usedMem;
    setUsedMemIsSet(true);
    this.cacheMem = cacheMem;
    setCacheMemIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public memoryStat(memoryStat other) {
    __isset_bitfield = other.__isset_bitfield;
    this.totalMem = other.totalMem;
    this.freeMem = other.freeMem;
    this.usedMem = other.usedMem;
    this.cacheMem = other.cacheMem;
  }

  public memoryStat deepCopy() {
    return new memoryStat(this);
  }

  @Override
  public void clear() {
    setTotalMemIsSet(false);
    this.totalMem = 0;
    setFreeMemIsSet(false);
    this.freeMem = 0;
    setUsedMemIsSet(false);
    this.usedMem = 0;
    setCacheMemIsSet(false);
    this.cacheMem = 0;
  }

  public long getTotalMem() {
    return this.totalMem;
  }

  public memoryStat setTotalMem(long totalMem) {
    this.totalMem = totalMem;
    setTotalMemIsSet(true);
    return this;
  }

  public void unsetTotalMem() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TOTALMEM_ISSET_ID);
  }

  /** Returns true if field totalMem is set (has been assigned a value) and false otherwise */
  public boolean isSetTotalMem() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TOTALMEM_ISSET_ID);
  }

  public void setTotalMemIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TOTALMEM_ISSET_ID, value);
  }

  public long getFreeMem() {
    return this.freeMem;
  }

  public memoryStat setFreeMem(long freeMem) {
    this.freeMem = freeMem;
    setFreeMemIsSet(true);
    return this;
  }

  public void unsetFreeMem() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __FREEMEM_ISSET_ID);
  }

  /** Returns true if field freeMem is set (has been assigned a value) and false otherwise */
  public boolean isSetFreeMem() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __FREEMEM_ISSET_ID);
  }

  public void setFreeMemIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __FREEMEM_ISSET_ID, value);
  }

  public long getUsedMem() {
    return this.usedMem;
  }

  public memoryStat setUsedMem(long usedMem) {
    this.usedMem = usedMem;
    setUsedMemIsSet(true);
    return this;
  }

  public void unsetUsedMem() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __USEDMEM_ISSET_ID);
  }

  /** Returns true if field usedMem is set (has been assigned a value) and false otherwise */
  public boolean isSetUsedMem() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __USEDMEM_ISSET_ID);
  }

  public void setUsedMemIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __USEDMEM_ISSET_ID, value);
  }

  public long getCacheMem() {
    return this.cacheMem;
  }

  public memoryStat setCacheMem(long cacheMem) {
    this.cacheMem = cacheMem;
    setCacheMemIsSet(true);
    return this;
  }

  public void unsetCacheMem() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __CACHEMEM_ISSET_ID);
  }

  /** Returns true if field cacheMem is set (has been assigned a value) and false otherwise */
  public boolean isSetCacheMem() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __CACHEMEM_ISSET_ID);
  }

  public void setCacheMemIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __CACHEMEM_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case TOTAL_MEM:
      if (value == null) {
        unsetTotalMem();
      } else {
        setTotalMem((java.lang.Long)value);
      }
      break;

    case FREE_MEM:
      if (value == null) {
        unsetFreeMem();
      } else {
        setFreeMem((java.lang.Long)value);
      }
      break;

    case USED_MEM:
      if (value == null) {
        unsetUsedMem();
      } else {
        setUsedMem((java.lang.Long)value);
      }
      break;

    case CACHE_MEM:
      if (value == null) {
        unsetCacheMem();
      } else {
        setCacheMem((java.lang.Long)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case TOTAL_MEM:
      return getTotalMem();

    case FREE_MEM:
      return getFreeMem();

    case USED_MEM:
      return getUsedMem();

    case CACHE_MEM:
      return getCacheMem();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case TOTAL_MEM:
      return isSetTotalMem();
    case FREE_MEM:
      return isSetFreeMem();
    case USED_MEM:
      return isSetUsedMem();
    case CACHE_MEM:
      return isSetCacheMem();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof memoryStat)
      return this.equals((memoryStat)that);
    return false;
  }

  public boolean equals(memoryStat that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_totalMem = true;
    boolean that_present_totalMem = true;
    if (this_present_totalMem || that_present_totalMem) {
      if (!(this_present_totalMem && that_present_totalMem))
        return false;
      if (this.totalMem != that.totalMem)
        return false;
    }

    boolean this_present_freeMem = true;
    boolean that_present_freeMem = true;
    if (this_present_freeMem || that_present_freeMem) {
      if (!(this_present_freeMem && that_present_freeMem))
        return false;
      if (this.freeMem != that.freeMem)
        return false;
    }

    boolean this_present_usedMem = true;
    boolean that_present_usedMem = true;
    if (this_present_usedMem || that_present_usedMem) {
      if (!(this_present_usedMem && that_present_usedMem))
        return false;
      if (this.usedMem != that.usedMem)
        return false;
    }

    boolean this_present_cacheMem = true;
    boolean that_present_cacheMem = true;
    if (this_present_cacheMem || that_present_cacheMem) {
      if (!(this_present_cacheMem && that_present_cacheMem))
        return false;
      if (this.cacheMem != that.cacheMem)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(totalMem);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(freeMem);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(usedMem);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(cacheMem);

    return hashCode;
  }

  @Override
  public int compareTo(memoryStat other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetTotalMem()).compareTo(other.isSetTotalMem());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTotalMem()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.totalMem, other.totalMem);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetFreeMem()).compareTo(other.isSetFreeMem());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFreeMem()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.freeMem, other.freeMem);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetUsedMem()).compareTo(other.isSetUsedMem());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUsedMem()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.usedMem, other.usedMem);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetCacheMem()).compareTo(other.isSetCacheMem());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCacheMem()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cacheMem, other.cacheMem);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("memoryStat(");
    boolean first = true;

    sb.append("totalMem:");
    sb.append(this.totalMem);
    first = false;
    if (!first) sb.append(", ");
    sb.append("freeMem:");
    sb.append(this.freeMem);
    first = false;
    if (!first) sb.append(", ");
    sb.append("usedMem:");
    sb.append(this.usedMem);
    first = false;
    if (!first) sb.append(", ");
    sb.append("cacheMem:");
    sb.append(this.cacheMem);
    first = false;
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

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class memoryStatStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public memoryStatStandardScheme getScheme() {
      return new memoryStatStandardScheme();
    }
  }

  private static class memoryStatStandardScheme extends org.apache.thrift.scheme.StandardScheme<memoryStat> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, memoryStat struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TOTAL_MEM
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.totalMem = iprot.readI64();
              struct.setTotalMemIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // FREE_MEM
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.freeMem = iprot.readI64();
              struct.setFreeMemIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // USED_MEM
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.usedMem = iprot.readI64();
              struct.setUsedMemIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // CACHE_MEM
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.cacheMem = iprot.readI64();
              struct.setCacheMemIsSet(true);
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

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, memoryStat struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(TOTAL_MEM_FIELD_DESC);
      oprot.writeI64(struct.totalMem);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(FREE_MEM_FIELD_DESC);
      oprot.writeI64(struct.freeMem);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(USED_MEM_FIELD_DESC);
      oprot.writeI64(struct.usedMem);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(CACHE_MEM_FIELD_DESC);
      oprot.writeI64(struct.cacheMem);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class memoryStatTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public memoryStatTupleScheme getScheme() {
      return new memoryStatTupleScheme();
    }
  }

  private static class memoryStatTupleScheme extends org.apache.thrift.scheme.TupleScheme<memoryStat> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, memoryStat struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetTotalMem()) {
        optionals.set(0);
      }
      if (struct.isSetFreeMem()) {
        optionals.set(1);
      }
      if (struct.isSetUsedMem()) {
        optionals.set(2);
      }
      if (struct.isSetCacheMem()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetTotalMem()) {
        oprot.writeI64(struct.totalMem);
      }
      if (struct.isSetFreeMem()) {
        oprot.writeI64(struct.freeMem);
      }
      if (struct.isSetUsedMem()) {
        oprot.writeI64(struct.usedMem);
      }
      if (struct.isSetCacheMem()) {
        oprot.writeI64(struct.cacheMem);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, memoryStat struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.totalMem = iprot.readI64();
        struct.setTotalMemIsSet(true);
      }
      if (incoming.get(1)) {
        struct.freeMem = iprot.readI64();
        struct.setFreeMemIsSet(true);
      }
      if (incoming.get(2)) {
        struct.usedMem = iprot.readI64();
        struct.setUsedMemIsSet(true);
      }
      if (incoming.get(3)) {
        struct.cacheMem = iprot.readI64();
        struct.setCacheMemIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
