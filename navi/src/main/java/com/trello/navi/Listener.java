package com.trello.navi;

/**
 * Listener callback.
 *
 * @param <T> the callback type; can be Void in cases where event has no metadata
 */
public interface Listener<T> {
  void call(T t);
}
