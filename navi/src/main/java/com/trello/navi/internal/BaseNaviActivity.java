package com.trello.navi.internal;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import com.trello.navi.Listener0;
import com.trello.navi.Listener1;
import com.trello.navi.NaviActivity;
import com.trello.navi.model.ActivityResult;
import com.trello.navi.model.BundleBundle;
import com.trello.navi.model.RequestPermissionsResult;
import java.util.ArrayList;
import java.util.List;

import static com.trello.navi.internal.Emitters.emitListener0;
import static com.trello.navi.internal.Emitters.emitListener1;

/**
 * Base helper which contains all the actual logic
 *
 * This makes it easier to port {@link com.trello.navi.NaviActivity} to other Activities
 * without duplicating quite as much code.
 */
public final class BaseNaviActivity implements NaviActivity {

  private List<Listener1<BundleBundle>> createListeners;
  private List<Listener0> startListeners;
  private List<Listener0> resumeListeners;
  private List<Listener0> pauseListeners;
  private List<Listener0> stopListeners;
  private List<Listener0> destroyListeners;

  private List<Listener0> restartListeners;

  private List<Listener1<BundleBundle>> restoreInstanceStateListeners;
  private List<Listener1<BundleBundle>> saveInstanceStateListeners;

  private List<Listener1<Intent>> newIntentListeners;

  private List<Listener0> backPressedListeners;

  private List<Listener0> attachedToWindowListeners;
  private List<Listener0> detachedFromWindowListeners;

  private List<Listener1<Configuration>> configurationChangedListeners;

  private List<Listener1<ActivityResult>> activityResultListeners;

  private List<Listener1<RequestPermissionsResult>> requestPermissionsResultListeners;

  ////////////////////////////////////////////////////////////////////////////
  // onCreate

  @Override public void addCreateListener(Listener1<BundleBundle> listener) {
    if (createListeners == null) {
      createListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    createListeners.add(listener);
  }

  @Override public void removeCreateListener(Listener1<BundleBundle> listener) {
    if (createListeners != null) {
      createListeners.remove(listener);
    }
  }

  public void onCreate(Bundle savedInstanceState) {
    if (createListeners != null) {
      emitListener1(createListeners, new BundleBundle(savedInstanceState));
    }
  }

  public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
    if (createListeners != null) {
      emitListener1(createListeners, new BundleBundle(savedInstanceState, persistentState));
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onStart

  @Override public void addStartListener(Listener0 listener) {
    if (startListeners == null) {
      startListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    startListeners.add(listener);
  }

  @Override public void removeStartListener(Listener0 listener) {
    if (startListeners != null) {
      startListeners.remove(listener);
    }
  }

  public void onStart() {
    if (startListeners != null) {
      emitListener0(startListeners);
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onResume

  @Override public void addResumeListener(Listener0 listener) {
    if (resumeListeners == null) {
      resumeListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    resumeListeners.add(listener);
  }

  @Override public void removeResumeListener(Listener0 listener) {
    if (resumeListeners != null) {
      resumeListeners.remove(listener);
    }
  }

  public void onResume() {
    if (resumeListeners != null) {
      emitListener0(resumeListeners);
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onPause

  @Override public void addPauseListener(Listener0 listener) {
    if (pauseListeners == null) {
      pauseListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    pauseListeners.add(listener);
  }

  @Override public void removePauseListener(Listener0 listener) {
    if (pauseListeners != null) {
      pauseListeners.remove(listener);
    }
  }

  public void onPause() {
    if (pauseListeners != null) {
      emitListener0(pauseListeners);
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onStop

  @Override public void addStopListener(Listener0 listener) {
    if (stopListeners == null) {
      stopListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    stopListeners.add(listener);
  }

  @Override public void removeStopListener(Listener0 listener) {
    if (stopListeners != null) {
      stopListeners.remove(listener);
    }
  }

  public void onStop() {
    if (stopListeners != null) {
      emitListener0(stopListeners);
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onDestroy

  @Override public void addDestroyListener(Listener0 listener) {
    if (destroyListeners == null) {
      destroyListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    destroyListeners.add(listener);
  }

  @Override public void removeDestroyListener(Listener0 listener) {
    if (destroyListeners != null) {
      destroyListeners.remove(listener);
    }
  }

  public void onDestroy() {
    if (destroyListeners != null) {
      emitListener0(destroyListeners);
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onRestart

  @Override public void addRestartListener(Listener0 listener) {
    if (restartListeners == null) {
      restartListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    restartListeners.add(listener);
  }

  @Override public void removeRestartListener(Listener0 listener) {
    if (restartListeners != null) {
      restartListeners.remove(listener);
    }
  }

  public void onRestart() {
    if (restartListeners != null) {
      emitListener0(restartListeners);
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onSaveInstanceState

  @Override public void addSaveInstanceStateListener(Listener1<BundleBundle> listener) {
    if (saveInstanceStateListeners == null) {
      saveInstanceStateListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    saveInstanceStateListeners.add(listener);
  }

  @Override public void removeSaveInstanceStateListener(Listener1<BundleBundle> listener) {
    if (saveInstanceStateListeners != null) {
      saveInstanceStateListeners.remove(listener);
    }
  }

  public void onSaveInstanceState(Bundle outState) {
    if (saveInstanceStateListeners != null) {
      emitListener1(saveInstanceStateListeners, new BundleBundle(outState));
    }
  }

  public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    if (saveInstanceStateListeners != null) {
      emitListener1(saveInstanceStateListeners, new BundleBundle(outState, outPersistentState));
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onRestoreInstanceState

  @Override public void addRestoreInstanceStateListener(Listener1<BundleBundle> listener) {
    if (restoreInstanceStateListeners == null) {
      restoreInstanceStateListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    restoreInstanceStateListeners.add(listener);
  }

  @Override public void removeRestoreInstanceStateListener(Listener1<BundleBundle> listener) {
    if (restoreInstanceStateListeners != null) {
      restoreInstanceStateListeners.remove(listener);
    }
  }

  public void onRestoreInstanceState(Bundle savedInstanceState) {
    if (restoreInstanceStateListeners != null) {
      emitListener1(restoreInstanceStateListeners, new BundleBundle(savedInstanceState));
    }
  }

  public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
    if (restoreInstanceStateListeners != null) {
      emitListener1(restoreInstanceStateListeners,
          new BundleBundle(savedInstanceState, persistentState));
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onNewIntent

  @Override public void addNewIntentListener(Listener1<Intent> listener) {
    if (newIntentListeners == null) {
      newIntentListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    newIntentListeners.add(listener);
  }

  @Override public void removeNewIntentListener(Listener1<Intent> listener) {
    if (newIntentListeners != null) {
      newIntentListeners.remove(listener);
    }
  }

  public void onNewIntent(Intent intent) {
    if (newIntentListeners != null) {
      emitListener1(newIntentListeners, intent);
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onBackPressed

  @Override public void addBackPressedListener(Listener0 listener) {
    if (backPressedListeners == null) {
      backPressedListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    backPressedListeners.add(listener);
  }

  @Override public void removeBackPressedListener(Listener0 listener) {
    if (backPressedListeners != null) {
      backPressedListeners.remove(listener);
    }
  }

  public void onBackPressed() {
    if (backPressedListeners != null) {
      emitListener0(backPressedListeners);
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onAttachedToWindow

  @Override public void addAttachedToWindowListener(Listener0 listener) {
    if (attachedToWindowListeners == null) {
      attachedToWindowListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    attachedToWindowListeners.add(listener);
  }

  @Override public void removeAttachedToWindowListener(Listener0 listener) {
    if (attachedToWindowListeners != null) {
      attachedToWindowListeners.remove(listener);
    }
  }

  public void onAttachedToWindow() {
    if (attachedToWindowListeners != null) {
      emitListener0(attachedToWindowListeners);
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onDetachedFromWindow

  @Override public void addDetachedFromWindowListener(Listener0 listener) {
    if (detachedFromWindowListeners == null) {
      detachedFromWindowListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    detachedFromWindowListeners.add(listener);
  }

  @Override public void removeDetachedFromWindowListener(Listener0 listener) {
    if (detachedFromWindowListeners != null) {
      detachedFromWindowListeners.remove(listener);
    }
  }

  public void onDetachedFromWindow() {
    if (detachedFromWindowListeners != null) {
      emitListener0(detachedFromWindowListeners);
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onConfigurationChanged

  @Override public void addConfigurationChangedListener(Listener1<Configuration> listener) {
    if (configurationChangedListeners == null) {
      configurationChangedListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    configurationChangedListeners.add(listener);
  }

  @Override public void removeConfigurationChangedListener(Listener1<Configuration> listener) {
    if (configurationChangedListeners != null) {
      configurationChangedListeners.remove(listener);
    }
  }

  public void onConfigurationChanged(Configuration newConfig) {
    if (configurationChangedListeners != null) {
      emitListener1(configurationChangedListeners, newConfig);
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onActivityResult

  @Override public void addActivityResultListener(Listener1<ActivityResult> listener) {
    if (activityResultListeners == null) {
      activityResultListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    activityResultListeners.add(listener);
  }

  @Override public void removeActivityResultListener(Listener1<ActivityResult> listener) {
    if (activityResultListeners != null) {
      activityResultListeners.remove(listener);
    }
  }

  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (activityResultListeners != null) {
      emitListener1(activityResultListeners, new ActivityResult(requestCode, resultCode, data));
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onRequestPermissionsResult

  @Override
  public void addRequestPermissionsResultListener(Listener1<RequestPermissionsResult> listener) {
    if (requestPermissionsResultListeners == null) {
      requestPermissionsResultListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    requestPermissionsResultListeners.add(listener);
  }

  @Override
  public void removeRequestPermissionsResultListener(Listener1<RequestPermissionsResult> listener) {
    if (requestPermissionsResultListeners != null) {
      requestPermissionsResultListeners.remove(listener);
    }
  }

  public void onRequestPermissionsResult(int requestCode, String[] permissions,
      int[] grantResults) {
    if (requestPermissionsResultListeners != null) {
      emitListener1(requestPermissionsResultListeners,
          new RequestPermissionsResult(requestCode, permissions, grantResults));
    }
  }
}
