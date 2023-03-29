package com.stellato.gprc.material;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.22.1)",
    comments = "Source: material.proto")
public final class MaterialServiceGrpc {

  private MaterialServiceGrpc() {}

  public static final String SERVICE_NAME = "material.MaterialService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.stellato.gprc.material.MaterialRequest,
      com.stellato.gprc.material.MaterialResponse> getVerificaMaterialMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "verificaMaterial",
      requestType = com.stellato.gprc.material.MaterialRequest.class,
      responseType = com.stellato.gprc.material.MaterialResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.stellato.gprc.material.MaterialRequest,
      com.stellato.gprc.material.MaterialResponse> getVerificaMaterialMethod() {
    io.grpc.MethodDescriptor<com.stellato.gprc.material.MaterialRequest, com.stellato.gprc.material.MaterialResponse> getVerificaMaterialMethod;
    if ((getVerificaMaterialMethod = MaterialServiceGrpc.getVerificaMaterialMethod) == null) {
      synchronized (MaterialServiceGrpc.class) {
        if ((getVerificaMaterialMethod = MaterialServiceGrpc.getVerificaMaterialMethod) == null) {
          MaterialServiceGrpc.getVerificaMaterialMethod = getVerificaMaterialMethod = 
              io.grpc.MethodDescriptor.<com.stellato.gprc.material.MaterialRequest, com.stellato.gprc.material.MaterialResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "material.MaterialService", "verificaMaterial"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.stellato.gprc.material.MaterialRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.stellato.gprc.material.MaterialResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MaterialServiceMethodDescriptorSupplier("verificaMaterial"))
                  .build();
          }
        }
     }
     return getVerificaMaterialMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MaterialServiceStub newStub(io.grpc.Channel channel) {
    return new MaterialServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MaterialServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MaterialServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MaterialServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MaterialServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class MaterialServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * unary
     * </pre>
     */
    public void verificaMaterial(com.stellato.gprc.material.MaterialRequest request,
        io.grpc.stub.StreamObserver<com.stellato.gprc.material.MaterialResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getVerificaMaterialMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getVerificaMaterialMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.stellato.gprc.material.MaterialRequest,
                com.stellato.gprc.material.MaterialResponse>(
                  this, METHODID_VERIFICA_MATERIAL)))
          .build();
    }
  }

  /**
   */
  public static final class MaterialServiceStub extends io.grpc.stub.AbstractStub<MaterialServiceStub> {
    private MaterialServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MaterialServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MaterialServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MaterialServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary
     * </pre>
     */
    public void verificaMaterial(com.stellato.gprc.material.MaterialRequest request,
        io.grpc.stub.StreamObserver<com.stellato.gprc.material.MaterialResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getVerificaMaterialMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MaterialServiceBlockingStub extends io.grpc.stub.AbstractStub<MaterialServiceBlockingStub> {
    private MaterialServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MaterialServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MaterialServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MaterialServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary
     * </pre>
     */
    public com.stellato.gprc.material.MaterialResponse verificaMaterial(com.stellato.gprc.material.MaterialRequest request) {
      return blockingUnaryCall(
          getChannel(), getVerificaMaterialMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MaterialServiceFutureStub extends io.grpc.stub.AbstractStub<MaterialServiceFutureStub> {
    private MaterialServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MaterialServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MaterialServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MaterialServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.stellato.gprc.material.MaterialResponse> verificaMaterial(
        com.stellato.gprc.material.MaterialRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getVerificaMaterialMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_VERIFICA_MATERIAL = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MaterialServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MaterialServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_VERIFICA_MATERIAL:
          serviceImpl.verificaMaterial((com.stellato.gprc.material.MaterialRequest) request,
              (io.grpc.stub.StreamObserver<com.stellato.gprc.material.MaterialResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MaterialServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MaterialServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.stellato.gprc.material.Material.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MaterialService");
    }
  }

  private static final class MaterialServiceFileDescriptorSupplier
      extends MaterialServiceBaseDescriptorSupplier {
    MaterialServiceFileDescriptorSupplier() {}
  }

  private static final class MaterialServiceMethodDescriptorSupplier
      extends MaterialServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MaterialServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MaterialServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MaterialServiceFileDescriptorSupplier())
              .addMethod(getVerificaMaterialMethod())
              .build();
        }
      }
    }
    return result;
  }
}
