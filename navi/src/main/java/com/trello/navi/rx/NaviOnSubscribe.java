package com.trello.navi.rx;

import com.trello.navi.Event;
import com.trello.navi.Listener;
import com.trello.navi.NaviComponent;
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
      @Override public void call(T t) {
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
