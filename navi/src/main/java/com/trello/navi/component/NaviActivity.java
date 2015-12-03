package com.trello.navi.component;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import com.trello.navi.Event;
import com.trello.navi.Listener;
import com.trello.navi.NaviComponent;
import com.trello.navi.internal.NaviEmitter;

public class NaviActivity extends Activity implements NaviComponent {

  private final NaviEmitter base = NaviEmitter.createActivityEmitter();

  @Override public boolean handlesEvents(Event... events) {
    return base.handlesEvents(events);
  }

  @Override public <T> void addListener(Event<T> event, Listener<T> listener) {
    base.addListener(event, listener);
  }

  @Override public <T> void removeListener(Event<T> event, Listener<T> listener) {
    base.removeListener(event, listener);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    base.onCreate(savedInstanceState);
  }

  @Override public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
    super.onCreate(savedInstanceState, persistentState);
    base.onCreate(savedInstanceState, persistentState);
  }

  @Override protected void onStart() {
    super.onStart();
    base.onStart();
  }

  @Override protected void onResume() {
    super.onResume();
    base.onResume();
  }

  @Override protected void onPause() {
    super.onPause();
    base.onPause();
  }

  @Override protected void onStop() {
    super.onStop();
    base.onStop();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    base.onDestroy();
  }

  @Override protected void onRestart() {
    super.onRestart();
    base.onRestart();
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    base.onSaveInstanceState(outState);
  }

  @Override public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    super.onSaveInstanceState(outState, outPersistentState);
    base.onSaveInstanceState(outState, outPersistentState);
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

  @Override protected void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
    base.onNewIntent(intent);
  }

  @Override public void onBackPressed() {
    super.onBackPressed();
    base.onBackPressed();
  }

  @Override public void onAttachedToWindow() {
    super.onAttachedToWindow();
    base.onAttachedToWindow();
  }

  @Override public void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    base.onDetachedFromWindow();
  }

  @Override public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    base.onConfigurationChanged(newConfig);
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    base.onActivityResult(requestCode, resultCode, data);
  }

  @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    base.onRequestPermissionsResult(requestCode, permissions, grantResults);
  }
}
