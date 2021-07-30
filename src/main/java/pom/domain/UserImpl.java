package pom.domain;

import com.akkaserverless.javasdk.EntityId;
import com.akkaserverless.javasdk.valueentity.*;
import com.google.protobuf.Empty;
import pom.UserApi;

/** A value entity. */
@ValueEntity(entityType = "user")
public class UserImpl extends UserInterface {
    @SuppressWarnings("unused")
    private final String entityId;
    
    public UserImpl(@EntityId String entityId) {
        this.entityId = entityId;
    }
    
    @Override
    protected Empty registerUser(UserApi.User command, CommandContext<UserDomain.UserState> ctx) {
        //throw ctx.fail("The command handler for `RegisterUser` is not implemented, yet");
       // UserDomain.UserState state = ctx.getState()
              //  .orElseGet(() -> UserDomain.UserState.newBuilder().build());
        //String userId = String.valueOf(Integer.parseInt(state.getUserId()) + Integer.parseInt(command.getUserId()));
        UserDomain.UserState newState = UserDomain.UserState.newBuilder().setUserId(command.getUserId())
                .setFirstName(command.getFirstName())
                .setLastName(command.getLastName())
                .setUserType(command.getUserType())
                .setAddress(command.getAddress())
                .setLocationCoordinates(command.getLocationCoordinates())
                .setPhoneNumber(command.getPhoneNumber())
                .setSubType(command.getSubType())
                .setEmailId(command.getEmailId())
                .setPassword(command.getPassword()).build();

        ctx.updateState(newState);
        return Empty.getDefaultInstance();
    }
    
    @Override
    protected Empty updateUser(UserApi.User command, CommandContext<UserDomain.UserState> ctx) {
      //  throw ctx.fail("The command handler for `UpdateUser` is not implemented, yet");
        UserDomain.UserState state = ctx.getState()
                .orElseThrow(IllegalArgumentException :: new);
//       if(!state.getPassword().equals(command.getPassword())){
//           throw new Exception("password can't be updated");
//       }
        UserDomain.UserState newState = state.toBuilder()
                .setFirstName(command.getFirstName())
                .setLastName(command.getLastName())
                .setUserType(command.getUserType())
                .setAddress(command.getAddress())
                .setLocationCoordinates(command.getLocationCoordinates())
                .setPhoneNumber(command.getPhoneNumber())
                .setSubType(command.getSubType())
                .setEmailId(command.getEmailId())
                .setPassword(state.getPassword()).build();

        ctx.updateState(newState);
        return Empty.getDefaultInstance();
    }
    
    @Override
    protected Empty deleteUser(UserApi.UserId command, CommandContext<UserDomain.UserState> ctx) {
//        throw ctx.fail("The command handler for `DeleteUser` is not implemented, yet");
        ctx.deleteState();
        return Empty.getDefaultInstance();
    }
    
    @Override
    protected UserApi.CurrentUser loginUser(UserApi.Login command, CommandContext<UserDomain.UserState> ctx) {
//        throw ctx.fail("The command handler for `LoginUser` is not implemented, yet");
        UserApi.CurrentUser current = ctx.getState()
                .filter((state) -> state.getUserId().equals(command.getUserId()) && state.getPassword() == command.getPassword())
                .map((state) -> UserApi.CurrentUser.newBuilder().setFirstName(state.getFirstName())
                        .setLastName(state.getLastName())
                        .setPhoneNumber(state.getPhoneNumber())
                        .setEmailId(state.getEmailId()).build())
                .orElseGet(() -> UserApi.CurrentUser.newBuilder().setFirstName("Invalid username/password").build());
        return current;
    }
    
    @Override
    protected UserApi.User getUser(UserApi.UserId command, CommandContext<UserDomain.UserState> ctx) {
        //throw ctx.fail("The command handler for `GetUser` is not implemented, yet");
        UserApi.User user = ctx.getState()
                .map((state) -> UserApi.User.newBuilder()
                        .setUserId(state.getUserId())
                        .setFirstName(state.getFirstName())
                        .setLastName(state.getLastName())
                        .setUserType(state.getUserType())
                        .setAddress(state.getAddress())
                        .setLocationCoordinates(state.getLocationCoordinates())
                        .setPhoneNumber(state.getPhoneNumber())
                        .setSubType(state.getSubType())
                        .setEmailId(state.getEmailId())
                        .setPassword(state.getPassword()).build())
                //.orElseGet(() -> UserApi.User.newBuilder().setFirstName("").build());
                .orElseThrow(IllegalArgumentException::new);
         return user;
    }
}