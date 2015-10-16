package com.trello.navi.internal;

import android.os.Bundle;
import android.os.PersistableBundle;
import com.trello.navi.NaviActivity;
import com.trello.navi.model.BundleBundle;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action0;
import rx.functions.Action1;

import static com.trello.navi.internal.Emitters.emitAction0;
import static com.trello.navi.internal.Emitters.emitAction1;

/**
 * Base helper which contains all the actual logic
 *
 * This makes it easier to port {@link com.trello.navi.NaviActivity} to other Activities
 * without duplicating quite as much code.
 */
public final class BaseNaviActivity implements NaviActivity {

  private List<Action1<BundleBundle>> createListeners;
  private List<Action0> startListeners;
  private List<Action0> resumeListeners;
  private List<Action0> pauseListeners;
  private List<Action0> stopListeners;
  private List<Action0> destroyListeners;

  private List<Action0> restartListeners;

  private List<Action1<BundleBundle>> restoreInstanceStateListeners;
  private List<Action1<BundleBundle>> saveInstanceStateListeners;

  private List<NaviActivityDelegate> activityDelegates;

  ////////////////////////////////////////////////////////////////////////////
  // onCreate

  @Override public void addCreateListener(Action1<BundleBundle> listener) {
    if (createListeners == null) {
      createListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    createListeners.add(listener);
  }

  @Override public void removeCreateListener(Action1<BundleBundle> listener) {
    if (createListeners != null) {
      createListeners.remove(listener);
    }
  }

  public void onCreate(Bundle savedInstanceState) {
    if (createListeners != null) {
      emitAction1(createListeners, new BundleBundle(savedInstanceState));
    }
    if (activityDelegates != null) {
      for (int i = 0; i < activityDelegates.size(); i++) {
        activityDelegates.get(i).onCreate(new BundleBundle(savedInstanceState));
      }
    }
  }

  public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
    if (createListeners != null) {
      emitAction1(createListeners, new BundleBundle(savedInstanceState, persistentState));
    }
    if (activityDelegates != null) {
      for (int i = 0; i < activityDelegates.size(); i++) {
        activityDelegates.get(i).onCreate(new BundleBundle(savedInstanceState, persistentState));
      }
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onStart

  @Override public void addStartListener(Action0 listener) {
    if (startListeners == null) {
      startListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    startListeners.add(listener);
  }

  @Override public void removeStartListener(Action0 listener) {
    if (startListeners != null) {
      startListeners.remove(listener);
    }
  }

  public void onStart() {
    if (startListeners != null) {
      emitAction0(startListeners);
    }
    if (activityDelegates != null) {
      for (int i = 0; i < activityDelegates.size(); i++) {
        activityDelegates.get(i).onStart();
      }
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onResume

  @Override public void addResumeListener(Action0 listener) {
    if (resumeListeners == null) {
      resumeListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    resumeListeners.add(listener);
  }

  @Override public void removeResumeListener(Action0 listener) {
    if (resumeListeners != null) {
      resumeListeners.remove(listener);
    }
  }

  public void onResume() {
    if (resumeListeners != null) {
      emitAction0(resumeListeners);
    }
    if (activityDelegates != null) {
      for (int i = 0; i < activityDelegates.size(); i++) {
        activityDelegates.get(i).onResume();
      }
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onPause

  @Override public void addPauseListener(Action0 listener) {
    if (pauseListeners == null) {
      pauseListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    pauseListeners.add(listener);
  }

  @Override public void removePauseListener(Action0 listener) {
    if (pauseListeners != null) {
      pauseListeners.remove(listener);
    }
  }

  public void onPause() {
    if (pauseListeners != null) {
      emitAction0(pauseListeners);
    }
    if (activityDelegates != null) {
      for (int i = 0; i < activityDelegates.size(); i++) {
        activityDelegates.get(i).onPause();
      }
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onStop

  @Override public void addStopListener(Action0 listener) {
    if (stopListeners == null) {
      stopListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    stopListeners.add(listener);
  }

  @Override public void removeStopListener(Action0 listener) {
    if (stopListeners != null) {
      stopListeners.remove(listener);
    }
  }

  public void onStop() {
    if (stopListeners != null) {
      emitAction0(stopListeners);
    }
    if (activityDelegates != null) {
      for (int i = 0; i < activityDelegates.size(); i++) {
        activityDelegates.get(i).onStop();
      }
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onDestroy

  @Override public void addDestroyListener(Action0 listener) {
    if (destroyListeners == null) {
      destroyListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    destroyListeners.add(listener);
  }

  @Override public void removeDestroyListener(Action0 listener) {
    if (destroyListeners != null) {
      destroyListeners.remove(listener);
    }
  }

  public void onDestroy() {
    if (destroyListeners != null) {
      emitAction0(destroyListeners);
    }
    if (activityDelegates != null) {
      for (int i = 0; i < activityDelegates.size(); i++) {
        activityDelegates.get(i).onDestroy();
      }
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onRestart

  @Override public void addRestartListener(Action0 listener) {
    if (restartListeners == null) {
      restartListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    restartListeners.add(listener);
  }

  @Override public void removeRestartListener(Action0 listener) {
    if (restartListeners != null) {
      restartListeners.remove(listener);
    }
  }

  public void onRestart() {
    if (restartListeners != null) {
      emitAction0(restartListeners);
    }
    if (activityDelegates != null) {
      for (int i = 0; i < activityDelegates.size(); i++) {
        activityDelegates.get(i).onRestart();
      }
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onSaveInstanceState

  @Override public void addSaveInstanceStateListener(Action1<BundleBundle> listener) {
    if (saveInstanceStateListeners == null) {
      saveInstanceStateListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    saveInstanceStateListeners.add(listener);
  }

  @Override public void removeSaveInstanceStateListener(Action1<BundleBundle> listener) {
    if (saveInstanceStateListeners != null) {
      saveInstanceStateListeners.remove(listener);
    }
  }

  public void onSaveInstanceState(Bundle outState) {
    if (saveInstanceStateListeners != null) {
      emitAction1(saveInstanceStateListeners, new BundleBundle(outState));
    }
    if (activityDelegates != null) {
      for (int i = 0; i < activityDelegates.size(); i++) {
        activityDelegates.get(i).onSaveInstanceState(new BundleBundle(outState));
      }
    }
  }

  public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    if (saveInstanceStateListeners != null) {
      emitAction1(saveInstanceStateListeners, new BundleBundle(outState, outPersistentState));
    }
    if (activityDelegates != null) {
      for (int i = 0; i < activityDelegates.size(); i++) {
        activityDelegates.get(i)
            .onSaveInstanceState(new BundleBundle(outState, outPersistentState));
      }
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onRestoreInstanceState

  @Override public void addRestoreInstanceStateListener(Action1<BundleBundle> listener) {
    if (restoreInstanceStateListeners == null) {
      restoreInstanceStateListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    restoreInstanceStateListeners.add(listener);
  }

  @Override public void removeRestoreInstanceStateListener(Action1<BundleBundle> listener) {
    if (restoreInstanceStateListeners != null) {
      restoreInstanceStateListeners.remove(listener);
    }
  }

  public void onRestoreInstanceState(Bundle savedInstanceState) {
    if (restoreInstanceStateListeners != null) {
      emitAction1(restoreInstanceStateListeners, new BundleBundle(savedInstanceState));
    }
    if (activityDelegates != null) {
      for (int i = 0; i < activityDelegates.size(); i++) {
        activityDelegates.get(i).onRestoreInstanceState(new BundleBundle(savedInstanceState));
      }
    }
  }

  public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
    if (restoreInstanceStateListeners != null) {
      emitAction1(restoreInstanceStateListeners,
          new BundleBundle(savedInstanceState, persistentState));
    }
    if (activityDelegates != null) {
      for (int i = 0; i < activityDelegates.size(); i++) {
        activityDelegates.get(i)
            .onRestoreInstanceState(new BundleBundle(savedInstanceState, persistentState));
      }
    }
  }

  public void addDelegate(NaviActivityDelegate delegate) {
    if (activityDelegates == null) {
      activityDelegates = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }
    activityDelegates.add(delegate);
  }
}
