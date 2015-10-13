package com.trello.navi.internal;

public final class Constants {

  /**
   * Used when creating a listener list.
   */
  public static final int DEFAULT_LIST_SIZE = 3;

  /**
   * Used for event notifications that have no extra data.
   */
  public static final Object UNIT = new Object();

  private Constants() {
    throw new AssertionError("No instances!");
  }
}
