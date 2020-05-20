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

import com.trello.navi3.internal.NaviEmitter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class EventHandlingTest {

  @Rule public final ExpectedException exception = ExpectedException.none();

  @Test public void handlesEventsNone() {
    NaviComponent component = NaviEmitter.createActivityEmitter();
    assertTrue(component.handlesEvents());
  }

  @Test public void handlesEventsSingle() {
    NaviComponent component = NaviEmitter.createActivityEmitter();
    assertTrue(component.handlesEvents(Event.CREATE));
    assertFalse(component.handlesEvents(Event.CREATE_VIEW));
  }

  @Test public void handlesEventsMultiple() {
    NaviComponent component = NaviEmitter.createActivityEmitter();
    assertTrue(component.handlesEvents(Event.CREATE, Event.START, Event.RESUME));
    assertFalse(component.handlesEvents(Event.ATTACH, Event.CREATE_VIEW));
    assertFalse(component.handlesEvents(Event.CREATE, Event.CREATE_VIEW));
  }

  @Test public void throwOnAddUnsupportedListener() {
    final NaviEmitter emitter = NaviEmitter.createActivityEmitter();
    exception.expect(IllegalArgumentException.class);
    emitter.addListener(Event.DETACH, mock(Listener.class));
  }
}
