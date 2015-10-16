package com.trello.navi.sample.delegate;

import android.support.annotation.Nullable;
import android.util.Log;
import com.trello.navi.internal.NaviActivityDelegate;
import com.trello.navi.model.BundleBundle;

public class AnotherLibraryDelegate extends NaviActivityDelegate {
  private static final String TAG = AnotherLibraryDelegate.class.getSimpleName();

  @Override public void onCreate(@Nullable BundleBundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (savedInstanceState != null) Log.v(TAG, "I've got created");
  }

  @Override public void onResume() {
    super.onResume();
    Log.v(TAG, "I'm running");
  }

  @Override public void onPause() {
    super.onPause();
    Log.v(TAG, "I've got paused");
  }
}
