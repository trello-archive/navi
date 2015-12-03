package com.trello.navi;

import com.trello.navi.internal.NaviEmitter;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class EventHandlingTest {
  @Test public void handlesEventsNone() {
    NaviComponent component = NaviEmitter.createActivityEmitter();
    assertTrue(component.handlesEvents());
  }

  @Test public void handlesEventsSingle() {
    NaviComponent component = NaviEmitter.createActivityEmitter();
    assertTrue(component.handlesEvents(Event.CREATE));
    assertFalse(component.handlesEvents(Event.CREATE_VIEW));
  }

  @Test public void handlesEventsMultiple() {
    NaviComponent component = NaviEmitter.createActivityEmitter();
    assertTrue(component.handlesEvents(Event.CREATE, Event.START, Event.RESUME));
    assertFalse(component.handlesEvents(Event.ATTACH, Event.CREATE_VIEW));
    assertFalse(component.handlesEvents(Event.CREATE, Event.CREATE_VIEW));
  }
}
