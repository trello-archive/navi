package com.trello.navi;

import com.trello.navi.model.BundleBundle;
import rx.functions.Action0;
import rx.functions.Action1;

public interface NaviActivity {
  void addCreateListener(Action1<BundleBundle> listener);

  void removeCreateListener(Action1<BundleBundle> listener);

  void addStartListener(Action0 listener);

  void removeStartListener(Action0 listener);

  void addResumeListener(Action0 listener);

  void removeResumeListener(Action0 listener);

  void addPauseListener(Action0 listener);

  void removePauseListener(Action0 listener);

  void addStopListener(Action0 listener);

  void removeStopListener(Action0 listener);

  void addDestroyListener(Action0 listener);

  void removeDestroyListener(Action0 listener);

  void addRestartListener(Action0 listener);

  void removeRestartListener(Action0 listener);

  void addSaveInstanceStateListener(Action1<BundleBundle> listener);

  void removeSaveInstanceStateListener(Action1<BundleBundle> listener);

  void addRestoreInstanceStateListener(Action1<BundleBundle> listener);

  void removeRestoreInstanceStateListener(Action1<BundleBundle> listener);
}
