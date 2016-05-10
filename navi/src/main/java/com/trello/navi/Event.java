package com.trello.navi;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.IntDef;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.trello.navi.model.ActivityResult;
import com.trello.navi.model.BundleBundle;
import com.trello.navi.model.RequestPermissionsResult;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Represents an event that can be listened to in an Activity or Fragment.
 * <p/>
 * Comes with a set of predefined events.
 * <p/>
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
    public static final Event<Integer> ALL = new Event<>(Type.ALL, Integer.class);

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
    public static final Event<Void> ATTACHED_TO_WINDOW = new Event<>(Type.ATTACHED_TO_WINDOW, Void.class);

    /**
     * Emits {@link Activity#onDetachedFromWindow()}. Emitted after super().
     */
    public static final Event<Void> DETACHED_FROM_WINDOW = new Event<>(Type.DETACHED_FROM_WINDOW, Void.class);

    /**
     * Emits {@link Fragment#onAttach(Context)}. Emitted after super().
     */
    public static final Event<Context> ATTACH = new Event<>(Type.ATTACH, Context.class);

    /**
     * Emits {@link Fragment#onCreateView(LayoutInflater, ViewGroup, Bundle)}. Emitted after super().
     */
    public static final Event<Bundle> CREATE_VIEW = new Event<>(Type.CREATE_VIEW, Bundle.class);

    /**
     * Emits {@link Fragment#onActivityCreated(Bundle)}. Emitted after super().
     */
    public static final Event<Bundle> ACTIVITY_CREATED = new Event<>(Type.ACTIVITY_CREATED, Bundle.class);

    /**
     * Emits {@link Fragment#onViewStateRestored(Bundle)}. Emitted after super().
     */
    public static final Event<Bundle> VIEW_STATE_RESTORED = new Event<>(Type.VIEW_STATE_RESTORED, Bundle.class);

    /**
     * Emits {@link Fragment#onDestroyView()}. Emitted before super().
     */
    public static final Event<Void> DESTROY_VIEW = new Event<>(Type.DESTROY_VIEW, Void.class);

    /**
     * Emits {@link Fragment#onDetach()}. Emitted before super().
     */
    public static final Event<Void> DETACH = new Event<>(Type.DETACH, Void.class);

    private final @Type Integer eventType;

    private final Class<T> callbackType;

    // This is purposefully hidden so that we can control available events
    private Event(@Type int eventType, Class<T> callbackType) {
        this.eventType = eventType;
        this.callbackType = callbackType;
    }

    public @Type Integer type() {
        return eventType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Event<?> event = (Event<?>) o;

        return eventType.equals(event.eventType) && callbackType.equals(event.callbackType);
    }

    @Override
    public int hashCode() {
        return 31 * eventType + callbackType.hashCode();
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventType=" + eventType +
                ", callbackType=" + callbackType +
                '}';
    }

    @IntDef({
            Type.ALL, Type.CREATE, Type.START, Type.RESUME, Type.PAUSE, Type.STOP, Type.DESTROY,
            Type.SAVE_INSTANCE_STATE, Type.CONFIGURATION_CHANGED, Type.ACTIVITY_RESULT, Type.REQUEST_PERMISSIONS_RESULT,
            Type.CREATE_PERSISTABLE, Type.RESTART, Type.SAVE_INSTANCE_STATE_PERSISTABLE, Type.RESTORE_INSTANCE_STATE,
            Type.RESTORE_INSTANCE_STATE_PERSISTABLE, Type.NEW_INTENT, Type.BACK_PRESSED, Type.ATTACHED_TO_WINDOW,
            Type.DETACHED_FROM_WINDOW, Type.ATTACH, Type.CREATE_VIEW, Type.ACTIVITY_CREATED, Type.VIEW_STATE_RESTORED,
            Type.DESTROY_VIEW, Type.DETACH
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
        int ALL = 0;

        // Shared
        int CREATE = 1;
        int START = 2;
        int RESUME = 3;
        int PAUSE = 4;
        int STOP = 5;
        int DESTROY = 6;
        int SAVE_INSTANCE_STATE = 7;
        int CONFIGURATION_CHANGED = 8;
        int ACTIVITY_RESULT = 9;
        int REQUEST_PERMISSIONS_RESULT = 10;

        // Activity-only
        int CREATE_PERSISTABLE = 11;
        int RESTART = 12;
        int SAVE_INSTANCE_STATE_PERSISTABLE = 13;
        int RESTORE_INSTANCE_STATE = 14;
        int RESTORE_INSTANCE_STATE_PERSISTABLE = 15;
        int NEW_INTENT = 16;
        int BACK_PRESSED = 17;
        int ATTACHED_TO_WINDOW = 18;
        int DETACHED_FROM_WINDOW = 19;

        // Fragment-only
        int ATTACH = 20;
        int CREATE_VIEW = 21;
        int ACTIVITY_CREATED = 21;
        int VIEW_STATE_RESTORED = 22;
        int DESTROY_VIEW = 23;
        int DETACH = 24;
    }
}
