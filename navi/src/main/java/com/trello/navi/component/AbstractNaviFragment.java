package com.trello.navi.component;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.trello.navi.NaviFragment;
import com.trello.navi.internal.BaseNaviFragment;
import rx.functions.Action0;
import rx.functions.Action1;

public abstract class AbstractNaviFragment extends Fragment implements NaviFragment {

  private final BaseNaviFragment base = new BaseNaviFragment();

  ////////////////////////////////////////////////////////////////////////////
  // onAttach

  @Override public void addAttachListener(Action1<Context> listener) {
    base.addAttachListener(listener);
  }

  @Override public void removeAttachListener(Action1<Context> listener) {
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

  @Override public void addCreateListener(Action1<Bundle> listener) {
    base.addCreateListener(listener);
  }

  @Override public void removeCreateListener(Action1<Bundle> listener) {
    base.removeCreateListener(listener);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    base.onCreate(savedInstanceState);
  }

  ////////////////////////////////////////////////////////////////////////////
  // onCreateView

  @Override public void addCreateViewListener(Action1<Bundle> listener) {
    base.addCreateViewListener(listener);
  }

  @Override public void removeCreateViewListener(Action1<Bundle> listener) {
    base.removeCreateViewListener(listener);
  }

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    base.onCreateView(savedInstanceState);
    return super.onCreateView(inflater, container, savedInstanceState);
  }

  ////////////////////////////////////////////////////////////////////////////
  // onActivityCreated

  @Override public void addActivityCreatedListener(Action1<Bundle> listener) {
    base.addActivityCreatedListener(listener);
  }

  @Override public void removeActivityCreatedListener(Action1<Bundle> listener) {
    base.removeActivityCreatedListener(listener);
  }

  @Override public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    base.onActivityCreated(savedInstanceState);
  }

  ////////////////////////////////////////////////////////////////////////////
  // onViewStatedRestored

  @Override public void addViewStateRestoredListener(Action1<Bundle> listener) {
    base.addViewStateRestoredListener(listener);
  }

  @Override public void removeViewStateRestoredListener(Action1<Bundle> listener) {
    base.removeViewStateRestoredListener(listener);
  }

  @Override public void onViewStateRestored(Bundle savedInstanceState) {
    super.onViewStateRestored(savedInstanceState);
    base.onViewStateRestored(savedInstanceState);
  }

  ////////////////////////////////////////////////////////////////////////////
  // onStart

  @Override public void addStartListener(Action0 listener) {
    base.addStartListener(listener);
  }

  @Override public void removeStartListener(Action0 listener) {
    base.removeStartListener(listener);
  }

  @Override public void onStart() {
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

  @Override public void onResume() {
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

  @Override public void onPause() {
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

  @Override public void onStop() {
    super.onStop();
    base.onStop();
  }

  ////////////////////////////////////////////////////////////////////////////
  // onDestroyView

  @Override public void addDestroyViewListener(Action0 listener) {
    base.addDestroyViewListener(listener);
  }

  @Override public void removeDestroyViewListener(Action0 listener) {
    base.removeDestroyViewListener(listener);
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    base.onDestroyView();
  }

  ////////////////////////////////////////////////////////////////////////////
  // onDestroy

  @Override public void addDestroyListener(Action0 listener) {
    base.addDestroyListener(listener);
  }

  @Override public void removeDestroyListener(Action0 listener) {
    base.removeDestroyListener(listener);
  }

  @Override public void onDestroy() {
    super.onDestroy();
    base.onDestroy();
  }

  ////////////////////////////////////////////////////////////////////////////
  // onDetach

  @Override public void addDetachListener(Action0 listener) {
    base.addDetachListener(listener);
  }

  @Override public void removeDetachListener(Action0 listener) {
    base.removeDetachListener(listener);
  }

  @Override public void onDetach() {
    super.onDetach();
    base.onDetach();
  }

  ////////////////////////////////////////////////////////////////////////////
  // onSaveInstanceState

  @Override public void addSaveInstanceStateListener(Action1<Bundle> listener) {
    base.addSaveInstanceStateListener(listener);
  }

  @Override public void removeSaveInstanceStateListener(Action1<Bundle> listener) {
    base.removeSaveInstanceStateListener(listener);
  }

  @Override public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    base.onSaveInstanceState(outState);
  }
}
