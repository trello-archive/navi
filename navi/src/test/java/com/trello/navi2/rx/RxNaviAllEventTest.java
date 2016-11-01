package com.trello.navi2.rx;

import android.os.Bundle;
import android.os.PersistableBundle;
import com.trello.navi2.Event;
import com.trello.navi2.Event.Type;
import com.trello.navi2.internal.NaviEmitter;
import io.reactivex.observers.TestObserver;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public final class RxNaviAllEventTest {

  private final NaviEmitter emitter = NaviEmitter.createActivityEmitter();

  // Test event without listener params works
  @Test public void observeAllStart() {
    TestObserver<Type> testObserver = RxNavi.observe(emitter, Event.ALL).test();
    testObserver.assertNoValues();

    emitter.onStart();
    testObserver.dispose();
    emitter.onStart();

    testObserver.assertValue(Type.START);
    testObserver.assertNotTerminated();
  }

  // Test event with listener params works
  @Test public void observeAllCreate() {
    TestObserver<Type> testObserver = RxNavi.observe(emitter, Event.ALL).test();
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onCreate(bundle);
    testObserver.dispose();
    emitter.onCreate(bundle);

    testObserver.assertValue(Type.CREATE);
    testObserver.assertNotTerminated();
  }

  // Test persistable Activities
  @Test public void observeAllCreatePersistable() {
    TestObserver<Type> testObserver = RxNavi.observe(emitter, Event.ALL).test();
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    emitter.onCreate(bundle);
    emitter.onCreate(bundle, persistableBundle);
    testObserver.dispose();
    emitter.onCreate(bundle);
    emitter.onCreate(bundle, persistableBundle);

    testObserver.assertValues(Type.CREATE, Type.CREATE_PERSISTABLE);
    testObserver.assertNotTerminated();
  }
}
