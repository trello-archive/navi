package com.trello.navi.rx;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.trello.navi.internal.BaseNaviFragment;
import com.trello.navi.model.ActivityResult;
import com.trello.navi.model.RequestPermissionsResult;
import org.junit.Test;
import rx.Subscription;
import rx.observers.TestSubscriber;

import static com.trello.navi.TestUtils.setSdkInt;
import static org.mockito.Mockito.mock;

public final class RxNaviFragmentTest {

  private final BaseNaviFragment naviFragment = new BaseNaviFragment();

  @Test public void attachingActivity() {
    setSdkInt(22);

    TestSubscriber<Context> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviFragment.attaching(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Activity activity = mock(Activity.class);
    naviFragment.onAttach(activity);
    subscription.unsubscribe();
    naviFragment.onAttach(activity);

    testSubscriber.assertValue(activity);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void attachingContext() {
    setSdkInt(23);

    TestSubscriber<Context> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviFragment.attaching(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Context context = mock(Context.class);
    naviFragment.onAttach(context);
    subscription.unsubscribe();
    naviFragment.onAttach(context);

    testSubscriber.assertValue(context);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void creating() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviFragment.creating(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    naviFragment.onCreate(bundle);
    subscription.unsubscribe();
    naviFragment.onCreate(bundle);

    testSubscriber.assertValue(bundle);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void creatingView() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviFragment.creatingView(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    naviFragment.onCreateView(bundle);
    subscription.unsubscribe();
    naviFragment.onCreateView(bundle);

    testSubscriber.assertValue(bundle);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void activityCreated() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNaviFragment.activityCreated(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    naviFragment.onActivityCreated(bundle);
    subscription.unsubscribe();
    naviFragment.onActivityCreated(bundle);

    testSubscriber.assertValue(bundle);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void viewStateRestored() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNaviFragment.viewStateRestored(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    naviFragment.onViewStateRestored(bundle);
    subscription.unsubscribe();
    naviFragment.onViewStateRestored(bundle);

    testSubscriber.assertValue(bundle);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void starting() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviFragment.starting(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    naviFragment.onStart();
    subscription.unsubscribe();
    naviFragment.onStart();

    testSubscriber.assertValueCount(1);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void resuming() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviFragment.resuming(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    naviFragment.onResume();
    subscription.unsubscribe();
    naviFragment.onResume();

    testSubscriber.assertValueCount(1);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void pausing() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviFragment.pausing(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    naviFragment.onPause();
    subscription.unsubscribe();
    naviFragment.onPause();

    testSubscriber.assertValueCount(1);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void stopping() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviFragment.stopping(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    naviFragment.onStop();
    subscription.unsubscribe();
    naviFragment.onStop();

    testSubscriber.assertValueCount(1);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void destroyingView() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNaviFragment.destroyingView(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    naviFragment.onDestroyView();
    subscription.unsubscribe();
    naviFragment.onDestroyView();

    testSubscriber.assertValueCount(1);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void destroying() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviFragment.destroying(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    naviFragment.onDestroy();
    subscription.unsubscribe();
    naviFragment.onDestroy();

    testSubscriber.assertValueCount(1);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void detaching() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviFragment.detaching(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    naviFragment.onDetach();
    subscription.unsubscribe();
    naviFragment.onDetach();

    testSubscriber.assertValueCount(1);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void savingInstanceState() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNaviFragment.savingInstanceState(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    naviFragment.onSaveInstanceState(bundle);
    subscription.unsubscribe();
    naviFragment.onSaveInstanceState(bundle);

    testSubscriber.assertValue(bundle);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void configurationChanging() {
    TestSubscriber<Configuration> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNaviFragment.configurationChanging(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Configuration configuration = mock(Configuration.class);
    naviFragment.onConfigurationChanged(configuration);
    subscription.unsubscribe();
    naviFragment.onConfigurationChanged(configuration);

    testSubscriber.assertValue(configuration);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void activityResults() {
    TestSubscriber<ActivityResult> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNaviFragment.activityResults(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    ActivityResult result = new ActivityResult(1, Activity.RESULT_OK, new Intent());
    naviFragment.onActivityResult(result.requestCode(), result.resultCode(), result.data());
    subscription.unsubscribe();
    naviFragment.onActivityResult(result.requestCode(), result.resultCode(), result.data());

    testSubscriber.assertValue(result);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void requestPermissionsResults() {
    TestSubscriber<RequestPermissionsResult> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNaviFragment.requestPermissionsResults(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    RequestPermissionsResult result = new RequestPermissionsResult(42, new String[0], new int[0]);
    naviFragment.onRequestPermissionsResult(result.requestCode(), result.permissions(),
        result.grantResults());
    subscription.unsubscribe();
    naviFragment.onRequestPermissionsResult(result.requestCode(), result.permissions(),
        result.grantResults());

    testSubscriber.assertValue(result);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }
}
