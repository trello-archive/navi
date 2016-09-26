package com.trello.navi.internal;

import com.trello.navi.Event;
import java.util.Arrays;
import java.util.List;

/**
 * A place to store a common list of handled events by activities and fragments
 */
final class HandledEvents {

  static final List<Event<?>> ACTIVITY_EVENTS =
      Arrays.asList(
          Event.CREATE,
          Event.CREATE_PERSISTABLE,
          Event.START,
          Event.POST_CREATE,
          Event.POST_CREATE_PERSISTABLE,
          Event.RESUME,
          Event.PAUSE,
          Event.STOP,
          Event.DESTROY,
          Event.RESTART,
          Event.SAVE_INSTANCE_STATE,
          Event.SAVE_INSTANCE_STATE_PERSISTABLE,
          Event.RESTORE_INSTANCE_STATE,
          Event.RESTORE_INSTANCE_STATE_PERSISTABLE,
          Event.NEW_INTENT,
          Event.BACK_PRESSED,
          Event.ATTACHED_TO_WINDOW,
          Event.DETACHED_FROM_WINDOW,
          Event.CONFIGURATION_CHANGED,
          Event.ACTIVITY_RESULT,
          Event.REQUEST_PERMISSIONS_RESULT
      );

  static final List<Event<?>> FRAGMENT_EVENTS =
      Arrays.asList(
          Event.ATTACH,
          Event.CREATE,
          Event.CREATE_VIEW,
          Event.VIEW_CREATED,
          Event.ACTIVITY_CREATED,
          Event.VIEW_STATE_RESTORED,
          Event.START,
          Event.RESUME,
          Event.PAUSE,
          Event.STOP,
          Event.DESTROY_VIEW,
          Event.DESTROY,
          Event.DETACH,
          Event.SAVE_INSTANCE_STATE,
          Event.CONFIGURATION_CHANGED,
          Event.ACTIVITY_RESULT,
          Event.REQUEST_PERMISSIONS_RESULT
      );

  private HandledEvents() {
    throw new AssertionError("No instances!");
  }
}
