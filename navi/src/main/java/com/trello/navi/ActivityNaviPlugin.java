package com.trello.navi;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.trello.navi.internal.HandledEvents;
import com.trello.navi.internal.NaviPlugin;
import com.trello.navi.model.ActivityResult;
import com.trello.navi.model.BundleBundle;
import com.trello.navi.model.RequestPermissionsResult;

public class ActivityNaviPlugin extends NaviPlugin {
  public ActivityNaviPlugin() {
    super(HandledEvents.ACTIVITY_EVENTS);
  }

  public <T> void onEvent(Event<T> event, T data) {
    //TODO not sure if pure if-else implementation would be faster
    final Event.Type type = event.type();
    switch (type) {
      case CREATE:
        if (event.equals(Event.CREATE_PERSISTABLE)) {
          onCreate((BundleBundle) data);
        } else {
          onCreate((Bundle) data);
        }
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
        if (event.equals(Event.SAVE_INSTANCE_STATE_PERSISTABLE)) {
          onSaveInstanceState((BundleBundle) data);
        } else {
          onSaveInstanceState((Bundle) data);
        }
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
      case RESTART:
        onRestart();
        break;
      case RESTORE_INSTANCE_STATE:
        if (event.equals(Event.RESTORE_INSTANCE_STATE_PERSISTABLE)) {
          onRestoreInstanceState((BundleBundle) data);
        } else {
          onRestoreInstanceState((Bundle) data);
        }
        break;
      case NEW_INTENT:
        onNewIntent((Intent) data);
        break;
      case BACK_PRESSED:
        onBackPressed();
        break;
      case ATTACHED_TO_WINDOW:
        onAttachedToWindow();
        break;
      case DETACHED_FROM_WINDOW:
        onDetachedFromWindow();
        break;
      default:
        // not handled
        break;
    }
  }

  protected void onCreate(BundleBundle bundle) {

  }

  protected void onCreate(Bundle bundle) {

  }

  protected void onStart() {

  }

  protected void onResume() {

  }

  protected void onPause() {

  }

  protected void onStop() {

  }

  protected void onDestroy() {

  }

  protected void onRestart() {

  }

  protected void onSaveInstanceState(Bundle bundle) {

  }

  protected void onSaveInstanceState(BundleBundle bundle) {

  }

  protected void onRestoreInstanceState(Bundle savedInstanceState) {

  }

  protected void onRestoreInstanceState(BundleBundle savedInstanceState) {

  }

  protected void onNewIntent(Intent intent) {

  }

  protected void onBackPressed() {

  }

  protected void onAttachedToWindow() {

  }

  protected void onDetachedFromWindow() {

  }

  protected void onConfigurationChanged(Configuration newConfig) {

  }

  protected void onActivityResult(ActivityResult result) {

  }

  protected void onRequestPermissionsResult(RequestPermissionsResult result) {

  }
}