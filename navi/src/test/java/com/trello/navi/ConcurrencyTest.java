package com.trello.navi;

import com.trello.navi.internal.BaseNaviComponent;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

public final class ConcurrencyTest {

  private final BaseNaviComponent activity = BaseNaviComponent.createActivityComponent();

  // Verify that we can handle a listener removing itself due to an event occurring
  @Test public void handleInnerRemovals() {
    final Listener<Void> listener1 = spy(new Listener<Void>() {
      @Override public void call(Void __) {
        activity.removeListener(Event.RESUME, this);
      }
    });
    final Listener<Void> listener2 = spy(new Listener<Void>() {
      @Override public void call(Void __) {
        activity.removeListener(Event.RESUME, this);
      }
    });

    activity.addListener(Event.RESUME, listener1);
    activity.addListener(Event.RESUME, listener2);
    activity.onResume();
    verify(listener1).call(null);
    verify(listener2).call(null);
  }

  // Verify that listeners added while emitting an item do not also get the current emission
  // (since they were not registered at the time of the event).
  @Test public void addDuringEmit() {
    final Listener<Void> addedDuringEmit = mock(Listener.class);
    final Listener<Void> listener = spy(new Listener<Void>() {
      @Override public void call(Void __) {
        activity.addListener(Event.RESUME, addedDuringEmit);
      }
    });

    activity.addListener(Event.RESUME, listener);
    activity.onResume();

    verify(listener).call(null);
    verifyZeroInteractions(addedDuringEmit);
  }

  // Verify that listeners removed while emitting an event still receive it (since they were
  // registered at the time of the event).
  @Test public void removeDuringEmit() {
    final Listener<Void> removedDuringEmit = mock(Listener.class);
    final Listener<Void> listener = spy(new Listener<Void>() {
      @Override public void call(Void __) {
        activity.removeListener(Event.RESUME, removedDuringEmit);
      }
    });

    activity.addListener(Event.RESUME, listener);
    activity.addListener(Event.RESUME, removedDuringEmit);
    activity.onResume();

    verify(listener).call(null);
    verify(removedDuringEmit).call(null);
  }
}
