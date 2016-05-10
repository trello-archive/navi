package com.trello.navi.rx;

import android.os.Bundle;
import android.os.PersistableBundle;
import com.trello.navi.Event;
import com.trello.navi.Event.Type;
import com.trello.navi.internal.NaviEmitter;
import org.junit.Test;
import rx.Subscription;
import rx.observers.TestSubscriber;

import static org.mockito.Mockito.mock;

public final class RxNaviAllEventTest {

  private final NaviEmitter emitter = NaviEmitter.createActivityEmitter();

  // Test event without listener params works
  @Test public void observeAllStart() {
    TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(emitter, Event.ALL).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    emitter.onStart();
    subscription.unsubscribe();
    emitter.onStart();

    testSubscriber.assertValue(Type.START);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  // Test event with listener params works
  @Test public void observeAllCreate() {
    TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(emitter, Event.ALL).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onCreate(bundle);
    subscription.unsubscribe();
    emitter.onCreate(bundle);

    testSubscriber.assertValue(Type.CREATE);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  // Test persistable Activities
  @Test public void observeAllCreatePersistable() {
    TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNavi.observe(emitter, Event.ALL).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    emitter.onCreate(bundle);
    emitter.onCreate(bundle, persistableBundle);
    subscription.unsubscribe();
    emitter.onCreate(bundle);
    emitter.onCreate(bundle, persistableBundle);

    testSubscriber.assertValues(Type.CREATE, Type.CREATE_PERSISTABLE);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }
}
