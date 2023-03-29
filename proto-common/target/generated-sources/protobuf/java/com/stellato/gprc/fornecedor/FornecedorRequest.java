// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: fornecedor.proto

package com.stellato.gprc.fornecedor;

/**
 * Protobuf type {@code fornecedor.FornecedorRequest}
 */
public  final class FornecedorRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:fornecedor.FornecedorRequest)
    FornecedorRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FornecedorRequest.newBuilder() to construct.
  private FornecedorRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FornecedorRequest() {
    idenFornecedor_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private FornecedorRequest(
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

            idenFornecedor_ = input.readInt32();
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
    return com.stellato.gprc.fornecedor.Fornecedor.internal_static_fornecedor_FornecedorRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.stellato.gprc.fornecedor.Fornecedor.internal_static_fornecedor_FornecedorRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.stellato.gprc.fornecedor.FornecedorRequest.class, com.stellato.gprc.fornecedor.FornecedorRequest.Builder.class);
  }

  public static final int IDEN_FORNECEDOR_FIELD_NUMBER = 1;
  private int idenFornecedor_;
  /**
   * <code>int32 iden_fornecedor = 1;</code>
   */
  public int getIdenFornecedor() {
    return idenFornecedor_;
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
    if (idenFornecedor_ != 0) {
      output.writeInt32(1, idenFornecedor_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (idenFornecedor_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, idenFornecedor_);
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
    if (!(obj instanceof com.stellato.gprc.fornecedor.FornecedorRequest)) {
      return super.equals(obj);
    }
    com.stellato.gprc.fornecedor.FornecedorRequest other = (com.stellato.gprc.fornecedor.FornecedorRequest) obj;

    boolean result = true;
    result = result && (getIdenFornecedor()
        == other.getIdenFornecedor());
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
    hash = (37 * hash) + IDEN_FORNECEDOR_FIELD_NUMBER;
    hash = (53 * hash) + getIdenFornecedor();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.stellato.gprc.fornecedor.FornecedorRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.stellato.gprc.fornecedor.FornecedorRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.stellato.gprc.fornecedor.FornecedorRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.stellato.gprc.fornecedor.FornecedorRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.stellato.gprc.fornecedor.FornecedorRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.stellato.gprc.fornecedor.FornecedorRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.stellato.gprc.fornecedor.FornecedorRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.stellato.gprc.fornecedor.FornecedorRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.stellato.gprc.fornecedor.FornecedorRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.stellato.gprc.fornecedor.FornecedorRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.stellato.gprc.fornecedor.FornecedorRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.stellato.gprc.fornecedor.FornecedorRequest parseFrom(
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
  public static Builder newBuilder(com.stellato.gprc.fornecedor.FornecedorRequest prototype) {
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
   * Protobuf type {@code fornecedor.FornecedorRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:fornecedor.FornecedorRequest)
      com.stellato.gprc.fornecedor.FornecedorRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.stellato.gprc.fornecedor.Fornecedor.internal_static_fornecedor_FornecedorRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.stellato.gprc.fornecedor.Fornecedor.internal_static_fornecedor_FornecedorRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.stellato.gprc.fornecedor.FornecedorRequest.class, com.stellato.gprc.fornecedor.FornecedorRequest.Builder.class);
    }

    // Construct using com.stellato.gprc.fornecedor.FornecedorRequest.newBuilder()
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
      idenFornecedor_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.stellato.gprc.fornecedor.Fornecedor.internal_static_fornecedor_FornecedorRequest_descriptor;
    }

    @java.lang.Override
    public com.stellato.gprc.fornecedor.FornecedorRequest getDefaultInstanceForType() {
      return com.stellato.gprc.fornecedor.FornecedorRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.stellato.gprc.fornecedor.FornecedorRequest build() {
      com.stellato.gprc.fornecedor.FornecedorRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.stellato.gprc.fornecedor.FornecedorRequest buildPartial() {
      com.stellato.gprc.fornecedor.FornecedorRequest result = new com.stellato.gprc.fornecedor.FornecedorRequest(this);
      result.idenFornecedor_ = idenFornecedor_;
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
      if (other instanceof com.stellato.gprc.fornecedor.FornecedorRequest) {
        return mergeFrom((com.stellato.gprc.fornecedor.FornecedorRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.stellato.gprc.fornecedor.FornecedorRequest other) {
      if (other == com.stellato.gprc.fornecedor.FornecedorRequest.getDefaultInstance()) return this;
      if (other.getIdenFornecedor() != 0) {
        setIdenFornecedor(other.getIdenFornecedor());
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
      com.stellato.gprc.fornecedor.FornecedorRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.stellato.gprc.fornecedor.FornecedorRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int idenFornecedor_ ;
    /**
     * <code>int32 iden_fornecedor = 1;</code>
     */
    public int getIdenFornecedor() {
      return idenFornecedor_;
    }
    /**
     * <code>int32 iden_fornecedor = 1;</code>
     */
    public Builder setIdenFornecedor(int value) {
      
      idenFornecedor_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 iden_fornecedor = 1;</code>
     */
    public Builder clearIdenFornecedor() {
      
      idenFornecedor_ = 0;
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


    // @@protoc_insertion_point(builder_scope:fornecedor.FornecedorRequest)
  }

  // @@protoc_insertion_point(class_scope:fornecedor.FornecedorRequest)
  private static final com.stellato.gprc.fornecedor.FornecedorRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.stellato.gprc.fornecedor.FornecedorRequest();
  }

  public static com.stellato.gprc.fornecedor.FornecedorRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FornecedorRequest>
      PARSER = new com.google.protobuf.AbstractParser<FornecedorRequest>() {
    @java.lang.Override
    public FornecedorRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new FornecedorRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FornecedorRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FornecedorRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.stellato.gprc.fornecedor.FornecedorRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

