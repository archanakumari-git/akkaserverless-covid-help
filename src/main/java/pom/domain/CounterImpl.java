package pom.domain;

import com.akkaserverless.javasdk.EntityId;
import com.akkaserverless.javasdk.Reply;
import com.akkaserverless.javasdk.valueentity.*;
import com.google.protobuf.Empty;
import pom.CounterApi;

/** A value entity. */
@ValueEntity(entityType = "counter")
public class CounterImpl extends CounterInterface {
    @SuppressWarnings("unused")
    private final String entityId;
    
    public CounterImpl(@EntityId String entityId) {
        this.entityId = entityId;
    }
    
    @Override
    public Empty increase(CounterApi.IncreaseValue command, CommandContext<CounterDomain.CounterState> ctx) {
        if (command.getValue() < 0) {
            throw ctx.fail("Increase requires a positive value. It was [" + command.getValue() + "].");
        }
        CounterDomain.CounterState state = ctx.getState()
                .orElseGet(() -> CounterDomain.CounterState.newBuilder().build());
        CounterDomain.CounterState newState =
                state.toBuilder().setValue(state.getValue() + command.getValue()).build();
        ctx.updateState(newState);
        return Empty.getDefaultInstance();
    }
    
    @Override
    protected Empty decrease(CounterApi.DecreaseValue command, CommandContext<CounterDomain.CounterState> ctx) {
        throw ctx.fail("The command handler for `Decrease` is not implemented, yet");
    }
    
    @Override
    protected Empty reset(CounterApi.ResetValue command, CommandContext<CounterDomain.CounterState> ctx) {
        throw ctx.fail("The command handler for `Reset` is not implemented, yet");
    }
    
    @Override
    protected CounterApi.CurrentCounter getCurrentCounter(CounterApi.GetCounter command, CommandContext<CounterDomain.CounterState> ctx) {
        CounterApi.CurrentCounter current = ctx.getState()
                .map((state) -> CounterApi.CurrentCounter.newBuilder().setValue(state.getValue()).build())
                .orElseGet(() -> CounterApi.CurrentCounter.newBuilder().setValue(0).build());
        return current;
    }
}