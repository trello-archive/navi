package com.trello.navi2.rx;

import android.support.annotation.NonNull;
import com.trello.navi2.Event;
import com.trello.navi2.Listener;
import com.trello.navi2.NaviComponent;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

final class NaviOnSubscribe<T> implements ObservableOnSubscribe<T>{

  final NaviComponent component;

  final Event<T> event;

  NaviOnSubscribe(NaviComponent component, Event<T> event) {
    this.component = component;
    this.event = event;
  }

  @Override public void subscribe(final ObservableEmitter<T> emitter) throws Exception {
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
