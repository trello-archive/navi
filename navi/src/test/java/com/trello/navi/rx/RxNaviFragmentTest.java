package com.trello.navi.rx;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.trello.navi.Event;
import com.trello.navi.internal.BaseNaviComponent;
import com.trello.navi.model.ActivityResult;
import com.trello.navi.model.RequestPermissionsResult;
import org.junit.Test;
import rx.Subscription;
import rx.observers.TestSubscriber;

import static com.trello.navi.TestUtils.setSdkInt;
import static org.mockito.Mockito.mock;

public final class RxNaviFragmentTest {

  private final BaseNaviComponent fragment = BaseNaviComponent.createFragmentComponent();

  @Test public void observeAttach() {
    setSdkInt(21);

    TestSubscriber<Context> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(fragment, Event.ATTACH).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Activity activity = mock(Activity.class);
    fragment.onAttach(activity);
    subscription.unsubscribe();
    fragment.onAttach(activity);

    testSubscriber.assertValue(activity);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeAttachApi23() {
    setSdkInt(23);

    TestSubscriber<Context> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(fragment, Event.ATTACH).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Context context = mock(Context.class);
    fragment.onAttach(context);
    subscription.unsubscribe();
    fragment.onAttach(context);

    testSubscriber.assertValue(context);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }


  @Test public void observeCreate() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(fragment, Event.CREATE).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    fragment.onCreate(bundle);
    subscription.unsubscribe();
    fragment.onCreate(bundle);

    testSubscriber.assertValue(bundle);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeCreateView() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(fragment, Event.CREATE_VIEW).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    fragment.onCreateView(bundle);
    subscription.unsubscribe();
    fragment.onCreateView(bundle);

    testSubscriber.assertValue(bundle);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeActivityCreated() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(fragment, Event.ACTIVITY_CREATED).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    fragment.onActivityCreated(bundle);
    subscription.unsubscribe();
    fragment.onActivityCreated(bundle);

    testSubscriber.assertValue(bundle);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeViewStateRestored() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(fragment, Event.VIEW_STATE_RESTORED).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    fragment.onViewStateRestored(bundle);
    subscription.unsubscribe();
    fragment.onViewStateRestored(bundle);

    testSubscriber.assertValue(bundle);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeStart() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(fragment, Event.START).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    fragment.onStart();
    subscription.unsubscribe();
    fragment.onStart();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeResume() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(fragment, Event.RESUME).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    fragment.onResume();
    subscription.unsubscribe();
    fragment.onResume();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observePause() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(fragment, Event.PAUSE).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    fragment.onPause();
    subscription.unsubscribe();
    fragment.onPause();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeStop() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(fragment, Event.STOP).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    fragment.onStop();
    subscription.unsubscribe();
    fragment.onStop();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeDestroyView() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(fragment, Event.DESTROY_VIEW).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    fragment.onDestroyView();
    subscription.unsubscribe();
    fragment.onDestroyView();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeDestroy() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(fragment, Event.DESTROY).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    fragment.onDestroy();
    subscription.unsubscribe();
    fragment.onDestroy();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeDetach() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(fragment, Event.DETACH).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    fragment.onDetach();
    subscription.unsubscribe();
    fragment.onDetach();

    testSubscriber.assertValue(null);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeSaveInstanceState() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(fragment, Event.SAVE_INSTANCE_STATE).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    fragment.onSaveInstanceState(bundle);
    subscription.unsubscribe();
    fragment.onSaveInstanceState(bundle);

    testSubscriber.assertValue(bundle);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeConfigurationChanged() {
    TestSubscriber<Configuration> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(fragment, Event.CONFIGURATION_CHANGED).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Configuration configuration = mock(Configuration.class);
    fragment.onConfigurationChanged(configuration);
    subscription.unsubscribe();
    fragment.onConfigurationChanged(configuration);

    testSubscriber.assertValue(configuration);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeActivityResult() {
    TestSubscriber<ActivityResult> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(fragment, Event.ACTIVITY_RESULT).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    int requestCode = 1;
    int resultCode = Activity.RESULT_OK;
    Intent data = new Intent();
    fragment.onActivityResult(requestCode, resultCode, data);
    subscription.unsubscribe();
    fragment.onActivityResult(requestCode, resultCode, data);

    testSubscriber.assertValue(new ActivityResult(requestCode, resultCode, data));
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeRequestPermissionsResult() {
    TestSubscriber<RequestPermissionsResult> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(fragment, Event.REQUEST_PERMISSIONS_RESULT).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    int requestCode = 1;
    String[] permissions = new String[0];
    int[] grantResults = new int[0];
    fragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
    subscription.unsubscribe();
    fragment.onRequestPermissionsResult(requestCode, permissions, grantResults);

    testSubscriber.assertValue(
        new RequestPermissionsResult(requestCode, permissions, grantResults));
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }
}
