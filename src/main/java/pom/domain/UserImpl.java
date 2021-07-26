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
    protected Empty registerUser(UserApi.RegisteredUser command, CommandContext<UserDomain.UserState> ctx) {
//        UserDomain.UserState state = ctx.getState()
//                .orElseGet(() -> UserDomain.UserState.newBuilder().build());
//        UserDomain.UserState newState = ???
//              //  state.toBuilder().setValue(state.getValue() + command.getValue()).build();
//        ctx.updateState(newState);
//        return Empty.getDefaultInstance();
        throw ctx.fail("The command handler for `RegisterUser` is not implemented, yet");
    }
    
    @Override
    protected Empty updateUser(UserApi.UpdatedUser command, CommandContext<UserDomain.UserState> ctx) {
        throw ctx.fail("The command handler for `UpdateUser` is not implemented, yet");
    }
    
    @Override
    protected Empty deleteUser(UserApi.DeletedUser command, CommandContext<UserDomain.UserState> ctx) {
        throw ctx.fail("The command handler for `DeleteUser` is not implemented, yet");
    }
    
    @Override
    protected UserApi.CurrentUser loginUser(UserApi.UserLogin command, CommandContext<UserDomain.UserState> ctx) {
        throw ctx.fail("The command handler for `LoginUser` is not implemented, yet");
    }
}