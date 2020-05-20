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
import com.trello.navi3.internal.NaviEmitter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class AddRemoveTest {

  @Rule public final ExpectedException exception = ExpectedException.none();

  @Test public void add() {
    NaviEmitter emitter = NaviEmitter.createActivityEmitter();
    Listener<Object> listener = mock(Listener.class);
    emitter.addListener(Event.START, listener);
    emitter.onStart();
    verify(listener).call(any());
  }

  // Allowed, but idempotent
  @Test public void doubleAdd() {
    NaviEmitter emitter = NaviEmitter.createActivityEmitter();
    Listener<Object> listener = mock(Listener.class);
    emitter.addListener(Event.START, listener);
    emitter.addListener(Event.START, listener);
    emitter.onStart();
    verify(listener).call(any());
  }

  // Not allowed
  @Test public void throwsOnMultiAdd() {
    NaviEmitter emitter = NaviEmitter.createActivityEmitter();
    Listener<Bundle> listener = mock(Listener.class);
    emitter.addListener(Event.CREATE, listener);
    exception.expect(IllegalStateException.class);
    emitter.addListener(Event.SAVE_INSTANCE_STATE, listener);
  }

  @Test public void remove() {
    NaviEmitter emitter = NaviEmitter.createActivityEmitter();
    Listener<Object> listener = mock(Listener.class);
    emitter.addListener(Event.START, listener);
    emitter.removeListener(listener);
    emitter.onStart();
    verifyNoMoreInteractions(listener);
  }

  // Dumb, but allowed
  @Test public void doubleRemove() {
    NaviEmitter emitter = NaviEmitter.createActivityEmitter();
    Listener<Object> listener = mock(Listener.class);
    emitter.addListener(Event.START, listener);
    emitter.removeListener(listener);
    emitter.removeListener(listener);
    emitter.onStart();
    verifyNoMoreInteractions(listener);
  }
}
