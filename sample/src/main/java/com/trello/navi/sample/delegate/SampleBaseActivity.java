package com.trello.navi.sample.delegate;

import android.os.Bundle;
import android.util.Log;
import com.trello.navi.component.support.AbstractNaviActivity;
import com.trello.navi.sample.R;

/**
 * Example how to add multiple delegates to an Activity.
 */
public class SampleBaseActivity extends AbstractNaviActivity {

  public SampleBaseActivity() {
    addDelegate(new AnotherLibraryDelegate());
    addDelegate(new GpsLibraryDelegate());
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
  }

  @Override protected void onStart() {
    super.onStart();
    Log.v(SampleBaseActivity.class.getSimpleName(), "started SampleBaseActivity");
  }
}
