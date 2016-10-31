package com.trello.navi2.rx;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.trello.navi2.Event;
import com.trello.navi2.internal.NaviEmitter;
import com.trello.navi2.model.ActivityResult;
import com.trello.navi2.model.RequestPermissionsResult;
import org.junit.Test;
import rx.Subscription;
import rx.observers.TestSubscriber;

import static com.trello.navi2.TestUtils.setSdkInt;
import static org.mockito.Mockito.mock;

public final class RxNaviFragmentTest {

  private final NaviEmitter emitter = NaviEmitter.createFragmentEmitter();

  @Test public void observeAttach() {
    setSdkInt(21);

    TestSubscriber<Context> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(emitter, Event.ATTACH).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Activity activity = mock(Activity.class);
    emitter.onAttach(activity);
    subscription.unsubscribe();
    emitter.onAttach(activity);

    testSubscriber.assertValue(activity);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeAttachApi23() {
    setSdkInt(23);

    TestSubscriber<Context> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(emitter, Event.ATTACH).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Context context = mock(Context.class);
    emitter.onAttach(context);
    subscription.unsubscribe();
    emitter.onAttach(context);

    testSubscriber.assertValue(context);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }


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

  @Test public void observeCreateView() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(emitter, Event.CREATE_VIEW).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onCreateView(bundle);
    subscription.unsubscribe();
    emitter.onCreateView(bundle);

    testSubscriber.assertValue(bundle);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeActivityCreated() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(emitter, Event.ACTIVITY_CREATED).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onActivityCreated(bundle);
    subscription.unsubscribe();
    emitter.onActivityCreated(bundle);

    testSubscriber.assertValue(bundle);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void observeViewStateRestored() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNavi.observe(emitter, Event.VIEW_STATE_RESTORED).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onViewStateRestored(bundle);
    subscription.unsubscribe();
    emitter.onViewStateRestored(bundle);

    testSubscriber.assertValue(bundle);
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

  @Test public void observeDestroyView() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(emitter, Event.DESTROY_VIEW).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    emitter.onDestroyView();
    subscription.unsubscribe();
    emitter.onDestroyView();

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

  @Test public void observeDetach() {
    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(emitter, Event.DETACH).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    emitter.onDetach();
    subscription.unsubscribe();
    emitter.onDetach();

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
