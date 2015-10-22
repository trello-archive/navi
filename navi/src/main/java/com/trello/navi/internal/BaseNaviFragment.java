package com.trello.navi.internal;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import com.trello.navi.Listener0;
import com.trello.navi.Listener1;
import com.trello.navi.NaviFragment;
import java.util.ArrayList;
import java.util.List;

import static com.trello.navi.internal.Emitters.emitListener0;
import static com.trello.navi.internal.Emitters.emitListener1;

/**
 * Base helper which contains all the actual logic
 *
 * This makes it easier to port {@link NaviFragment} to other Fragments
 * without duplicating quite as much code.
 */
public final class BaseNaviFragment implements NaviFragment {

  private List<Listener1<Context>> attachListeners;
  private List<Listener1<Bundle>> createListeners;
  private List<Listener1<Bundle>> createViewListeners;
  private List<Listener1<Bundle>> activityCreatedListeners;
  private List<Listener1<Bundle>> viewStateRestoredListeners;
  private List<Listener0> startListeners;
  private List<Listener0> resumeListeners;
  private List<Listener0> pauseListeners;
  private List<Listener0> stopListeners;
  private List<Listener0> destroyViewListeners;
  private List<Listener0> destroyListeners;
  private List<Listener0> detachListeners;

  private List<Listener1<Bundle>> saveInstanceStateListeners;

  private List<Listener1<Configuration>> configurationChangedListeners;

  ////////////////////////////////////////////////////////////////////////////
  // onAttach

  @Override public void addAttachListener(Listener1<Context> listener) {
    if (attachListeners == null) {
      attachListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    attachListeners.add(listener);
  }

  @Override public void removeAttachListener(Listener1<Context> listener) {
    if (attachListeners != null) {
      attachListeners.remove(listener);
    }
  }

  public void onAttach(Activity activity) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M && attachListeners != null) {
      emitListener1(attachListeners, activity);
    }
  }

  public void onAttach(Context context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && attachListeners != null) {
      emitListener1(attachListeners, context);
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onCreate

  @Override public void addCreateListener(Listener1<Bundle> listener) {
    if (createListeners == null) {
      createListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    createListeners.add(listener);
  }

  @Override public void removeCreateListener(Listener1<Bundle> listener) {
    if (createListeners != null) {
      createListeners.remove(listener);
    }
  }

  public void onCreate(Bundle savedInstanceState) {
    if (createListeners != null) {
      emitListener1(createListeners, savedInstanceState);
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onCreateView

  @Override public void addCreateViewListener(Listener1<Bundle> listener) {
    if (createViewListeners == null) {
      createViewListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    createViewListeners.add(listener);
  }

  @Override public void removeCreateViewListener(Listener1<Bundle> listener) {
    if (createViewListeners != null) {
      createViewListeners.remove(listener);
    }
  }

  public void onCreateView(Bundle savedInstanceState) {
    if (createViewListeners != null) {
      emitListener1(createViewListeners, savedInstanceState);
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onActivityCreated

  @Override public void addActivityCreatedListener(Listener1<Bundle> listener) {
    if (activityCreatedListeners == null) {
      activityCreatedListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    activityCreatedListeners.add(listener);
  }

  @Override public void removeActivityCreatedListener(Listener1<Bundle> listener) {
    if (activityCreatedListeners != null) {
      activityCreatedListeners.remove(listener);
    }
  }

  public void onActivityCreated(Bundle savedInstanceState) {
    if (activityCreatedListeners != null) {
      emitListener1(activityCreatedListeners, savedInstanceState);
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onViewStateRestored

  @Override public void addViewStateRestoredListener(Listener1<Bundle> listener) {
    if (viewStateRestoredListeners == null) {
      viewStateRestoredListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    viewStateRestoredListeners.add(listener);
  }

  @Override public void removeViewStateRestoredListener(Listener1<Bundle> listener) {
    if (viewStateRestoredListeners != null) {
      viewStateRestoredListeners.remove(listener);
    }
  }

  public void onViewStateRestored(Bundle savedInstanceState) {
    if (viewStateRestoredListeners != null) {
      emitListener1(viewStateRestoredListeners, savedInstanceState);
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
  // onDestroyView

  @Override public void addDestroyViewListener(Listener0 listener) {
    if (destroyViewListeners == null) {
      destroyViewListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    destroyViewListeners.add(listener);
  }

  @Override public void removeDestroyViewListener(Listener0 listener) {
    if (destroyViewListeners != null) {
      destroyViewListeners.remove(listener);
    }
  }

  public void onDestroyView() {
    if (destroyViewListeners != null) {
      emitListener0(destroyViewListeners);
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
  // onDetach

  @Override public void addDetachListener(Listener0 listener) {
    if (detachListeners == null) {
      detachListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    detachListeners.add(listener);
  }

  @Override public void removeDetachListener(Listener0 listener) {
    if (detachListeners != null) {
      detachListeners.remove(listener);
    }
  }

  public void onDetach() {
    if (detachListeners != null) {
      emitListener0(detachListeners);
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onSaveInstanceState

  @Override public void addSaveInstanceStateListener(Listener1<Bundle> listener) {
    if (saveInstanceStateListeners == null) {
      saveInstanceStateListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    saveInstanceStateListeners.add(listener);
  }

  @Override public void removeSaveInstanceStateListener(Listener1<Bundle> listener) {
    if (saveInstanceStateListeners != null) {
      saveInstanceStateListeners.remove(listener);
    }
  }

  public void onSaveInstanceState(Bundle outState) {
    if (saveInstanceStateListeners != null) {
      emitListener1(saveInstanceStateListeners, outState);
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
}
