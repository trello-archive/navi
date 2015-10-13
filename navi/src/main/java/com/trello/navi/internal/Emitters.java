package com.trello.navi.internal;

import android.support.annotation.NonNull;
import java.util.List;
import rx.functions.Action0;
import rx.functions.Action1;

final class Emitters {

  static void emitAction0(@NonNull List<Action0> listeners) {
    for (int a = 0, size = listeners.size(); a < size; a++) {
      listeners.get(a).call();
    }
  }

  static <T> void emitAction1(@NonNull List<Action1<T>> listeners, T param1) {
    for (int a = 0, size = listeners.size(); a < size; a++) {
      listeners.get(a).call(param1);
    }
  }

  private Emitters() {
    throw new AssertionError("No instances!");
  }
}
