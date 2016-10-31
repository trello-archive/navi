package com.trello.navi2.rx;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import com.trello.navi2.Event;
import com.trello.navi2.internal.NaviEmitter;
import com.trello.navi2.model.ActivityResult;
import com.trello.navi2.model.BundleBundle;
import com.trello.navi2.model.RequestPermissionsResult;
import org.junit.Test;
import rx.Subscription;
import rx.observers.TestSubscriber;

import static org.mockito.Mockito.mock;

public final class RxNaviActivityTest {

  private final NaviEmitter emitter = NaviEmitter.createActivityEmitter();

  @Test public void observeCreate() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(emitter, Event.CREATE).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onCreate(bundle);
    subscription.unsubscribe();
    emitter.onCreate(bundle);

    testSubscriber.assertValue(bundle);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeCreatePersistable() {
    TestSubscriber<BundleBundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(emitter, Event.CREATE_PERSISTABLE).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    emitter.onCreate(bundle, persistableBundle);
    subscription.unsubscribe();
    emitter.onCreate(bundle, persistableBundle);

    testSubscriber.assertValue(new BundleBundle(bundle, persistableBundle));
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeStart() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(emitter, Event.START).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    emitter.onStart();
    subscription.unsubscribe();
    emitter.onStart();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observePostCreate() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
            RxNavi.observe(emitter, Event.POST_CREATE).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onPostCreate(bundle);
    subscription.unsubscribe();
    emitter.onPostCreate(bundle);

    testSubscriber.assertValue(bundle);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observePostCreatePersistable() {
    TestSubscriber<BundleBundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
            RxNavi.observe(emitter, Event.POST_CREATE_PERSISTABLE).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    emitter.onPostCreate(bundle, persistableBundle);
    subscription.unsubscribe();
    emitter.onPostCreate(bundle, persistableBundle);

    testSubscriber.assertValue(new BundleBundle(bundle, persistableBundle));
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeResume() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(emitter, Event.RESUME).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    emitter.onResume();
    subscription.unsubscribe();
    emitter.onResume();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observePause() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(emitter, Event.PAUSE).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    emitter.onPause();
    subscription.unsubscribe();
    emitter.onPause();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeStop() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(emitter, Event.STOP).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    emitter.onStop();
    subscription.unsubscribe();
    emitter.onStop();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeDestroy() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(emitter, Event.DESTROY).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    emitter.onDestroy();
    subscription.unsubscribe();
    emitter.onDestroy();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeRestart() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(emitter, Event.RESTART).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    emitter.onRestart();
    subscription.unsubscribe();
    emitter.onRestart();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeSaveInstanceState() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(emitter, Event.SAVE_INSTANCE_STATE).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onSaveInstanceState(bundle);
    subscription.unsubscribe();
    emitter.onSaveInstanceState(bundle);

    testSubscriber.assertValue(bundle);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeSaveInstanceStatePersistable() {
    TestSubscriber<BundleBundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(emitter, Event.SAVE_INSTANCE_STATE_PERSISTABLE).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    emitter.onSaveInstanceState(bundle, persistableBundle);
    subscription.unsubscribe();
    emitter.onSaveInstanceState(bundle, persistableBundle);

    testSubscriber.assertValue(new BundleBundle(bundle, persistableBundle));
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeRestoreInstanceState() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(emitter, Event.RESTORE_INSTANCE_STATE).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onRestoreInstanceState(bundle);
    subscription.unsubscribe();
    emitter.onRestoreInstanceState(bundle);

    testSubscriber.assertValue(bundle);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeRestoreInstanceStatePersistable() {
    TestSubscriber<BundleBundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(emitter, Event.RESTORE_INSTANCE_STATE_PERSISTABLE)
        .subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    emitter.onRestoreInstanceState(bundle, persistableBundle);
    subscription.unsubscribe();
    emitter.onRestoreInstanceState(bundle, persistableBundle);

    testSubscriber.assertValue(new BundleBundle(bundle, persistableBundle));
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeNewIntent() {
    TestSubscriber<Intent> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(emitter, Event.NEW_INTENT).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Intent intent = new Intent();
    emitter.onNewIntent(intent);
    subscription.unsubscribe();
    emitter.onNewIntent(intent);

    testSubscriber.assertValue(intent);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeBackPressed() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(emitter, Event.BACK_PRESSED).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    emitter.onBackPressed();
    subscription.unsubscribe();
    emitter.onBackPressed();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeAttachedToWindow() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(emitter, Event.ATTACHED_TO_WINDOW).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    emitter.onAttachedToWindow();
    subscription.unsubscribe();
    emitter.onAttachedToWindow();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeDetachedFromWindow() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(emitter, Event.DETACHED_FROM_WINDOW).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    emitter.onDetachedFromWindow();
    subscription.unsubscribe();
    emitter.onDetachedFromWindow();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeConfigurationChanged() {
    TestSubscriber<Configuration> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(emitter, Event.CONFIGURATION_CHANGED).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Configuration configuration = mock(Configuration.class);
    emitter.onConfigurationChanged(configuration);
    subscription.unsubscribe();
    emitter.onConfigurationChanged(configuration);

    testSubscriber.assertValue(configuration);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeActivityResult() {
    TestSubscriber<ActivityResult> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(emitter, Event.ACTIVITY_RESULT).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    int requestCode = 1;
    int resultCode = Activity.RESULT_OK;
    Intent data = new Intent();
    emitter.onActivityResult(requestCode, resultCode, data);
    subscription.unsubscribe();
    emitter.onActivityResult(requestCode, resultCode, data);

    testSubscriber.assertValue(new ActivityResult(requestCode, resultCode, data));
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeRequestPermissionsResult() {
    TestSubscriber<RequestPermissionsResult> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(emitter, Event.REQUEST_PERMISSIONS_RESULT).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    int requestCode = 1;
    String[] permissions = new String[0];
    int[] grantResults = new int[0];
    emitter.onRequestPermissionsResult(requestCode, permissions, grantResults);
    subscription.unsubscribe();
    emitter.onRequestPermissionsResult(requestCode, permissions, grantResults);

    testSubscriber.assertValue(
        new RequestPermissionsResult(requestCode, permissions, grantResults));
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }
}
