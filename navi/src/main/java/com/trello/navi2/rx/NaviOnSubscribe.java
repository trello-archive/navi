package com.trello.navi2.rx;

import android.support.annotation.NonNull;
import com.trello.navi2.Event;
import com.trello.navi2.Listener;
import com.trello.navi2.NaviComponent;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Cancellable;

final class NaviOnSubscribe<T> implements ObservableOnSubscribe<T>{

  private final NaviComponent component;

  private final Event<T> event;

  NaviOnSubscribe(NaviComponent component, Event<T> event) {
    this.component = component;
    this.event = event;
  }

  @Override public void subscribe(final ObservableEmitter<T> emitter) throws Exception {
    EmitterListener listener = new EmitterListener(emitter);
    emitter.setCancellable(listener);
    component.addListener(event, listener);
  }

  class EmitterListener implements Listener<T>, Cancellable {
    private final ObservableEmitter<T> emitter;

    public EmitterListener(ObservableEmitter<T> emitter) {
      this.emitter = emitter;
    }

    @Override public void call(@NonNull T t) {
      emitter.onNext(t);
    }

    @Override public void cancel() throws Exception {
      component.removeListener(this);
    }
  }
}
