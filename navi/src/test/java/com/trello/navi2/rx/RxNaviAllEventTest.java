/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
