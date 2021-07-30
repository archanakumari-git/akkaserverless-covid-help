package pom.domain;

import com.akkaserverless.javasdk.EntityId;
import com.akkaserverless.javasdk.Reply;
import com.akkaserverless.javasdk.valueentity.*;
import com.google.protobuf.Empty;
import pom.UserApi;

/** A value entity. */
public abstract class UserInterface {
    
    public class CommandNotImplementedException extends UnsupportedOperationException {
        public CommandNotImplementedException() {
            super("You have either created a new command or removed the handling of an existing command. Please declare a method in your \"impl\" class for this command.");
        }
    }
    
    @CommandHandler(name = "RegisterUser")
    public Reply<Empty> registerUserWithReply(UserApi.User command, CommandContext<UserDomain.UserState> ctx) {
        return Reply.message(registerUser(command, ctx));
    }
    
    protected Empty registerUser(UserApi.User command, CommandContext<UserDomain.UserState> ctx) {
        return registerUser(command);
    }
    
    protected Empty registerUser(UserApi.User command) {
        throw new CommandNotImplementedException();
    }
    
    @CommandHandler(name = "UpdateUser")
    public Reply<Empty> updateUserWithReply(UserApi.User command, CommandContext<UserDomain.UserState> ctx) {
        return Reply.message(updateUser(command, ctx));
    }
    
    protected Empty updateUser(UserApi.User command, CommandContext<UserDomain.UserState> ctx) {
        return updateUser(command);
    }
    
    protected Empty updateUser(UserApi.User command) {
        throw new CommandNotImplementedException();
    }
    
    @CommandHandler(name = "DeleteUser")
    public Reply<Empty> deleteUserWithReply(UserApi.UserId command, CommandContext<UserDomain.UserState> ctx) {
        return Reply.message(deleteUser(command, ctx));
    }
    
    protected Empty deleteUser(UserApi.UserId command, CommandContext<UserDomain.UserState> ctx) {
        return deleteUser(command);
    }
    
    protected Empty deleteUser(UserApi.UserId command) {
        throw new CommandNotImplementedException();
    }
    
    @CommandHandler(name = "LoginUser")
    public Reply<UserApi.CurrentUser> loginUserWithReply(UserApi.Login command, CommandContext<UserDomain.UserState> ctx) {
        return Reply.message(loginUser(command, ctx));
    }
    
    protected UserApi.CurrentUser loginUser(UserApi.Login command, CommandContext<UserDomain.UserState> ctx) {
        return loginUser(command);
    }
    
    protected UserApi.CurrentUser loginUser(UserApi.Login command) {
        throw new CommandNotImplementedException();
    }
    
    @CommandHandler(name = "GetUser")
    public Reply<UserApi.User> getUserWithReply(UserApi.UserId command, CommandContext<UserDomain.UserState> ctx) {
        return Reply.message(getUser(command, ctx));
    }
    
    protected UserApi.User getUser(UserApi.UserId command, CommandContext<UserDomain.UserState> ctx) {
        return getUser(command);
    }
    
    protected UserApi.User getUser(UserApi.UserId command) {
        throw new CommandNotImplementedException();
    }
}