package com.stellato.gprc.fornecedor;

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
    comments = "Source: fornecedor.proto")
public final class FornecedorServiceGrpc {

  private FornecedorServiceGrpc() {}

  public static final String SERVICE_NAME = "fornecedor.FornecedorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.stellato.gprc.fornecedor.FornecedorRequest,
      com.stellato.gprc.fornecedor.FornecedorResponse> getVerificaFornecedorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "verificaFornecedor",
      requestType = com.stellato.gprc.fornecedor.FornecedorRequest.class,
      responseType = com.stellato.gprc.fornecedor.FornecedorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.stellato.gprc.fornecedor.FornecedorRequest,
      com.stellato.gprc.fornecedor.FornecedorResponse> getVerificaFornecedorMethod() {
    io.grpc.MethodDescriptor<com.stellato.gprc.fornecedor.FornecedorRequest, com.stellato.gprc.fornecedor.FornecedorResponse> getVerificaFornecedorMethod;
    if ((getVerificaFornecedorMethod = FornecedorServiceGrpc.getVerificaFornecedorMethod) == null) {
      synchronized (FornecedorServiceGrpc.class) {
        if ((getVerificaFornecedorMethod = FornecedorServiceGrpc.getVerificaFornecedorMethod) == null) {
          FornecedorServiceGrpc.getVerificaFornecedorMethod = getVerificaFornecedorMethod = 
              io.grpc.MethodDescriptor.<com.stellato.gprc.fornecedor.FornecedorRequest, com.stellato.gprc.fornecedor.FornecedorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fornecedor.FornecedorService", "verificaFornecedor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.stellato.gprc.fornecedor.FornecedorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.stellato.gprc.fornecedor.FornecedorResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FornecedorServiceMethodDescriptorSupplier("verificaFornecedor"))
                  .build();
          }
        }
     }
     return getVerificaFornecedorMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FornecedorServiceStub newStub(io.grpc.Channel channel) {
    return new FornecedorServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FornecedorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FornecedorServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FornecedorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FornecedorServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class FornecedorServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * unary
     * </pre>
     */
    public void verificaFornecedor(com.stellato.gprc.fornecedor.FornecedorRequest request,
        io.grpc.stub.StreamObserver<com.stellato.gprc.fornecedor.FornecedorResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getVerificaFornecedorMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getVerificaFornecedorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.stellato.gprc.fornecedor.FornecedorRequest,
                com.stellato.gprc.fornecedor.FornecedorResponse>(
                  this, METHODID_VERIFICA_FORNECEDOR)))
          .build();
    }
  }

  /**
   */
  public static final class FornecedorServiceStub extends io.grpc.stub.AbstractStub<FornecedorServiceStub> {
    private FornecedorServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FornecedorServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FornecedorServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FornecedorServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary
     * </pre>
     */
    public void verificaFornecedor(com.stellato.gprc.fornecedor.FornecedorRequest request,
        io.grpc.stub.StreamObserver<com.stellato.gprc.fornecedor.FornecedorResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getVerificaFornecedorMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FornecedorServiceBlockingStub extends io.grpc.stub.AbstractStub<FornecedorServiceBlockingStub> {
    private FornecedorServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FornecedorServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FornecedorServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FornecedorServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary
     * </pre>
     */
    public com.stellato.gprc.fornecedor.FornecedorResponse verificaFornecedor(com.stellato.gprc.fornecedor.FornecedorRequest request) {
      return blockingUnaryCall(
          getChannel(), getVerificaFornecedorMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FornecedorServiceFutureStub extends io.grpc.stub.AbstractStub<FornecedorServiceFutureStub> {
    private FornecedorServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FornecedorServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FornecedorServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FornecedorServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.stellato.gprc.fornecedor.FornecedorResponse> verificaFornecedor(
        com.stellato.gprc.fornecedor.FornecedorRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getVerificaFornecedorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_VERIFICA_FORNECEDOR = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FornecedorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FornecedorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_VERIFICA_FORNECEDOR:
          serviceImpl.verificaFornecedor((com.stellato.gprc.fornecedor.FornecedorRequest) request,
              (io.grpc.stub.StreamObserver<com.stellato.gprc.fornecedor.FornecedorResponse>) responseObserver);
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

  private static abstract class FornecedorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FornecedorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.stellato.gprc.fornecedor.Fornecedor.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FornecedorService");
    }
  }

  private static final class FornecedorServiceFileDescriptorSupplier
      extends FornecedorServiceBaseDescriptorSupplier {
    FornecedorServiceFileDescriptorSupplier() {}
  }

  private static final class FornecedorServiceMethodDescriptorSupplier
      extends FornecedorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FornecedorServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FornecedorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FornecedorServiceFileDescriptorSupplier())
              .addMethod(getVerificaFornecedorMethod())
              .build();
        }
      }
    }
    return result;
  }
}
