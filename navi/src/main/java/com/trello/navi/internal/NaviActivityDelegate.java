package com.trello.navi.internal;

import android.support.annotation.Nullable;
import com.trello.navi.model.BundleBundle;

/**
 * Forwards multiple Activity lifecycle methods. Useful for libraries requiring multiple lifecycle
 * events
 */
public class NaviActivityDelegate {

  public void onCreate(@Nullable BundleBundle savedInstanceState) {

  }

  public void onRestoreInstanceState(BundleBundle savedInstanceState) {

  }

  public void onStart() {

  }

  public void onRestart() {

  }

  public void onResume() {
  }

  public void onSaveInstanceState(BundleBundle outState) {
  }

  public void onPause() {

  }

  public void onStop() {

  }

  public void onDestroy() {

  }
}
