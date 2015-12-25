package com.trello.navi.component;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.trello.navi.Event;
import com.trello.navi.Listener;
import com.trello.navi.NaviComponent;
import com.trello.navi.internal.NaviEmitter;
import com.trello.navi.internal.NaviPlugin;

public class NaviDialogFragment extends DialogFragment implements NaviComponent {

  private final NaviEmitter base = NaviEmitter.createFragmentEmitter();

  @Override public boolean handlesEvents(Event... events) {
    return base.handlesEvents(events);
  }

  @Override public <T> void addListener(Event<T> event, Listener<T> listener) {
    base.addListener(event, listener);
  }

  @Override public <T> void removeListener(Event<T> event, Listener<T> listener) {
    base.removeListener(event, listener);
  }

  @Override public void addPlugin(NaviPlugin plugin) {
    base.addPlugin(plugin);
  }

  @Override public void removePlugin(NaviPlugin plugin) {
    base.removePlugin(plugin);
  }

  @Override public void onAttach(Activity activity) {
    super.onAttach(activity);
    base.onAttach(activity);
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    base.onAttach(context);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    base.onCreate(savedInstanceState);
  }

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    base.onCreateView(savedInstanceState);
    return super.onCreateView(inflater, container, savedInstanceState);
  }

  @Override public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    base.onActivityCreated(savedInstanceState);
  }

  @Override public void onViewStateRestored(Bundle savedInstanceState) {
    super.onViewStateRestored(savedInstanceState);
    base.onViewStateRestored(savedInstanceState);
  }

  @Override public void onStart() {
    super.onStart();
    base.onStart();
  }

  @Override public void onResume() {
    super.onResume();
    base.onResume();
  }

  @Override public void onPause() {
    super.onPause();
    base.onPause();
  }

  @Override public void onStop() {
    super.onStop();
    base.onStop();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    base.onDestroyView();
  }

  @Override public void onDestroy() {
    super.onDestroy();
    base.onDestroy();
  }

  @Override public void onDetach() {
    super.onDetach();
    base.onDetach();
  }

  @Override public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    base.onSaveInstanceState(outState);
  }

  @Override public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    base.onConfigurationChanged(newConfig);
  }

  @Override public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    base.onActivityResult(requestCode, resultCode, data);
  }

  @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    base.onRequestPermissionsResult(requestCode, permissions, grantResults);
  }
}
