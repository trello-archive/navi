package com.trello.navi.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.trello.navi.NaviFragment;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action0;
import rx.functions.Action1;

import static com.trello.navi.internal.Emitters.emitAction0;
import static com.trello.navi.internal.Emitters.emitAction1;

/**
 * Base helper which contains all the actual logic
 *
 * This makes it easier to port {@link NaviFragment} to other Fragments
 * without duplicating quite as much code.
 */
public final class BaseNaviFragment implements NaviFragment {

  private List<Action1<Context>> attachListeners;
  private List<Action1<Bundle>> createListeners;
  private List<Action1<Bundle>> createViewListeners;
  private List<Action1<Bundle>> activityCreatedListeners;
  private List<Action1<Bundle>> viewStateRestoredListeners;
  private List<Action0> startListeners;
  private List<Action0> resumeListeners;
  private List<Action0> pauseListeners;
  private List<Action0> stopListeners;
  private List<Action0> destroyViewListeners;
  private List<Action0> destroyListeners;
  private List<Action0> detachListeners;

  private List<Action1<Bundle>> saveInstanceStateListeners;

  ////////////////////////////////////////////////////////////////////////////
  // onAttach

  @Override public void addAttachListener(Action1<Context> listener) {
    if (attachListeners == null) {
      attachListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    attachListeners.add(listener);
  }

  @Override public void removeAttachListener(Action1<Context> listener) {
    if (attachListeners != null) {
      attachListeners.remove(listener);
    }
  }

  public void onAttach(Activity activity) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M && attachListeners != null) {
      emitAction1(attachListeners, activity);
    }
  }

  public void onAttach(Context context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && attachListeners != null) {
      emitAction1(attachListeners, context);
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onCreate

  @Override public void addCreateListener(Action1<Bundle> listener) {
    if (createListeners == null) {
      createListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    createListeners.add(listener);
  }

  @Override public void removeCreateListener(Action1<Bundle> listener) {
    if (createListeners != null) {
      createListeners.remove(listener);
    }
  }

  public void onCreate(Bundle savedInstanceState) {
    if (createListeners != null) {
      emitAction1(createListeners, savedInstanceState);
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onCreateView

  @Override public void addCreateViewListener(Action1<Bundle> listener) {
    if (createViewListeners == null) {
      createViewListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    createViewListeners.add(listener);
  }

  @Override public void removeCreateViewListener(Action1<Bundle> listener) {
    if (createViewListeners != null) {
      createViewListeners.remove(listener);
    }
  }

  public void onCreateView(Bundle savedInstanceState) {
    if (createViewListeners != null) {
      emitAction1(createViewListeners, savedInstanceState);
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onActivityCreated

  @Override public void addActivityCreatedListener(Action1<Bundle> listener) {
    if (activityCreatedListeners == null) {
      activityCreatedListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    activityCreatedListeners.add(listener);
  }

  @Override public void removeActivityCreatedListener(Action1<Bundle> listener) {
    if (activityCreatedListeners != null) {
      activityCreatedListeners.remove(listener);
    }
  }

  public void onActivityCreated(Bundle savedInstanceState) {
    if (activityCreatedListeners != null) {
      emitAction1(activityCreatedListeners, savedInstanceState);
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onViewStateRestored

  @Override public void addViewStateRestoredListener(Action1<Bundle> listener) {
    if (viewStateRestoredListeners == null) {
      viewStateRestoredListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    viewStateRestoredListeners.add(listener);
  }

  @Override public void removeViewStateRestoredListener(Action1<Bundle> listener) {
    if (viewStateRestoredListeners != null) {
      viewStateRestoredListeners.remove(listener);
    }
  }

  public void onViewStateRestored(Bundle savedInstanceState) {
    if (viewStateRestoredListeners != null) {
      emitAction1(viewStateRestoredListeners, savedInstanceState);
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
  }

  ////////////////////////////////////////////////////////////////////////////
  // onDestroyView

  @Override public void addDestroyViewListener(Action0 listener) {
    if (destroyViewListeners == null) {
      destroyViewListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    destroyViewListeners.add(listener);
  }

  @Override public void removeDestroyViewListener(Action0 listener) {
    if (destroyViewListeners != null) {
      destroyViewListeners.remove(listener);
    }
  }

  public void onDestroyView() {
    if (destroyViewListeners != null) {
      emitAction0(destroyViewListeners);
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
  }

  ////////////////////////////////////////////////////////////////////////////
  // onDetach

  @Override public void addDetachListener(Action0 listener) {
    if (detachListeners == null) {
      detachListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    detachListeners.add(listener);
  }

  @Override public void removeDetachListener(Action0 listener) {
    if (detachListeners != null) {
      detachListeners.remove(listener);
    }
  }

  public void onDetach() {
    if (detachListeners != null) {
      emitAction0(detachListeners);
    }
  }

  ////////////////////////////////////////////////////////////////////////////
  // onSaveInstanceState

  @Override public void addSaveInstanceStateListener(Action1<Bundle> listener) {
    if (saveInstanceStateListeners == null) {
      saveInstanceStateListeners = new ArrayList<>(Constants.DEFAULT_LIST_SIZE);
    }

    saveInstanceStateListeners.add(listener);
  }

  @Override public void removeSaveInstanceStateListener(Action1<Bundle> listener) {
    if (saveInstanceStateListeners != null) {
      saveInstanceStateListeners.remove(listener);
    }
  }

  public void onSaveInstanceState(Bundle outState) {
    if (saveInstanceStateListeners != null) {
      emitAction1(saveInstanceStateListeners, outState);
    }
  }
}
