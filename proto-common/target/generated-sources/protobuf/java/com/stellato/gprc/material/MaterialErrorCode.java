// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: material.proto

package com.stellato.gprc.material;

/**
 * Protobuf enum {@code material.MaterialErrorCode}
 */
public enum MaterialErrorCode
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>INVALID_MATERIAL_ID_VALUE = 0;</code>
   */
  INVALID_MATERIAL_ID_VALUE(0),
  /**
   * <code>MATERIAL_ID_CANNOT_BE_NULL = 1;</code>
   */
  MATERIAL_ID_CANNOT_BE_NULL(1),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>INVALID_MATERIAL_ID_VALUE = 0;</code>
   */
  public static final int INVALID_MATERIAL_ID_VALUE_VALUE = 0;
  /**
   * <code>MATERIAL_ID_CANNOT_BE_NULL = 1;</code>
   */
  public static final int MATERIAL_ID_CANNOT_BE_NULL_VALUE = 1;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static MaterialErrorCode valueOf(int value) {
    return forNumber(value);
  }

  public static MaterialErrorCode forNumber(int value) {
    switch (value) {
      case 0: return INVALID_MATERIAL_ID_VALUE;
      case 1: return MATERIAL_ID_CANNOT_BE_NULL;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<MaterialErrorCode>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      MaterialErrorCode> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<MaterialErrorCode>() {
          public MaterialErrorCode findValueByNumber(int number) {
            return MaterialErrorCode.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return com.stellato.gprc.material.Material.getDescriptor().getEnumTypes().get(0);
  }

  private static final MaterialErrorCode[] VALUES = values();

  public static MaterialErrorCode valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private MaterialErrorCode(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:material.MaterialErrorCode)
}

