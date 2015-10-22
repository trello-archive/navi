package com.trello.navi.component.support;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import com.trello.navi.Listener0;
import com.trello.navi.Listener1;
import com.trello.navi.NaviActivity;
import com.trello.navi.internal.BaseNaviActivity;
import com.trello.navi.model.ActivityResult;
import com.trello.navi.model.BundleBundle;
import com.trello.navi.model.RequestPermissionsResult;

public abstract class AbstractNaviActivity extends AppCompatActivity implements NaviActivity {

  private final BaseNaviActivity base = new BaseNaviActivity();

  ////////////////////////////////////////////////////////////////////////////
  // onCreate

  @Override public void addCreateListener(Listener1<BundleBundle> listener) {
    base.addCreateListener(listener);
  }

  @Override public void removeCreateListener(Listener1<BundleBundle> listener) {
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

  @Override public void addStartListener(Listener0 listener) {
    base.addStartListener(listener);
  }

  @Override public void removeStartListener(Listener0 listener) {
    base.removeStartListener(listener);
  }

  @Override protected void onStart() {
    super.onStart();
    base.onStart();
  }

  ////////////////////////////////////////////////////////////////////////////
  // onResume

  @Override public void addResumeListener(Listener0 listener) {
    base.addResumeListener(listener);
  }

  @Override public void removeResumeListener(Listener0 listener) {
    base.removeResumeListener(listener);
  }

  @Override protected void onResume() {
    super.onResume();
    base.onResume();
  }

  ////////////////////////////////////////////////////////////////////////////
  // onPause

  @Override public void addPauseListener(Listener0 listener) {
    base.addPauseListener(listener);
  }

  @Override public void removePauseListener(Listener0 listener) {
    base.removePauseListener(listener);
  }

  @Override protected void onPause() {
    super.onPause();
    base.onPause();
  }

  ////////////////////////////////////////////////////////////////////////////
  // onStop

  @Override public void addStopListener(Listener0 listener) {
    base.addStopListener(listener);
  }

  @Override public void removeStopListener(Listener0 listener) {
    base.removeStopListener(listener);
  }

  @Override protected void onStop() {
    super.onStop();
    base.onStop();
  }

  ////////////////////////////////////////////////////////////////////////////
  // onDestroy

  @Override public void addDestroyListener(Listener0 listener) {
    base.addDestroyListener(listener);
  }

  @Override public void removeDestroyListener(Listener0 listener) {
    base.removeDestroyListener(listener);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    base.onDestroy();
  }

  ////////////////////////////////////////////////////////////////////////////
  // onRestart

  @Override public void addRestartListener(Listener0 listener) {
    base.addRestartListener(listener);
  }

  @Override public void removeRestartListener(Listener0 listener) {
    base.removeRestartListener(listener);
  }

  @Override protected void onRestart() {
    super.onRestart();
    base.onRestart();
  }

  ////////////////////////////////////////////////////////////////////////////
  // onSaveInstanceState

  @Override public void addSaveInstanceStateListener(Listener1<BundleBundle> listener) {
    base.addSaveInstanceStateListener(listener);
  }

  @Override public void removeSaveInstanceStateListener(Listener1<BundleBundle> listener) {
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

  @Override public void addRestoreInstanceStateListener(Listener1<BundleBundle> listener) {
    base.addRestoreInstanceStateListener(listener);
  }

  @Override public void removeRestoreInstanceStateListener(Listener1<BundleBundle> listener) {
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

  ////////////////////////////////////////////////////////////////////////////
  // onNewIntent

  @Override public void addNewIntentListener(Listener1<Intent> listener) {
    base.addNewIntentListener(listener);
  }

  @Override public void removeNewIntentListener(Listener1<Intent> listener) {
    base.removeNewIntentListener(listener);
  }

  @Override protected void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
    base.onNewIntent(intent);
  }

  ////////////////////////////////////////////////////////////////////////////
  // onBackPressed

  @Override public void addBackPressedListener(Listener0 listener) {
    base.addBackPressedListener(listener);
  }

  @Override public void removeBackPressedListener(Listener0 listener) {
    base.removeBackPressedListener(listener);
  }

  @Override public void onBackPressed() {
    super.onBackPressed();
    base.onBackPressed();
  }

  ////////////////////////////////////////////////////////////////////////////
  // onAttachedToWindow

  @Override public void addAttachedToWindowListener(Listener0 listener0) {
    base.addAttachedToWindowListener(listener0);
  }

  @Override public void removeAttachedToWindowListener(Listener0 listener0) {
    base.removeAttachedToWindowListener(listener0);
  }

  @Override public void onAttachedToWindow() {
    super.onAttachedToWindow();
    base.onAttachedToWindow();
  }

  ////////////////////////////////////////////////////////////////////////////
  // onDetachedFromWindow

  @Override public void addDetachedFromWindowListener(Listener0 listener) {
    base.addDetachedFromWindowListener(listener);
  }

  @Override public void removeDetachedFromWindowListener(Listener0 listener) {
    base.removeDetachedFromWindowListener(listener);
  }

  @Override public void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    base.onDetachedFromWindow();
  }

  ////////////////////////////////////////////////////////////////////////////
  // onConfigurationChanged

  @Override public void addConfigurationChangedListener(Listener1<Configuration> listener) {
    base.addConfigurationChangedListener(listener);
  }

  @Override public void removeConfigurationChangedListener(Listener1<Configuration> listener) {
    base.removeConfigurationChangedListener(listener);
  }

  @Override public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    base.onConfigurationChanged(newConfig);
  }

  ////////////////////////////////////////////////////////////////////////////
  // onActivityResult

  @Override public void addActivityResultListener(Listener1<ActivityResult> listener) {
    base.addActivityResultListener(listener);
  }

  @Override public void removeActivityResultListener(Listener1<ActivityResult> listener) {
    base.removeActivityResultListener(listener);
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    base.onActivityResult(requestCode, resultCode, data);
  }

  ////////////////////////////////////////////////////////////////////////////
  // onRequestPermissionsResult

  @Override
  public void addRequestPermissionsResultListener(Listener1<RequestPermissionsResult> listener) {
    base.addRequestPermissionsResultListener(listener);
  }

  @Override
  public void removeRequestPermissionsResultListener(Listener1<RequestPermissionsResult> listener) {
    base.removeRequestPermissionsResultListener(listener);
  }

  @Override public void onRequestPermissionsResult(int requestCode, String[] permissions,
      int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    base.onRequestPermissionsResult(requestCode, permissions, grantResults);
  }
}
