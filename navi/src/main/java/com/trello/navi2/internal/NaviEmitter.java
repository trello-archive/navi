/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.trello.navi2.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.trello.navi2.Event;
import com.trello.navi2.Event.Type;
import com.trello.navi2.Listener;
import com.trello.navi2.NaviComponent;
import com.trello.navi2.model.ActivityResult;
import com.trello.navi2.model.BundleBundle;
import com.trello.navi2.model.RequestPermissionsResult;
import com.trello.navi2.model.ViewCreated;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import static com.trello.navi2.internal.Constants.SIGNAL;

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

  @Override
  public final <T> void addListener(@NonNull Event<T> event, @NonNull Listener<T> listener) {
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

  @Override public final <T> void removeListener(@NonNull Listener<T> listener) {
    final Event event = eventMap.remove(listener);
    if (event != null && listenerMap.containsKey(event)) {
      listenerMap.get(event).remove(listener);
    }
  }

  private void emitEvent(@NonNull Event<Object> event) {
    emitEvent(event, SIGNAL);
  }

  private <T> void emitEvent(@NonNull Event<T> event, @NonNull T data) {
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

  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    emitEvent(Event.ACTIVITY_CREATED,
        savedInstanceState != null ? savedInstanceState : new Bundle());
  }

  public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    emitEvent(Event.ACTIVITY_RESULT, ActivityResult.create(requestCode, resultCode, data));
  }

  public void onAttach(@NonNull Activity activity) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
      emitEvent(Event.ATTACH, activity);
    }
  }

  public void onAttach(@NonNull Context context) {
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

  public void onConfigurationChanged(@NonNull Configuration newConfig) {
    emitEvent(Event.CONFIGURATION_CHANGED, newConfig);
  }

  public void onCreate(@Nullable Bundle savedInstanceState) {
    emitEvent(Event.CREATE, savedInstanceState != null ? savedInstanceState : new Bundle());
  }

  public void onCreate(@Nullable Bundle savedInstanceState,
      @Nullable PersistableBundle persistentState) {
    emitEvent(Event.CREATE_PERSISTABLE, BundleBundle.create(savedInstanceState, persistentState));
  }

  public void onCreateView(@Nullable Bundle savedInstanceState) {
    emitEvent(Event.CREATE_VIEW, savedInstanceState != null ? savedInstanceState : new Bundle());
  }

  public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
    emitEvent(Event.VIEW_CREATED, ViewCreated.create(view, bundle));
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

  public void onNewIntent(@NonNull Intent intent) {
    emitEvent(Event.NEW_INTENT, intent);
  }

  public void onPause() {
    emitEvent(Event.PAUSE);
  }

  public void onPostCreate(@Nullable Bundle savedInstanceState) {
    emitEvent(Event.POST_CREATE, savedInstanceState != null ? savedInstanceState : new Bundle());
  }

  public void onPostCreate(@Nullable Bundle savedInstanceState,
      @Nullable PersistableBundle persistentState) {
    emitEvent(Event.POST_CREATE_PERSISTABLE,
        BundleBundle.create(savedInstanceState, persistentState));
  }

  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    emitEvent(Event.REQUEST_PERMISSIONS_RESULT,
        RequestPermissionsResult.create(requestCode, permissions, grantResults));
  }

  public void onRestart() {
    emitEvent(Event.RESTART);
  }

  public void onRestoreInstanceState(@Nullable Bundle savedInstanceState) {
    emitEvent(Event.RESTORE_INSTANCE_STATE,
        savedInstanceState != null ? savedInstanceState : new Bundle());
  }

  public void onRestoreInstanceState(@Nullable Bundle savedInstanceState,
      @Nullable PersistableBundle persistentState) {
    emitEvent(Event.RESTORE_INSTANCE_STATE_PERSISTABLE,
        BundleBundle.create(savedInstanceState, persistentState));
  }

  public void onResume() {
    emitEvent(Event.RESUME);
  }

  public void onSaveInstanceState(@NonNull Bundle outState) {
    emitEvent(Event.SAVE_INSTANCE_STATE, outState);
  }

  public void onSaveInstanceState(@NonNull Bundle outState,
      @NonNull PersistableBundle outPersistentState) {
    emitEvent(Event.SAVE_INSTANCE_STATE_PERSISTABLE,
        BundleBundle.create(outState, outPersistentState));
  }

  public void onStart() {
    emitEvent(Event.START);
  }

  public void onStop() {
    emitEvent(Event.STOP);
  }

  public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
    emitEvent(Event.VIEW_STATE_RESTORED,
        savedInstanceState != null ? savedInstanceState : new Bundle());
  }
}
