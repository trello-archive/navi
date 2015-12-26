package com.trello.navi.internal;

import com.trello.navi.Event;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class NaviPlugin {

  private final Set<Event<?>> events;

  public NaviPlugin(Collection<Event<?>> events) {
    Set<Event<?>> set = new HashSet<>();
    set.addAll(events);
    this.events = Collections.unmodifiableSet(set);
  }

  public NaviPlugin(Event<?>... events) {
    this(Arrays.asList(events));
  }

  public Set<Event<?>> getEvents() {
    return events;
  }

  public abstract <T> void onEvent(Event<T> event, T data);
}
