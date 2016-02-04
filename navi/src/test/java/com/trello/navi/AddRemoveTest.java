package com.trello.navi;

import android.os.Bundle;
import com.trello.navi.internal.NaviEmitter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class AddRemoveTest {

  @Rule public final ExpectedException exception = ExpectedException.none();

  @Test public void add() {
    NaviEmitter emitter = NaviEmitter.createActivityEmitter();
    Listener<Void> listener = mock(Listener.class);
    emitter.addListener(Event.START, listener);
    emitter.onStart();
    verify(listener).call(null);
  }

  // Allowed, but idempotent
  @Test public void doubleAdd() {
    NaviEmitter emitter = NaviEmitter.createActivityEmitter();
    Listener<Void> listener = mock(Listener.class);
    emitter.addListener(Event.START, listener);
    emitter.addListener(Event.START, listener);
    emitter.onStart();
    verify(listener).call(null);
  }

  // Not allowed
  @Test public void throwsOnMultiAdd() {
    NaviEmitter emitter = NaviEmitter.createActivityEmitter();
    Listener<Bundle> listener = mock(Listener.class);
    emitter.addListener(Event.CREATE, listener);
    exception.expect(IllegalStateException.class);
    emitter.addListener(Event.SAVE_INSTANCE_STATE, listener);
  }

  @Test public void remove() {
    NaviEmitter emitter = NaviEmitter.createActivityEmitter();
    Listener<Void> listener = mock(Listener.class);
    emitter.addListener(Event.START, listener);
    emitter.removeListener(listener);
    emitter.onStart();
    verifyNoMoreInteractions(listener);
  }

  // Dumb, but allowed
  @Test public void doubleRemove() {
    NaviEmitter emitter = NaviEmitter.createActivityEmitter();
    Listener<Void> listener = mock(Listener.class);
    emitter.addListener(Event.START, listener);
    emitter.removeListener(listener);
    emitter.removeListener(listener);
    emitter.onStart();
    verifyNoMoreInteractions(listener);
  }
}
