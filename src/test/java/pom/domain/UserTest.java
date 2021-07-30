package pom.domain;

import com.akkaserverless.javasdk.valueentity.CommandContext;
import org.junit.Test;
import org.mockito.Mockito;
import pom.UserApi;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class UserTest {
    private String entityId = "entityId1";
    private UserImpl entity;
    private CommandContext<UserDomain.UserState> context = Mockito.mock(CommandContext.class);

    private class MockedContextFailure extends RuntimeException {
    }

    ;

    @Test
    public void registerUserTest() {
        entity = new UserImpl(entityId);

        context = contextWithoutState();
        UserApi.User message = UserApi.User.newBuilder().setUserId("1")
                .setFirstName("archana")
                .setLastName("Kumari")
                .setUserType("userType")
                .setAddress("Bengaluru")
                .setLocationCoordinates("2.4,3.1")
                .setPhoneNumber("123456789")
                .setSubType("subType")
                .setEmailId("ak@bct.com")
                .setPassword("password").build();
        entity.registerUser(message, context);

        Mockito.verify(context).updateState(UserDomain.UserState.newBuilder().setUserId("1")
                .setFirstName("archana")
                .setLastName("Kumari")
                .setUserType("userType")
                .setAddress("Bengaluru")
                .setLocationCoordinates("2.4,3.1")
                .setPhoneNumber("123456789")
                .setSubType("subType")
                .setEmailId("ak@bct.com")
                .setPassword("password").build());
    }

    @Test
    public void updateUserTest() {
        entity = new UserImpl(entityId);

        context = contextWithState();
        UserApi.User message =  UserApi.User.newBuilder().setUserId("2")
                .setFirstName("preeti")
                .setLastName("Kumari")
                .setUserType("userType")
                .setAddress("Bihar")
                .setLocationCoordinates("2.4,3.1")
                .setPhoneNumber("123456789")
                .setSubType("subType")
                .setEmailId("pkri@bct.com")
                .setPassword("passwordNew").build();

        entity.updateUser(message,context);
        Mockito.verify(context).updateState(UserDomain.UserState.newBuilder()
                .setUserId("2")
                .setFirstName("preeti")
                .setLastName("Kumari")
                .setUserType("userType")
                .setAddress("Bihar")
                .setLocationCoordinates("2.4,3.1")
                .setPhoneNumber("123456789")
                .setSubType("subType")
                .setEmailId("pkri@bct.com")
                .setPassword("password").build());
    }

    @Test
    public void deleteUserTest() {
        entity = new UserImpl(entityId);

        context = contextWithState();
        UserApi.UserId message = UserApi.UserId.newBuilder().setUserId("2").build();
        entity.deleteUser(message,context);

        Mockito.verify(context).deleteState();
    }

    @Test
    public void loginUserTest() {
        entity = new UserImpl(entityId);
        context = contextWithState();

        UserApi.Login message = UserApi.Login.newBuilder()
                .setUserId("2")
                .setPassword("password").build();
        UserApi.CurrentUser result = entity.loginUser(message, context);
        UserApi.CurrentUser expectedResult = UserApi.CurrentUser.newBuilder()
                .setFirstName("priti")
                .setLastName("Kumari")
                .setPhoneNumber("123456789")
                .setEmailId("pk@bct.com").build();

        assertEquals(result.getFirstName(), expectedResult.getFirstName());
        assertEquals(result.getLastName(), expectedResult.getLastName());
        assertEquals(result.getPhoneNumber(), expectedResult.getPhoneNumber());
        assertEquals(result.getEmailId(), expectedResult.getEmailId());

    }

    @Test
    public void getUserTest() {
        entity = new UserImpl(entityId);

        context = contextWithState();
        UserApi.UserId message = UserApi.UserId.newBuilder().setUserId("2").build();
        UserApi.User result = entity.getUser(message, context);
        UserApi.User expectedResult = UserApi.User.newBuilder()
                .setUserId("2")
                .setFirstName("priti")
                .setLastName("Kumari")
                .setUserType("userType")
                .setAddress("Bengaluru")
                .setLocationCoordinates("2.4,3.1")
                .setPhoneNumber("123456789")
                .setSubType("subType")
                .setEmailId("pk@bct.com")
                .setPassword("password").build();

        assertEquals(result.getUserId(),expectedResult.getUserId());
        assertEquals(result.getFirstName(),expectedResult.getFirstName());
        assertEquals(result.getLastName(),expectedResult.getLastName());
        assertEquals(result.getUserType(),expectedResult.getUserType());
        assertEquals(result.getAddress(),expectedResult.getAddress());
        assertEquals(result.getLocationCoordinates(),expectedResult.getLocationCoordinates());
        assertEquals(result.getPhoneNumber(),expectedResult.getPhoneNumber());
        assertEquals(result.getSubType(),expectedResult.getSubType());
        assertEquals(result.getEmailId(),expectedResult.getEmailId());
        assertEquals(result.getPassword(),expectedResult.getPassword());

    }

    private CommandContext<UserDomain.UserState> contextWithoutState() {
        Mockito.when(context.getState()).thenReturn(Optional.empty());
        return context;
    }

    private CommandContext<UserDomain.UserState> contextWithState() {
        UserDomain.UserState state = UserDomain.UserState.newBuilder()
                .setUserId("2")
                .setFirstName("priti")
                .setLastName("Kumari")
                .setUserType("userType")
                .setAddress("Bengaluru")
                .setLocationCoordinates("2.4,3.1")
                .setPhoneNumber("123456789")
                .setSubType("subType")
                .setEmailId("pk@bct.com")
                .setPassword("password").build();
        Mockito.when(context.getState()).thenReturn(Optional.of(state));
        return context;
    }
}