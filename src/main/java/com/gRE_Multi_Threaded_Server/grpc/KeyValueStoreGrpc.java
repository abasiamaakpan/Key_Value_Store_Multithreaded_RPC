package com.gRE_Multi_Threaded_Server.grpc;

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
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: key_value_store_procedures.proto")
public final class KeyValueStoreGrpc {

  private KeyValueStoreGrpc() {}

  public static final String SERVICE_NAME = "KeyValueStore";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Pair,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulPut> getInsertKeyValueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InsertKeyValue",
      requestType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Pair.class,
      responseType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulPut.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Pair,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulPut> getInsertKeyValueMethod() {
    io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Pair, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulPut> getInsertKeyValueMethod;
    if ((getInsertKeyValueMethod = KeyValueStoreGrpc.getInsertKeyValueMethod) == null) {
      synchronized (KeyValueStoreGrpc.class) {
        if ((getInsertKeyValueMethod = KeyValueStoreGrpc.getInsertKeyValueMethod) == null) {
          KeyValueStoreGrpc.getInsertKeyValueMethod = getInsertKeyValueMethod = 
              io.grpc.MethodDescriptor.<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Pair, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulPut>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "KeyValueStore", "InsertKeyValue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Pair.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulPut.getDefaultInstance()))
                  .setSchemaDescriptor(new KeyValueStoreMethodDescriptorSupplier("InsertKeyValue"))
                  .build();
          }
        }
     }
     return getInsertKeyValueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.GetKey,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulGet> getGetKeyValueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetKeyValue",
      requestType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.GetKey.class,
      responseType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulGet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.GetKey,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulGet> getGetKeyValueMethod() {
    io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.GetKey, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulGet> getGetKeyValueMethod;
    if ((getGetKeyValueMethod = KeyValueStoreGrpc.getGetKeyValueMethod) == null) {
      synchronized (KeyValueStoreGrpc.class) {
        if ((getGetKeyValueMethod = KeyValueStoreGrpc.getGetKeyValueMethod) == null) {
          KeyValueStoreGrpc.getGetKeyValueMethod = getGetKeyValueMethod = 
              io.grpc.MethodDescriptor.<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.GetKey, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulGet>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "KeyValueStore", "GetKeyValue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.GetKey.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulGet.getDefaultInstance()))
                  .setSchemaDescriptor(new KeyValueStoreMethodDescriptorSupplier("GetKeyValue"))
                  .build();
          }
        }
     }
     return getGetKeyValueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.DeleteKey,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulDelete> getDeleteKeyValueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteKeyValue",
      requestType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.DeleteKey.class,
      responseType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulDelete.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.DeleteKey,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulDelete> getDeleteKeyValueMethod() {
    io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.DeleteKey, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulDelete> getDeleteKeyValueMethod;
    if ((getDeleteKeyValueMethod = KeyValueStoreGrpc.getDeleteKeyValueMethod) == null) {
      synchronized (KeyValueStoreGrpc.class) {
        if ((getDeleteKeyValueMethod = KeyValueStoreGrpc.getDeleteKeyValueMethod) == null) {
          KeyValueStoreGrpc.getDeleteKeyValueMethod = getDeleteKeyValueMethod = 
              io.grpc.MethodDescriptor.<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.DeleteKey, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulDelete>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "KeyValueStore", "DeleteKeyValue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.DeleteKey.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulDelete.getDefaultInstance()))
                  .setSchemaDescriptor(new KeyValueStoreMethodDescriptorSupplier("DeleteKeyValue"))
                  .build();
          }
        }
     }
     return getDeleteKeyValueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ClientExit,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulExit> getClientExitedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ClientExited",
      requestType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ClientExit.class,
      responseType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulExit.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ClientExit,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulExit> getClientExitedMethod() {
    io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ClientExit, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulExit> getClientExitedMethod;
    if ((getClientExitedMethod = KeyValueStoreGrpc.getClientExitedMethod) == null) {
      synchronized (KeyValueStoreGrpc.class) {
        if ((getClientExitedMethod = KeyValueStoreGrpc.getClientExitedMethod) == null) {
          KeyValueStoreGrpc.getClientExitedMethod = getClientExitedMethod = 
              io.grpc.MethodDescriptor.<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ClientExit, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulExit>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "KeyValueStore", "ClientExited"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ClientExit.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulExit.getDefaultInstance()))
                  .setSchemaDescriptor(new KeyValueStoreMethodDescriptorSupplier("ClientExited"))
                  .build();
          }
        }
     }
     return getClientExitedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendNameofClient,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendNameofClient> getEnterNameofClientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnterNameofClient",
      requestType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendNameofClient.class,
      responseType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendNameofClient.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendNameofClient,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendNameofClient> getEnterNameofClientMethod() {
    io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendNameofClient, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendNameofClient> getEnterNameofClientMethod;
    if ((getEnterNameofClientMethod = KeyValueStoreGrpc.getEnterNameofClientMethod) == null) {
      synchronized (KeyValueStoreGrpc.class) {
        if ((getEnterNameofClientMethod = KeyValueStoreGrpc.getEnterNameofClientMethod) == null) {
          KeyValueStoreGrpc.getEnterNameofClientMethod = getEnterNameofClientMethod = 
              io.grpc.MethodDescriptor.<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendNameofClient, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendNameofClient>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "KeyValueStore", "EnterNameofClient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendNameofClient.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendNameofClient.getDefaultInstance()))
                  .setSchemaDescriptor(new KeyValueStoreMethodDescriptorSupplier("EnterNameofClient"))
                  .build();
          }
        }
     }
     return getEnterNameofClientMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static KeyValueStoreStub newStub(io.grpc.Channel channel) {
    return new KeyValueStoreStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static KeyValueStoreBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new KeyValueStoreBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static KeyValueStoreFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new KeyValueStoreFutureStub(channel);
  }

  /**
   */
  public static abstract class KeyValueStoreImplBase implements io.grpc.BindableService {

    /**
     */
    public void insertKeyValue(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Pair request,
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulPut> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertKeyValueMethod(), responseObserver);
    }

    /**
     */
    public void getKeyValue(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.GetKey request,
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulGet> responseObserver) {
      asyncUnimplementedUnaryCall(getGetKeyValueMethod(), responseObserver);
    }

    /**
     */
    public void deleteKeyValue(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.DeleteKey request,
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulDelete> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteKeyValueMethod(), responseObserver);
    }

    /**
     */
    public void clientExited(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ClientExit request,
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulExit> responseObserver) {
      asyncUnimplementedUnaryCall(getClientExitedMethod(), responseObserver);
    }

    /**
     */
    public void enterNameofClient(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendNameofClient request,
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendNameofClient> responseObserver) {
      asyncUnimplementedUnaryCall(getEnterNameofClientMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getInsertKeyValueMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Pair,
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulPut>(
                  this, METHODID_INSERT_KEY_VALUE)))
          .addMethod(
            getGetKeyValueMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.GetKey,
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulGet>(
                  this, METHODID_GET_KEY_VALUE)))
          .addMethod(
            getDeleteKeyValueMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.DeleteKey,
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulDelete>(
                  this, METHODID_DELETE_KEY_VALUE)))
          .addMethod(
            getClientExitedMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ClientExit,
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulExit>(
                  this, METHODID_CLIENT_EXITED)))
          .addMethod(
            getEnterNameofClientMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendNameofClient,
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendNameofClient>(
                  this, METHODID_ENTER_NAMEOF_CLIENT)))
          .build();
    }
  }

  /**
   */
  public static final class KeyValueStoreStub extends io.grpc.stub.AbstractStub<KeyValueStoreStub> {
    private KeyValueStoreStub(io.grpc.Channel channel) {
      super(channel);
    }

    private KeyValueStoreStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KeyValueStoreStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new KeyValueStoreStub(channel, callOptions);
    }

    /**
     */
    public void insertKeyValue(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Pair request,
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulPut> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertKeyValueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getKeyValue(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.GetKey request,
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulGet> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetKeyValueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteKeyValue(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.DeleteKey request,
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulDelete> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteKeyValueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void clientExited(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ClientExit request,
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulExit> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getClientExitedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void enterNameofClient(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendNameofClient request,
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendNameofClient> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEnterNameofClientMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class KeyValueStoreBlockingStub extends io.grpc.stub.AbstractStub<KeyValueStoreBlockingStub> {
    private KeyValueStoreBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private KeyValueStoreBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KeyValueStoreBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new KeyValueStoreBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulPut insertKeyValue(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Pair request) {
      return blockingUnaryCall(
          getChannel(), getInsertKeyValueMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulGet getKeyValue(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.GetKey request) {
      return blockingUnaryCall(
          getChannel(), getGetKeyValueMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulDelete deleteKeyValue(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.DeleteKey request) {
      return blockingUnaryCall(
          getChannel(), getDeleteKeyValueMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulExit clientExited(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ClientExit request) {
      return blockingUnaryCall(
          getChannel(), getClientExitedMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendNameofClient enterNameofClient(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendNameofClient request) {
      return blockingUnaryCall(
          getChannel(), getEnterNameofClientMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class KeyValueStoreFutureStub extends io.grpc.stub.AbstractStub<KeyValueStoreFutureStub> {
    private KeyValueStoreFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private KeyValueStoreFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KeyValueStoreFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new KeyValueStoreFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulPut> insertKeyValue(
        com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Pair request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertKeyValueMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulGet> getKeyValue(
        com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.GetKey request) {
      return futureUnaryCall(
          getChannel().newCall(getGetKeyValueMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulDelete> deleteKeyValue(
        com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.DeleteKey request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteKeyValueMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulExit> clientExited(
        com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ClientExit request) {
      return futureUnaryCall(
          getChannel().newCall(getClientExitedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendNameofClient> enterNameofClient(
        com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendNameofClient request) {
      return futureUnaryCall(
          getChannel().newCall(getEnterNameofClientMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INSERT_KEY_VALUE = 0;
  private static final int METHODID_GET_KEY_VALUE = 1;
  private static final int METHODID_DELETE_KEY_VALUE = 2;
  private static final int METHODID_CLIENT_EXITED = 3;
  private static final int METHODID_ENTER_NAMEOF_CLIENT = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final KeyValueStoreImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(KeyValueStoreImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_INSERT_KEY_VALUE:
          serviceImpl.insertKeyValue((com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Pair) request,
              (io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulPut>) responseObserver);
          break;
        case METHODID_GET_KEY_VALUE:
          serviceImpl.getKeyValue((com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.GetKey) request,
              (io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulGet>) responseObserver);
          break;
        case METHODID_DELETE_KEY_VALUE:
          serviceImpl.deleteKeyValue((com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.DeleteKey) request,
              (io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulDelete>) responseObserver);
          break;
        case METHODID_CLIENT_EXITED:
          serviceImpl.clientExited((com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ClientExit) request,
              (io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulExit>) responseObserver);
          break;
        case METHODID_ENTER_NAMEOF_CLIENT:
          serviceImpl.enterNameofClient((com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendNameofClient) request,
              (io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendNameofClient>) responseObserver);
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

  private static abstract class KeyValueStoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    KeyValueStoreBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("KeyValueStore");
    }
  }

  private static final class KeyValueStoreFileDescriptorSupplier
      extends KeyValueStoreBaseDescriptorSupplier {
    KeyValueStoreFileDescriptorSupplier() {}
  }

  private static final class KeyValueStoreMethodDescriptorSupplier
      extends KeyValueStoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    KeyValueStoreMethodDescriptorSupplier(String methodName) {
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
      synchronized (KeyValueStoreGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new KeyValueStoreFileDescriptorSupplier())
              .addMethod(getInsertKeyValueMethod())
              .addMethod(getGetKeyValueMethod())
              .addMethod(getDeleteKeyValueMethod())
              .addMethod(getClientExitedMethod())
              .addMethod(getEnterNameofClientMethod())
              .build();
        }
      }
    }
    return result;
  }
}
