package com.trello.navi.rx;

import com.trello.navi.Listener1;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

final class OnSubscribe1<T> implements Observable.OnSubscribe<T> {

  private final Implementation<T> implementation;

  OnSubscribe1(Implementation<T> implementation) {
    this.implementation = implementation;
  }

  @Override public void call(final Subscriber<? super T> subscriber) {
    final Listener1<T> listener = new Listener1<T>() {
      @Override public void call(T t) {
        if (!subscriber.isUnsubscribed()) {
          subscriber.onNext(t);
        }
      }
    };

    implementation.subscribe(listener);

    subscriber.add(Subscriptions.create(new Action0() {
      @Override public void call() {
        implementation.unsubscribe(listener);
      }
    }));
  }

  interface Implementation<T> {
    void subscribe(Listener1<T> listener);

    void unsubscribe(Listener1<T> listener);
  }
}
