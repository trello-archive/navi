package com.trello.navi;

import com.trello.navi.internal.NaviEmitter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class EventHandlingTest {

  @Rule public final ExpectedException exception = ExpectedException.none();

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

  @Test public void throwOnRemoveUnsupportedListener() {
    final NaviEmitter emitter = NaviEmitter.createActivityEmitter();
    exception.expect(IllegalArgumentException.class);
    emitter.removeListener(Event.DETACH, mock(Listener.class));
  }

  @Test public void throwOnAddUnsupportedListener() {
    final NaviEmitter emitter = NaviEmitter.createActivityEmitter();
    exception.expect(IllegalArgumentException.class);
    emitter.addListener(Event.DETACH, mock(Listener.class));
  }
}
