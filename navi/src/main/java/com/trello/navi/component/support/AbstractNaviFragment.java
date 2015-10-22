package com.trello.navi.component.support;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.trello.navi.Listener0;
import com.trello.navi.Listener1;
import com.trello.navi.NaviFragment;
import com.trello.navi.internal.BaseNaviFragment;
import com.trello.navi.model.ActivityResult;

public abstract class AbstractNaviFragment extends Fragment implements NaviFragment {

  private final BaseNaviFragment base = new BaseNaviFragment();

  ////////////////////////////////////////////////////////////////////////////
  // onAttach

  @Override public void addAttachListener(Listener1<Context> listener) {
    base.addAttachListener(listener);
  }

  @Override public void removeAttachListener(Listener1<Context> listener) {
    base.removeAttachListener(listener);
  }

  @Override public void onAttach(Activity activity) {
    super.onAttach(activity);
    base.onAttach(activity);
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    base.onAttach(context);
  }

  ////////////////////////////////////////////////////////////////////////////
  // onCreate

  @Override public void addCreateListener(Listener1<Bundle> listener) {
    base.addCreateListener(listener);
  }

  @Override public void removeCreateListener(Listener1<Bundle> listener) {
    base.removeCreateListener(listener);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    base.onCreate(savedInstanceState);
  }

  ////////////////////////////////////////////////////////////////////////////
  // onCreateView

  @Override public void addCreateViewListener(Listener1<Bundle> listener) {
    base.addCreateViewListener(listener);
  }

  @Override public void removeCreateViewListener(Listener1<Bundle> listener) {
    base.removeCreateViewListener(listener);
  }

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    base.onCreateView(savedInstanceState);
    return super.onCreateView(inflater, container, savedInstanceState);
  }

  ////////////////////////////////////////////////////////////////////////////
  // onActivityCreated

  @Override public void addActivityCreatedListener(Listener1<Bundle> listener) {
    base.addActivityCreatedListener(listener);
  }

  @Override public void removeActivityCreatedListener(Listener1<Bundle> listener) {
    base.removeActivityCreatedListener(listener);
  }

  @Override public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    base.onActivityCreated(savedInstanceState);
  }

  ////////////////////////////////////////////////////////////////////////////
  // onViewStatedRestored

  @Override public void addViewStateRestoredListener(Listener1<Bundle> listener) {
    base.addViewStateRestoredListener(listener);
  }

  @Override public void removeViewStateRestoredListener(Listener1<Bundle> listener) {
    base.removeViewStateRestoredListener(listener);
  }

  @Override public void onViewStateRestored(Bundle savedInstanceState) {
    super.onViewStateRestored(savedInstanceState);
    base.onViewStateRestored(savedInstanceState);
  }

  ////////////////////////////////////////////////////////////////////////////
  // onStart

  @Override public void addStartListener(Listener0 listener) {
    base.addStartListener(listener);
  }

  @Override public void removeStartListener(Listener0 listener) {
    base.removeStartListener(listener);
  }

  @Override public void onStart() {
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

  @Override public void onResume() {
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

  @Override public void onPause() {
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

  @Override public void onStop() {
    super.onStop();
    base.onStop();
  }

  ////////////////////////////////////////////////////////////////////////////
  // onDestroyView

  @Override public void addDestroyViewListener(Listener0 listener) {
    base.addDestroyViewListener(listener);
  }

  @Override public void removeDestroyViewListener(Listener0 listener) {
    base.removeDestroyViewListener(listener);
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    base.onDestroyView();
  }

  ////////////////////////////////////////////////////////////////////////////
  // onDestroy

  @Override public void addDestroyListener(Listener0 listener) {
    base.addDestroyListener(listener);
  }

  @Override public void removeDestroyListener(Listener0 listener) {
    base.removeDestroyListener(listener);
  }

  @Override public void onDestroy() {
    super.onDestroy();
    base.onDestroy();
  }

  ////////////////////////////////////////////////////////////////////////////
  // onDetach

  @Override public void addDetachListener(Listener0 listener) {
    base.addDetachListener(listener);
  }

  @Override public void removeDetachListener(Listener0 listener) {
    base.removeDetachListener(listener);
  }

  @Override public void onDetach() {
    super.onDetach();
    base.onDetach();
  }

  ////////////////////////////////////////////////////////////////////////////
  // onSaveInstanceState

  @Override public void addSaveInstanceStateListener(Listener1<Bundle> listener) {
    base.addSaveInstanceStateListener(listener);
  }

  @Override public void removeSaveInstanceStateListener(Listener1<Bundle> listener) {
    base.removeSaveInstanceStateListener(listener);
  }

  @Override public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    base.onSaveInstanceState(outState);
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

  @Override public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    base.onActivityResult(requestCode, resultCode, data);
  }
}
