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

  private static volatile io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.GetNamesofClients,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ListofClients> getNamesOfClientsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "NamesOfClients",
      requestType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.GetNamesofClients.class,
      responseType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ListofClients.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.GetNamesofClients,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ListofClients> getNamesOfClientsMethod() {
    io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.GetNamesofClients, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ListofClients> getNamesOfClientsMethod;
    if ((getNamesOfClientsMethod = KeyValueStoreGrpc.getNamesOfClientsMethod) == null) {
      synchronized (KeyValueStoreGrpc.class) {
        if ((getNamesOfClientsMethod = KeyValueStoreGrpc.getNamesOfClientsMethod) == null) {
          KeyValueStoreGrpc.getNamesOfClientsMethod = getNamesOfClientsMethod = 
              io.grpc.MethodDescriptor.<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.GetNamesofClients, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ListofClients>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "KeyValueStore", "NamesOfClients"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.GetNamesofClients.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ListofClients.getDefaultInstance()))
                  .setSchemaDescriptor(new KeyValueStoreMethodDescriptorSupplier("NamesOfClients"))
                  .build();
          }
        }
     }
     return getNamesOfClientsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Abortorcommit,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulAbort> getAcceptabortorcommitMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Acceptabortorcommit",
      requestType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Abortorcommit.class,
      responseType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulAbort.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Abortorcommit,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulAbort> getAcceptabortorcommitMethod() {
    io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Abortorcommit, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulAbort> getAcceptabortorcommitMethod;
    if ((getAcceptabortorcommitMethod = KeyValueStoreGrpc.getAcceptabortorcommitMethod) == null) {
      synchronized (KeyValueStoreGrpc.class) {
        if ((getAcceptabortorcommitMethod = KeyValueStoreGrpc.getAcceptabortorcommitMethod) == null) {
          KeyValueStoreGrpc.getAcceptabortorcommitMethod = getAcceptabortorcommitMethod = 
              io.grpc.MethodDescriptor.<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Abortorcommit, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulAbort>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "KeyValueStore", "Acceptabortorcommit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Abortorcommit.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulAbort.getDefaultInstance()))
                  .setSchemaDescriptor(new KeyValueStoreMethodDescriptorSupplier("Acceptabortorcommit"))
                  .build();
          }
        }
     }
     return getAcceptabortorcommitMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Broadcasttoallclients,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.FromServer> getChatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "chat",
      requestType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Broadcasttoallclients.class,
      responseType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.FromServer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Broadcasttoallclients,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.FromServer> getChatMethod() {
    io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Broadcasttoallclients, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.FromServer> getChatMethod;
    if ((getChatMethod = KeyValueStoreGrpc.getChatMethod) == null) {
      synchronized (KeyValueStoreGrpc.class) {
        if ((getChatMethod = KeyValueStoreGrpc.getChatMethod) == null) {
          KeyValueStoreGrpc.getChatMethod = getChatMethod = 
              io.grpc.MethodDescriptor.<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Broadcasttoallclients, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.FromServer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "KeyValueStore", "chat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Broadcasttoallclients.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.FromServer.getDefaultInstance()))
                  .setSchemaDescriptor(new KeyValueStoreMethodDescriptorSupplier("chat"))
                  .build();
          }
        }
     }
     return getChatMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.PermissionRequest,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.PermissionGrantedorDenied> getCommunicateWithProposersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "communicateWithProposers",
      requestType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.PermissionRequest.class,
      responseType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.PermissionGrantedorDenied.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.PermissionRequest,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.PermissionGrantedorDenied> getCommunicateWithProposersMethod() {
    io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.PermissionRequest, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.PermissionGrantedorDenied> getCommunicateWithProposersMethod;
    if ((getCommunicateWithProposersMethod = KeyValueStoreGrpc.getCommunicateWithProposersMethod) == null) {
      synchronized (KeyValueStoreGrpc.class) {
        if ((getCommunicateWithProposersMethod = KeyValueStoreGrpc.getCommunicateWithProposersMethod) == null) {
          KeyValueStoreGrpc.getCommunicateWithProposersMethod = getCommunicateWithProposersMethod = 
              io.grpc.MethodDescriptor.<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.PermissionRequest, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.PermissionGrantedorDenied>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "KeyValueStore", "communicateWithProposers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.PermissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.PermissionGrantedorDenied.getDefaultInstance()))
                  .setSchemaDescriptor(new KeyValueStoreMethodDescriptorSupplier("communicateWithProposers"))
                  .build();
          }
        }
     }
     return getCommunicateWithProposersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendConsensus,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ClientConsensus> getConsensusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Consensus",
      requestType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendConsensus.class,
      responseType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ClientConsensus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendConsensus,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ClientConsensus> getConsensusMethod() {
    io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendConsensus, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ClientConsensus> getConsensusMethod;
    if ((getConsensusMethod = KeyValueStoreGrpc.getConsensusMethod) == null) {
      synchronized (KeyValueStoreGrpc.class) {
        if ((getConsensusMethod = KeyValueStoreGrpc.getConsensusMethod) == null) {
          KeyValueStoreGrpc.getConsensusMethod = getConsensusMethod = 
              io.grpc.MethodDescriptor.<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendConsensus, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ClientConsensus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "KeyValueStore", "Consensus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendConsensus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ClientConsensus.getDefaultInstance()))
                  .setSchemaDescriptor(new KeyValueStoreMethodDescriptorSupplier("Consensus"))
                  .build();
          }
        }
     }
     return getConsensusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ServerShutdown,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ServerShutdown> getSendServerShutdownMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendServerShutdown",
      requestType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ServerShutdown.class,
      responseType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ServerShutdown.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ServerShutdown,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ServerShutdown> getSendServerShutdownMethod() {
    io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ServerShutdown, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ServerShutdown> getSendServerShutdownMethod;
    if ((getSendServerShutdownMethod = KeyValueStoreGrpc.getSendServerShutdownMethod) == null) {
      synchronized (KeyValueStoreGrpc.class) {
        if ((getSendServerShutdownMethod = KeyValueStoreGrpc.getSendServerShutdownMethod) == null) {
          KeyValueStoreGrpc.getSendServerShutdownMethod = getSendServerShutdownMethod = 
              io.grpc.MethodDescriptor.<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ServerShutdown, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ServerShutdown>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "KeyValueStore", "SendServerShutdown"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ServerShutdown.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ServerShutdown.getDefaultInstance()))
                  .setSchemaDescriptor(new KeyValueStoreMethodDescriptorSupplier("SendServerShutdown"))
                  .build();
          }
        }
     }
     return getSendServerShutdownMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.RequestListofServers,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary> getRequestServerListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RequestServerList",
      requestType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.RequestListofServers.class,
      responseType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.RequestListofServers,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary> getRequestServerListMethod() {
    io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.RequestListofServers, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary> getRequestServerListMethod;
    if ((getRequestServerListMethod = KeyValueStoreGrpc.getRequestServerListMethod) == null) {
      synchronized (KeyValueStoreGrpc.class) {
        if ((getRequestServerListMethod = KeyValueStoreGrpc.getRequestServerListMethod) == null) {
          KeyValueStoreGrpc.getRequestServerListMethod = getRequestServerListMethod = 
              io.grpc.MethodDescriptor.<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.RequestListofServers, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "KeyValueStore", "RequestServerList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.RequestListofServers.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary.getDefaultInstance()))
                  .setSchemaDescriptor(new KeyValueStoreMethodDescriptorSupplier("RequestServerList"))
                  .build();
          }
        }
     }
     return getRequestServerListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.BringServerDown,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary> getRemoveServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveServer",
      requestType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.BringServerDown.class,
      responseType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.BringServerDown,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary> getRemoveServerMethod() {
    io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.BringServerDown, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary> getRemoveServerMethod;
    if ((getRemoveServerMethod = KeyValueStoreGrpc.getRemoveServerMethod) == null) {
      synchronized (KeyValueStoreGrpc.class) {
        if ((getRemoveServerMethod = KeyValueStoreGrpc.getRemoveServerMethod) == null) {
          KeyValueStoreGrpc.getRemoveServerMethod = getRemoveServerMethod = 
              io.grpc.MethodDescriptor.<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.BringServerDown, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "KeyValueStore", "RemoveServer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.BringServerDown.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary.getDefaultInstance()))
                  .setSchemaDescriptor(new KeyValueStoreMethodDescriptorSupplier("RemoveServer"))
                  .build();
          }
        }
     }
     return getRemoveServerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.BringServerDown,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary> getServerAvailabilityCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ServerAvailabilityCheck",
      requestType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.BringServerDown.class,
      responseType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.BringServerDown,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary> getServerAvailabilityCheckMethod() {
    io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.BringServerDown, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary> getServerAvailabilityCheckMethod;
    if ((getServerAvailabilityCheckMethod = KeyValueStoreGrpc.getServerAvailabilityCheckMethod) == null) {
      synchronized (KeyValueStoreGrpc.class) {
        if ((getServerAvailabilityCheckMethod = KeyValueStoreGrpc.getServerAvailabilityCheckMethod) == null) {
          KeyValueStoreGrpc.getServerAvailabilityCheckMethod = getServerAvailabilityCheckMethod = 
              io.grpc.MethodDescriptor.<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.BringServerDown, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "KeyValueStore", "ServerAvailabilityCheck"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.BringServerDown.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary.getDefaultInstance()))
                  .setSchemaDescriptor(new KeyValueStoreMethodDescriptorSupplier("ServerAvailabilityCheck"))
                  .build();
          }
        }
     }
     return getServerAvailabilityCheckMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.removeClientsFromList,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.removeClientsFromList> getRemoveClientsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveClients",
      requestType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.removeClientsFromList.class,
      responseType = com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.removeClientsFromList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.removeClientsFromList,
      com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.removeClientsFromList> getRemoveClientsMethod() {
    io.grpc.MethodDescriptor<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.removeClientsFromList, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.removeClientsFromList> getRemoveClientsMethod;
    if ((getRemoveClientsMethod = KeyValueStoreGrpc.getRemoveClientsMethod) == null) {
      synchronized (KeyValueStoreGrpc.class) {
        if ((getRemoveClientsMethod = KeyValueStoreGrpc.getRemoveClientsMethod) == null) {
          KeyValueStoreGrpc.getRemoveClientsMethod = getRemoveClientsMethod = 
              io.grpc.MethodDescriptor.<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.removeClientsFromList, com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.removeClientsFromList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "KeyValueStore", "RemoveClients"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.removeClientsFromList.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.removeClientsFromList.getDefaultInstance()))
                  .setSchemaDescriptor(new KeyValueStoreMethodDescriptorSupplier("RemoveClients"))
                  .build();
          }
        }
     }
     return getRemoveClientsMethod;
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

    /**
     */
    public void namesOfClients(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.GetNamesofClients request,
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ListofClients> responseObserver) {
      asyncUnimplementedUnaryCall(getNamesOfClientsMethod(), responseObserver);
    }

    /**
     */
    public void acceptabortorcommit(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Abortorcommit request,
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulAbort> responseObserver) {
      asyncUnimplementedUnaryCall(getAcceptabortorcommitMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Broadcasttoallclients> chat(
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.FromServer> responseObserver) {
      return asyncUnimplementedStreamingCall(getChatMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.PermissionRequest> communicateWithProposers(
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.PermissionGrantedorDenied> responseObserver) {
      return asyncUnimplementedStreamingCall(getCommunicateWithProposersMethod(), responseObserver);
    }

    /**
     */
    public void consensus(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendConsensus request,
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ClientConsensus> responseObserver) {
      asyncUnimplementedUnaryCall(getConsensusMethod(), responseObserver);
    }

    /**
     * <pre>
     *Initial function that just posts on client that a particular server has been brought down
     * </pre>
     */
    public void sendServerShutdown(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ServerShutdown request,
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ServerShutdown> responseObserver) {
      asyncUnimplementedUnaryCall(getSendServerShutdownMethod(), responseObserver);
    }

    /**
     */
    public void requestServerList(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.RequestListofServers request,
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary> responseObserver) {
      asyncUnimplementedUnaryCall(getRequestServerListMethod(), responseObserver);
    }

    /**
     * <pre>
     *new function that goes into hashmap, removes the server and returns the remaining server list. Uses same logic as previous client that performs the same function
     * </pre>
     */
    public void removeServer(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.BringServerDown request,
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveServerMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.BringServerDown> serverAvailabilityCheck(
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary> responseObserver) {
      return asyncUnimplementedStreamingCall(getServerAvailabilityCheckMethod(), responseObserver);
    }

    /**
     */
    public void removeClients(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.removeClientsFromList request,
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.removeClientsFromList> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveClientsMethod(), responseObserver);
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
          .addMethod(
            getNamesOfClientsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.GetNamesofClients,
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ListofClients>(
                  this, METHODID_NAMES_OF_CLIENTS)))
          .addMethod(
            getAcceptabortorcommitMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Abortorcommit,
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulAbort>(
                  this, METHODID_ACCEPTABORTORCOMMIT)))
          .addMethod(
            getChatMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Broadcasttoallclients,
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.FromServer>(
                  this, METHODID_CHAT)))
          .addMethod(
            getCommunicateWithProposersMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.PermissionRequest,
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.PermissionGrantedorDenied>(
                  this, METHODID_COMMUNICATE_WITH_PROPOSERS)))
          .addMethod(
            getConsensusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendConsensus,
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ClientConsensus>(
                  this, METHODID_CONSENSUS)))
          .addMethod(
            getSendServerShutdownMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ServerShutdown,
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ServerShutdown>(
                  this, METHODID_SEND_SERVER_SHUTDOWN)))
          .addMethod(
            getRequestServerListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.RequestListofServers,
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary>(
                  this, METHODID_REQUEST_SERVER_LIST)))
          .addMethod(
            getRemoveServerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.BringServerDown,
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary>(
                  this, METHODID_REMOVE_SERVER)))
          .addMethod(
            getServerAvailabilityCheckMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.BringServerDown,
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary>(
                  this, METHODID_SERVER_AVAILABILITY_CHECK)))
          .addMethod(
            getRemoveClientsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.removeClientsFromList,
                com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.removeClientsFromList>(
                  this, METHODID_REMOVE_CLIENTS)))
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

    /**
     */
    public void namesOfClients(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.GetNamesofClients request,
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ListofClients> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getNamesOfClientsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void acceptabortorcommit(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Abortorcommit request,
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulAbort> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAcceptabortorcommitMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Broadcasttoallclients> chat(
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.FromServer> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getChatMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.PermissionRequest> communicateWithProposers(
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.PermissionGrantedorDenied> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getCommunicateWithProposersMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void consensus(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendConsensus request,
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ClientConsensus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getConsensusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Initial function that just posts on client that a particular server has been brought down
     * </pre>
     */
    public void sendServerShutdown(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ServerShutdown request,
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ServerShutdown> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendServerShutdownMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void requestServerList(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.RequestListofServers request,
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRequestServerListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *new function that goes into hashmap, removes the server and returns the remaining server list. Uses same logic as previous client that performs the same function
     * </pre>
     */
    public void removeServer(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.BringServerDown request,
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveServerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.BringServerDown> serverAvailabilityCheck(
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getServerAvailabilityCheckMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void removeClients(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.removeClientsFromList request,
        io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.removeClientsFromList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveClientsMethod(), getCallOptions()), request, responseObserver);
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

    /**
     */
    public com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ListofClients namesOfClients(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.GetNamesofClients request) {
      return blockingUnaryCall(
          getChannel(), getNamesOfClientsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulAbort acceptabortorcommit(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Abortorcommit request) {
      return blockingUnaryCall(
          getChannel(), getAcceptabortorcommitMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ClientConsensus consensus(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendConsensus request) {
      return blockingUnaryCall(
          getChannel(), getConsensusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Initial function that just posts on client that a particular server has been brought down
     * </pre>
     */
    public com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ServerShutdown sendServerShutdown(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ServerShutdown request) {
      return blockingUnaryCall(
          getChannel(), getSendServerShutdownMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary requestServerList(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.RequestListofServers request) {
      return blockingUnaryCall(
          getChannel(), getRequestServerListMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *new function that goes into hashmap, removes the server and returns the remaining server list. Uses same logic as previous client that performs the same function
     * </pre>
     */
    public com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary removeServer(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.BringServerDown request) {
      return blockingUnaryCall(
          getChannel(), getRemoveServerMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.removeClientsFromList removeClients(com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.removeClientsFromList request) {
      return blockingUnaryCall(
          getChannel(), getRemoveClientsMethod(), getCallOptions(), request);
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

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ListofClients> namesOfClients(
        com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.GetNamesofClients request) {
      return futureUnaryCall(
          getChannel().newCall(getNamesOfClientsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulAbort> acceptabortorcommit(
        com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Abortorcommit request) {
      return futureUnaryCall(
          getChannel().newCall(getAcceptabortorcommitMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ClientConsensus> consensus(
        com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendConsensus request) {
      return futureUnaryCall(
          getChannel().newCall(getConsensusMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Initial function that just posts on client that a particular server has been brought down
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ServerShutdown> sendServerShutdown(
        com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ServerShutdown request) {
      return futureUnaryCall(
          getChannel().newCall(getSendServerShutdownMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary> requestServerList(
        com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.RequestListofServers request) {
      return futureUnaryCall(
          getChannel().newCall(getRequestServerListMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *new function that goes into hashmap, removes the server and returns the remaining server list. Uses same logic as previous client that performs the same function
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary> removeServer(
        com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.BringServerDown request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveServerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.removeClientsFromList> removeClients(
        com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.removeClientsFromList request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveClientsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INSERT_KEY_VALUE = 0;
  private static final int METHODID_GET_KEY_VALUE = 1;
  private static final int METHODID_DELETE_KEY_VALUE = 2;
  private static final int METHODID_CLIENT_EXITED = 3;
  private static final int METHODID_ENTER_NAMEOF_CLIENT = 4;
  private static final int METHODID_NAMES_OF_CLIENTS = 5;
  private static final int METHODID_ACCEPTABORTORCOMMIT = 6;
  private static final int METHODID_CONSENSUS = 7;
  private static final int METHODID_SEND_SERVER_SHUTDOWN = 8;
  private static final int METHODID_REQUEST_SERVER_LIST = 9;
  private static final int METHODID_REMOVE_SERVER = 10;
  private static final int METHODID_REMOVE_CLIENTS = 11;
  private static final int METHODID_CHAT = 12;
  private static final int METHODID_COMMUNICATE_WITH_PROPOSERS = 13;
  private static final int METHODID_SERVER_AVAILABILITY_CHECK = 14;

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
        case METHODID_NAMES_OF_CLIENTS:
          serviceImpl.namesOfClients((com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.GetNamesofClients) request,
              (io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ListofClients>) responseObserver);
          break;
        case METHODID_ACCEPTABORTORCOMMIT:
          serviceImpl.acceptabortorcommit((com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Abortorcommit) request,
              (io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SuccessfulAbort>) responseObserver);
          break;
        case METHODID_CONSENSUS:
          serviceImpl.consensus((com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.SendConsensus) request,
              (io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ClientConsensus>) responseObserver);
          break;
        case METHODID_SEND_SERVER_SHUTDOWN:
          serviceImpl.sendServerShutdown((com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ServerShutdown) request,
              (io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.ServerShutdown>) responseObserver);
          break;
        case METHODID_REQUEST_SERVER_LIST:
          serviceImpl.requestServerList((com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.RequestListofServers) request,
              (io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary>) responseObserver);
          break;
        case METHODID_REMOVE_SERVER:
          serviceImpl.removeServer((com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.BringServerDown) request,
              (io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary>) responseObserver);
          break;
        case METHODID_REMOVE_CLIENTS:
          serviceImpl.removeClients((com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.removeClientsFromList) request,
              (io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.removeClientsFromList>) responseObserver);
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
        case METHODID_CHAT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.chat(
              (io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.FromServer>) responseObserver);
        case METHODID_COMMUNICATE_WITH_PROPOSERS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.communicateWithProposers(
              (io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.PermissionGrantedorDenied>) responseObserver);
        case METHODID_SERVER_AVAILABILITY_CHECK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.serverAvailabilityCheck(
              (io.grpc.stub.StreamObserver<com.gRE_Multi_Threaded_Server.grpc.KeyValueStoreProcedures.Dictionary>) responseObserver);
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
              .addMethod(getNamesOfClientsMethod())
              .addMethod(getAcceptabortorcommitMethod())
              .addMethod(getChatMethod())
              .addMethod(getCommunicateWithProposersMethod())
              .addMethod(getConsensusMethod())
              .addMethod(getSendServerShutdownMethod())
              .addMethod(getRequestServerListMethod())
              .addMethod(getRemoveServerMethod())
              .addMethod(getServerAvailabilityCheckMethod())
              .addMethod(getRemoveClientsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
