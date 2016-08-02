package com.trello.navi;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.trello.navi.model.ActivityResult;
import com.trello.navi.model.BundleBundle;
import com.trello.navi.model.RequestPermissionsResult;
import com.trello.navi.model.ViewCreated;

/**
 * Represents an event that can be listened to in an Activity or Fragment.
 *
 * Comes with a set of predefined events.
 *
 * Events will vary in their timing in relation to the normally-required super() call. Generally,
 * component creation ({@code onCreate()}, {@code onStart()}, etc.) is emitted *after*
 * their super calls are made. Component destruction ({@code onPause()}, {@code onStop()}, etc.)
 * are called *before* their super calls are made. Events that are neither are called *after*
 * their super calls.
 *
 * @param <T> the callback type for the event
 */
public final class Event<T> {

  /**
   * Emits all events (though without any extra data).
   */
  public static final Event<Type> ALL = new Event<>(Type.ALL, Type.class);

  /**
   * Emits {@link Activity#onCreate(Bundle)} and {@link Fragment#onCreate(Bundle)}. Emitted after
   * super().
   */
  public static final Event<Bundle> CREATE = new Event<>(Type.CREATE, Bundle.class);

  /**
   * Emits {@link Activity#onCreate(Bundle, PersistableBundle)}. Emitted after super().
   */
  public static final Event<BundleBundle> CREATE_PERSISTABLE =
      new Event<>(Type.CREATE_PERSISTABLE, BundleBundle.class);

    /**
     * Emits {@link Activity#onPostCreate(Bundle)}. Emitted after super().
     */
    public static final Event<Bundle> POST_CREATE = new Event<>(Type.POST_CREATE, Bundle.class);

  /**
   * Emits {@link Activity#onStart()} and {@link Fragment#onStart()}. Emitted after super().
   */
  public static final Event<Void> START = new Event<>(Type.START, Void.class);

  /**
   * Emits {@link Activity#onResume()} and {@link Fragment#onResume()}. Emitted after super().
   */
  public static final Event<Void> RESUME = new Event<>(Type.RESUME, Void.class);

  /**
   * Emits {@link Activity#onPause()} and {@link Fragment#onPause()}. Emitted before super().
   */
  public static final Event<Void> PAUSE = new Event<>(Type.PAUSE, Void.class);

  /**
   * Emits {@link Activity#onStop()} and {@link Fragment#onStop()}. Emitted before super().
   */
  public static final Event<Void> STOP = new Event<>(Type.STOP, Void.class);

  /**
   * Emits {@link Activity#onDestroy()} and {@link Fragment#onDestroy()}. Emitted before super().
   */
  public static final Event<Void> DESTROY = new Event<>(Type.DESTROY, Void.class);

  /**
   * Emits {@link Activity#onSaveInstanceState(Bundle)} and
   * {@link Fragment#onSaveInstanceState(Bundle)}. Emitted after super().
   */
  public static final Event<Bundle> SAVE_INSTANCE_STATE =
      new Event<>(Type.SAVE_INSTANCE_STATE, Bundle.class);

  /**
   * Emits {@link Activity#onSaveInstanceState(Bundle, PersistableBundle)}. Emitted after super().
   */
  public static final Event<BundleBundle> SAVE_INSTANCE_STATE_PERSISTABLE =
      new Event<>(Type.SAVE_INSTANCE_STATE_PERSISTABLE, BundleBundle.class);

  /**
   * Emits {@link Activity#onConfigurationChanged(Configuration)} and
   * {@link Fragment#onConfigurationChanged(Configuration)}. Emitted after super().
   */
  public static final Event<Configuration> CONFIGURATION_CHANGED =
      new Event<>(Type.CONFIGURATION_CHANGED, Configuration.class);

  /**
   * Emits {@link Activity#onActivityResult(int, int, Intent)} and
   * {@link Fragment#onActivityResult(int, int, Intent)}. Emitted after super().
   */
  public static final Event<ActivityResult> ACTIVITY_RESULT =
      new Event<>(Type.ACTIVITY_RESULT, ActivityResult.class);

  /**
   * Emits {@link Activity#onRequestPermissionsResult(int, String[], int[])} and
   * {@link Fragment#onRequestPermissionsResult(int, String[], int[])}. Emitted after super().
   */
  public static final Event<RequestPermissionsResult> REQUEST_PERMISSIONS_RESULT =
      new Event<>(Type.REQUEST_PERMISSIONS_RESULT, RequestPermissionsResult.class);

  /**
   * Emits {@link Activity#onRestart()}. Emitted after super().
   */
  public static final Event<Void> RESTART = new Event<>(Type.RESTART, Void.class);

  /**
   * Emits {@link Activity#onRestoreInstanceState(Bundle)}. Emitted after super().
   */
  public static final Event<Bundle> RESTORE_INSTANCE_STATE =
      new Event<>(Type.RESTORE_INSTANCE_STATE, Bundle.class);

  /**
   * Emits {@link Activity#onRestoreInstanceState(Bundle, PersistableBundle)}. Emitted after
   * super().
   */
  public static final Event<BundleBundle> RESTORE_INSTANCE_STATE_PERSISTABLE =
      new Event<>(Type.RESTORE_INSTANCE_STATE_PERSISTABLE, BundleBundle.class);

  /**
   * Emits {@link Activity#onNewIntent(Intent)}. Emitted after super().
   */
  public static final Event<Intent> NEW_INTENT = new Event<>(Type.NEW_INTENT, Intent.class);

  /**
   * Emits {@link Activity#onBackPressed()}. Emitted after super().
   */
  public static final Event<Void> BACK_PRESSED = new Event<>(Type.BACK_PRESSED, Void.class);

  /**
   * Emits {@link Activity#onAttachedToWindow()}. Emitted after super().
   */
  public static final Event<Void> ATTACHED_TO_WINDOW =
      new Event<>(Type.ATTACHED_TO_WINDOW, Void.class);

  /**
   * Emits {@link Activity#onDetachedFromWindow()}. Emitted after super().
   */
  public static final Event<Void> DETACHED_FROM_WINDOW =
      new Event<>(Type.DETACHED_FROM_WINDOW, Void.class);

  /**
   * Emits {@link Fragment#onAttach(Context)}. Emitted after super().
   */
  public static final Event<Context> ATTACH = new Event<>(Type.ATTACH, Context.class);

  /**
   * Emits {@link Fragment#onCreateView(LayoutInflater, ViewGroup, Bundle)}. Emitted after super().
   */
  public static final Event<Bundle> CREATE_VIEW = new Event<>(Type.CREATE_VIEW, Bundle.class);

  /**
   * Emits {@link Fragment#onViewCreated(View, Bundle)} ()}. Emitted before super().
   */
  public static final Event<ViewCreated> VIEW_CREATED = new Event<>(Type.VIEW_CREATED, ViewCreated.class);

  /**
   * Emits {@link Fragment#onActivityCreated(Bundle)}. Emitted after super().
   */
  public static final Event<Bundle> ACTIVITY_CREATED =
      new Event<>(Type.ACTIVITY_CREATED, Bundle.class);

  /**
   * Emits {@link Fragment#onViewStateRestored(Bundle)}. Emitted after super().
   */
  public static final Event<Bundle> VIEW_STATE_RESTORED =
      new Event<>(Type.VIEW_STATE_RESTORED, Bundle.class);

  /**
   * Emits {@link Fragment#onDestroyView()}. Emitted before super().
   */
  public static final Event<Void> DESTROY_VIEW = new Event<>(Type.DESTROY_VIEW, Void.class);

  /**
   * Emits {@link Fragment#onDetach()}. Emitted before super().
   */
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
    CREATE_PERSISTABLE,
    POST_CREATE,
    RESTART,
    SAVE_INSTANCE_STATE_PERSISTABLE,
    RESTORE_INSTANCE_STATE,
    RESTORE_INSTANCE_STATE_PERSISTABLE,
    NEW_INTENT,
    BACK_PRESSED,
    ATTACHED_TO_WINDOW,
    DETACHED_FROM_WINDOW,

    // Fragment-only
    ATTACH,
    CREATE_VIEW,
    VIEW_CREATED,
    ACTIVITY_CREATED,
    VIEW_STATE_RESTORED,
    DESTROY_VIEW,
    DETACH
  }
}
