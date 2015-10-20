package com.trello.navi;

import com.trello.navi.model.BundleBundle;

public interface NaviActivity {
  void addCreateListener(Listener1<BundleBundle> listener);

  void removeCreateListener(Listener1<BundleBundle> listener);

  void addStartListener(Listener0 listener);

  void removeStartListener(Listener0 listener);

  void addResumeListener(Listener0 listener);

  void removeResumeListener(Listener0 listener);

  void addPauseListener(Listener0 listener);

  void removePauseListener(Listener0 listener);

  void addStopListener(Listener0 listener);

  void removeStopListener(Listener0 listener);

  void addDestroyListener(Listener0 listener);

  void removeDestroyListener(Listener0 listener);

  void addRestartListener(Listener0 listener);

  void removeRestartListener(Listener0 listener);

  void addSaveInstanceStateListener(Listener1<BundleBundle> listener);

  void removeSaveInstanceStateListener(Listener1<BundleBundle> listener);

  void addRestoreInstanceStateListener(Listener1<BundleBundle> listener);

  void removeRestoreInstanceStateListener(Listener1<BundleBundle> listener);
}
