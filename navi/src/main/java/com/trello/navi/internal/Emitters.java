package com.trello.navi.internal;

import android.support.annotation.NonNull;
import com.trello.navi.Listener0;
import com.trello.navi.Listener1;
import java.util.List;

final class Emitters {

  static void emitListener0(@NonNull List<Listener0> listeners) {
    for (int a = 0, size = listeners.size(); a < size; a++) {
      listeners.get(a).call();
    }
  }

  static <T> void emitListener1(@NonNull List<Listener1<T>> listeners, T param1) {
    for (int a = 0, size = listeners.size(); a < size; a++) {
      listeners.get(a).call(param1);
    }
  }

  private Emitters() {
    throw new AssertionError("No instances!");
  }
}
