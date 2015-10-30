package com.trello.navi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.trello.navi.internal.BaseNaviComponent;
import com.trello.navi.model.ActivityResult;
import com.trello.navi.model.RequestPermissionsResult;
import org.junit.Test;

import static com.trello.navi.TestUtils.setSdkInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public final class NaviFragmentTest {

  private final BaseNaviComponent fragment = BaseNaviComponent.createFragmentComponent();

  @Test public void attachListener() {
    setSdkInt(21);

    Listener<Context> listener = mock(Listener.class);
    fragment.addListener(Event.ATTACH, listener);

    Activity activity = mock(Activity.class);
    fragment.onAttach(activity);
    verify(listener).call(activity);

    fragment.removeListener(Event.ATTACH, listener);
    fragment.onAttach(activity);
    verifyNoMoreInteractions(listener);
  }

  @Test public void attachListenerApi23() {
    setSdkInt(23);

    Listener<Context> listener = mock(Listener.class);
    fragment.addListener(Event.ATTACH, listener);

    Context context = mock(Context.class);
    fragment.onAttach(context);
    verify(listener).call(context);

    fragment.removeListener(Event.ATTACH, listener);
    fragment.onAttach(context);
    verifyNoMoreInteractions(listener);
  }

  @Test public void createListener() {
    Listener<Bundle> listener = mock(Listener.class);
    fragment.addListener(Event.CREATE, listener);

    Bundle bundle = new Bundle();
    fragment.onCreate(bundle);
    verify(listener).call(bundle);

    fragment.removeListener(Event.CREATE, listener);
    fragment.onCreate(bundle);
    verifyNoMoreInteractions(listener);
  }

  @Test public void createViewListener() {
    Listener<Bundle> listener = mock(Listener.class);
    fragment.addListener(Event.CREATE_VIEW, listener);

    Bundle bundle = new Bundle();
    fragment.onCreateView(bundle);
    verify(listener).call(bundle);

    fragment.removeListener(Event.CREATE_VIEW, listener);
    fragment.onCreate(bundle);
    verifyNoMoreInteractions(listener);
  }

  @Test public void activityCreatedListener() {
    Listener<Bundle> listener = mock(Listener.class);
    fragment.addListener(Event.ACTIVITY_CREATED, listener);

    Bundle bundle = new Bundle();
    fragment.onActivityCreated(bundle);
    verify(listener).call(bundle);

    fragment.removeListener(Event.ACTIVITY_CREATED, listener);
    fragment.onActivityCreated(bundle);
    verifyNoMoreInteractions(listener);
  }

  @Test public void viewStateRestoredListener() {
    Listener<Bundle> listener = mock(Listener.class);
    fragment.addListener(Event.VIEW_STATE_RESTORED, listener);

    Bundle bundle = new Bundle();
    fragment.onViewStateRestored(bundle);
    verify(listener).call(bundle);

    fragment.removeListener(Event.VIEW_STATE_RESTORED, listener);
    fragment.onViewStateRestored(bundle);
    verifyNoMoreInteractions(listener);
  }

  @Test public void startListener() {
    Listener<Void> listener = mock(Listener.class);
    fragment.addListener(Event.START, listener);

    fragment.onStart();
    verify(listener).call(null);

    fragment.removeListener(Event.START, listener);
    fragment.onStart();
    verifyNoMoreInteractions(listener);
  }

  @Test public void resumeListener() {
    Listener<Void> listener = mock(Listener.class);
    fragment.addListener(Event.RESUME, listener);

    fragment.onResume();
    verify(listener).call(null);

    fragment.removeListener(Event.RESUME, listener);
    fragment.onResume();
    verifyNoMoreInteractions(listener);
  }

  @Test public void pauseListener() {
    Listener<Void> listener = mock(Listener.class);
    fragment.addListener(Event.PAUSE, listener);

    fragment.onPause();
    verify(listener).call(null);

    fragment.removeListener(Event.PAUSE, listener);
    fragment.onPause();
    verifyNoMoreInteractions(listener);
  }

  @Test public void stopListener() {
    Listener<Void> listener = mock(Listener.class);
    fragment.addListener(Event.STOP, listener);

    fragment.onStop();
    verify(listener).call(null);

    fragment.removeListener(Event.STOP, listener);
    fragment.onStop();
    verifyNoMoreInteractions(listener);
  }

  @Test public void destroyViewListener() {
    Listener<Void> listener = mock(Listener.class);
    fragment.addListener(Event.DESTROY_VIEW, listener);

    fragment.onDestroyView();
    verify(listener).call(null);

    fragment.removeListener(Event.DESTROY_VIEW, listener);
    fragment.onDestroyView();
    verifyNoMoreInteractions(listener);

    fragment.addListener(Event.DESTROY_VIEW, mock(Listener.class));
  }

  @Test public void destroyListener() {
    Listener<Void> listener = mock(Listener.class);
    fragment.addListener(Event.DESTROY, listener);

    fragment.onDestroy();
    verify(listener).call(null);

    fragment.removeListener(Event.DESTROY, listener);
    fragment.onDestroy();
    verifyNoMoreInteractions(listener);
  }

  @Test public void detachListener() {
    Listener<Void> listener = mock(Listener.class);
    fragment.addListener(Event.DETACH, listener);

    fragment.onDetach();
    verify(listener).call(null);

    fragment.removeListener(Event.DETACH, listener);
    fragment.onDetach();
    verifyNoMoreInteractions(listener);
  }

  @Test public void saveInstanceStateListener() {
    Listener<Bundle> listener = mock(Listener.class);
    fragment.addListener(Event.SAVE_INSTANCE_STATE, listener);

    Bundle bundle = new Bundle();
    fragment.onSaveInstanceState(bundle);
    verify(listener).call(bundle);

    fragment.removeListener(Event.SAVE_INSTANCE_STATE, listener);
    fragment.onSaveInstanceState(bundle);
    verifyNoMoreInteractions(listener);
  }

  @Test public void configurationChangedListener() {
    Listener<Configuration> listener = mock(Listener.class);
    fragment.addListener(Event.CONFIGURATION_CHANGED, listener);

    Configuration configuration = new Configuration();
    fragment.onConfigurationChanged(configuration);
    verify(listener).call(configuration);

    fragment.removeListener(Event.CONFIGURATION_CHANGED, listener);
    fragment.onConfigurationChanged(configuration);
    verifyNoMoreInteractions(listener);
  }

  @Test public void activityResultListener() {
    Listener<ActivityResult> listener = mock(Listener.class);
    fragment.addListener(Event.ACTIVITY_RESULT, listener);

    int requestCode = 1;
    int resultCode = Activity.RESULT_OK;
    Intent data = new Intent();
    fragment.onActivityResult(requestCode, resultCode, data);
    verify(listener).call(new ActivityResult(requestCode, resultCode, data));

    fragment.removeListener(Event.ACTIVITY_RESULT, listener);
    fragment.onActivityResult(requestCode, resultCode, data);
    verifyNoMoreInteractions(listener);
  }

  @Test public void requestPermissionsResultListener() {
    Listener<RequestPermissionsResult> listener = mock(Listener.class);
    fragment.addListener(Event.REQUEST_PERMISSIONS_RESULT, listener);

    int requestCode = 1;
    String[] permissions = new String[0];
    int[] grantResults = new int[0];
    fragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
    verify(listener).call(new RequestPermissionsResult(requestCode, permissions, grantResults));

    fragment.removeListener(Event.REQUEST_PERMISSIONS_RESULT, listener);
    fragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
    verifyNoMoreInteractions(listener);
  }

  // The below should not work with fragments

  @Test(expected = IllegalArgumentException.class) public void createPersistableListener() {
    fragment.addListener(Event.CREATE_PERSISTABLE, mock(Listener.class));
  }

  @Test(expected = IllegalArgumentException.class) public void restartListener() {
    fragment.addListener(Event.RESTART, mock(Listener.class));
  }

  @Test(expected = IllegalArgumentException.class)
  public void saveInstanceStatePersistableListener() {
    fragment.addListener(Event.SAVE_INSTANCE_STATE_PERSISTABLE, mock(Listener.class));
  }

  @Test(expected = IllegalArgumentException.class) public void restoreInstanceStateListener() {
    fragment.addListener(Event.RESTORE_INSTANCE_STATE, mock(Listener.class));
  }

  @Test(expected = IllegalArgumentException.class)
  public void restoreInstanceStatePersistableListener() {
    fragment.addListener(Event.RESTORE_INSTANCE_STATE_PERSISTABLE, mock(Listener.class));
  }

  @Test(expected = IllegalArgumentException.class) public void newIntentListener() {
    fragment.addListener(Event.NEW_INTENT, mock(Listener.class));
  }

  @Test(expected = IllegalArgumentException.class) public void backPressedListener() {
    fragment.addListener(Event.BACK_PRESSED, mock(Listener.class));
  }

  @Test(expected = IllegalArgumentException.class) public void attachedToWindowListener() {
    fragment.addListener(Event.ATTACHED_TO_WINDOW, mock(Listener.class));
  }

  @Test(expected = IllegalArgumentException.class) public void detachedFromWindowListener() {
    fragment.addListener(Event.DETACHED_FROM_WINDOW, mock(Listener.class));
  }
}
