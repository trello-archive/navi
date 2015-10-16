package com.trello.navi.sample.delegate;

import android.util.Log;
import com.trello.navi.internal.NaviActivityDelegate;

public class GpsLibraryDelegate extends NaviActivityDelegate {
  private static final String TAG = GpsLibraryDelegate.class.getSimpleName();

  @Override public void onResume() {
    super.onResume();
    Log.v(TAG, "starting GPS");
  }

  @Override public void onPause() {
    super.onPause();
    Log.v(TAG, "stopping GPS");
  }
}
