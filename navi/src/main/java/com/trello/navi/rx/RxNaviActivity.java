package com.trello.navi.rx;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import com.trello.navi.NaviActivity;
import com.trello.navi.model.BundleBundle;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

public final class RxNaviActivity {

  @CheckResult @NonNull
  public static Observable<BundleBundle> creating(@NonNull final NaviActivity naviActivity) {
    return Observable.create(new OnSubscribe1<>(new OnSubscribe1.Implementation<BundleBundle>() {
      @Override public void subscribe(Action1<BundleBundle> listener) {
        naviActivity.addCreateListener(listener);
      }

      @Override public void unsubscribe(Action1<BundleBundle> listener) {
        naviActivity.removeCreateListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Object> starting(@NonNull final NaviActivity naviActivity) {
    return Observable.create(new UnitOnSubscribe(new UnitOnSubscribe.Implementation() {
      @Override public void subscribe(Action0 listener) {
        naviActivity.addStartListener(listener);
      }

      @Override public void unsubscribe(Action0 listener) {
        naviActivity.removeStartListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Object> resuming(@NonNull final NaviActivity naviActivity) {
    return Observable.create(new UnitOnSubscribe(new UnitOnSubscribe.Implementation() {
      @Override public void subscribe(Action0 listener) {
        naviActivity.addResumeListener(listener);
      }

      @Override public void unsubscribe(Action0 listener) {
        naviActivity.removeResumeListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Object> pausing(@NonNull final NaviActivity naviActivity) {
    return Observable.create(new UnitOnSubscribe(new UnitOnSubscribe.Implementation() {
      @Override public void subscribe(Action0 listener) {
        naviActivity.addPauseListener(listener);
      }

      @Override public void unsubscribe(Action0 listener) {
        naviActivity.removePauseListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Object> stopping(@NonNull final NaviActivity naviActivity) {
    return Observable.create(new UnitOnSubscribe(new UnitOnSubscribe.Implementation() {
      @Override public void subscribe(Action0 listener) {
        naviActivity.addStopListener(listener);
      }

      @Override public void unsubscribe(Action0 listener) {
        naviActivity.removeStopListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Object> destroying(@NonNull final NaviActivity naviActivity) {
    return Observable.create(new UnitOnSubscribe(new UnitOnSubscribe.Implementation() {
      @Override public void subscribe(Action0 listener) {
        naviActivity.addDestroyListener(listener);
      }

      @Override public void unsubscribe(Action0 listener) {
        naviActivity.removeDestroyListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Object> restarting(@NonNull final NaviActivity naviActivity) {
    return Observable.create(new UnitOnSubscribe(new UnitOnSubscribe.Implementation() {
      @Override public void subscribe(Action0 listener) {
        naviActivity.addRestartListener(listener);
      }

      @Override public void unsubscribe(Action0 listener) {
        naviActivity.removeRestartListener(listener);
      }
    }));
  }

  @CheckResult @NonNull public static Observable<BundleBundle> savingInstanceState(
      @NonNull final NaviActivity naviActivity) {
    return Observable.create(new OnSubscribe1<>(new OnSubscribe1.Implementation<BundleBundle>() {
      @Override public void subscribe(Action1<BundleBundle> listener) {
        naviActivity.addSaveInstanceStateListener(listener);
      }

      @Override public void unsubscribe(Action1<BundleBundle> listener) {
        naviActivity.removeSaveInstanceStateListener(listener);
      }
    }));
  }

  @CheckResult @NonNull public static Observable<BundleBundle> restoringInstanceState(
      @NonNull final NaviActivity naviActivity) {
    return Observable.create(new OnSubscribe1<>(new OnSubscribe1.Implementation<BundleBundle>() {
      @Override public void subscribe(Action1<BundleBundle> listener) {
        naviActivity.addRestoreInstanceStateListener(listener);
      }

      @Override public void unsubscribe(Action1<BundleBundle> listener) {
        naviActivity.removeRestoreInstanceStateListener(listener);
      }
    }));
  }

  private RxNaviActivity() {
    throw new AssertionError("No instances!");
  }
}
