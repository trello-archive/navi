package com.trello.navi2;

import android.os.Bundle;
import com.trello.navi2.internal.NaviEmitter;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class NullBundleTest {

  @Test public void activityCreatedWithNullBundle() {
    NaviEmitter emitter = NaviEmitter.createFragmentEmitter();
    Listener<Bundle> listener = mock(Listener.class);
    emitter.addListener(Event.ACTIVITY_CREATED, listener);
    emitter.onActivityCreated(null);
    verify(listener).call(any(Bundle.class));
  }

  @Test public void createWithNullBundle() {
    NaviEmitter emitter = NaviEmitter.createActivityEmitter();
    Listener<Bundle> listener = mock(Listener.class);
    emitter.addListener(Event.CREATE, listener);
    emitter.onCreate(null);
    verify(listener).call(any(Bundle.class));
  }

  @Test public void createViewWithNullBundle() {
    NaviEmitter emitter = NaviEmitter.createFragmentEmitter();
    Listener<Bundle> listener = mock(Listener.class);
    emitter.addListener(Event.CREATE_VIEW, listener);
    emitter.onCreateView(null);
    verify(listener).call(any(Bundle.class));
  }

  @Test public void postCreateWithNullBundle() {
    NaviEmitter emitter = NaviEmitter.createActivityEmitter();
    Listener<Bundle> listener = mock(Listener.class);
    emitter.addListener(Event.POST_CREATE, listener);
    emitter.onPostCreate(null);
    verify(listener).call(any(Bundle.class));
  }

  @Test public void restoreInstanceStateWithNullBundle() {
    NaviEmitter emitter = NaviEmitter.createActivityEmitter();
    Listener<Bundle> listener = mock(Listener.class);
    emitter.addListener(Event.RESTORE_INSTANCE_STATE, listener);
    emitter.onRestoreInstanceState(null);
    verify(listener).call(any(Bundle.class));
  }

  @Test public void viewStateRestoredWithNullBundle() {
    NaviEmitter emitter = NaviEmitter.createFragmentEmitter();
    Listener<Bundle> listener = mock(Listener.class);
    emitter.addListener(Event.VIEW_STATE_RESTORED, listener);
    emitter.onViewStateRestored(null);
    verify(listener).call(any(Bundle.class));
  }
}
