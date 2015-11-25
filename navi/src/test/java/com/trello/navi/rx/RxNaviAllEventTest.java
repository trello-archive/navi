package com.trello.navi.rx;

import android.os.Bundle;
import android.os.PersistableBundle;
import com.trello.navi.Event;
import com.trello.navi.Event.Type;
import com.trello.navi.internal.BaseNaviComponent;
import org.junit.Test;
import rx.Subscription;
import rx.observers.TestSubscriber;

import static org.mockito.Mockito.mock;

public final class RxNaviAllEventTest {

  private final BaseNaviComponent activity = BaseNaviComponent.createActivityComponent();

  // Test event without listener params works
  @Test public void observeAllStart() {
    TestSubscriber<Type> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(activity, Event.ALL).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    activity.onStart();
    subscription.unsubscribe();
    activity.onStart();

    testSubscriber.assertValue(Type.START);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  // Test event with listener params works
  @Test public void observeAllCreate() {
    TestSubscriber<Type> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(activity, Event.ALL).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    activity.onCreate(bundle);
    subscription.unsubscribe();
    activity.onCreate(bundle);

    testSubscriber.assertValue(Type.CREATE);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  // Test persistable Activities
  @Test public void observeAllCreatePersistable() {
    TestSubscriber<Type> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(activity, Event.ALL).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    activity.onCreate(bundle, persistableBundle);
    subscription.unsubscribe();
    activity.onCreate(bundle, persistableBundle);

    testSubscriber.assertValues(Type.CREATE, Type.CREATE);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }
}
