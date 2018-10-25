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

package com.trello.navi2;

import androidx.annotation.NonNull;

/**
 * Represents an Android component (Activity, Fragment) that can have listeners.
 */
public interface NaviComponent {

  /**
   * Determines whether this component can handle particular events.
   *
   * For example, Activities do not handle Event.CREATE_VIEW since they do not have that step.
   *
   * @param events the events to check
   * @return true if all events can be handled
   */
  boolean handlesEvents(Event... events);

  /**
   * Adds a listener to this component.
   *
   * @param event an Event
   * @param listener the listener for that event
   * @param <T> the callback type for the event
   * @throws IllegalArgumentException if this component cannot handle the event
   */
  <T> void addListener(@NonNull Event<T> event, @NonNull Listener<T> listener);

  /**
   * Removes a listener from this component.
   *
   * @param <T> the callback type for the event
   * @param listener the listener for that event
   */
  <T> void removeListener(@NonNull Listener<T> listener);
}
