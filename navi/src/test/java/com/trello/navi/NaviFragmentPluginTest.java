package com.trello.navi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import com.trello.navi.internal.NaviEmitter;
import com.trello.navi.internal.NaviPlugin;
import com.trello.navi.model.ActivityResult;
import com.trello.navi.model.BundleBundle;
import com.trello.navi.model.RequestPermissionsResult;
import org.junit.Test;

import static com.trello.navi.TestUtils.setSdkInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class NaviFragmentPluginTest {

  private final NaviEmitter emitter = NaviEmitter.createFragmentEmitter();
  private FragmentNaviPlugin plugin = spy(new FragmentNaviPlugin());

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

  @Test public void testOnAttachWithContext_PostM() throws Exception {
    setSdkInt(Build.VERSION_CODES.M);
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    Context context = mock(Context.class);
    emitter.onAttach(context);
    verify(plugin).onEvent(Event.ATTACH, context);
    verify(plugin).onAttach(context);

    emitter.removePlugin(plugin);
    emitter.onAttach(context);
    verifyNoMoreInteractions(plugin);
  }
  @Test public void testOnAttachWithContext_PreM() throws Exception {
    setSdkInt(Build.VERSION_CODES.LOLLIPOP);
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    Context context = mock(Context.class);
    emitter.onAttach(context);
    // will not be called. Not supported on pre M
    verify(plugin, times(0)).onEvent(Event.ATTACH, context);
    verify(plugin, times(0)).onAttach(context);

    emitter.removePlugin(plugin);
    emitter.onAttach(context);
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testOnAttachWithActivity_PostM() throws Exception {
    setSdkInt(Build.VERSION_CODES.M);
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    Activity activity = mock(Activity.class);
    emitter.onAttach(activity);
    // will not be called. Not supported on post M
    verify(plugin, times(0)).onEvent(Event.ATTACH, activity);
    verify(plugin, times(0)).onAttach(activity);

    emitter.removePlugin(plugin);
    emitter.onAttach(activity);
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testOnAttachWithActivity_PreM() throws Exception {
    setSdkInt(Build.VERSION_CODES.LOLLIPOP);
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    Activity activity = mock(Activity.class);
    emitter.onAttach(activity);
    verify(plugin).onEvent(Event.ATTACH, activity);
    verify(plugin).onAttach(activity);

    emitter.removePlugin(plugin);
    emitter.onAttach(activity);
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testOnCreateView() throws Exception {
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    Bundle bundle = mock(Bundle.class);
    emitter.onCreateView(bundle);
    verify(plugin).onEvent(Event.CREATE_VIEW, bundle);
    verify(plugin).onCreateView(bundle);

    emitter.removePlugin(plugin);
    emitter.onCreateView(bundle);
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testOnActivityCreated() throws Exception {
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    Bundle bundle = mock(Bundle.class);
    emitter.onActivityCreated(bundle);
    verify(plugin).onEvent(Event.ACTIVITY_CREATED, bundle);
    verify(plugin).onActivityCreated(bundle);

    emitter.removePlugin(plugin);
    emitter.onActivityCreated(bundle);
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testOnViewStateRestored() throws Exception {
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    Bundle bundle = mock(Bundle.class);
    emitter.onViewStateRestored(bundle);
    verify(plugin).onEvent(Event.VIEW_STATE_RESTORED, bundle);
    verify(plugin).onViewStateRestored(bundle);

    emitter.removePlugin(plugin);
    emitter.onViewStateRestored(bundle);
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testOnDestroyView() throws Exception {
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    emitter.onDestroyView();
    verify(plugin).onEvent(Event.DESTROY_VIEW, null);
    verify(plugin).onDestroyView();

    emitter.removePlugin(plugin);
    emitter.onDestroyView();
    verifyNoMoreInteractions(plugin);
  }

  @Test public void testOnDetach() throws Exception {
    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    emitter.onDetach();
    verify(plugin).onEvent(Event.DETACH, null);
    verify(plugin).onDetach();

    emitter.removePlugin(plugin);
    emitter.onDetach();
    verifyNoMoreInteractions(plugin);
  }
}
