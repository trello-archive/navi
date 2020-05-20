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

package com.trello.navi3;

import android.os.Bundle;
import android.os.PersistableBundle;
import com.trello.navi3.Event.Type;
import com.trello.navi3.internal.NaviEmitter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public final class AllEventTest {

  private final NaviEmitter emitter = NaviEmitter.createActivityEmitter();

  @Mock Listener<Type> listener;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @After
  public void tearDown() {
    verifyNoMoreInteractions(listener);
  }

  // Test event without listener params works
  @Test public void startAllListener() {
    emitter.addListener(Event.ALL, listener);

    emitter.onStart();
    verify(listener).call(Type.START);

    emitter.removeListener(listener);
    emitter.onStart();
  }

  // Test event with listener params works
  @Test public void createAllListener() {
    emitter.addListener(Event.ALL, listener);

    Bundle bundle = new Bundle();
    emitter.onCreate(bundle);
    verify(listener).call(Type.CREATE);

    emitter.removeListener(listener);
    emitter.onCreate(bundle);
  }

  // Test persistable Activities
  @Test public void createPersistableListener() {
    emitter.addListener(Event.ALL, listener);

    Bundle bundle = new Bundle();
    PersistableBundle persistableBundle = mock(PersistableBundle.class);
    emitter.onCreate(bundle);
    emitter.onCreate(bundle, persistableBundle);
    verify(listener).call(Type.CREATE);
    verify(listener).call(Type.CREATE_PERSISTABLE);

    emitter.removeListener(listener);
    emitter.onCreate(bundle, persistableBundle);
  }
}
