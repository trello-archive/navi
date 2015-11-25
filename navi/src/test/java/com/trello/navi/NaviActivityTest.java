package com.trello.navi;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import com.trello.navi.internal.BaseNaviComponent;
import com.trello.navi.model.ActivityResult;
import com.trello.navi.model.BundleBundle;
import com.trello.navi.model.RequestPermissionsResult;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public final class NaviActivityTest {

  private final BaseNaviComponent activity = BaseNaviComponent.createActivityComponent();

  @Test public void createListener() {
    Listener<Bundle> listener = mock(Listener.class);
    activity.addListener(Event.CREATE, listener);

    Bundle bundle = new Bundle();
    activity.onCreate(bundle);
    verify(listener).call(bundle);

    activity.removeListener(Event.CREATE, listener);
    activity.onCreate(bundle);
    verifyNoMoreInteractions(listener);
  }

  @Test public void createPersistableListener() {
    Listener<Bundle> listener = mock(Listener.class);
    Listener<BundleBundle> persistableListener = mock(Listener.class);
    activity.addListener(Event.CREATE, listener);
    activity.addListener(Event.CREATE_PERSISTABLE, persistableListener);

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    activity.onCreate(bundle, persistableBundle);
    verify(listener).call(bundle);
    verify(persistableListener).call(new BundleBundle(bundle, persistableBundle));

    activity.removeListener(Event.CREATE, listener);
    activity.removeListener(Event.CREATE_PERSISTABLE, persistableListener);
    activity.onCreate(bundle, persistableBundle);
    verifyNoMoreInteractions(listener);
    verifyNoMoreInteractions(persistableListener);
  }

  @Test public void startListener() {
    Listener<Void> listener = mock(Listener.class);
    activity.addListener(Event.START, listener);

    activity.onStart();
    verify(listener).call(null);

    activity.removeListener(Event.START, listener);
    activity.onStart();
    verifyNoMoreInteractions(listener);
  }

  @Test public void resumeListener() {
    Listener<Void> listener = mock(Listener.class);
    activity.addListener(Event.RESUME, listener);

    activity.onResume();
    verify(listener).call(null);

    activity.removeListener(Event.RESUME, listener);
    activity.onResume();
    verifyNoMoreInteractions(listener);
  }

  @Test public void pauseListener() {
    Listener<Void> listener = mock(Listener.class);
    activity.addListener(Event.PAUSE, listener);

    activity.onPause();
    verify(listener).call(null);

    activity.removeListener(Event.PAUSE, listener);
    activity.onPause();
    verifyNoMoreInteractions(listener);
  }

  @Test public void stopListener() {
    Listener<Void> listener = mock(Listener.class);
    activity.addListener(Event.STOP, listener);

    activity.onStop();
    verify(listener).call(null);

    activity.removeListener(Event.STOP, listener);
    activity.onStop();
    verifyNoMoreInteractions(listener);
  }

  @Test public void destroyListener() {
    Listener<Void> listener = mock(Listener.class);
    activity.addListener(Event.DESTROY, listener);

    activity.onDestroy();
    verify(listener).call(null);

    activity.removeListener(Event.DESTROY, listener);
    activity.onDestroy();
    verifyNoMoreInteractions(listener);
  }

  @Test public void restartListener() {
    Listener<Void> listener = mock(Listener.class);
    activity.addListener(Event.RESTART, listener);

    activity.onRestart();
    verify(listener).call(null);

    activity.removeListener(Event.RESTART, listener);
    activity.onRestart();
    verifyNoMoreInteractions(listener);
  }

  @Test public void saveInstanceStateListener() {
    Listener<Bundle> listener = mock(Listener.class);
    activity.addListener(Event.SAVE_INSTANCE_STATE, listener);

    Bundle bundle = new Bundle();
    activity.onSaveInstanceState(bundle);
    verify(listener).call(bundle);

    activity.removeListener(Event.SAVE_INSTANCE_STATE, listener);
    activity.onSaveInstanceState(bundle);
    verifyNoMoreInteractions(listener);
  }

  @Test public void saveInstanceStatePersistableListener() {
    Listener<Bundle> listener = mock(Listener.class);
    Listener<BundleBundle> persistableListener = mock(Listener.class);
    activity.addListener(Event.SAVE_INSTANCE_STATE, listener);
    activity.addListener(Event.SAVE_INSTANCE_STATE_PERSISTABLE, persistableListener);

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    activity.onSaveInstanceState(bundle, persistableBundle);
    verify(listener).call(bundle);
    verify(persistableListener).call(new BundleBundle(bundle, persistableBundle));

    activity.removeListener(Event.SAVE_INSTANCE_STATE, listener);
    activity.removeListener(Event.SAVE_INSTANCE_STATE_PERSISTABLE, persistableListener);
    activity.onSaveInstanceState(bundle, persistableBundle);
    verifyNoMoreInteractions(listener);
    verifyNoMoreInteractions(persistableListener);
  }

  @Test public void restoreInstanceStateListener() {
    Listener<Bundle> listener = mock(Listener.class);
    activity.addListener(Event.RESTORE_INSTANCE_STATE, listener);

    Bundle bundle = new Bundle();
    activity.onRestoreInstanceState(bundle);
    verify(listener).call(bundle);

    activity.removeListener(Event.RESTORE_INSTANCE_STATE, listener);
    activity.onRestoreInstanceState(bundle);
    verifyNoMoreInteractions(listener);
  }

  @Test public void restoreInstanceStatePersistableListener() {
    Listener<Bundle> listener = mock(Listener.class);
    Listener<BundleBundle> persistableListener = mock(Listener.class);
    activity.addListener(Event.RESTORE_INSTANCE_STATE, listener);
    activity.addListener(Event.RESTORE_INSTANCE_STATE_PERSISTABLE, persistableListener);

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    activity.onRestoreInstanceState(bundle, persistableBundle);
    verify(listener).call(bundle);
    verify(persistableListener).call(new BundleBundle(bundle, persistableBundle));

    activity.removeListener(Event.RESTORE_INSTANCE_STATE, listener);
    activity.removeListener(Event.RESTORE_INSTANCE_STATE_PERSISTABLE, persistableListener);
    activity.onRestoreInstanceState(bundle, persistableBundle);
    verifyNoMoreInteractions(listener);
    verifyNoMoreInteractions(persistableListener);
  }

  @Test public void newIntentListener() {
    Listener<Intent> listener = mock(Listener.class);
    activity.addListener(Event.NEW_INTENT, listener);

    Intent intent = new Intent();
    activity.onNewIntent(intent);
    verify(listener).call(intent);

    activity.removeListener(Event.NEW_INTENT, listener);
    activity.onNewIntent(intent);
    verifyNoMoreInteractions(listener);
  }

  @Test public void backPressedListener() {
    Listener<Void> listener = mock(Listener.class);
    activity.addListener(Event.BACK_PRESSED, listener);

    activity.onBackPressed();
    verify(listener).call(null);

    activity.removeListener(Event.BACK_PRESSED, listener);
    activity.onBackPressed();
    verifyNoMoreInteractions(listener);
  }

  @Test public void attachedToWindowListener() {
    Listener<Void> listener = mock(Listener.class);
    activity.addListener(Event.ATTACHED_TO_WINDOW, listener);

    activity.onAttachedToWindow();
    verify(listener).call(null);

    activity.removeListener(Event.ATTACHED_TO_WINDOW, listener);
    activity.onAttachedToWindow();
    verifyNoMoreInteractions(listener);
  }

  @Test public void detachedFromWindowListener() {
    Listener<Void> listener = mock(Listener.class);
    activity.addListener(Event.DETACHED_FROM_WINDOW, listener);

    activity.onDetachedFromWindow();
    verify(listener).call(null);

    activity.removeListener(Event.DETACHED_FROM_WINDOW, listener);
    activity.onDetachedFromWindow();
    verifyNoMoreInteractions(listener);
  }

  @Test public void configurationChangedListener() {
    Listener<Configuration> listener = mock(Listener.class);
    activity.addListener(Event.CONFIGURATION_CHANGED, listener);

    Configuration configuration = new Configuration();
    activity.onConfigurationChanged(configuration);
    verify(listener).call(configuration);

    activity.removeListener(Event.CONFIGURATION_CHANGED, listener);
    activity.onConfigurationChanged(configuration);
    verifyNoMoreInteractions(listener);
  }

  @Test public void activityResultListener() {
    Listener<ActivityResult> listener = mock(Listener.class);
    activity.addListener(Event.ACTIVITY_RESULT, listener);

    int requestCode = 1;
    int resultCode = Activity.RESULT_OK;
    Intent data = new Intent();
    activity.onActivityResult(requestCode, resultCode, data);
    verify(listener).call(new ActivityResult(requestCode, resultCode, data));

    activity.removeListener(Event.ACTIVITY_RESULT, listener);
    activity.onActivityResult(requestCode, resultCode, data);
    verifyNoMoreInteractions(listener);
  }

  @Test public void requestPermissionsResultListener() {
    Listener<RequestPermissionsResult> listener = mock(Listener.class);
    activity.addListener(Event.REQUEST_PERMISSIONS_RESULT, listener);

    int requestCode = 1;
    String[] permissions = new String[0];
    int[] grantResults = new int[0];
    activity.onRequestPermissionsResult(requestCode, permissions, grantResults);
    verify(listener).call(new RequestPermissionsResult(requestCode, permissions, grantResults));

    activity.removeListener(Event.REQUEST_PERMISSIONS_RESULT, listener);
    activity.onRequestPermissionsResult(requestCode, permissions, grantResults);
    verifyNoMoreInteractions(listener);
  }

  // The below should not work with activities

  @Test(expected = IllegalArgumentException.class) public void attachListener() {
    activity.addListener(Event.ATTACH, mock(Listener.class));
  }

  @Test(expected = IllegalArgumentException.class) public void createViewListener() {
    activity.addListener(Event.CREATE_VIEW, mock(Listener.class));
  }

  @Test(expected = IllegalArgumentException.class) public void activityCreatedListener() {
    activity.addListener(Event.ACTIVITY_CREATED, mock(Listener.class));
  }

  @Test(expected = IllegalArgumentException.class) public void viewStateRestoredListener() {
    activity.addListener(Event.VIEW_STATE_RESTORED, mock(Listener.class));
  }

  @Test(expected = IllegalArgumentException.class) public void destroyViewListener() {
    activity.addListener(Event.DESTROY_VIEW, mock(Listener.class));
  }

  @Test(expected = IllegalArgumentException.class) public void detachListener() {
    activity.addListener(Event.DETACH, mock(Listener.class));
  }
}
