package com.trello.navi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.trello.navi.internal.NaviEmitter;
import com.trello.navi.model.ActivityResult;
import com.trello.navi.model.RequestPermissionsResult;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.trello.navi.TestUtils.setSdkInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public final class NaviFragmentTest {

  @Rule public final ExpectedException exception = ExpectedException.none();

  private final NaviEmitter emitter = NaviEmitter.createFragmentEmitter();

  @Test public void attachListener() {
    setSdkInt(21);

    Listener<Context> listener = mock(Listener.class);
    emitter.addListener(Event.ATTACH, listener);

    Activity activity = mock(Activity.class);
    emitter.onAttach(activity);
    verify(listener).call(activity);

    emitter.removeListener(Event.ATTACH, listener);
    emitter.onAttach(activity);
    verifyNoMoreInteractions(listener);
  }

  @Test public void attachListenerApi23() {
    setSdkInt(23);

    Listener<Context> listener = mock(Listener.class);
    emitter.addListener(Event.ATTACH, listener);

    Context context = mock(Context.class);
    emitter.onAttach(context);
    verify(listener).call(context);

    emitter.removeListener(Event.ATTACH, listener);
    emitter.onAttach(context);
    verifyNoMoreInteractions(listener);
  }

  @Test public void createListener() {
    Listener<Bundle> listener = mock(Listener.class);
    emitter.addListener(Event.CREATE, listener);

    Bundle bundle = new Bundle();
    emitter.onCreate(bundle);
    verify(listener).call(bundle);

    emitter.removeListener(Event.CREATE, listener);
    emitter.onCreate(bundle);
    verifyNoMoreInteractions(listener);
  }

  @Test public void createViewListener() {
    Listener<Bundle> listener = mock(Listener.class);
    emitter.addListener(Event.CREATE_VIEW, listener);

    Bundle bundle = new Bundle();
    emitter.onCreateView(bundle);
    verify(listener).call(bundle);

    emitter.removeListener(Event.CREATE_VIEW, listener);
    emitter.onCreate(bundle);
    verifyNoMoreInteractions(listener);
  }

  @Test public void activityCreatedListener() {
    Listener<Bundle> listener = mock(Listener.class);
    emitter.addListener(Event.ACTIVITY_CREATED, listener);

    Bundle bundle = new Bundle();
    emitter.onActivityCreated(bundle);
    verify(listener).call(bundle);

    emitter.removeListener(Event.ACTIVITY_CREATED, listener);
    emitter.onActivityCreated(bundle);
    verifyNoMoreInteractions(listener);
  }

  @Test public void viewStateRestoredListener() {
    Listener<Bundle> listener = mock(Listener.class);
    emitter.addListener(Event.VIEW_STATE_RESTORED, listener);

    Bundle bundle = new Bundle();
    emitter.onViewStateRestored(bundle);
    verify(listener).call(bundle);

    emitter.removeListener(Event.VIEW_STATE_RESTORED, listener);
    emitter.onViewStateRestored(bundle);
    verifyNoMoreInteractions(listener);
  }

  @Test public void startListener() {
    Listener<Void> listener = mock(Listener.class);
    emitter.addListener(Event.START, listener);

    emitter.onStart();
    verify(listener).call(null);

    emitter.removeListener(Event.START, listener);
    emitter.onStart();
    verifyNoMoreInteractions(listener);
  }

  @Test public void resumeListener() {
    Listener<Void> listener = mock(Listener.class);
    emitter.addListener(Event.RESUME, listener);

    emitter.onResume();
    verify(listener).call(null);

    emitter.removeListener(Event.RESUME, listener);
    emitter.onResume();
    verifyNoMoreInteractions(listener);
  }

  @Test public void pauseListener() {
    Listener<Void> listener = mock(Listener.class);
    emitter.addListener(Event.PAUSE, listener);

    emitter.onPause();
    verify(listener).call(null);

    emitter.removeListener(Event.PAUSE, listener);
    emitter.onPause();
    verifyNoMoreInteractions(listener);
  }

  @Test public void stopListener() {
    Listener<Void> listener = mock(Listener.class);
    emitter.addListener(Event.STOP, listener);

    emitter.onStop();
    verify(listener).call(null);

    emitter.removeListener(Event.STOP, listener);
    emitter.onStop();
    verifyNoMoreInteractions(listener);
  }

  @Test public void destroyViewListener() {
    Listener<Void> listener = mock(Listener.class);
    emitter.addListener(Event.DESTROY_VIEW, listener);

    emitter.onDestroyView();
    verify(listener).call(null);

    emitter.removeListener(Event.DESTROY_VIEW, listener);
    emitter.onDestroyView();
    verifyNoMoreInteractions(listener);

    emitter.addListener(Event.DESTROY_VIEW, mock(Listener.class));
  }

  @Test public void destroyListener() {
    Listener<Void> listener = mock(Listener.class);
    emitter.addListener(Event.DESTROY, listener);

    emitter.onDestroy();
    verify(listener).call(null);

    emitter.removeListener(Event.DESTROY, listener);
    emitter.onDestroy();
    verifyNoMoreInteractions(listener);
  }

  @Test public void detachListener() {
    Listener<Void> listener = mock(Listener.class);
    emitter.addListener(Event.DETACH, listener);

    emitter.onDetach();
    verify(listener).call(null);

    emitter.removeListener(Event.DETACH, listener);
    emitter.onDetach();
    verifyNoMoreInteractions(listener);
  }

  @Test public void saveInstanceStateListener() {
    Listener<Bundle> listener = mock(Listener.class);
    emitter.addListener(Event.SAVE_INSTANCE_STATE, listener);

    Bundle bundle = new Bundle();
    emitter.onSaveInstanceState(bundle);
    verify(listener).call(bundle);

    emitter.removeListener(Event.SAVE_INSTANCE_STATE, listener);
    emitter.onSaveInstanceState(bundle);
    verifyNoMoreInteractions(listener);
  }

  @Test public void configurationChangedListener() {
    Listener<Configuration> listener = mock(Listener.class);
    emitter.addListener(Event.CONFIGURATION_CHANGED, listener);

    Configuration configuration = new Configuration();
    emitter.onConfigurationChanged(configuration);
    verify(listener).call(configuration);

    emitter.removeListener(Event.CONFIGURATION_CHANGED, listener);
    emitter.onConfigurationChanged(configuration);
    verifyNoMoreInteractions(listener);
  }

  @Test public void activityResultListener() {
    Listener<ActivityResult> listener = mock(Listener.class);
    emitter.addListener(Event.ACTIVITY_RESULT, listener);

    int requestCode = 1;
    int resultCode = Activity.RESULT_OK;
    Intent data = new Intent();
    emitter.onActivityResult(requestCode, resultCode, data);
    verify(listener).call(new ActivityResult(requestCode, resultCode, data));

    emitter.removeListener(Event.ACTIVITY_RESULT, listener);
    emitter.onActivityResult(requestCode, resultCode, data);
    verifyNoMoreInteractions(listener);
  }

  @Test public void requestPermissionsResultListener() {
    Listener<RequestPermissionsResult> listener = mock(Listener.class);
    emitter.addListener(Event.REQUEST_PERMISSIONS_RESULT, listener);

    int requestCode = 1;
    String[] permissions = new String[0];
    int[] grantResults = new int[0];
    emitter.onRequestPermissionsResult(requestCode, permissions, grantResults);
    verify(listener).call(new RequestPermissionsResult(requestCode, permissions, grantResults));

    emitter.removeListener(Event.REQUEST_PERMISSIONS_RESULT, listener);
    emitter.onRequestPermissionsResult(requestCode, permissions, grantResults);
    verifyNoMoreInteractions(listener);
  }

  // The below should not work with fragments

  @Test public void createPersistableListener() {
    exception.expect(IllegalArgumentException.class);
    emitter.addListener(Event.CREATE_PERSISTABLE, mock(Listener.class));
  }

  @Test public void restartListener() {
    exception.expect(IllegalArgumentException.class);
    emitter.addListener(Event.RESTART, mock(Listener.class));
  }

  @Test
  public void saveInstanceStatePersistableListener() {
    exception.expect(IllegalArgumentException.class);
    emitter.addListener(Event.SAVE_INSTANCE_STATE_PERSISTABLE, mock(Listener.class));
  }

  @Test public void restoreInstanceStateListener() {
    exception.expect(IllegalArgumentException.class);
    emitter.addListener(Event.RESTORE_INSTANCE_STATE, mock(Listener.class));
  }

  @Test
  public void restoreInstanceStatePersistableListener() {
    exception.expect(IllegalArgumentException.class);
    emitter.addListener(Event.RESTORE_INSTANCE_STATE_PERSISTABLE, mock(Listener.class));
  }

  @Test public void newIntentListener() {
    exception.expect(IllegalArgumentException.class);
    emitter.addListener(Event.NEW_INTENT, mock(Listener.class));
  }

  @Test public void backPressedListener() {
    exception.expect(IllegalArgumentException.class);
    emitter.addListener(Event.BACK_PRESSED, mock(Listener.class));
  }

  @Test public void attachedToWindowListener() {
    exception.expect(IllegalArgumentException.class);
    emitter.addListener(Event.ATTACHED_TO_WINDOW, mock(Listener.class));
  }

  @Test public void detachedFromWindowListener() {
    exception.expect(IllegalArgumentException.class);
    emitter.addListener(Event.DETACHED_FROM_WINDOW, mock(Listener.class));
  }
}
