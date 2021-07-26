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
    public Reply<Empty> registerUserWithReply(UserApi.RegisteredUser command, CommandContext<UserDomain.UserState> ctx) {
        return Reply.message(registerUser(command, ctx));
    }
    
    protected Empty registerUser(UserApi.RegisteredUser command, CommandContext<UserDomain.UserState> ctx) {
        return registerUser(command);
    }
    
    protected Empty registerUser(UserApi.RegisteredUser command) {
        throw new CommandNotImplementedException();
    }
    
    @CommandHandler(name = "UpdateUser")
    public Reply<Empty> updateUserWithReply(UserApi.UpdatedUser command, CommandContext<UserDomain.UserState> ctx) {
        return Reply.message(updateUser(command, ctx));
    }
    
    protected Empty updateUser(UserApi.UpdatedUser command, CommandContext<UserDomain.UserState> ctx) {
        return updateUser(command);
    }
    
    protected Empty updateUser(UserApi.UpdatedUser command) {
        throw new CommandNotImplementedException();
    }
    
    @CommandHandler(name = "DeleteUser")
    public Reply<Empty> deleteUserWithReply(UserApi.DeletedUser command, CommandContext<UserDomain.UserState> ctx) {
        return Reply.message(deleteUser(command, ctx));
    }
    
    protected Empty deleteUser(UserApi.DeletedUser command, CommandContext<UserDomain.UserState> ctx) {
        return deleteUser(command);
    }
    
    protected Empty deleteUser(UserApi.DeletedUser command) {
        throw new CommandNotImplementedException();
    }
    
    @CommandHandler(name = "LoginUser")
    public Reply<UserApi.CurrentUser> loginUserWithReply(UserApi.UserLogin command, CommandContext<UserDomain.UserState> ctx) {
        return Reply.message(loginUser(command, ctx));
    }
    
    protected UserApi.CurrentUser loginUser(UserApi.UserLogin command, CommandContext<UserDomain.UserState> ctx) {
        return loginUser(command);
    }
    
    protected UserApi.CurrentUser loginUser(UserApi.UserLogin command) {
        throw new CommandNotImplementedException();
    }
}