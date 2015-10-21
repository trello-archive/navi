package com.trello.navi.rx;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import com.trello.navi.internal.BaseNaviActivity;
import com.trello.navi.model.BundleBundle;
import org.junit.Test;
import rx.Subscription;
import rx.observers.TestSubscriber;

import static org.mockito.Mockito.mock;

public final class RxNaviActivityTest {

  private final BaseNaviActivity naviActivity = new BaseNaviActivity();

  @Test public void creating() {
    TestSubscriber<BundleBundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviActivity.creating(naviActivity).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    naviActivity.onCreate(bundle);
    subscription.unsubscribe();
    naviActivity.onCreate(bundle);

    testSubscriber.assertValue(new BundleBundle(bundle));
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void creatingPersistable() {
    TestSubscriber<BundleBundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviActivity.creating(naviActivity).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    naviActivity.onCreate(bundle, persistableBundle);
    subscription.unsubscribe();
    naviActivity.onCreate(bundle, persistableBundle);

    testSubscriber.assertValue(new BundleBundle(bundle, persistableBundle));
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void starting() {
    TestSubscriber<Object> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviActivity.starting(naviActivity).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    naviActivity.onStart();
    subscription.unsubscribe();
    naviActivity.onStart();

    testSubscriber.assertValueCount(1);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void resuming() {
    TestSubscriber<Object> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviActivity.resuming(naviActivity).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    naviActivity.onResume();
    subscription.unsubscribe();
    naviActivity.onResume();

    testSubscriber.assertValueCount(1);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void pausing() {
    TestSubscriber<Object> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviActivity.pausing(naviActivity).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    naviActivity.onPause();
    subscription.unsubscribe();
    naviActivity.onPause();

    testSubscriber.assertValueCount(1);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void stopping() {
    TestSubscriber<Object> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviActivity.stopping(naviActivity).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    naviActivity.onStop();
    subscription.unsubscribe();
    naviActivity.onStop();

    testSubscriber.assertValueCount(1);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void destroying() {
    TestSubscriber<Object> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviActivity.destroying(naviActivity).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    naviActivity.onDestroy();
    subscription.unsubscribe();
    naviActivity.onDestroy();

    testSubscriber.assertValueCount(1);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void restarting() {
    TestSubscriber<Object> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviActivity.restarting(naviActivity).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    naviActivity.onRestart();
    subscription.unsubscribe();
    naviActivity.onRestart();

    testSubscriber.assertValueCount(1);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void savingInstanceState() {
    TestSubscriber<BundleBundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNaviActivity.savingInstanceState(naviActivity).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    naviActivity.onSaveInstanceState(bundle);
    subscription.unsubscribe();
    naviActivity.onSaveInstanceState(bundle);

    testSubscriber.assertValue(new BundleBundle(bundle));
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void savingInstanceStatePersistable() {
    TestSubscriber<BundleBundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNaviActivity.savingInstanceState(naviActivity).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    naviActivity.onSaveInstanceState(bundle, persistableBundle);
    subscription.unsubscribe();
    naviActivity.onSaveInstanceState(bundle, persistableBundle);

    testSubscriber.assertValue(new BundleBundle(bundle, persistableBundle));
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void restoringInstanceState() {
    TestSubscriber<BundleBundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNaviActivity.restoringInstanceState(naviActivity).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    naviActivity.onRestoreInstanceState(bundle);
    subscription.unsubscribe();
    naviActivity.onRestoreInstanceState(bundle);

    testSubscriber.assertValue(new BundleBundle(bundle));
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void restoringInstanceStatePersistable() {
    TestSubscriber<BundleBundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNaviActivity.restoringInstanceState(naviActivity).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    naviActivity.onRestoreInstanceState(bundle, persistableBundle);
    subscription.unsubscribe();
    naviActivity.onRestoreInstanceState(bundle, persistableBundle);

    testSubscriber.assertValue(new BundleBundle(bundle, persistableBundle));
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void newIntent() {
    TestSubscriber<Intent> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviActivity.newIntent(naviActivity).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Intent intent = new Intent();
    naviActivity.onNewIntent(intent);
    subscription.unsubscribe();
    naviActivity.onNewIntent(intent);

    testSubscriber.assertValue(intent);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void backPresses() {
    TestSubscriber<Object> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviActivity.backPresses(naviActivity).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    naviActivity.onBackPressed();
    subscription.unsubscribe();
    naviActivity.onBackPressed();

    testSubscriber.assertValueCount(1);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void windowAttaching() {
    TestSubscriber<Object> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNaviActivity.windowAttaching(naviActivity).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    naviActivity.onAttachedToWindow();
    subscription.unsubscribe();
    naviActivity.onAttachedToWindow();

    testSubscriber.assertValueCount(1);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }
}
