package com.trello.navi.rx;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import com.trello.navi.Event;
import com.trello.navi.internal.BaseNaviComponent;
import com.trello.navi.model.ActivityResult;
import com.trello.navi.model.BundleBundle;
import com.trello.navi.model.RequestPermissionsResult;
import org.junit.Test;
import rx.Subscription;
import rx.observers.TestSubscriber;

import static org.mockito.Mockito.mock;

public final class RxNaviActivityTest {

  private final BaseNaviComponent activity = BaseNaviComponent.createActivityComponent();

  @Test public void observeCreate() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(activity, Event.CREATE).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    activity.onCreate(bundle);
    subscription.unsubscribe();
    activity.onCreate(bundle);

    testSubscriber.assertValue(bundle);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeCreatePersistable() {
    TestSubscriber<BundleBundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(activity, Event.CREATE_PERSISTABLE).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    activity.onCreate(bundle, persistableBundle);
    subscription.unsubscribe();
    activity.onCreate(bundle, persistableBundle);

    testSubscriber.assertValue(new BundleBundle(bundle, persistableBundle));
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeStart() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(activity, Event.START).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    activity.onStart();
    subscription.unsubscribe();
    activity.onStart();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeResume() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(activity, Event.RESUME).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    activity.onResume();
    subscription.unsubscribe();
    activity.onResume();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observePause() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(activity, Event.PAUSE).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    activity.onPause();
    subscription.unsubscribe();
    activity.onPause();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeStop() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(activity, Event.STOP).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    activity.onStop();
    subscription.unsubscribe();
    activity.onStop();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeDestroy() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(activity, Event.DESTROY).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    activity.onDestroy();
    subscription.unsubscribe();
    activity.onDestroy();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeRestart() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(activity, Event.RESTART).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    activity.onRestart();
    subscription.unsubscribe();
    activity.onRestart();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeSaveInstanceState() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(activity, Event.SAVE_INSTANCE_STATE).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    activity.onSaveInstanceState(bundle);
    subscription.unsubscribe();
    activity.onSaveInstanceState(bundle);

    testSubscriber.assertValue(bundle);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeSaveInstanceStatePersistable() {
    TestSubscriber<BundleBundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(activity, Event.SAVE_INSTANCE_STATE_PERSISTABLE).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    activity.onSaveInstanceState(bundle, persistableBundle);
    subscription.unsubscribe();
    activity.onSaveInstanceState(bundle, persistableBundle);

    testSubscriber.assertValue(new BundleBundle(bundle, persistableBundle));
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeRestoreInstanceState() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(activity, Event.RESTORE_INSTANCE_STATE).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    activity.onRestoreInstanceState(bundle);
    subscription.unsubscribe();
    activity.onRestoreInstanceState(bundle);

    testSubscriber.assertValue(bundle);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeRestoreInstanceStatePersistable() {
    TestSubscriber<BundleBundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(activity, Event.RESTORE_INSTANCE_STATE_PERSISTABLE)
        .subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    activity.onRestoreInstanceState(bundle, persistableBundle);
    subscription.unsubscribe();
    activity.onRestoreInstanceState(bundle, persistableBundle);

    testSubscriber.assertValue(new BundleBundle(bundle, persistableBundle));
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeNewIntent() {
    TestSubscriber<Intent> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(activity, Event.NEW_INTENT).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Intent intent = new Intent();
    activity.onNewIntent(intent);
    subscription.unsubscribe();
    activity.onNewIntent(intent);

    testSubscriber.assertValue(intent);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeBackPressed() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(activity, Event.BACK_PRESSED).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    activity.onBackPressed();
    subscription.unsubscribe();
    activity.onBackPressed();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeAttachedToWindow() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(activity, Event.ATTACHED_TO_WINDOW).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    activity.onAttachedToWindow();
    subscription.unsubscribe();
    activity.onAttachedToWindow();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeDetachedFromWindow() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(activity, Event.DETACHED_FROM_WINDOW).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    activity.onDetachedFromWindow();
    subscription.unsubscribe();
    activity.onDetachedFromWindow();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeConfigurationChanged() {
    TestSubscriber<Configuration> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(activity, Event.CONFIGURATION_CHANGED).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Configuration configuration = mock(Configuration.class);
    activity.onConfigurationChanged(configuration);
    subscription.unsubscribe();
    activity.onConfigurationChanged(configuration);

    testSubscriber.assertValue(configuration);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeActivityResult() {
    TestSubscriber<ActivityResult> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(activity, Event.ACTIVITY_RESULT).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    int requestCode = 1;
    int resultCode = Activity.RESULT_OK;
    Intent data = new Intent();
    activity.onActivityResult(requestCode, resultCode, data);
    subscription.unsubscribe();
    activity.onActivityResult(requestCode, resultCode, data);

    testSubscriber.assertValue(new ActivityResult(requestCode, resultCode, data));
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeRequestPermissionsResult() {
    TestSubscriber<RequestPermissionsResult> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(activity, Event.REQUEST_PERMISSIONS_RESULT).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    int requestCode = 1;
    String[] permissions = new String[0];
    int[] grantResults = new int[0];
    activity.onRequestPermissionsResult(requestCode, permissions, grantResults);
    subscription.unsubscribe();
    activity.onRequestPermissionsResult(requestCode, permissions, grantResults);

    testSubscriber.assertValue(
        new RequestPermissionsResult(requestCode, permissions, grantResults));
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }
}
