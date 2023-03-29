// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: city_score.proto

package com.stellato.gprc.cityscore;

/**
 * Protobuf type {@code cityscore.CityScoreRequest}
 */
public  final class CityScoreRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:cityscore.CityScoreRequest)
    CityScoreRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CityScoreRequest.newBuilder() to construct.
  private CityScoreRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CityScoreRequest() {
    cityCode_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private CityScoreRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            cityCode_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.stellato.gprc.cityscore.CityScore.internal_static_cityscore_CityScoreRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.stellato.gprc.cityscore.CityScore.internal_static_cityscore_CityScoreRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.stellato.gprc.cityscore.CityScoreRequest.class, com.stellato.gprc.cityscore.CityScoreRequest.Builder.class);
  }

  public static final int CITY_CODE_FIELD_NUMBER = 1;
  private int cityCode_;
  /**
   * <code>int32 city_code = 1;</code>
   */
  public int getCityCode() {
    return cityCode_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (cityCode_ != 0) {
      output.writeInt32(1, cityCode_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (cityCode_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, cityCode_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.stellato.gprc.cityscore.CityScoreRequest)) {
      return super.equals(obj);
    }
    com.stellato.gprc.cityscore.CityScoreRequest other = (com.stellato.gprc.cityscore.CityScoreRequest) obj;

    boolean result = true;
    result = result && (getCityCode()
        == other.getCityCode());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CITY_CODE_FIELD_NUMBER;
    hash = (53 * hash) + getCityCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.stellato.gprc.cityscore.CityScoreRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.stellato.gprc.cityscore.CityScoreRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.stellato.gprc.cityscore.CityScoreRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.stellato.gprc.cityscore.CityScoreRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.stellato.gprc.cityscore.CityScoreRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.stellato.gprc.cityscore.CityScoreRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.stellato.gprc.cityscore.CityScoreRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.stellato.gprc.cityscore.CityScoreRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.stellato.gprc.cityscore.CityScoreRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.stellato.gprc.cityscore.CityScoreRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.stellato.gprc.cityscore.CityScoreRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.stellato.gprc.cityscore.CityScoreRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.stellato.gprc.cityscore.CityScoreRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code cityscore.CityScoreRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:cityscore.CityScoreRequest)
      com.stellato.gprc.cityscore.CityScoreRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.stellato.gprc.cityscore.CityScore.internal_static_cityscore_CityScoreRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.stellato.gprc.cityscore.CityScore.internal_static_cityscore_CityScoreRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.stellato.gprc.cityscore.CityScoreRequest.class, com.stellato.gprc.cityscore.CityScoreRequest.Builder.class);
    }

    // Construct using com.stellato.gprc.cityscore.CityScoreRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      cityCode_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.stellato.gprc.cityscore.CityScore.internal_static_cityscore_CityScoreRequest_descriptor;
    }

    @java.lang.Override
    public com.stellato.gprc.cityscore.CityScoreRequest getDefaultInstanceForType() {
      return com.stellato.gprc.cityscore.CityScoreRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.stellato.gprc.cityscore.CityScoreRequest build() {
      com.stellato.gprc.cityscore.CityScoreRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.stellato.gprc.cityscore.CityScoreRequest buildPartial() {
      com.stellato.gprc.cityscore.CityScoreRequest result = new com.stellato.gprc.cityscore.CityScoreRequest(this);
      result.cityCode_ = cityCode_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.stellato.gprc.cityscore.CityScoreRequest) {
        return mergeFrom((com.stellato.gprc.cityscore.CityScoreRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.stellato.gprc.cityscore.CityScoreRequest other) {
      if (other == com.stellato.gprc.cityscore.CityScoreRequest.getDefaultInstance()) return this;
      if (other.getCityCode() != 0) {
        setCityCode(other.getCityCode());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.stellato.gprc.cityscore.CityScoreRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.stellato.gprc.cityscore.CityScoreRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int cityCode_ ;
    /**
     * <code>int32 city_code = 1;</code>
     */
    public int getCityCode() {
      return cityCode_;
    }
    /**
     * <code>int32 city_code = 1;</code>
     */
    public Builder setCityCode(int value) {
      
      cityCode_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 city_code = 1;</code>
     */
    public Builder clearCityCode() {
      
      cityCode_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:cityscore.CityScoreRequest)
  }

  // @@protoc_insertion_point(class_scope:cityscore.CityScoreRequest)
  private static final com.stellato.gprc.cityscore.CityScoreRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.stellato.gprc.cityscore.CityScoreRequest();
  }

  public static com.stellato.gprc.cityscore.CityScoreRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CityScoreRequest>
      PARSER = new com.google.protobuf.AbstractParser<CityScoreRequest>() {
    @java.lang.Override
    public CityScoreRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new CityScoreRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CityScoreRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CityScoreRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.stellato.gprc.cityscore.CityScoreRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

