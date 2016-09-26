package com.trello.navi.rx;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import com.trello.navi.Event;
import com.trello.navi.internal.NaviEmitter;
import com.trello.navi.model.ActivityResult;
import com.trello.navi.model.BundleBundle;
import com.trello.navi.model.RequestPermissionsResult;
import io.reactivex.observers.TestObserver;
import org.junit.Test;

import static com.trello.navi.rx.RxNavi.observe;
import static org.mockito.Mockito.mock;

public final class RxNaviActivityTest {

  private final NaviEmitter emitter = NaviEmitter.createActivityEmitter();

  @Test public void observeCreate() {
    TestObserver<Bundle> testObserver = RxNavi.observe(emitter, Event.CREATE).test();
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onCreate(bundle);
    testObserver.dispose();
    emitter.onCreate(bundle);

    testObserver.assertValue(bundle);
    testObserver.assertNotTerminated();
  }

  @Test public void observeCreatePersistable() {
    TestObserver<BundleBundle> testObserver =
        observe(emitter, Event.CREATE_PERSISTABLE).test();
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    emitter.onCreate(bundle, persistableBundle);
    testObserver.dispose();
    emitter.onCreate(bundle, persistableBundle);

    testObserver.assertValue(new BundleBundle(bundle, persistableBundle));
    testObserver.assertNotTerminated();
  }

  @Test public void observeStart() {
    TestObserver<Void> testObserver = observe(emitter, Event.START).test();
    testObserver.assertNoValues();

    emitter.onStart();
    testObserver.dispose();
    emitter.onStart();

    testObserver.assertValue(null);
    testObserver.assertNotTerminated();
  }

  @Test public void observePostCreate() {
    TestObserver<Bundle> testObserver =
            observe(emitter, Event.POST_CREATE).test();
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onPostCreate(bundle);
    testObserver.dispose();
    emitter.onPostCreate(bundle);

    testObserver.assertValue(bundle);
    testObserver.assertNotTerminated();
  }

  @Test public void observePostCreatePersistable() {
    TestObserver<BundleBundle> testObserver =
            observe(emitter, Event.POST_CREATE_PERSISTABLE).test();
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    emitter.onPostCreate(bundle, persistableBundle);
    testObserver.dispose();
    emitter.onPostCreate(bundle, persistableBundle);

    testObserver.assertValue(new BundleBundle(bundle, persistableBundle));
    testObserver.assertNotTerminated();
  }

  @Test public void observeResume() {
    TestObserver<Void> testObserver = observe(emitter, Event.RESUME).test();
    testObserver.assertNoValues();

    emitter.onResume();
    testObserver.dispose();
    emitter.onResume();

    testObserver.assertValue(null);
    testObserver.assertNotTerminated();
  }

  @Test public void observePause() {
    TestObserver<Void> testObserver = observe(emitter, Event.PAUSE).test();
    testObserver.assertNoValues();

    emitter.onPause();
    testObserver.dispose();
    emitter.onPause();

    testObserver.assertValue(null);
    testObserver.assertNotTerminated();
  }

  @Test public void observeStop() {
    TestObserver<Void> testObserver = observe(emitter, Event.STOP).test();
    testObserver.assertNoValues();

    emitter.onStop();
    testObserver.dispose();
    emitter.onStop();

    testObserver.assertValue(null);
    testObserver.assertNotTerminated();
  }

  @Test public void observeDestroy() {
    TestObserver<Void> testObserver = observe(emitter, Event.DESTROY).test();
    testObserver.assertNoValues();

    emitter.onDestroy();
    testObserver.dispose();
    emitter.onDestroy();

    testObserver.assertValue(null);
    testObserver.assertNotTerminated();
  }

  @Test public void observeRestart() {
    TestObserver<Void> testObserver = observe(emitter, Event.RESTART).test();
    testObserver.assertNoValues();

    emitter.onRestart();
    testObserver.dispose();
    emitter.onRestart();

    testObserver.assertValue(null);
    testObserver.assertNotTerminated();
  }

  @Test public void observeSaveInstanceState() {
    TestObserver<Bundle> testObserver =
        observe(emitter, Event.SAVE_INSTANCE_STATE).test();
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onSaveInstanceState(bundle);
    testObserver.dispose();
    emitter.onSaveInstanceState(bundle);

    testObserver.assertValue(bundle);
    testObserver.assertNotTerminated();
  }

  @Test public void observeSaveInstanceStatePersistable() {
    TestObserver<BundleBundle> testObserver =
        observe(emitter, Event.SAVE_INSTANCE_STATE_PERSISTABLE).test();
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    emitter.onSaveInstanceState(bundle, persistableBundle);
    testObserver.dispose();
    emitter.onSaveInstanceState(bundle, persistableBundle);

    testObserver.assertValue(new BundleBundle(bundle, persistableBundle));
    testObserver.assertNotTerminated();
  }

  @Test public void observeRestoreInstanceState() {
    TestObserver<Bundle> testObserver =
        observe(emitter, Event.RESTORE_INSTANCE_STATE).test();
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onRestoreInstanceState(bundle);
    testObserver.dispose();
    emitter.onRestoreInstanceState(bundle);

    testObserver.assertValue(bundle);
    testObserver.assertNotTerminated();
  }

  @Test public void observeRestoreInstanceStatePersistable() {
    TestObserver<BundleBundle> testObserver = observe(emitter, Event.RESTORE_INSTANCE_STATE_PERSISTABLE)
        .test();
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    emitter.onRestoreInstanceState(bundle, persistableBundle);
    testObserver.dispose();
    emitter.onRestoreInstanceState(bundle, persistableBundle);

    testObserver.assertValue(new BundleBundle(bundle, persistableBundle));
    testObserver.assertNotTerminated();
  }

  @Test public void observeNewIntent() {
    TestObserver<Intent> testObserver =
        observe(emitter, Event.NEW_INTENT).test();
    testObserver.assertNoValues();

    Intent intent = new Intent();
    emitter.onNewIntent(intent);
    testObserver.dispose();
    emitter.onNewIntent(intent);

    testObserver.assertValue(intent);
    testObserver.assertNotTerminated();
  }

  @Test public void observeBackPressed() {
    TestObserver<Void> testObserver =
        observe(emitter, Event.BACK_PRESSED).test();
    testObserver.assertNoValues();

    emitter.onBackPressed();
    testObserver.dispose();
    emitter.onBackPressed();

    testObserver.assertValue(null);
    testObserver.assertNotTerminated();
  }

  @Test public void observeAttachedToWindow() {
    TestObserver<Void> testObserver =
        observe(emitter, Event.ATTACHED_TO_WINDOW).test();
    testObserver.assertNoValues();

    emitter.onAttachedToWindow();
    testObserver.dispose();
    emitter.onAttachedToWindow();

    testObserver.assertValue(null);
    testObserver.assertNotTerminated();
  }

  @Test public void observeDetachedFromWindow() {
    TestObserver<Void> testObserver =
        observe(emitter, Event.DETACHED_FROM_WINDOW).test();
    testObserver.assertNoValues();

    emitter.onDetachedFromWindow();
    testObserver.dispose();
    emitter.onDetachedFromWindow();

    testObserver.assertValue(null);
    testObserver.assertNotTerminated();
  }

  @Test public void observeConfigurationChanged() {
    TestObserver<Configuration> testObserver =
        observe(emitter, Event.CONFIGURATION_CHANGED).test();
    testObserver.assertNoValues();

    Configuration configuration = mock(Configuration.class);
    emitter.onConfigurationChanged(configuration);
    testObserver.dispose();
    emitter.onConfigurationChanged(configuration);

    testObserver.assertValue(configuration);
    testObserver.assertNotTerminated();
  }

  @Test public void observeActivityResult() {
    TestObserver<ActivityResult> testObserver =
        observe(emitter, Event.ACTIVITY_RESULT).test();
    testObserver.assertNoValues();

    int requestCode = 1;
    int resultCode = Activity.RESULT_OK;
    Intent data = new Intent();
    emitter.onActivityResult(requestCode, resultCode, data);
    testObserver.dispose();
    emitter.onActivityResult(requestCode, resultCode, data);

    testObserver.assertValue(new ActivityResult(requestCode, resultCode, data));
    testObserver.assertNotTerminated();
  }

  @Test public void observeRequestPermissionsResult() {
    TestObserver<RequestPermissionsResult> testObserver =
        observe(emitter, Event.REQUEST_PERMISSIONS_RESULT).test();
    testObserver.assertNoValues();

    int requestCode = 1;
    String[] permissions = new String[0];
    int[] grantResults = new int[0];
    emitter.onRequestPermissionsResult(requestCode, permissions, grantResults);
    testObserver.dispose();
    emitter.onRequestPermissionsResult(requestCode, permissions, grantResults);

    testObserver.assertValue(
        new RequestPermissionsResult(requestCode, permissions, grantResults));
    testObserver.assertNotTerminated();
  }
}
