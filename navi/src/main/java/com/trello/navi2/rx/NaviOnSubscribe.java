package com.trello.navi2.rx;

import android.support.annotation.NonNull;
import com.trello.navi2.Event;
import com.trello.navi2.Listener;
import com.trello.navi2.NaviComponent;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

final class NaviOnSubscribe<T> implements Observable.OnSubscribe<T> {

  private final NaviComponent component;

  private final Event<T> event;

  NaviOnSubscribe(NaviComponent component, Event<T> event) {
    this.component = component;
    this.event = event;
  }

  @Override public void call(final Subscriber<? super T> subscriber) {
    final Listener<T> listener = new Listener<T>() {
      @Override public void call(@NonNull T t) {
        if (!subscriber.isUnsubscribed()) {
          subscriber.onNext(t);
        }
      }
    };

    component.addListener(event, listener);

    subscriber.add(Subscriptions.create(new Action0() {
      @Override public void call() {
        component.removeListener(listener);
      }
    }));
  }
}
