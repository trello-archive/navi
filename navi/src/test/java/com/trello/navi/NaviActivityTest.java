package com.trello.navi;

import android.os.Bundle;
import android.os.PersistableBundle;
import com.trello.navi.internal.BaseNaviActivity;
import com.trello.navi.model.BundleBundle;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public final class NaviActivityTest {

  private final BaseNaviActivity naviActivity = new BaseNaviActivity();

  @Test public void createListener() {
    Listener1<BundleBundle> listener = mock(Listener1.class);
    naviActivity.addCreateListener(listener);

    Bundle bundle = new Bundle();
    naviActivity.onCreate(bundle);
    verify(listener).call(new BundleBundle(bundle));

    naviActivity.removeCreateListener(listener);
    naviActivity.onCreate(bundle);
    verifyNoMoreInteractions(listener);
  }

  @Test public void createListenerPersistable() {
    Listener1<BundleBundle> listener = mock(Listener1.class);
    naviActivity.addCreateListener(listener);

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    naviActivity.onCreate(bundle, persistableBundle);
    verify(listener).call(new BundleBundle(bundle, persistableBundle));

    naviActivity.removeCreateListener(listener);
    naviActivity.onCreate(bundle, persistableBundle);
    verifyNoMoreInteractions(listener);
  }

  @Test public void startListener() {
    Listener0 listener = mock(Listener0.class);
    naviActivity.addStartListener(listener);

    naviActivity.onStart();
    verify(listener).call();

    naviActivity.removeStartListener(listener);
    naviActivity.onStart();
    verifyNoMoreInteractions(listener);
  }

  @Test public void resumeListener() {
    Listener0 listener = mock(Listener0.class);
    naviActivity.addResumeListener(listener);

    naviActivity.onResume();
    verify(listener).call();

    naviActivity.removeResumeListener(listener);
    naviActivity.onResume();
    verifyNoMoreInteractions(listener);
  }

  @Test public void pauseListener() {
    Listener0 listener = mock(Listener0.class);
    naviActivity.addPauseListener(listener);

    naviActivity.onPause();
    verify(listener).call();

    naviActivity.removePauseListener(listener);
    naviActivity.onPause();
    verifyNoMoreInteractions(listener);
  }

  @Test public void stopListener() {
    Listener0 listener = mock(Listener0.class);
    naviActivity.addStopListener(listener);

    naviActivity.onStop();
    verify(listener).call();

    naviActivity.removeStopListener(listener);
    naviActivity.onStop();
    verifyNoMoreInteractions(listener);
  }

  @Test public void destroyListener() {
    Listener0 listener = mock(Listener0.class);
    naviActivity.addDestroyListener(listener);

    naviActivity.onDestroy();
    verify(listener).call();

    naviActivity.removeDestroyListener(listener);
    naviActivity.onDestroy();
    verifyNoMoreInteractions(listener);
  }

  @Test public void restartListener() {
    Listener0 listener = mock(Listener0.class);
    naviActivity.addRestartListener(listener);

    naviActivity.onRestart();
    verify(listener).call();

    naviActivity.removeRestartListener(listener);
    naviActivity.onRestart();
    verifyNoMoreInteractions(listener);
  }

  @Test public void saveInstanceStateListener() {
    Listener1<BundleBundle> listener = mock(Listener1.class);
    naviActivity.addSaveInstanceStateListener(listener);

    Bundle bundle = new Bundle();
    naviActivity.onSaveInstanceState(bundle);
    verify(listener).call(new BundleBundle(bundle));

    naviActivity.removeSaveInstanceStateListener(listener);
    naviActivity.onSaveInstanceState(bundle);
    verifyNoMoreInteractions(listener);
  }

  @Test public void saveInstanceStateListenerPersistable() {
    Listener1<BundleBundle> listener = mock(Listener1.class);
    naviActivity.addSaveInstanceStateListener(listener);

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    naviActivity.onSaveInstanceState(bundle, persistableBundle);
    verify(listener).call(new BundleBundle(bundle, persistableBundle));

    naviActivity.removeSaveInstanceStateListener(listener);
    naviActivity.onSaveInstanceState(bundle, persistableBundle);
    verifyNoMoreInteractions(listener);
  }

  @Test public void restoreInstanceStateListener() {
    Listener1<BundleBundle> listener = mock(Listener1.class);
    naviActivity.addRestoreInstanceStateListener(listener);

    Bundle bundle = new Bundle();
    naviActivity.onRestoreInstanceState(bundle);
    verify(listener).call(new BundleBundle(bundle));

    naviActivity.removeRestoreInstanceStateListener(listener);
    naviActivity.onRestoreInstanceState(bundle);
    verifyNoMoreInteractions(listener);
  }

  @Test public void restoreInstanceStateListenerPersistable() {
    Listener1<BundleBundle> listener = mock(Listener1.class);
    naviActivity.addRestoreInstanceStateListener(listener);

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    naviActivity.onRestoreInstanceState(bundle, persistableBundle);
    verify(listener).call(new BundleBundle(bundle, persistableBundle));

    naviActivity.removeRestoreInstanceStateListener(listener);
    naviActivity.onRestoreInstanceState(bundle, persistableBundle);
    verifyNoMoreInteractions(listener);
  }
}
