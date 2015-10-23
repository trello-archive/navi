package com.trello.navi.rx;

import com.trello.navi.Listener0;
import com.trello.navi.internal.Constants;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

final class UnitOnSubscribe implements Observable.OnSubscribe<Void> {

  private final Implementation implementation;

  UnitOnSubscribe(Implementation implementation) {
    this.implementation = implementation;
  }

  @Override public void call(final Subscriber<? super Void> subscriber) {
    final Listener0 listener = new Listener0() {
      @Override public void call() {
        if (!subscriber.isUnsubscribed()) {
          subscriber.onNext(null);
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

  interface Implementation {
    void subscribe(Listener0 listener);

    void unsubscribe(Listener0 listener);
  }
}
