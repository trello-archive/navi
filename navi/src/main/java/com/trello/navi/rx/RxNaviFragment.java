package com.trello.navi.rx;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import com.trello.navi.NaviFragment;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

public final class RxNaviFragment {

  @CheckResult @NonNull
  public static Observable<Context> attaching(@NonNull final NaviFragment naviFragment) {
    return Observable.create(new OnSubscribe1<>(new OnSubscribe1.Implementation<Context>() {
      @Override public void subscribe(Action1<Context> listener) {
        naviFragment.addAttachListener(listener);
      }

      @Override public void unsubscribe(Action1<Context> listener) {
        naviFragment.removeAttachListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Bundle> creating(@NonNull final NaviFragment naviFragment) {
    return Observable.create(new OnSubscribe1<>(new OnSubscribe1.Implementation<Bundle>() {
      @Override public void subscribe(Action1<Bundle> listener) {
        naviFragment.addCreateListener(listener);
      }

      @Override public void unsubscribe(Action1<Bundle> listener) {
        naviFragment.removeCreateListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Bundle> creatingView(@NonNull final NaviFragment naviFragment) {
    return Observable.create(new OnSubscribe1<>(new OnSubscribe1.Implementation<Bundle>() {
      @Override public void subscribe(Action1<Bundle> listener) {
        naviFragment.addCreateViewListener(listener);
      }

      @Override public void unsubscribe(Action1<Bundle> listener) {
        naviFragment.removeCreateViewListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Bundle> activityCreated(@NonNull final NaviFragment naviFragment) {
    return Observable.create(new OnSubscribe1<>(new OnSubscribe1.Implementation<Bundle>() {
      @Override public void subscribe(Action1<Bundle> listener) {
        naviFragment.addActivityCreatedListener(listener);
      }

      @Override public void unsubscribe(Action1<Bundle> listener) {
        naviFragment.removeActivityCreatedListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Bundle> viewStateRestored(@NonNull final NaviFragment naviFragment) {
    return Observable.create(new OnSubscribe1<>(new OnSubscribe1.Implementation<Bundle>() {
      @Override public void subscribe(Action1<Bundle> listener) {
        naviFragment.addViewStateRestoredListener(listener);
      }

      @Override public void unsubscribe(Action1<Bundle> listener) {
        naviFragment.removeViewStateRestoredListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Object> starting(@NonNull final NaviFragment naviFragment) {
    return Observable.create(new UnitOnSubscribe(new UnitOnSubscribe.Implementation() {
      @Override public void subscribe(Action0 listener) {
        naviFragment.addStartListener(listener);
      }

      @Override public void unsubscribe(Action0 listener) {
        naviFragment.removeStartListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Object> resuming(@NonNull final NaviFragment naviFragment) {
    return Observable.create(new UnitOnSubscribe(new UnitOnSubscribe.Implementation() {
      @Override public void subscribe(Action0 listener) {
        naviFragment.addResumeListener(listener);
      }

      @Override public void unsubscribe(Action0 listener) {
        naviFragment.removeResumeListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Object> pausing(@NonNull final NaviFragment naviFragment) {
    return Observable.create(new UnitOnSubscribe(new UnitOnSubscribe.Implementation() {
      @Override public void subscribe(Action0 listener) {
        naviFragment.addPauseListener(listener);
      }

      @Override public void unsubscribe(Action0 listener) {
        naviFragment.removePauseListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Object> stopping(@NonNull final NaviFragment naviFragment) {
    return Observable.create(new UnitOnSubscribe(new UnitOnSubscribe.Implementation() {
      @Override public void subscribe(Action0 listener) {
        naviFragment.addStopListener(listener);
      }

      @Override public void unsubscribe(Action0 listener) {
        naviFragment.removeStopListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Object> destroyingView(@NonNull final NaviFragment naviFragment) {
    return Observable.create(new UnitOnSubscribe(new UnitOnSubscribe.Implementation() {
      @Override public void subscribe(Action0 listener) {
        naviFragment.addDestroyViewListener(listener);
      }

      @Override public void unsubscribe(Action0 listener) {
        naviFragment.removeDestroyViewListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Object> destroying(@NonNull final NaviFragment naviFragment) {
    return Observable.create(new UnitOnSubscribe(new UnitOnSubscribe.Implementation() {
      @Override public void subscribe(Action0 listener) {
        naviFragment.addDestroyListener(listener);
      }

      @Override public void unsubscribe(Action0 listener) {
        naviFragment.removeDestroyListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Object> detaching(@NonNull final NaviFragment naviFragment) {
    return Observable.create(new UnitOnSubscribe(new UnitOnSubscribe.Implementation() {
      @Override public void subscribe(Action0 listener) {
        naviFragment.addDetachListener(listener);
      }

      @Override public void unsubscribe(Action0 listener) {
        naviFragment.removeDetachListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Bundle> savingInstanceState(@NonNull final NaviFragment naviFragment) {
    return Observable.create(new OnSubscribe1<>(new OnSubscribe1.Implementation<Bundle>() {
      @Override public void subscribe(Action1<Bundle> listener) {
        naviFragment.addSaveInstanceStateListener(listener);
      }

      @Override public void unsubscribe(Action1<Bundle> listener) {
        naviFragment.removeSaveInstanceStateListener(listener);
      }
    }));
  }

  private RxNaviFragment() {
    throw new AssertionError("No instances!");
  }
}
