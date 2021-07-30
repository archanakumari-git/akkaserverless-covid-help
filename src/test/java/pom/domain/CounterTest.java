package pom.domain;

import com.akkaserverless.javasdk.valueentity.CommandContext;
import com.google.protobuf.Empty;
import org.junit.Test;
import org.mockito.*;
import org.w3c.dom.css.Counter;
import pom.CounterApi;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CounterTest {
    private String entityId = "entityId1";
    private CounterImpl entity;
    private CommandContext<CounterDomain.CounterState> context = Mockito.mock(CommandContext.class);

    private class MockedContextFailure extends RuntimeException {
    }

    ;

    @Test
    public void increaseTest() {
        entity = new CounterImpl(entityId);
        context = contextWithoutState();

        CounterApi.IncreaseValue message = CounterApi.IncreaseValue.newBuilder().setValue(42).build();
        entity.increase(message, context);

        Mockito.verify(context).updateState(CounterDomain.CounterState.newBuilder().setValue(42).build());
    }

    @Test
    public void decreaseTest() {
        entity = new CounterImpl(entityId);
        context = contextWithState(22);

        CounterApi.DecreaseValue message = CounterApi.DecreaseValue.newBuilder().setValue(10).build();
        entity.decrease(message, context);

        Mockito.verify(context).updateState(CounterDomain.CounterState.newBuilder().setValue(12).build());
    }

    @Test
    public void resetTest() {
        entity = new CounterImpl(entityId);
        CommandContext<CounterDomain.CounterState> context = contextWithState(12);

        assert (context.getState().get().getValue() == 12);
        CounterApi.ResetValue message = CounterApi.ResetValue.newBuilder().build();
        entity.reset(message, context);

        Mockito.verify(context).deleteState();
    }

    @Test
    public void getCurrentCounterTest() {
        entity = new CounterImpl(entityId);

        entity = new CounterImpl(entityId);
        CommandContext<CounterDomain.CounterState> context = contextWithState(12);
        CounterApi.GetCounter message = CounterApi.GetCounter.newBuilder().build();
        CounterApi.CurrentCounter result = entity.getCurrentCounter(message, context);

        CounterApi.CurrentCounter expectedResult = CounterApi.CurrentCounter.newBuilder().setValue(12).build();

        assert(result.getValue() == expectedResult.getValue());
    }

    private CommandContext<CounterDomain.CounterState> contextWithoutState() {
        Mockito.when(context.getState()).thenReturn(Optional.empty());
        return context;
    }

    private CommandContext<CounterDomain.CounterState> contextWithState(int value) {
        CounterDomain.CounterState state =  CounterDomain.CounterState.newBuilder().setValue(value).build();
        Mockito.when(context.getState()).thenReturn(Optional.of(state));
        return context;
    }
}