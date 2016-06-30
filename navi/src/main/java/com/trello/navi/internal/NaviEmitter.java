package com.trello.navi.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;

import com.trello.navi.Event;
import com.trello.navi.Event.Type;
import com.trello.navi.Listener;
import com.trello.navi.NaviComponent;
import com.trello.navi.model.ActivityResult;
import com.trello.navi.model.BundleBundle;
import com.trello.navi.model.RequestPermissionsResult;
import com.trello.navi.model.ViewCreated;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Emitter of Navi events which contains all the actual logic
 *
 * This makes it easier to port {@link NaviComponent} to Activities and Fragments
 * without duplicating quite as much code.
 */
public final class NaviEmitter implements NaviComponent {

  private final Set<Event<?>> handledEvents;

  private final Map<Event<?>, List<Listener>> listenerMap;

  // Only used for fast removal of listeners
  private final Map<Listener, Event<?>> eventMap;

  public NaviEmitter(@NonNull Collection<Event<?>> handledEvents) {
    this.handledEvents = Collections.unmodifiableSet(new HashSet<>(handledEvents));
    this.listenerMap = new ConcurrentHashMap<>();
    this.eventMap = new ConcurrentHashMap<>();
  }

  public static NaviEmitter createActivityEmitter() {
    return new NaviEmitter(HandledEvents.ACTIVITY_EVENTS);
  }

  public static NaviEmitter createFragmentEmitter() {
    return new NaviEmitter(HandledEvents.FRAGMENT_EVENTS);
  }

  @Override public final boolean handlesEvents(Event... events) {
    for (int a = 0; a < events.length; a++) {
      Event event = events[a];
      if (event != Event.ALL && !handledEvents.contains(event)) {
        return false;
      }
    }

    return true;
  }

  @Override public final <T> void addListener(Event<T> event, Listener<T> listener) {
    if (!handlesEvents(event)) {
      throw new IllegalArgumentException("This component cannot handle event " + event);
    }

    // Check that we're not adding the same listener in multiple places
    // For the same event, it's idempotent; for different events, it's an error
    if (eventMap.containsKey(listener)) {
      final Event otherEvent = eventMap.get(listener);
      if (!event.equals(otherEvent)) {
        throw new IllegalStateException(
            "Cannot use the same listener for two events! e1: " + event + " e2: " + otherEvent);
      }
      return;
    }

    eventMap.put(listener, event);

    if (!listenerMap.containsKey(event)) {
      listenerMap.put(event, new CopyOnWriteArrayList<Listener>());
    }

    List<Listener> listeners = listenerMap.get(event);
    listeners.add(listener);
  }

  @Override public final <T> void removeListener(Listener<T> listener) {
    final Event event = eventMap.remove(listener);
    if (event != null && listenerMap.containsKey(event)) {
      listenerMap.get(event).remove(listener);
    }
  }

  private void emitEvent(Event<Void> event) {
    emitEvent(event, null);
  }

  private <T> void emitEvent(Event<T> event, T data) {
    // We gather listener iterators  all at once so adding/removing listeners during emission
    // doesn't change the listener list.
    final List<Listener> listeners = listenerMap.get(event);
    final Iterator<Listener> listenersIterator =
        listeners != null ? listeners.listIterator() : null;

    final List<Listener> allListeners = listenerMap.get(Event.ALL);
    final Iterator<Listener> allListenersIterator =
        allListeners != null ? allListeners.iterator() : null;

    if (allListenersIterator != null) {
      final Type type = event.type();
      while (allListenersIterator.hasNext()) {
        allListenersIterator.next().call(type);
      }
    }

    if (listeners != null) {
      while (listenersIterator.hasNext()) {
        listenersIterator.next().call(data);
      }
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // Events

  public void onActivityCreated(Bundle savedInstanceState) {
    emitEvent(Event.ACTIVITY_CREATED, savedInstanceState);
  }

  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    emitEvent(Event.ACTIVITY_RESULT, new ActivityResult(requestCode, resultCode, data));
  }

  public void onAttach(Activity activity) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
      emitEvent(Event.ATTACH, activity);
    }
  }

  public void onAttach(Context context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      emitEvent(Event.ATTACH, context);
    }
  }

  public void onAttachedToWindow() {
    emitEvent(Event.ATTACHED_TO_WINDOW);
  }

  public void onBackPressed() {
    emitEvent(Event.BACK_PRESSED);
  }

  public void onConfigurationChanged(Configuration newConfig) {
    emitEvent(Event.CONFIGURATION_CHANGED, newConfig);
  }

  public void onCreate(Bundle savedInstanceState) {
    emitEvent(Event.CREATE, savedInstanceState);
  }

  public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
    emitEvent(Event.CREATE_PERSISTABLE, new BundleBundle(savedInstanceState, persistentState));
  }

  public void onCreateView(Bundle savedInstanceState) {
    emitEvent(Event.CREATE_VIEW, savedInstanceState);
  }

  public void onViewCreated(ViewCreated viewCreated) {
    emitEvent(Event.VIEW_CREATED, viewCreated);
  }

  public void onDestroy() {
    emitEvent(Event.DESTROY);
  }

  public void onDestroyView() {
    emitEvent(Event.DESTROY_VIEW);
  }

  public void onDetach() {
    emitEvent(Event.DETACH);
  }

  public void onDetachedFromWindow() {
    emitEvent(Event.DETACHED_FROM_WINDOW);
  }

  public void onNewIntent(Intent intent) {
    emitEvent(Event.NEW_INTENT, intent);
  }

  public void onPause() {
    emitEvent(Event.PAUSE);
  }

  public void onRequestPermissionsResult(int requestCode, String[] permissions,
      int[] grantResults) {
    emitEvent(Event.REQUEST_PERMISSIONS_RESULT,
        new RequestPermissionsResult(requestCode, permissions, grantResults));
  }

  public void onRestart() {
    emitEvent(Event.RESTART);
  }

  public void onRestoreInstanceState(Bundle savedInstanceState) {
    emitEvent(Event.RESTORE_INSTANCE_STATE, savedInstanceState);
  }

  public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
    emitEvent(Event.RESTORE_INSTANCE_STATE_PERSISTABLE,
        new BundleBundle(savedInstanceState, persistentState));
  }

  public void onResume() {
    emitEvent(Event.RESUME);
  }

  public void onSaveInstanceState(Bundle outState) {
    emitEvent(Event.SAVE_INSTANCE_STATE, outState);
  }

  public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    emitEvent(Event.SAVE_INSTANCE_STATE_PERSISTABLE,
        new BundleBundle(outState, outPersistentState));
  }

  public void onStart() {
    emitEvent(Event.START);
  }

  public void onStop() {
    emitEvent(Event.STOP);
  }

  public void onViewStateRestored(Bundle savedInstanceState) {
    emitEvent(Event.VIEW_STATE_RESTORED, savedInstanceState);
  }
}
