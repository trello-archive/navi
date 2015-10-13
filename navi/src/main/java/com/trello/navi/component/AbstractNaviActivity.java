package com.trello.navi.component;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import com.trello.navi.NaviActivity;
import com.trello.navi.internal.BaseNaviActivity;
import com.trello.navi.model.BundleBundle;
import rx.functions.Action0;
import rx.functions.Action1;

public abstract class AbstractNaviActivity extends Activity implements NaviActivity {

  private final BaseNaviActivity base = new BaseNaviActivity();

  ////////////////////////////////////////////////////////////////////////////
  // onCreate

  @Override public void addCreateListener(Action1<BundleBundle> listener) {
    base.addCreateListener(listener);
  }

  @Override public void removeCreateListener(Action1<BundleBundle> listener) {
    base.removeCreateListener(listener);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    base.onCreate(savedInstanceState);
  }

  @Override public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
    super.onCreate(savedInstanceState, persistentState);
    base.onCreate(savedInstanceState, persistentState);
  }

  ////////////////////////////////////////////////////////////////////////////
  // onStart

  @Override public void addStartListener(Action0 listener) {
    base.addStartListener(listener);
  }

  @Override public void removeStartListener(Action0 listener) {
    base.removeStartListener(listener);
  }

  @Override protected void onStart() {
    super.onStart();
    base.onStart();
  }

  ////////////////////////////////////////////////////////////////////////////
  // onResume

  @Override public void addResumeListener(Action0 listener) {
    base.addResumeListener(listener);
  }

  @Override public void removeResumeListener(Action0 listener) {
    base.removeResumeListener(listener);
  }

  @Override protected void onResume() {
    super.onResume();
    base.onResume();
  }

  ////////////////////////////////////////////////////////////////////////////
  // onPause

  @Override public void addPauseListener(Action0 listener) {
    base.addPauseListener(listener);
  }

  @Override public void removePauseListener(Action0 listener) {
    base.removePauseListener(listener);
  }

  @Override protected void onPause() {
    super.onPause();
    base.onPause();
  }

  ////////////////////////////////////////////////////////////////////////////
  // onStop

  @Override public void addStopListener(Action0 listener) {
    base.addStopListener(listener);
  }

  @Override public void removeStopListener(Action0 listener) {
    base.removeStopListener(listener);
  }

  @Override protected void onStop() {
    super.onStop();
    base.onStop();
  }

  ////////////////////////////////////////////////////////////////////////////
  // onDestroy

  @Override public void addDestroyListener(Action0 listener) {
    base.addDestroyListener(listener);
  }

  @Override public void removeDestroyListener(Action0 listener) {
    base.removeDestroyListener(listener);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    base.onDestroy();
  }

  ////////////////////////////////////////////////////////////////////////////
  // onRestart

  @Override public void addRestartListener(Action0 listener) {
    base.addRestartListener(listener);
  }

  @Override public void removeRestartListener(Action0 listener) {
    base.removeRestartListener(listener);
  }

  @Override protected void onRestart() {
    super.onRestart();
    base.onRestart();
  }

  ////////////////////////////////////////////////////////////////////////////
  // onSaveInstanceState

  @Override public void addSaveInstanceStateListener(Action1<BundleBundle> listener) {
    base.addSaveInstanceStateListener(listener);
  }

  @Override public void removeSaveInstanceStateListener(Action1<BundleBundle> listener) {
    base.removeSaveInstanceStateListener(listener);
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    base.onSaveInstanceState(outState);
  }

  @Override public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    super.onSaveInstanceState(outState, outPersistentState);
    base.onSaveInstanceState(outState, outPersistentState);
  }

  ////////////////////////////////////////////////////////////////////////////
  // onRestoreInstanceState

  @Override public void addRestoreInstanceStateListener(Action1<BundleBundle> listener) {
    base.addRestoreInstanceStateListener(listener);
  }

  @Override public void removeRestoreInstanceStateListener(Action1<BundleBundle> listener) {
    base.removeRestoreInstanceStateListener(listener);
  }

  @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    base.onRestoreInstanceState(savedInstanceState);
  }

  @Override
  public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
    super.onRestoreInstanceState(savedInstanceState, persistentState);
    base.onRestoreInstanceState(savedInstanceState, persistentState);
  }
}
