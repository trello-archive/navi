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

package com.trello.navi3.rx;

import com.trello.navi3.Event;
import com.trello.navi3.NaviComponent;

import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import io.reactivex.rxjava3.core.Observable;

public final class RxNavi {

  @CheckResult @NonNull
  public static <T> Observable<T> observe(@NonNull NaviComponent component, @NonNull Event<T> event) {
    if (component == null) throw new IllegalArgumentException("component == null");
    if (event == null) throw new IllegalArgumentException("event == null");
    return Observable.create(new NaviOnSubscribe<>(component, event));
  }

  private RxNavi() {
    throw new AssertionError("No instances!");
  }
}
