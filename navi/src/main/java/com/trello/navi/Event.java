package com.trello.navi;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.trello.navi.model.ActivityResult;
import com.trello.navi.model.BundleBundle;
import com.trello.navi.model.RequestPermissionsResult;

/**
 * Represents an event that can be listened to in an Activity or Fragment.
 *
 * Comes with a set of predefined events.
 *
 * @param <T> the callback type for the event
 */
public final class Event<T> {

  public static final Event<Type> ALL = new Event<>(Type.ALL, Type.class);

  public static final Event<Bundle> CREATE = new Event<>(Type.CREATE, Bundle.class);
  public static final Event<BundleBundle> CREATE_PERSISTABLE =
      new Event<>(Type.CREATE, BundleBundle.class);
  public static final Event<Void> START = new Event<>(Type.START, Void.class);
  public static final Event<Void> RESUME = new Event<>(Type.RESUME, Void.class);
  public static final Event<Void> PAUSE = new Event<>(Type.PAUSE, Void.class);
  public static final Event<Void> STOP = new Event<>(Type.STOP, Void.class);
  public static final Event<Void> DESTROY = new Event<>(Type.DESTROY, Void.class);
  public static final Event<BundleBundle> SAVE_INSTANCE_STATE_PERSISTABLE =
      new Event<>(Type.SAVE_INSTANCE_STATE, BundleBundle.class);
  public static final Event<Bundle> SAVE_INSTANCE_STATE =
      new Event<>(Type.SAVE_INSTANCE_STATE, Bundle.class);
  public static final Event<Configuration> CONFIGURATION_CHANGED =
      new Event<>(Type.CONFIGURATION_CHANGED, Configuration.class);
  public static final Event<ActivityResult> ACTIVITY_RESULT =
      new Event<>(Type.ACTIVITY_RESULT, ActivityResult.class);
  public static final Event<RequestPermissionsResult> REQUEST_PERMISSIONS_RESULT =
      new Event<>(Type.REQUEST_PERMISSIONS_RESULT, RequestPermissionsResult.class);

  public static final Event<Void> RESTART = new Event<>(Type.RESTART, Void.class);
  public static final Event<Bundle> RESTORE_INSTANCE_STATE =
      new Event<>(Type.RESTORE_INSTANCE_STATE, Bundle.class);
  public static final Event<BundleBundle> RESTORE_INSTANCE_STATE_PERSISTABLE =
      new Event<>(Type.RESTORE_INSTANCE_STATE, BundleBundle.class);
  public static final Event<Intent> NEW_INTENT = new Event<>(Type.NEW_INTENT, Intent.class);
  public static final Event<Void> BACK_PRESSED = new Event<>(Type.BACK_PRESSED, Void.class);
  public static final Event<Void> ATTACHED_TO_WINDOW =
      new Event<>(Type.ATTACHED_TO_WINDOW, Void.class);
  public static final Event<Void> DETACHED_FROM_WINDOW =
      new Event<>(Type.DETACHED_FROM_WINDOW, Void.class);

  public static final Event<Context> ATTACH = new Event<>(Type.ATTACH, Context.class);
  public static final Event<Bundle> CREATE_VIEW = new Event<>(Type.CREATE_VIEW, Bundle.class);
  public static final Event<Bundle> ACTIVITY_CREATED =
      new Event<>(Type.ACTIVITY_CREATED, Bundle.class);
  public static final Event<Bundle> VIEW_STATE_RESTORED =
      new Event<>(Type.VIEW_STATE_RESTORED, Bundle.class);
  public static final Event<Void> DESTROY_VIEW = new Event<>(Type.DESTROY_VIEW, Void.class);
  public static final Event<Void> DETACH = new Event<>(Type.DETACH, Void.class);

  private final Type eventType;

  private final Class<T> callbackType;

  // This is purposefully hidden so that we can control available events
  private Event(Type eventType, Class<T> callbackType) {
    this.eventType = eventType;
    this.callbackType = callbackType;
  }

  public Type type() {
    return eventType;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Event<?> event = (Event<?>) o;

    if (eventType != event.eventType) return false;
    return callbackType.equals(event.callbackType);
  }

  @Override public int hashCode() {
    int result = eventType.hashCode();
    result = 31 * result + callbackType.hashCode();
    return result;
  }

  @Override public String toString() {
    return "Event{" +
        "eventType=" + eventType +
        ", callbackType=" + callbackType +
        '}';
  }

  public enum Type {
    ALL,

    // Shared
    CREATE,
    START,
    RESUME,
    PAUSE,
    STOP,
    DESTROY,
    SAVE_INSTANCE_STATE,
    CONFIGURATION_CHANGED,
    ACTIVITY_RESULT,
    REQUEST_PERMISSIONS_RESULT,

    // Activity-only
    RESTART,
    RESTORE_INSTANCE_STATE,
    NEW_INTENT,
    BACK_PRESSED,
    ATTACHED_TO_WINDOW,
    DETACHED_FROM_WINDOW,

    // Fragment-only
    ATTACH,
    CREATE_VIEW,
    ACTIVITY_CREATED,
    VIEW_STATE_RESTORED,
    DESTROY_VIEW,
    DETACH
  }
}
