package com.trello.navi;

import com.trello.navi.internal.NaviEmitter;
import com.trello.navi.internal.NaviPlugin;
import java.util.Arrays;
import org.junit.Test;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class NaviPluginTest {

  @Test public void addRemovePlugin() {
    NaviPlugin plugin = spy(new NaviPlugin(Event.START) {
      @Override public <T> void onEvent(Event<T> event, T data) {

      }
    });
    NaviEmitter emitter = new NaviEmitter(Arrays.<Event<?>>asList(Event.START));

    emitter.addPlugin(plugin);
    verify(plugin).getEvents();

    emitter.onStart();
    verify(plugin).onEvent(Event.START, null);

    emitter.removePlugin(plugin);
    emitter.onStart();
    verifyNoMoreInteractions(plugin);
  }

  @Test(expected = IllegalArgumentException.class) public void addWrongPlugin() throws Exception {
    NaviEmitter emitter = NaviEmitter.createFragmentEmitter();
    ActivityNaviPlugin plugin = new ActivityNaviPlugin();
    emitter.addPlugin(plugin);
  }
}
