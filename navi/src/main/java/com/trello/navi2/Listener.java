package com.trello.navi2;

import android.support.annotation.NonNull;

/**
 * Listener callback.
 *
 * @param <T> the callback type; can be Void in cases where event has no metadata
 */
public interface Listener<T> {
  void call(@NonNull T t);
}
