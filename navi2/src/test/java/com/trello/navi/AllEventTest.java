package com.trello.navi;

import android.os.Bundle;
import android.os.PersistableBundle;
import com.trello.navi.Event.Type;
import com.trello.navi.internal.NaviEmitter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public final class AllEventTest {

  private final NaviEmitter emitter = NaviEmitter.createActivityEmitter();

  @Mock Listener<Type> listener;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @After
  public void tearDown() {
    verifyNoMoreInteractions(listener);
  }

  // Test event without listener params works
  @Test public void startAllListener() {
    emitter.addListener(Event.ALL, listener);

    emitter.onStart();
    verify(listener).call(Type.START);

    emitter.removeListener(listener);
    emitter.onStart();
  }

  // Test event with listener params works
  @Test public void createAllListener() {
    emitter.addListener(Event.ALL, listener);

    Bundle bundle = new Bundle();
    emitter.onCreate(bundle);
    verify(listener).call(Type.CREATE);

    emitter.removeListener(listener);
    emitter.onCreate(bundle);
  }

  // Test persistable Activities
  @Test public void createPersistableListener() {
    emitter.addListener(Event.ALL, listener);

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    emitter.onCreate(bundle);
    emitter.onCreate(bundle, persistableBundle);
    verify(listener).call(Type.CREATE);
    verify(listener).call(Type.CREATE_PERSISTABLE);

    emitter.removeListener(listener);
    emitter.onCreate(bundle, persistableBundle);
  }
}
