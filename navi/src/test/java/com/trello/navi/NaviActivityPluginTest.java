package com.trello.navi;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import com.trello.navi.internal.NaviEmitter;
import com.trello.navi.internal.NaviPlugin;
import com.trello.navi.model.ActivityResult;
import com.trello.navi.model.BundleBundle;
import com.trello.navi.model.RequestPermissionsResult;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class NaviActivityPluginTest {

  private final NaviEmitter emitter = NaviEmitter.createActivityEmitter();
  private ActivityNaviPlugin plugin = spy(new ActivityNaviPlugin());

  @Test public void testOnCreate() throws Exception {
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    Bundle bundle = mock(Bundle.class);
    emitter.onCreate(bundle);
    verify(plugin).onEvent(Event.CREATE, bundle);
    verify(plugin).onCreate(bundle);

    emitter.removePlugin(plugin);
    emitter.onCreate(bundle);
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testOnCreatePersistable() throws Exception {
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    Bundle bundle = mock(Bundle.class);
    PersistableBundle persistentState = mock(PersistableBundle.class);
    final BundleBundle bundleBundle = new BundleBundle(bundle, persistentState);
    emitter.onCreate(bundle, persistentState);
    verify(plugin).onEvent(Event.CREATE, bundle);
    verify(plugin).onEvent(Event.CREATE_PERSISTABLE, bundleBundle);
    verify(plugin).onCreate(bundle);
    verify(plugin).onCreate(bundleBundle);

    emitter.removePlugin(plugin);
    emitter.onCreate(bundle, persistentState);
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testOnStart() throws Exception {
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    emitter.onStart();
    verify(plugin).onEvent(Event.START, null);
    verify(plugin).onStart();

    emitter.removePlugin(plugin);
    emitter.onStart();
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testOnResume() throws Exception {
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    emitter.onResume();
    verify(plugin).onEvent(Event.RESUME, null);
    verify(plugin).onResume();

    emitter.removePlugin(plugin);
    emitter.onResume();
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testOnPause() throws Exception {
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    emitter.onPause();
    verify(plugin).onEvent(Event.PAUSE, null);
    verify(plugin).onPause();

    emitter.removePlugin(plugin);
    emitter.onPause();
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testStop() throws Exception {
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    emitter.onStop();
    verify(plugin).onEvent(Event.STOP, null);
    verify(plugin).onStop();

    emitter.removePlugin(plugin);
    emitter.onStop();
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testOnDestroy() throws Exception {
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    emitter.onDestroy();
    verify(plugin).onEvent(Event.DESTROY, null);
    verify(plugin).onDestroy();

    emitter.removePlugin(plugin);
    emitter.onDestroy();
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testOnSaveInstanceState() throws Exception {
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    Bundle bundle = mock(Bundle.class);
    emitter.onSaveInstanceState(bundle);
    verify(plugin).onEvent(Event.SAVE_INSTANCE_STATE, bundle);
    verify(plugin).onSaveInstanceState(bundle);

    emitter.removePlugin(plugin);
    emitter.onSaveInstanceState(bundle);
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testOnSaveInstanceStatePersistable() throws Exception {
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    Bundle bundle = mock(Bundle.class);
    PersistableBundle persistentState = mock(PersistableBundle.class);
    final BundleBundle bundleBundle = new BundleBundle(bundle, persistentState);
    emitter.onSaveInstanceState(bundle, persistentState);
    verify(plugin).onEvent(Event.SAVE_INSTANCE_STATE, bundle);
    verify(plugin).onEvent(Event.SAVE_INSTANCE_STATE_PERSISTABLE, bundleBundle);
    verify(plugin).onSaveInstanceState(bundle);
    verify(plugin).onSaveInstanceState(bundleBundle);

    emitter.removePlugin(plugin);
    emitter.onSaveInstanceState(bundle, persistentState);
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testOnConfigurationChanged() throws Exception {
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    Configuration configuration = mock(Configuration.class);
    emitter.onConfigurationChanged(configuration);
    verify(plugin).onEvent(Event.CONFIGURATION_CHANGED, configuration);
    verify(plugin).onConfigurationChanged(configuration);

    emitter.removePlugin(plugin);
    emitter.onConfigurationChanged(configuration);
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testOnActivityResult() throws Exception {
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    Intent intent = mock(Intent.class);
    final ActivityResult activityResult = new ActivityResult(0, 0, intent);
    emitter.onActivityResult(0, 0, intent);
    verify(plugin).onEvent(Event.ACTIVITY_RESULT, activityResult);
    verify(plugin).onActivityResult(activityResult);

    emitter.removePlugin(plugin);
    emitter.onActivityResult(0, 0, intent);
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testOnRequestPermissionResult() throws Exception {
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    String[] permissions = new String[0];
    int[] grantResults = new int[0];
    final RequestPermissionsResult requestPermissionsResult =
        new RequestPermissionsResult(0, permissions, grantResults);
    emitter.onRequestPermissionsResult(0, permissions, grantResults);
    verify(plugin).onEvent(Event.REQUEST_PERMISSIONS_RESULT, requestPermissionsResult);
    verify(plugin).onRequestPermissionsResult(requestPermissionsResult);

    emitter.removePlugin(plugin);
    emitter.onRequestPermissionsResult(0, permissions, grantResults);
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testOnRestart() throws Exception {
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    emitter.onRestart();
    verify(plugin).onEvent(Event.RESTART, null);
    verify(plugin).onRestart();

    emitter.removePlugin(plugin);
    emitter.onRestart();
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testOnRestoreInstanceState() throws Exception {
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    Bundle bundle = mock(Bundle.class);
    emitter.onRestoreInstanceState(bundle);
    verify(plugin).onEvent(Event.RESTORE_INSTANCE_STATE, bundle);
    verify(plugin).onRestoreInstanceState(bundle);

    emitter.removePlugin(plugin);
    emitter.onRestoreInstanceState(bundle);
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testOnRestoreInstanceStatePersistable() throws Exception {
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    Bundle bundle = mock(Bundle.class);
    PersistableBundle persistentState = mock(PersistableBundle.class);
    final BundleBundle bundleBundle = new BundleBundle(bundle, persistentState);
    emitter.onRestoreInstanceState(bundle, persistentState);
    verify(plugin).onEvent(Event.RESTORE_INSTANCE_STATE, bundle);
    verify(plugin).onEvent(Event.RESTORE_INSTANCE_STATE_PERSISTABLE, bundleBundle);
    verify(plugin).onRestoreInstanceState(bundle);
    verify(plugin).onRestoreInstanceState(bundleBundle);

    emitter.removePlugin(plugin);
    emitter.onRestoreInstanceState(bundle, persistentState);
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testOnNewIntent() throws Exception {
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    Intent intent = mock(Intent.class);
    emitter.onNewIntent(intent);
    verify(plugin).onEvent(Event.NEW_INTENT, intent);
    verify(plugin).onNewIntent(intent);

    emitter.removePlugin(plugin);
    emitter.onNewIntent(intent);
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testOnBackPressed() throws Exception {
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    emitter.onBackPressed();
    verify(plugin).onEvent(Event.BACK_PRESSED, null);
    verify(plugin).onBackPressed();

    emitter.removePlugin(plugin);
    emitter.onBackPressed();
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testOnAttachedToWindow() throws Exception {
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    emitter.onAttachedToWindow();
    verify(plugin).onEvent(Event.ATTACHED_TO_WINDOW, null);
    verify(plugin).onAttachedToWindow();

    emitter.removePlugin(plugin);
    emitter.onAttachedToWindow();
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testOnDetachedToWindow() throws Exception {
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    emitter.onDetachedFromWindow();
    verify(plugin).onEvent(Event.DETACHED_FROM_WINDOW, null);
    verify(plugin).onDetachedFromWindow();

    emitter.removePlugin(plugin);
    emitter.onDetachedFromWindow();
    verifyNoMoreInteractions(plugin);
  }
}
