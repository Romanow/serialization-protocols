// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ProtobufObject.proto

package ru.romanow.serialization.generated;

public final class ProtobufObjectProto {
  private ProtobufObjectProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  /**
   * Protobuf enum {@code Status}
   */
  public enum Status
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>DONE = 0;</code>
     */
    DONE(0),
    /**
     * <code>FAIL = 1;</code>
     */
    FAIL(1),
    /**
     * <code>PAUSED = 2;</code>
     */
    PAUSED(2),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>DONE = 0;</code>
     */
    public static final int DONE_VALUE = 0;
    /**
     * <code>FAIL = 1;</code>
     */
    public static final int FAIL_VALUE = 1;
    /**
     * <code>PAUSED = 2;</code>
     */
    public static final int PAUSED_VALUE = 2;


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
    public static Status valueOf(int value) {
      return forNumber(value);
    }

    public static Status forNumber(int value) {
      switch (value) {
        case 0: return DONE;
        case 1: return FAIL;
        case 2: return PAUSED;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<Status>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        Status> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<Status>() {
            public Status findValueByNumber(int number) {
              return Status.forNumber(number);
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
      return ru.romanow.serialization.generated.ProtobufObjectProto.getDescriptor().getEnumTypes().get(0);
    }

    private static final Status[] VALUES = values();

    public static Status valueOf(
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

    private Status(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:Status)
  }

  public interface ProtobufObjectOrBuilder extends
      // @@protoc_insertion_point(interface_extends:ProtobufObject)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string message = 1;</code>
     */
    java.lang.String getMessage();
    /**
     * <code>optional string message = 1;</code>
     */
    com.google.protobuf.ByteString
        getMessageBytes();

    /**
     * <code>optional int32 code = 2;</code>
     */
    int getCode();

    /**
     * <code>optional .Status status = 3;</code>
     */
    int getStatusValue();
    /**
     * <code>optional .Status status = 3;</code>
     */
    ru.romanow.serialization.generated.ProtobufObjectProto.Status getStatus();
  }
  /**
   * Protobuf type {@code ProtobufObject}
   */
  public  static final class ProtobufObject extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:ProtobufObject)
      ProtobufObjectOrBuilder {
    // Use ProtobufObject.newBuilder() to construct.
    private ProtobufObject(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ProtobufObject() {
      message_ = "";
      code_ = 0;
      status_ = 0;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private ProtobufObject(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              message_ = s;
              break;
            }
            case 16: {

              code_ = input.readInt32();
              break;
            }
            case 24: {
              int rawValue = input.readEnum();

              status_ = rawValue;
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
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ru.romanow.serialization.generated.ProtobufObjectProto.internal_static_ProtobufObject_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ru.romanow.serialization.generated.ProtobufObjectProto.internal_static_ProtobufObject_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject.class, ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject.Builder.class);
    }

    public static final int MESSAGE_FIELD_NUMBER = 1;
    private volatile java.lang.Object message_;
    /**
     * <code>optional string message = 1;</code>
     */
    public java.lang.String getMessage() {
      java.lang.Object ref = message_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        message_ = s;
        return s;
      }
    }
    /**
     * <code>optional string message = 1;</code>
     */
    public com.google.protobuf.ByteString
        getMessageBytes() {
      java.lang.Object ref = message_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        message_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int CODE_FIELD_NUMBER = 2;
    private int code_;
    /**
     * <code>optional int32 code = 2;</code>
     */
    public int getCode() {
      return code_;
    }

    public static final int STATUS_FIELD_NUMBER = 3;
    private int status_;
    /**
     * <code>optional .Status status = 3;</code>
     */
    public int getStatusValue() {
      return status_;
    }
    /**
     * <code>optional .Status status = 3;</code>
     */
    public ru.romanow.serialization.generated.ProtobufObjectProto.Status getStatus() {
      ru.romanow.serialization.generated.ProtobufObjectProto.Status result = ru.romanow.serialization.generated.ProtobufObjectProto.Status.valueOf(status_);
      return result == null ? ru.romanow.serialization.generated.ProtobufObjectProto.Status.UNRECOGNIZED : result;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getMessageBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, message_);
      }
      if (code_ != 0) {
        output.writeInt32(2, code_);
      }
      if (status_ != ru.romanow.serialization.generated.ProtobufObjectProto.Status.DONE.getNumber()) {
        output.writeEnum(3, status_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getMessageBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, message_);
      }
      if (code_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, code_);
      }
      if (status_ != ru.romanow.serialization.generated.ProtobufObjectProto.Status.DONE.getNumber()) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(3, status_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject)) {
        return super.equals(obj);
      }
      ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject other = (ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject) obj;

      boolean result = true;
      result = result && getMessage()
          .equals(other.getMessage());
      result = result && (getCode()
          == other.getCode());
      result = result && status_ == other.status_;
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
      hash = (53 * hash) + getMessage().hashCode();
      hash = (37 * hash) + CODE_FIELD_NUMBER;
      hash = (53 * hash) + getCode();
      hash = (37 * hash) + STATUS_FIELD_NUMBER;
      hash = (53 * hash) + status_;
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
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
     * Protobuf type {@code ProtobufObject}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:ProtobufObject)
        ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObjectOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return ru.romanow.serialization.generated.ProtobufObjectProto.internal_static_ProtobufObject_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return ru.romanow.serialization.generated.ProtobufObjectProto.internal_static_ProtobufObject_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject.class, ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject.Builder.class);
      }

      // Construct using ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject.newBuilder()
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
      public Builder clear() {
        super.clear();
        message_ = "";

        code_ = 0;

        status_ = 0;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return ru.romanow.serialization.generated.ProtobufObjectProto.internal_static_ProtobufObject_descriptor;
      }

      public ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject getDefaultInstanceForType() {
        return ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject.getDefaultInstance();
      }

      public ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject build() {
        ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject buildPartial() {
        ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject result = new ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject(this);
        result.message_ = message_;
        result.code_ = code_;
        result.status_ = status_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject) {
          return mergeFrom((ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject other) {
        if (other == ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject.getDefaultInstance()) return this;
        if (!other.getMessage().isEmpty()) {
          message_ = other.message_;
          onChanged();
        }
        if (other.getCode() != 0) {
          setCode(other.getCode());
        }
        if (other.status_ != 0) {
          setStatusValue(other.getStatusValue());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object message_ = "";
      /**
       * <code>optional string message = 1;</code>
       */
      public java.lang.String getMessage() {
        java.lang.Object ref = message_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          message_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string message = 1;</code>
       */
      public com.google.protobuf.ByteString
          getMessageBytes() {
        java.lang.Object ref = message_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          message_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string message = 1;</code>
       */
      public Builder setMessage(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        message_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string message = 1;</code>
       */
      public Builder clearMessage() {
        
        message_ = getDefaultInstance().getMessage();
        onChanged();
        return this;
      }
      /**
       * <code>optional string message = 1;</code>
       */
      public Builder setMessageBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        message_ = value;
        onChanged();
        return this;
      }

      private int code_ ;
      /**
       * <code>optional int32 code = 2;</code>
       */
      public int getCode() {
        return code_;
      }
      /**
       * <code>optional int32 code = 2;</code>
       */
      public Builder setCode(int value) {
        
        code_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 code = 2;</code>
       */
      public Builder clearCode() {
        
        code_ = 0;
        onChanged();
        return this;
      }

      private int status_ = 0;
      /**
       * <code>optional .Status status = 3;</code>
       */
      public int getStatusValue() {
        return status_;
      }
      /**
       * <code>optional .Status status = 3;</code>
       */
      public Builder setStatusValue(int value) {
        status_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional .Status status = 3;</code>
       */
      public ru.romanow.serialization.generated.ProtobufObjectProto.Status getStatus() {
        ru.romanow.serialization.generated.ProtobufObjectProto.Status result = ru.romanow.serialization.generated.ProtobufObjectProto.Status.valueOf(status_);
        return result == null ? ru.romanow.serialization.generated.ProtobufObjectProto.Status.UNRECOGNIZED : result;
      }
      /**
       * <code>optional .Status status = 3;</code>
       */
      public Builder setStatus(ru.romanow.serialization.generated.ProtobufObjectProto.Status value) {
        if (value == null) {
          throw new NullPointerException();
        }
        
        status_ = value.getNumber();
        onChanged();
        return this;
      }
      /**
       * <code>optional .Status status = 3;</code>
       */
      public Builder clearStatus() {
        
        status_ = 0;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:ProtobufObject)
    }

    // @@protoc_insertion_point(class_scope:ProtobufObject)
    private static final ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject();
    }

    public static ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ProtobufObject>
        PARSER = new com.google.protobuf.AbstractParser<ProtobufObject>() {
      public ProtobufObject parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new ProtobufObject(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<ProtobufObject> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ProtobufObject> getParserForType() {
      return PARSER;
    }

    public ru.romanow.serialization.generated.ProtobufObjectProto.ProtobufObject getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ProtobufObject_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ProtobufObject_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024ProtobufObject.proto\"H\n\016ProtobufObject" +
      "\022\017\n\007message\030\001 \001(\t\022\014\n\004code\030\002 \001(\005\022\027\n\006statu" +
      "s\030\003 \001(\0162\007.Status*(\n\006Status\022\010\n\004DONE\020\000\022\010\n\004" +
      "FAIL\020\001\022\n\n\006PAUSED\020\002B9\n\"ru.romanow.seriali" +
      "zation.generatedB\023ProtobufObjectProtob\006p" +
      "roto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_ProtobufObject_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ProtobufObject_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ProtobufObject_descriptor,
        new java.lang.String[] { "Message", "Code", "Status", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
