package com.trello.navi;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import com.trello.navi.internal.HandledEvents;
import com.trello.navi.internal.NaviPlugin;
import com.trello.navi.model.ActivityResult;
import com.trello.navi.model.RequestPermissionsResult;

public class FragmentNaviPlugin extends NaviPlugin {
  public FragmentNaviPlugin() {
    super(HandledEvents.FRAGMENT_EVENTS);
  }

  @Override public <T> void onEvent(Event<T> event, T data) {
    final Event.Type type = event.type();
    switch (type) {
      case CREATE:
        onCreate((Bundle) data);
        break;
      case START:
        onStart();
        break;
      case RESUME:
        onResume();
        break;
      case PAUSE:
        onPause();
        break;
      case STOP:
        onStop();
        break;
      case DESTROY:
        onDestroy();
        break;
      case SAVE_INSTANCE_STATE:
        onSaveInstanceState((Bundle) data);
        break;
      case CONFIGURATION_CHANGED:
        onConfigurationChanged((Configuration) data);
        break;
      case ACTIVITY_RESULT:
        onActivityResult((ActivityResult) data);
        break;
      case REQUEST_PERMISSIONS_RESULT:
        onRequestPermissionsResult((RequestPermissionsResult) data);
        break;
      case ATTACH:
        onAttach((Context) data);
        break;
      case CREATE_VIEW:
        onCreateView((Bundle) data);
        break;
      case ACTIVITY_CREATED:
        onActivityCreated((Bundle) data);
        break;
      case VIEW_STATE_RESTORED:
        onViewStateRestored((Bundle) data);
        break;
      case DESTROY_VIEW:
        onDestroyView();
        break;
      case DETACH:
        onDetach();
        break;
      default:
        // not handled
        break;
    }
  }

  protected void onAttach(Context context) {

  }

  protected void onCreate(Bundle savedInstanceState) {

  }

  protected void onCreateView(Bundle savedInstanceState) {

  }

  protected void onActivityCreated(Bundle savedInstanceState) {

  }

  protected void onViewStateRestored(Bundle savedInstanceState) {

  }

  protected void onStart() {

  }

  protected void onResume() {

  }

  protected void onPause() {

  }

  protected void onStop() {

  }

  protected void onDestroyView() {

  }

  protected void onDestroy() {

  }

  protected void onDetach() {

  }

  protected void onSaveInstanceState(Bundle outState) {

  }

  protected void onConfigurationChanged(Configuration newConfig) {

  }

  protected void onActivityResult(ActivityResult activityResult) {

  }

  protected void onRequestPermissionsResult(RequestPermissionsResult requestPermissionsResult) {

  }
}
