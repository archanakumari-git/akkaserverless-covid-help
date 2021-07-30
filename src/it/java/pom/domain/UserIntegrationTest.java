package pom.domain;

import pom.Main;
import pom.UserServiceClient;
import com.akkaserverless.javasdk.testkit.junit.AkkaServerlessTestkitResource;
import org.junit.ClassRule;
import org.junit.Test;

import static java.util.concurrent.TimeUnit.*;

// Example of an integration test calling our service via the Akka Serverless proxy
// Run all test classes ending with "IntegrationTest" using `mvn verify -Pit`
public class UserIntegrationTest {
    
    /**
     * The test kit starts both the service container and the Akka Serverless proxy.
     */
    @ClassRule
    public static final AkkaServerlessTestkitResource testkit = new AkkaServerlessTestkitResource(Main.SERVICE);
    
    /**
     * Use the generated gRPC client to call the service through the Akka Serverless proxy.
     */
    private final UserServiceClient client;
    
    public UserIntegrationTest() {
        client = UserServiceClient.create(testkit.getGrpcClientSettings(), testkit.getActorSystem());
    }
    
    @Test
    public void registerUserOnNonExistingEntity() throws Exception {
        // TODO: set fields in command, and provide assertions to match replies
        // client.registerUser(UserApi.User.newBuilder().build())
        //         .toCompletableFuture().get(2, SECONDS);
    }
    
    @Test
    public void updateUserOnNonExistingEntity() throws Exception {
        // TODO: set fields in command, and provide assertions to match replies
        // client.updateUser(UserApi.User.newBuilder().build())
        //         .toCompletableFuture().get(2, SECONDS);
    }
    
    @Test
    public void deleteUserOnNonExistingEntity() throws Exception {
        // TODO: set fields in command, and provide assertions to match replies
        // client.deleteUser(UserApi.UserId.newBuilder().build())
        //         .toCompletableFuture().get(2, SECONDS);
    }
    
    @Test
    public void loginUserOnNonExistingEntity() throws Exception {
        // TODO: set fields in command, and provide assertions to match replies
        // client.loginUser(UserApi.Login.newBuilder().build())
        //         .toCompletableFuture().get(2, SECONDS);
    }
    
    @Test
    public void getUserOnNonExistingEntity() throws Exception {
        // TODO: set fields in command, and provide assertions to match replies
        // client.getUser(UserApi.UserId.newBuilder().build())
        //         .toCompletableFuture().get(2, SECONDS);
    }
}