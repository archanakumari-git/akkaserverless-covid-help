package pom;

import com.akkaserverless.javasdk.AkkaServerless;
import com.google.protobuf.EmptyProto;
import pom.domain.CounterDomain;
import pom.domain.CounterImpl;
import pom.domain.UserDomain;
import pom.domain.UserImpl;

public final class MainComponentRegistrations {
    
    public static AkkaServerless withGeneratedComponentsAdded(AkkaServerless akkaServerless) {
        return akkaServerless
                .registerValueEntity(
                    CounterImpl.class,
                    CounterApi.getDescriptor().findServiceByName("CounterService"),
                    CounterDomain.getDescriptor(),
                    EmptyProto.getDescriptor()
                )
                .registerValueEntity(
                    UserImpl.class,
                    UserApi.getDescriptor().findServiceByName("UserService"),
                    UserDomain.getDescriptor(),
                    EmptyProto.getDescriptor()
                );
    }
}