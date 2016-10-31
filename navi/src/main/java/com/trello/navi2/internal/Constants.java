package com.trello.navi2.internal;

final class Constants {

  /**
   * Acts as a signal for events that have no data associated with them.
   *
   * We reuse a single Object to avoid any extra allocations.
   */
  static final Object SIGNAL = new Object();

  private Constants() {
    throw new AssertionError("No instances!");
  }
}
