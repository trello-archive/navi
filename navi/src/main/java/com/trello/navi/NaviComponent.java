package com.trello.navi;

/**
 * Represents an Android component (Activity, Fragment) that can have listeners.
 */
public interface NaviComponent {

  /**
   * Determines whether this component can handle particular events.
   *
   * For example, Activities do not handle Event.CREATE_VIEW since they do not have that step.
   *
   * @param events the events to check
   * @return true if all events can be handled
   */
  boolean handlesEvents(Event... events);

  /**
   * Adds a listener to this component.
   *
   * @param event an Event
   * @param listener the listener for that event
   * @param <T> the callback type for the event
   * @throws IllegalArgumentException if this component cannot handle the event
   */
  <T> void addListener(Event<T> event, Listener<T> listener);

  /**
   * Removes a listener from this component.
   *
   * @param event an Event
   * @param listener the listener for that event
   * @param <T> the callback type for the event
   * @throws IllegalArgumentException if this component cannot handle the event
   */
  <T> void removeListener(Event<T> event, Listener<T> listener);
}
