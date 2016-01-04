package com.trello.navi;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import com.trello.navi.internal.NaviEmitter;
import com.trello.navi.model.ActivityResult;
import com.trello.navi.model.BundleBundle;
import com.trello.navi.model.RequestPermissionsResult;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public final class NaviActivityTest {

  @Rule public final ExpectedException exception = ExpectedException.none();

  private final NaviEmitter emitter = NaviEmitter.createActivityEmitter();

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

  @Test public void createPersistableListener() {
    Listener<Bundle> listener = mock(Listener.class);
    Listener<BundleBundle> persistableListener = mock(Listener.class);
    emitter.addListener(Event.CREATE, listener);
    emitter.addListener(Event.CREATE_PERSISTABLE, persistableListener);

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    emitter.onCreate(bundle, persistableBundle);
    verify(listener).call(bundle);
    verify(persistableListener).call(new BundleBundle(bundle, persistableBundle));

    emitter.removeListener(Event.CREATE, listener);
    emitter.removeListener(Event.CREATE_PERSISTABLE, persistableListener);
    emitter.onCreate(bundle, persistableBundle);
    verifyNoMoreInteractions(listener);
    verifyNoMoreInteractions(persistableListener);
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

  @Test public void destroyListener() {
    Listener<Void> listener = mock(Listener.class);
    emitter.addListener(Event.DESTROY, listener);

    emitter.onDestroy();
    verify(listener).call(null);

    emitter.removeListener(Event.DESTROY, listener);
    emitter.onDestroy();
    verifyNoMoreInteractions(listener);
  }

  @Test public void restartListener() {
    Listener<Void> listener = mock(Listener.class);
    emitter.addListener(Event.RESTART, listener);

    emitter.onRestart();
    verify(listener).call(null);

    emitter.removeListener(Event.RESTART, listener);
    emitter.onRestart();
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

  @Test public void saveInstanceStatePersistableListener() {
    Listener<Bundle> listener = mock(Listener.class);
    Listener<BundleBundle> persistableListener = mock(Listener.class);
    emitter.addListener(Event.SAVE_INSTANCE_STATE, listener);
    emitter.addListener(Event.SAVE_INSTANCE_STATE_PERSISTABLE, persistableListener);

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    emitter.onSaveInstanceState(bundle, persistableBundle);
    verify(listener).call(bundle);
    verify(persistableListener).call(new BundleBundle(bundle, persistableBundle));

    emitter.removeListener(Event.SAVE_INSTANCE_STATE, listener);
    emitter.removeListener(Event.SAVE_INSTANCE_STATE_PERSISTABLE, persistableListener);
    emitter.onSaveInstanceState(bundle, persistableBundle);
    verifyNoMoreInteractions(listener);
    verifyNoMoreInteractions(persistableListener);
  }

  @Test public void restoreInstanceStateListener() {
    Listener<Bundle> listener = mock(Listener.class);
    emitter.addListener(Event.RESTORE_INSTANCE_STATE, listener);

    Bundle bundle = new Bundle();
    emitter.onRestoreInstanceState(bundle);
    verify(listener).call(bundle);

    emitter.removeListener(Event.RESTORE_INSTANCE_STATE, listener);
    emitter.onRestoreInstanceState(bundle);
    verifyNoMoreInteractions(listener);
  }

  @Test public void restoreInstanceStatePersistableListener() {
    Listener<Bundle> listener = mock(Listener.class);
    Listener<BundleBundle> persistableListener = mock(Listener.class);
    emitter.addListener(Event.RESTORE_INSTANCE_STATE, listener);
    emitter.addListener(Event.RESTORE_INSTANCE_STATE_PERSISTABLE, persistableListener);

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    emitter.onRestoreInstanceState(bundle, persistableBundle);
    verify(listener).call(bundle);
    verify(persistableListener).call(new BundleBundle(bundle, persistableBundle));

    emitter.removeListener(Event.RESTORE_INSTANCE_STATE, listener);
    emitter.removeListener(Event.RESTORE_INSTANCE_STATE_PERSISTABLE, persistableListener);
    emitter.onRestoreInstanceState(bundle, persistableBundle);
    verifyNoMoreInteractions(listener);
    verifyNoMoreInteractions(persistableListener);
  }

  @Test public void newIntentListener() {
    Listener<Intent> listener = mock(Listener.class);
    emitter.addListener(Event.NEW_INTENT, listener);

    Intent intent = new Intent();
    emitter.onNewIntent(intent);
    verify(listener).call(intent);

    emitter.removeListener(Event.NEW_INTENT, listener);
    emitter.onNewIntent(intent);
    verifyNoMoreInteractions(listener);
  }

  @Test public void backPressedListener() {
    Listener<Void> listener = mock(Listener.class);
    emitter.addListener(Event.BACK_PRESSED, listener);

    emitter.onBackPressed();
    verify(listener).call(null);

    emitter.removeListener(Event.BACK_PRESSED, listener);
    emitter.onBackPressed();
    verifyNoMoreInteractions(listener);
  }

  @Test public void attachedToWindowListener() {
    Listener<Void> listener = mock(Listener.class);
    emitter.addListener(Event.ATTACHED_TO_WINDOW, listener);

    emitter.onAttachedToWindow();
    verify(listener).call(null);

    emitter.removeListener(Event.ATTACHED_TO_WINDOW, listener);
    emitter.onAttachedToWindow();
    verifyNoMoreInteractions(listener);
  }

  @Test public void detachedFromWindowListener() {
    Listener<Void> listener = mock(Listener.class);
    emitter.addListener(Event.DETACHED_FROM_WINDOW, listener);

    emitter.onDetachedFromWindow();
    verify(listener).call(null);

    emitter.removeListener(Event.DETACHED_FROM_WINDOW, listener);
    emitter.onDetachedFromWindow();
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

  // The below should not work with activities

  @Test public void attachListener() {
    exception.expect(IllegalArgumentException.class);
    emitter.addListener(Event.ATTACH, mock(Listener.class));
  }

  @Test public void createViewListener() {
    exception.expect(IllegalArgumentException.class);
    emitter.addListener(Event.CREATE_VIEW, mock(Listener.class));
  }

  @Test public void activityCreatedListener() {
    exception.expect(IllegalArgumentException.class);
    emitter.addListener(Event.ACTIVITY_CREATED, mock(Listener.class));
  }

  @Test public void viewStateRestoredListener() {
    exception.expect(IllegalArgumentException.class);
    emitter.addListener(Event.VIEW_STATE_RESTORED, mock(Listener.class));
  }

  @Test public void destroyViewListener() {
    exception.expect(IllegalArgumentException.class);
    emitter.addListener(Event.DESTROY_VIEW, mock(Listener.class));
  }

  @Test public void detachListener() {
    exception.expect(IllegalArgumentException.class);
    emitter.addListener(Event.DETACH, mock(Listener.class));
  }
}
