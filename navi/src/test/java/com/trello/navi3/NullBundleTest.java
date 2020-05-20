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
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class NullBundleTest {

  @Test public void activityCreatedWithNullBundle() {
    NaviEmitter emitter = NaviEmitter.createFragmentEmitter();
    Listener<Bundle> listener = mock(Listener.class);
    emitter.addListener(Event.ACTIVITY_CREATED, listener);
    emitter.onActivityCreated(null);
    verify(listener).call(any(Bundle.class));
  }

  @Test public void createWithNullBundle() {
    NaviEmitter emitter = NaviEmitter.createActivityEmitter();
    Listener<Bundle> listener = mock(Listener.class);
    emitter.addListener(Event.CREATE, listener);
    emitter.onCreate(null);
    verify(listener).call(any(Bundle.class));
  }

  @Test public void createViewWithNullBundle() {
    NaviEmitter emitter = NaviEmitter.createFragmentEmitter();
    Listener<Bundle> listener = mock(Listener.class);
    emitter.addListener(Event.CREATE_VIEW, listener);
    emitter.onCreateView(null);
    verify(listener).call(any(Bundle.class));
  }

  @Test public void postCreateWithNullBundle() {
    NaviEmitter emitter = NaviEmitter.createActivityEmitter();
    Listener<Bundle> listener = mock(Listener.class);
    emitter.addListener(Event.POST_CREATE, listener);
    emitter.onPostCreate(null);
    verify(listener).call(any(Bundle.class));
  }

  @Test public void restoreInstanceStateWithNullBundle() {
    NaviEmitter emitter = NaviEmitter.createActivityEmitter();
    Listener<Bundle> listener = mock(Listener.class);
    emitter.addListener(Event.RESTORE_INSTANCE_STATE, listener);
    emitter.onRestoreInstanceState(null);
    verify(listener).call(any(Bundle.class));
  }

  @Test public void viewStateRestoredWithNullBundle() {
    NaviEmitter emitter = NaviEmitter.createFragmentEmitter();
    Listener<Bundle> listener = mock(Listener.class);
    emitter.addListener(Event.VIEW_STATE_RESTORED, listener);
    emitter.onViewStateRestored(null);
    verify(listener).call(any(Bundle.class));
  }
}
