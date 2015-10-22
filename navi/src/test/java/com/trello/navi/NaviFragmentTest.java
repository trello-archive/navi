package com.trello.navi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.trello.navi.internal.BaseNaviFragment;
import com.trello.navi.model.ActivityResult;
import org.junit.Test;

import static com.trello.navi.TestUtils.setSdkInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public final class NaviFragmentTest {

  private final BaseNaviFragment naviFragment = new BaseNaviFragment();

  @Test public void attachActivityListener() {
    setSdkInt(22);

    Listener1<Context> listener = mock(Listener1.class);
    naviFragment.addAttachListener(listener);

    Activity activity = mock(Activity.class);
    naviFragment.onAttach(activity);
    verify(listener).call(activity);

    naviFragment.removeAttachListener(listener);
    naviFragment.onAttach(activity);
    verifyNoMoreInteractions(listener);
  }

  @Test public void attachContextListener() {
    setSdkInt(23);

    Listener1<Context> listener = mock(Listener1.class);
    naviFragment.addAttachListener(listener);

    Context context = mock(Context.class);
    naviFragment.onAttach(context);
    verify(listener).call(context);

    naviFragment.removeAttachListener(listener);
    naviFragment.onAttach(context);
    verifyNoMoreInteractions(listener);
  }

  @Test public void createListener() {
    Listener1<Bundle> listener = mock(Listener1.class);
    naviFragment.addCreateListener(listener);

    Bundle bundle = new Bundle();
    naviFragment.onCreate(bundle);
    verify(listener).call(bundle);

    naviFragment.removeCreateListener(listener);
    naviFragment.onCreate(bundle);
    verifyNoMoreInteractions(listener);
  }

  @Test public void createViewListener() {
    Listener1<Bundle> listener = mock(Listener1.class);
    naviFragment.addCreateViewListener(listener);

    Bundle bundle = new Bundle();
    naviFragment.onCreateView(bundle);
    verify(listener).call(bundle);

    naviFragment.removeCreateViewListener(listener);
    naviFragment.onCreateView(bundle);
    verifyNoMoreInteractions(listener);
  }

  @Test public void activityCreatedListener() {
    Listener1<Bundle> listener = mock(Listener1.class);
    naviFragment.addActivityCreatedListener(listener);

    Bundle bundle = new Bundle();
    naviFragment.onActivityCreated(bundle);
    verify(listener).call(bundle);

    naviFragment.removeActivityCreatedListener(listener);
    naviFragment.onActivityCreated(bundle);
    verifyNoMoreInteractions(listener);
  }

  @Test public void viewStateRestoredListener() {
    Listener1<Bundle> listener = mock(Listener1.class);
    naviFragment.addViewStateRestoredListener(listener);

    Bundle bundle = new Bundle();
    naviFragment.onViewStateRestored(bundle);
    verify(listener).call(bundle);

    naviFragment.removeViewStateRestoredListener(listener);
    naviFragment.onViewStateRestored(bundle);
    verifyNoMoreInteractions(listener);
  }

  @Test public void startListener() {
    Listener0 listener = mock(Listener0.class);
    naviFragment.addStartListener(listener);

    naviFragment.onStart();
    verify(listener).call();

    naviFragment.removeStartListener(listener);
    naviFragment.onStart();
    verifyNoMoreInteractions(listener);
  }

  @Test public void resumeListener() {
    Listener0 listener = mock(Listener0.class);
    naviFragment.addResumeListener(listener);

    naviFragment.onResume();
    verify(listener).call();

    naviFragment.removeResumeListener(listener);
    naviFragment.onResume();
    verifyNoMoreInteractions(listener);
  }

  @Test public void pauseListener() {
    Listener0 listener = mock(Listener0.class);
    naviFragment.addPauseListener(listener);

    naviFragment.onPause();
    verify(listener).call();

    naviFragment.removePauseListener(listener);
    naviFragment.onPause();
    verifyNoMoreInteractions(listener);
  }

  @Test public void stopListener() {
    Listener0 listener = mock(Listener0.class);
    naviFragment.addStopListener(listener);

    naviFragment.onStop();
    verify(listener).call();

    naviFragment.removeStopListener(listener);
    naviFragment.onStop();
    verifyNoMoreInteractions(listener);
  }

  @Test public void destroyViewListener() {
    Listener0 listener = mock(Listener0.class);
    naviFragment.addDestroyViewListener(listener);

    naviFragment.onDestroyView();
    verify(listener).call();

    naviFragment.removeDestroyViewListener(listener);
    naviFragment.onDestroyView();
    verifyNoMoreInteractions(listener);
  }

  @Test public void destroyListener() {
    Listener0 listener = mock(Listener0.class);
    naviFragment.addDestroyListener(listener);

    naviFragment.onDestroy();
    verify(listener).call();

    naviFragment.removeDestroyListener(listener);
    naviFragment.onDestroy();
    verifyNoMoreInteractions(listener);
  }

  @Test public void detachListener() {
    Listener0 listener = mock(Listener0.class);
    naviFragment.addDetachListener(listener);

    naviFragment.onDetach();
    verify(listener).call();

    naviFragment.removeDetachListener(listener);
    naviFragment.onDetach();
    verifyNoMoreInteractions(listener);
  }

  @Test public void saveInstanceStateListener() {
    Listener1<Bundle> listener = mock(Listener1.class);
    naviFragment.addSaveInstanceStateListener(listener);

    Bundle bundle = new Bundle();
    naviFragment.onSaveInstanceState(bundle);
    verify(listener).call(bundle);

    naviFragment.removeSaveInstanceStateListener(listener);
    naviFragment.onSaveInstanceState(bundle);
    verifyNoMoreInteractions(listener);
  }

  @Test public void configurationChangeListener() {
    Listener1<Configuration> listener = mock(Listener1.class);
    naviFragment.addConfigurationChangedListener(listener);

    Configuration configuration = mock(Configuration.class);
    naviFragment.onConfigurationChanged(configuration);
    verify(listener).call(configuration);

    naviFragment.removeConfigurationChangedListener(listener);
    naviFragment.onConfigurationChanged(configuration);
    verifyNoMoreInteractions(listener);
  }

  @Test public void activityResultListener() {
    Listener1<ActivityResult> listener = mock(Listener1.class);
    naviFragment.addActivityResultListener(listener);

    ActivityResult result = new ActivityResult(1, Activity.RESULT_OK, new Intent());
    naviFragment.onActivityResult(result.requestCode(), result.resultCode(), result.data());
    verify(listener).call(result);

    naviFragment.removeActivityResultListener(listener);
    naviFragment.onActivityResult(result.requestCode(), result.resultCode(), result.data());
    verifyNoMoreInteractions(listener);
  }
}
