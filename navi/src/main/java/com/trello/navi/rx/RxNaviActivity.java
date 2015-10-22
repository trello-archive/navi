package com.trello.navi.rx;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import com.trello.navi.Listener0;
import com.trello.navi.Listener1;
import com.trello.navi.NaviActivity;
import com.trello.navi.model.ActivityResult;
import com.trello.navi.model.BundleBundle;
import com.trello.navi.model.PermissionsRequestResult;
import rx.Observable;

public final class RxNaviActivity {

  @CheckResult @NonNull
  public static Observable<BundleBundle> creating(@NonNull final NaviActivity naviActivity) {
    return Observable.create(new OnSubscribe1<>(new OnSubscribe1.Implementation<BundleBundle>() {
      @Override public void subscribe(Listener1<BundleBundle> listener) {
        naviActivity.addCreateListener(listener);
      }

      @Override public void unsubscribe(Listener1<BundleBundle> listener) {
        naviActivity.removeCreateListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Object> starting(@NonNull final NaviActivity naviActivity) {
    return Observable.create(new UnitOnSubscribe(new UnitOnSubscribe.Implementation() {
      @Override public void subscribe(Listener0 listener) {
        naviActivity.addStartListener(listener);
      }

      @Override public void unsubscribe(Listener0 listener) {
        naviActivity.removeStartListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Object> resuming(@NonNull final NaviActivity naviActivity) {
    return Observable.create(new UnitOnSubscribe(new UnitOnSubscribe.Implementation() {
      @Override public void subscribe(Listener0 listener) {
        naviActivity.addResumeListener(listener);
      }

      @Override public void unsubscribe(Listener0 listener) {
        naviActivity.removeResumeListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Object> pausing(@NonNull final NaviActivity naviActivity) {
    return Observable.create(new UnitOnSubscribe(new UnitOnSubscribe.Implementation() {
      @Override public void subscribe(Listener0 listener) {
        naviActivity.addPauseListener(listener);
      }

      @Override public void unsubscribe(Listener0 listener) {
        naviActivity.removePauseListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Object> stopping(@NonNull final NaviActivity naviActivity) {
    return Observable.create(new UnitOnSubscribe(new UnitOnSubscribe.Implementation() {
      @Override public void subscribe(Listener0 listener) {
        naviActivity.addStopListener(listener);
      }

      @Override public void unsubscribe(Listener0 listener) {
        naviActivity.removeStopListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Object> destroying(@NonNull final NaviActivity naviActivity) {
    return Observable.create(new UnitOnSubscribe(new UnitOnSubscribe.Implementation() {
      @Override public void subscribe(Listener0 listener) {
        naviActivity.addDestroyListener(listener);
      }

      @Override public void unsubscribe(Listener0 listener) {
        naviActivity.removeDestroyListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Object> restarting(@NonNull final NaviActivity naviActivity) {
    return Observable.create(new UnitOnSubscribe(new UnitOnSubscribe.Implementation() {
      @Override public void subscribe(Listener0 listener) {
        naviActivity.addRestartListener(listener);
      }

      @Override public void unsubscribe(Listener0 listener) {
        naviActivity.removeRestartListener(listener);
      }
    }));
  }

  @CheckResult @NonNull public static Observable<BundleBundle> savingInstanceState(
      @NonNull final NaviActivity naviActivity) {
    return Observable.create(new OnSubscribe1<>(new OnSubscribe1.Implementation<BundleBundle>() {
      @Override public void subscribe(Listener1<BundleBundle> listener) {
        naviActivity.addSaveInstanceStateListener(listener);
      }

      @Override public void unsubscribe(Listener1<BundleBundle> listener) {
        naviActivity.removeSaveInstanceStateListener(listener);
      }
    }));
  }

  @CheckResult @NonNull public static Observable<BundleBundle> restoringInstanceState(
      @NonNull final NaviActivity naviActivity) {
    return Observable.create(new OnSubscribe1<>(new OnSubscribe1.Implementation<BundleBundle>() {
      @Override public void subscribe(Listener1<BundleBundle> listener) {
        naviActivity.addRestoreInstanceStateListener(listener);
      }

      @Override public void unsubscribe(Listener1<BundleBundle> listener) {
        naviActivity.removeRestoreInstanceStateListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Intent> newIntent(@NonNull final NaviActivity naviActivity) {
    return Observable.create(new OnSubscribe1<>(new OnSubscribe1.Implementation<Intent>() {
      @Override public void subscribe(Listener1<Intent> listener) {
        naviActivity.addNewIntentListener(listener);
      }

      @Override public void unsubscribe(Listener1<Intent> listener) {
        naviActivity.removeNewIntentListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Object> backPresses(@NonNull final NaviActivity naviActivity) {
    return Observable.create(new UnitOnSubscribe(new UnitOnSubscribe.Implementation() {
      @Override public void subscribe(Listener0 listener) {
        naviActivity.addBackPressedListener(listener);
      }

      @Override public void unsubscribe(Listener0 listener) {
        naviActivity.removeBackPressedListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Object> windowAttaching(@NonNull final NaviActivity naviActivity) {
    return Observable.create(new UnitOnSubscribe(new UnitOnSubscribe.Implementation() {
      @Override public void subscribe(Listener0 listener) {
        naviActivity.addAttachedToWindowListener(listener);
      }

      @Override public void unsubscribe(Listener0 listener) {
        naviActivity.removeAttachedToWindowListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<Object> windowDetaching(@NonNull final NaviActivity naviActivity) {
    return Observable.create(new UnitOnSubscribe(new UnitOnSubscribe.Implementation() {
      @Override public void subscribe(Listener0 listener) {
        naviActivity.addDetachedFromWindowListener(listener);
      }

      @Override public void unsubscribe(Listener0 listener) {
        naviActivity.removeDetachedFromWindowListener(listener);
      }
    }));
  }

  @CheckResult @NonNull public static Observable<Configuration> configurationChanging(
      @NonNull final NaviActivity naviActivity) {
    return Observable.create(new OnSubscribe1<>(new OnSubscribe1.Implementation<Configuration>() {
      @Override public void subscribe(Listener1<Configuration> listener) {
        naviActivity.addConfigurationChangedListener(listener);
      }

      @Override public void unsubscribe(Listener1<Configuration> listener) {
        naviActivity.removeConfigurationChangedListener(listener);
      }
    }));
  }

  @CheckResult @NonNull public static Observable<ActivityResult> activityResults(
      @NonNull final NaviActivity naviActivity) {
    return Observable.create(new OnSubscribe1<>(new OnSubscribe1.Implementation<ActivityResult>() {
      @Override public void subscribe(Listener1<ActivityResult> listener) {
        naviActivity.addActivityResultListener(listener);
      }

      @Override public void unsubscribe(Listener1<ActivityResult> listener) {
        naviActivity.removeActivityResultListener(listener);
      }
    }));
  }

  @CheckResult @NonNull
  public static Observable<PermissionsRequestResult> permissionsRequestResults(
      @NonNull final NaviActivity naviActivity) {
    return Observable.create(
        new OnSubscribe1<>(new OnSubscribe1.Implementation<PermissionsRequestResult>() {
          @Override public void subscribe(Listener1<PermissionsRequestResult> listener) {
            naviActivity.addPermissionsRequestResultListener(listener);
          }

          @Override public void unsubscribe(Listener1<PermissionsRequestResult> listener) {
            naviActivity.removePermissionsRequestResultListener(listener);
          }
        }));
  }

  private RxNaviActivity() {
    throw new AssertionError("No instances!");
  }
}
