package com.trello.navi.rx;

import com.trello.navi.internal.Constants;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

final class UnitOnSubscribe implements Observable.OnSubscribe<Object> {

  private final Implementation implementation;

  UnitOnSubscribe(Implementation implementation) {
    this.implementation = implementation;
  }

  @Override public void call(final Subscriber<? super Object> subscriber) {
    final Action0 listener = new Action0() {
      @Override public void call() {
        if (!subscriber.isUnsubscribed()) {
          subscriber.onNext(Constants.UNIT);
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
    void subscribe(Action0 listener);

    void unsubscribe(Action0 listener);
  }
}
