package com.trello.navi;

import android.os.Bundle;
import android.os.PersistableBundle;
import com.trello.navi.Event.Type;
import com.trello.navi.internal.BaseNaviComponent;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public final class AllEventTest {

  private final BaseNaviComponent activity = BaseNaviComponent.createActivityComponent();

  // Test event without listener params works
  @Test public void startAllListener() {
    Listener<Type> listener = mock(Listener.class);
    activity.addListener(Event.ALL, listener);

    activity.onStart();
    verify(listener).call(Type.START);

    activity.removeListener(Event.ALL, listener);
    activity.onStart();
    verifyNoMoreInteractions(listener);
  }

  // Test event with listener params works
  @Test public void createAllListener() {
    Listener<Type> listener = mock(Listener.class);
    activity.addListener(Event.ALL, listener);

    Bundle bundle = new Bundle();
    activity.onCreate(bundle);
    verify(listener).call(Type.CREATE);

    activity.removeListener(Event.ALL, listener);
    activity.onCreate(bundle);
    verifyNoMoreInteractions(listener);
  }

  // Test persistable Activities
  @Test public void createPersistableListener() {
    Listener<Type> listener = mock(Listener.class);
    activity.addListener(Event.ALL, listener);

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    activity.onCreate(bundle, persistableBundle);
    verify(listener, times(2)).call(Type.CREATE);

    activity.removeListener(Event.ALL, listener);
    activity.onCreate(bundle, persistableBundle);
    verifyNoMoreInteractions(listener);
  }
}
