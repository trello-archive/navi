package com.trello.navi.rx;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import com.trello.navi.Event;
import com.trello.navi.NaviComponent;
import rx.Observable;

public final class RxNavi {

  @CheckResult @NonNull
  public static <T> Observable<T> observe(@NonNull NaviComponent component, @NonNull Event<T> event) {
    return Observable.create(new NaviOnSubscribe<T>(component, event));
  }

  private RxNavi() {
    throw new AssertionError("No instances!");
  }
}
