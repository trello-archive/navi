package com.trello.navi.rx;

import com.trello.navi.Event;
import com.trello.navi.Listener;
import com.trello.navi.NaviComponent;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Cancellable;

final class NaviOnSubscribe<T> implements ObservableOnSubscribe<T> {

  private final NaviComponent component;

  private final Event<T> event;

  NaviOnSubscribe(NaviComponent component, Event<T> event) {
    this.component = component;
    this.event = event;
  }

  @Override public void subscribe(final ObservableEmitter<T> emitter) throws Exception {
    final Listener<T> listener = new Listener<T>() {
      @Override public void call(T t) {
        if (!emitter.isDisposed()) {
          emitter.onNext(t);
        }
      }
    };

    component.addListener(event, listener);

    emitter.setCancellable(new Cancellable() {
      @Override public void cancel() throws Exception {
        component.removeListener(listener);
      }
    });
  }
}
