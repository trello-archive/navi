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
import com.trello.navi3.Listener;
import com.trello.navi3.NaviComponent;

import java.util.concurrent.atomic.AtomicBoolean;

import androidx.annotation.NonNull;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;

final class NaviOnSubscribe<T> implements ObservableOnSubscribe<T>{

  final NaviComponent component;

  final Event<T> event;

  NaviOnSubscribe(NaviComponent component, Event<T> event) {
    this.component = component;
    this.event = event;
  }

  @Override public void subscribe(final ObservableEmitter<T> emitter) {
    EmitterListener listener = new EmitterListener(emitter);
    emitter.setDisposable(listener);
    component.addListener(event, listener);
  }

  class EmitterListener extends AtomicBoolean implements Listener<T>, Disposable {
    final ObservableEmitter<T> emitter;

    public EmitterListener(ObservableEmitter<T> emitter) {
      this.emitter = emitter;
    }

    @Override public void call(@NonNull T t) {
      emitter.onNext(t);
    }

    @Override public void dispose() {
      if (compareAndSet(false, true)) {
        component.removeListener(this);
      }
    }

    @Override public boolean isDisposed() {
      return get();
    }
  }
}
