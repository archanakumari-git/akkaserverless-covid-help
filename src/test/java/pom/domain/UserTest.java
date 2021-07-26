package pom.domain;

import com.akkaserverless.javasdk.valueentity.CommandContext;
import com.google.protobuf.Empty;
import org.junit.Test;
import org.mockito.*;
import pom.UserApi;

import static org.junit.Assert.assertThrows;

public class UserTest {
    private String entityId = "entityId1";
    private UserImpl entity;
    private CommandContext<UserDomain.UserState> context = Mockito.mock(CommandContext.class);
    
    private class MockedContextFailure extends RuntimeException {};
    
    @Test
    public void registerUserTest() {
        entity = new UserImpl(entityId);
        
        Mockito.when(context.fail("The command handler for `RegisterUser` is not implemented, yet"))
            .thenReturn(new MockedContextFailure());
        
        // TODO: set fields in command, and update assertions to match implementation
        assertThrows(MockedContextFailure.class, () -> {
            entity.registerUserWithReply(UserApi.RegisteredUser.newBuilder().build(), context);
        });
    }
    
    @Test
    public void updateUserTest() {
        entity = new UserImpl(entityId);
        
        Mockito.when(context.fail("The command handler for `UpdateUser` is not implemented, yet"))
            .thenReturn(new MockedContextFailure());
        
        // TODO: set fields in command, and update assertions to match implementation
        assertThrows(MockedContextFailure.class, () -> {
            entity.updateUserWithReply(UserApi.UpdatedUser.newBuilder().build(), context);
        });
    }
    
    @Test
    public void deleteUserTest() {
        entity = new UserImpl(entityId);
        
        Mockito.when(context.fail("The command handler for `DeleteUser` is not implemented, yet"))
            .thenReturn(new MockedContextFailure());
        
        // TODO: set fields in command, and update assertions to match implementation
        assertThrows(MockedContextFailure.class, () -> {
            entity.deleteUserWithReply(UserApi.DeletedUser.newBuilder().build(), context);
        });
    }
    
    @Test
    public void loginUserTest() {
        entity = new UserImpl(entityId);
        
        Mockito.when(context.fail("The command handler for `LoginUser` is not implemented, yet"))
            .thenReturn(new MockedContextFailure());
        
        // TODO: set fields in command, and update assertions to match implementation
        assertThrows(MockedContextFailure.class, () -> {
            entity.loginUserWithReply(UserApi.UserLogin.newBuilder().build(), context);
        });
    }
}