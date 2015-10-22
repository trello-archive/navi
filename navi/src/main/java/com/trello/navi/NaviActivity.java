package com.trello.navi;

import android.content.Intent;
import android.content.res.Configuration;
import com.trello.navi.model.ActivityResult;
import com.trello.navi.model.BundleBundle;
import com.trello.navi.model.RequestPermissionsResult;

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

  void addNewIntentListener(Listener1<Intent> listener);

  void removeNewIntentListener(Listener1<Intent> listener);

  void addBackPressedListener(Listener0 listener);

  void removeBackPressedListener(Listener0 listener);

  void addAttachedToWindowListener(Listener0 listener0);

  void removeAttachedToWindowListener(Listener0 listener0);

  void addDetachedFromWindowListener(Listener0 listener);

  void removeDetachedFromWindowListener(Listener0 listener);

  void addConfigurationChangedListener(Listener1<Configuration> listener);

  void removeConfigurationChangedListener(Listener1<Configuration> listener);

  void addActivityResultListener(Listener1<ActivityResult> listener);

  void removeActivityResultListener(Listener1<ActivityResult> listener);

  void addRequestPermissionsResultListener(Listener1<RequestPermissionsResult> listener);

  void removeRequestPermissionsResultListener(Listener1<RequestPermissionsResult> listener);
}
