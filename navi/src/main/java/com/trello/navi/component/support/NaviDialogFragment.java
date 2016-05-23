package com.trello.navi.component.support;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.trello.navi.Event;
import com.trello.navi.Listener;
import com.trello.navi.NaviComponent;
import com.trello.navi.internal.NaviEmitter;

public class NaviDialogFragment extends DialogFragment implements NaviComponent {

  private final NaviEmitter base = NaviEmitter.createFragmentEmitter();

  @Override public final boolean handlesEvents(Event... events) {
    return base.handlesEvents(events);
  }

  @Override public final <T> void addListener(Event<T> event, Listener<T> listener) {
    base.addListener(event, listener);
  }

  @Override public final <T> void removeListener(Listener<T> listener) {
    base.removeListener(listener);
  }

  @Override @CallSuper public void onAttach(Activity activity) {
    super.onAttach(activity);
    base.onAttach(activity);
  }

  @Override @CallSuper public void onAttach(Context context) {
    super.onAttach(context);
    base.onAttach(context);
  }

  @Override @CallSuper public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    base.onCreate(savedInstanceState);
  }

  @Nullable @Override @CallSuper public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    base.onCreateView(savedInstanceState);
    return super.onCreateView(inflater, container, savedInstanceState);
  }

  @Override @CallSuper public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    base.onActivityCreated(savedInstanceState);
  }

  @Override @CallSuper public void onViewStateRestored(Bundle savedInstanceState) {
    super.onViewStateRestored(savedInstanceState);
    base.onViewStateRestored(savedInstanceState);
  }

  @Override @CallSuper public void onStart() {
    super.onStart();
    base.onStart();
  }

  @Override @CallSuper public void onResume() {
    super.onResume();
    base.onResume();
  }

  @Override @CallSuper public void onPause() {
    base.onPause();
    super.onPause();
  }

  @Override @CallSuper public void onStop() {
    base.onStop();
    super.onStop();
  }

  @Override @CallSuper public void onDestroyView() {
    base.onDestroyView();
    super.onDestroyView();
  }

  @Override @CallSuper public void onDestroy() {
    base.onDestroy();
    super.onDestroy();
  }

  @Override @CallSuper public void onDetach() {
    base.onDetach();
    super.onDetach();
  }

  @Override @CallSuper public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    base.onSaveInstanceState(outState);
  }

  @Override @CallSuper public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    base.onConfigurationChanged(newConfig);
  }

  @Override @CallSuper public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    base.onActivityResult(requestCode, resultCode, data);
  }

  @Override @CallSuper public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    base.onRequestPermissionsResult(requestCode, permissions, grantResults);
  }
}
