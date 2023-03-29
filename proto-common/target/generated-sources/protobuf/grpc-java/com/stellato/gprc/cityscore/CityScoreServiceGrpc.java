package com.stellato.gprc.cityscore;

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
    comments = "Source: city_score.proto")
public final class CityScoreServiceGrpc {

  private CityScoreServiceGrpc() {}

  public static final String SERVICE_NAME = "cityscore.CityScoreService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.stellato.gprc.cityscore.CityScoreRequest,
      com.stellato.gprc.cityscore.CityScoreResponse> getCalculateCityScoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "calculateCityScore",
      requestType = com.stellato.gprc.cityscore.CityScoreRequest.class,
      responseType = com.stellato.gprc.cityscore.CityScoreResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.stellato.gprc.cityscore.CityScoreRequest,
      com.stellato.gprc.cityscore.CityScoreResponse> getCalculateCityScoreMethod() {
    io.grpc.MethodDescriptor<com.stellato.gprc.cityscore.CityScoreRequest, com.stellato.gprc.cityscore.CityScoreResponse> getCalculateCityScoreMethod;
    if ((getCalculateCityScoreMethod = CityScoreServiceGrpc.getCalculateCityScoreMethod) == null) {
      synchronized (CityScoreServiceGrpc.class) {
        if ((getCalculateCityScoreMethod = CityScoreServiceGrpc.getCalculateCityScoreMethod) == null) {
          CityScoreServiceGrpc.getCalculateCityScoreMethod = getCalculateCityScoreMethod = 
              io.grpc.MethodDescriptor.<com.stellato.gprc.cityscore.CityScoreRequest, com.stellato.gprc.cityscore.CityScoreResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "cityscore.CityScoreService", "calculateCityScore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.stellato.gprc.cityscore.CityScoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.stellato.gprc.cityscore.CityScoreResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CityScoreServiceMethodDescriptorSupplier("calculateCityScore"))
                  .build();
          }
        }
     }
     return getCalculateCityScoreMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CityScoreServiceStub newStub(io.grpc.Channel channel) {
    return new CityScoreServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CityScoreServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CityScoreServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CityScoreServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CityScoreServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CityScoreServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * unary
     * </pre>
     */
    public void calculateCityScore(com.stellato.gprc.cityscore.CityScoreRequest request,
        io.grpc.stub.StreamObserver<com.stellato.gprc.cityscore.CityScoreResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCalculateCityScoreMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCalculateCityScoreMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.stellato.gprc.cityscore.CityScoreRequest,
                com.stellato.gprc.cityscore.CityScoreResponse>(
                  this, METHODID_CALCULATE_CITY_SCORE)))
          .build();
    }
  }

  /**
   */
  public static final class CityScoreServiceStub extends io.grpc.stub.AbstractStub<CityScoreServiceStub> {
    private CityScoreServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CityScoreServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CityScoreServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CityScoreServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary
     * </pre>
     */
    public void calculateCityScore(com.stellato.gprc.cityscore.CityScoreRequest request,
        io.grpc.stub.StreamObserver<com.stellato.gprc.cityscore.CityScoreResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCalculateCityScoreMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CityScoreServiceBlockingStub extends io.grpc.stub.AbstractStub<CityScoreServiceBlockingStub> {
    private CityScoreServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CityScoreServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CityScoreServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CityScoreServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary
     * </pre>
     */
    public com.stellato.gprc.cityscore.CityScoreResponse calculateCityScore(com.stellato.gprc.cityscore.CityScoreRequest request) {
      return blockingUnaryCall(
          getChannel(), getCalculateCityScoreMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CityScoreServiceFutureStub extends io.grpc.stub.AbstractStub<CityScoreServiceFutureStub> {
    private CityScoreServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CityScoreServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CityScoreServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CityScoreServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.stellato.gprc.cityscore.CityScoreResponse> calculateCityScore(
        com.stellato.gprc.cityscore.CityScoreRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCalculateCityScoreMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CALCULATE_CITY_SCORE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CityScoreServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CityScoreServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CALCULATE_CITY_SCORE:
          serviceImpl.calculateCityScore((com.stellato.gprc.cityscore.CityScoreRequest) request,
              (io.grpc.stub.StreamObserver<com.stellato.gprc.cityscore.CityScoreResponse>) responseObserver);
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

  private static abstract class CityScoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CityScoreServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.stellato.gprc.cityscore.CityScore.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CityScoreService");
    }
  }

  private static final class CityScoreServiceFileDescriptorSupplier
      extends CityScoreServiceBaseDescriptorSupplier {
    CityScoreServiceFileDescriptorSupplier() {}
  }

  private static final class CityScoreServiceMethodDescriptorSupplier
      extends CityScoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CityScoreServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CityScoreServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CityScoreServiceFileDescriptorSupplier())
              .addMethod(getCalculateCityScoreMethod())
              .build();
        }
      }
    }
    return result;
  }
}
