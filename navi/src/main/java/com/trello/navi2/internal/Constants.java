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

package com.trello.navi2.internal;

final class Constants {

  /**
   * Acts as a signal for events that have no data associated with them.
   *
   * We reuse a single Object to avoid any extra allocations.
   */
  static final Object SIGNAL = new Object();

  private Constants() {
    throw new AssertionError("No instances!");
  }
}
