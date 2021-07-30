
// Generated by Akka gRPC. DO NOT EDIT.
package pom;

import akka.actor.ClassicActorSystemProvider;
import akka.stream.Materializer;
import akka.stream.SystemMaterializer;

import akka.grpc.internal.*;
import akka.grpc.GrpcClientSettings;
import akka.grpc.javadsl.AkkaGrpcClient;

import io.grpc.MethodDescriptor;

import static pom.UserService.Serializers.*;

import scala.concurrent.ExecutionContext;


import akka.grpc.javadsl.SingleResponseRequestBuilder;


public abstract class UserServiceClient extends UserServiceClientPowerApi implements UserService, AkkaGrpcClient {
  public static final UserServiceClient create(GrpcClientSettings settings, ClassicActorSystemProvider sys) {
    return new DefaultUserServiceClient(settings, sys);
  }

  protected final static class DefaultUserServiceClient extends UserServiceClient {

      private final ClientState clientState;
      private final GrpcClientSettings settings;
      private final io.grpc.CallOptions options;
      private final Materializer mat;
      private final ExecutionContext ec;

      private DefaultUserServiceClient(GrpcClientSettings settings, ClassicActorSystemProvider sys) {
        this.settings = settings;
        this.mat = SystemMaterializer.get(sys).materializer();
        this.ec = sys.classicSystem().dispatcher();
        this.clientState = new ClientState(
          settings,
          akka.event.Logging$.MODULE$.apply(sys.classicSystem(), DefaultUserServiceClient.class, akka.event.LogSource$.MODULE$.<DefaultUserServiceClient>fromAnyClass()),
          sys);
        this.options = NettyClientUtils.callOptions(settings);

        sys.classicSystem().getWhenTerminated().whenComplete((v, e) -> close());
      }

  
    
      private final SingleResponseRequestBuilder<pom.UserApi.User, com.google.protobuf.Empty> registerUserRequestBuilder(akka.grpc.internal.InternalChannel channel){
        return new JavaUnaryRequestBuilder<>(registerUserDescriptor, channel, options, settings, ec);
      }
    
  
    
      private final SingleResponseRequestBuilder<pom.UserApi.User, com.google.protobuf.Empty> updateUserRequestBuilder(akka.grpc.internal.InternalChannel channel){
        return new JavaUnaryRequestBuilder<>(updateUserDescriptor, channel, options, settings, ec);
      }
    
  
    
      private final SingleResponseRequestBuilder<pom.UserApi.UserId, com.google.protobuf.Empty> deleteUserRequestBuilder(akka.grpc.internal.InternalChannel channel){
        return new JavaUnaryRequestBuilder<>(deleteUserDescriptor, channel, options, settings, ec);
      }
    
  
    
      private final SingleResponseRequestBuilder<pom.UserApi.Login, pom.UserApi.CurrentUser> loginUserRequestBuilder(akka.grpc.internal.InternalChannel channel){
        return new JavaUnaryRequestBuilder<>(loginUserDescriptor, channel, options, settings, ec);
      }
    
  
    
      private final SingleResponseRequestBuilder<pom.UserApi.UserId, pom.UserApi.User> getUserRequestBuilder(akka.grpc.internal.InternalChannel channel){
        return new JavaUnaryRequestBuilder<>(getUserDescriptor, channel, options, settings, ec);
      }
    
  

      

        /**
         * For access to method metadata use the parameterless version of registerUser
         */
        public java.util.concurrent.CompletionStage<com.google.protobuf.Empty> registerUser(pom.UserApi.User request) {
          return registerUser().invoke(request);
        }

        /**
         * Lower level "lifted" version of the method, giving access to request metadata etc.
         * prefer registerUser(pom.UserApi.User) if possible.
         */
        
          public SingleResponseRequestBuilder<pom.UserApi.User, com.google.protobuf.Empty> registerUser()
        
        {
          return registerUserRequestBuilder(clientState.internalChannel());
        }
      

        /**
         * For access to method metadata use the parameterless version of updateUser
         */
        public java.util.concurrent.CompletionStage<com.google.protobuf.Empty> updateUser(pom.UserApi.User request) {
          return updateUser().invoke(request);
        }

        /**
         * Lower level "lifted" version of the method, giving access to request metadata etc.
         * prefer updateUser(pom.UserApi.User) if possible.
         */
        
          public SingleResponseRequestBuilder<pom.UserApi.User, com.google.protobuf.Empty> updateUser()
        
        {
          return updateUserRequestBuilder(clientState.internalChannel());
        }
      

        /**
         * For access to method metadata use the parameterless version of deleteUser
         */
        public java.util.concurrent.CompletionStage<com.google.protobuf.Empty> deleteUser(pom.UserApi.UserId request) {
          return deleteUser().invoke(request);
        }

        /**
         * Lower level "lifted" version of the method, giving access to request metadata etc.
         * prefer deleteUser(pom.UserApi.UserId) if possible.
         */
        
          public SingleResponseRequestBuilder<pom.UserApi.UserId, com.google.protobuf.Empty> deleteUser()
        
        {
          return deleteUserRequestBuilder(clientState.internalChannel());
        }
      

        /**
         * For access to method metadata use the parameterless version of loginUser
         */
        public java.util.concurrent.CompletionStage<pom.UserApi.CurrentUser> loginUser(pom.UserApi.Login request) {
          return loginUser().invoke(request);
        }

        /**
         * Lower level "lifted" version of the method, giving access to request metadata etc.
         * prefer loginUser(pom.UserApi.Login) if possible.
         */
        
          public SingleResponseRequestBuilder<pom.UserApi.Login, pom.UserApi.CurrentUser> loginUser()
        
        {
          return loginUserRequestBuilder(clientState.internalChannel());
        }
      

        /**
         * For access to method metadata use the parameterless version of getUser
         */
        public java.util.concurrent.CompletionStage<pom.UserApi.User> getUser(pom.UserApi.UserId request) {
          return getUser().invoke(request);
        }

        /**
         * Lower level "lifted" version of the method, giving access to request metadata etc.
         * prefer getUser(pom.UserApi.UserId) if possible.
         */
        
          public SingleResponseRequestBuilder<pom.UserApi.UserId, pom.UserApi.User> getUser()
        
        {
          return getUserRequestBuilder(clientState.internalChannel());
        }
      

      
        private static MethodDescriptor<pom.UserApi.User, com.google.protobuf.Empty> registerUserDescriptor =
          MethodDescriptor.<pom.UserApi.User, com.google.protobuf.Empty>newBuilder()
            .setType(
   MethodDescriptor.MethodType.UNARY 
  
  
  
)
            .setFullMethodName(MethodDescriptor.generateFullMethodName("pom.UserService", "RegisterUser"))
            .setRequestMarshaller(new ProtoMarshaller<pom.UserApi.User>(UserSerializer))
            .setResponseMarshaller(new ProtoMarshaller<com.google.protobuf.Empty>(EmptySerializer))
            .setSampledToLocalTracing(true)
            .build();
        
        private static MethodDescriptor<pom.UserApi.User, com.google.protobuf.Empty> updateUserDescriptor =
          MethodDescriptor.<pom.UserApi.User, com.google.protobuf.Empty>newBuilder()
            .setType(
   MethodDescriptor.MethodType.UNARY 
  
  
  
)
            .setFullMethodName(MethodDescriptor.generateFullMethodName("pom.UserService", "UpdateUser"))
            .setRequestMarshaller(new ProtoMarshaller<pom.UserApi.User>(UserSerializer))
            .setResponseMarshaller(new ProtoMarshaller<com.google.protobuf.Empty>(EmptySerializer))
            .setSampledToLocalTracing(true)
            .build();
        
        private static MethodDescriptor<pom.UserApi.UserId, com.google.protobuf.Empty> deleteUserDescriptor =
          MethodDescriptor.<pom.UserApi.UserId, com.google.protobuf.Empty>newBuilder()
            .setType(
   MethodDescriptor.MethodType.UNARY 
  
  
  
)
            .setFullMethodName(MethodDescriptor.generateFullMethodName("pom.UserService", "DeleteUser"))
            .setRequestMarshaller(new ProtoMarshaller<pom.UserApi.UserId>(UserIdSerializer))
            .setResponseMarshaller(new ProtoMarshaller<com.google.protobuf.Empty>(EmptySerializer))
            .setSampledToLocalTracing(true)
            .build();
        
        private static MethodDescriptor<pom.UserApi.Login, pom.UserApi.CurrentUser> loginUserDescriptor =
          MethodDescriptor.<pom.UserApi.Login, pom.UserApi.CurrentUser>newBuilder()
            .setType(
   MethodDescriptor.MethodType.UNARY 
  
  
  
)
            .setFullMethodName(MethodDescriptor.generateFullMethodName("pom.UserService", "LoginUser"))
            .setRequestMarshaller(new ProtoMarshaller<pom.UserApi.Login>(LoginSerializer))
            .setResponseMarshaller(new ProtoMarshaller<pom.UserApi.CurrentUser>(CurrentUserSerializer))
            .setSampledToLocalTracing(true)
            .build();
        
        private static MethodDescriptor<pom.UserApi.UserId, pom.UserApi.User> getUserDescriptor =
          MethodDescriptor.<pom.UserApi.UserId, pom.UserApi.User>newBuilder()
            .setType(
   MethodDescriptor.MethodType.UNARY 
  
  
  
)
            .setFullMethodName(MethodDescriptor.generateFullMethodName("pom.UserService", "GetUser"))
            .setRequestMarshaller(new ProtoMarshaller<pom.UserApi.UserId>(UserIdSerializer))
            .setResponseMarshaller(new ProtoMarshaller<pom.UserApi.User>(UserSerializer))
            .setSampledToLocalTracing(true)
            .build();
        

      /**
       * Initiates a shutdown in which preexisting and new calls are cancelled.
       */
      public java.util.concurrent.CompletionStage<akka.Done> close() {
        return clientState.closeCS() ;
      }

     /**
      * Returns a CompletionState that completes successfully when shutdown via close()
      * or exceptionally if a connection can not be established after maxConnectionAttempts.
      */
      public java.util.concurrent.CompletionStage<akka.Done> closed() {
        return clientState.closedCS();
      }
  }

}


