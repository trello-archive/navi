package com.trello.navi;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import com.trello.navi.model.ActivityResult;
import com.trello.navi.model.PermissionsRequestResult;

public interface NaviFragment {
  void addAttachListener(Listener1<Context> listener);

  void removeAttachListener(Listener1<Context> listener);

  void addCreateListener(Listener1<Bundle> listener);

  void removeCreateListener(Listener1<Bundle> listener);

  void addCreateViewListener(Listener1<Bundle> listener);

  void removeCreateViewListener(Listener1<Bundle> listener);

  void addActivityCreatedListener(Listener1<Bundle> listener);

  void removeActivityCreatedListener(Listener1<Bundle> listener);

  void addViewStateRestoredListener(Listener1<Bundle> listener);

  void removeViewStateRestoredListener(Listener1<Bundle> listener);

  void addStartListener(Listener0 listener);

  void removeStartListener(Listener0 listener);

  void addResumeListener(Listener0 listener);

  void removeResumeListener(Listener0 listener);

  void addPauseListener(Listener0 listener);

  void removePauseListener(Listener0 listener);

  void addStopListener(Listener0 listener);

  void removeStopListener(Listener0 listener);

  void addDestroyViewListener(Listener0 listener);

  void removeDestroyViewListener(Listener0 listener);

  void addDestroyListener(Listener0 listener);

  void removeDestroyListener(Listener0 listener);

  void addDetachListener(Listener0 listener);

  void removeDetachListener(Listener0 listener);

  void addSaveInstanceStateListener(Listener1<Bundle> listener);

  void removeSaveInstanceStateListener(Listener1<Bundle> listener);

  void addConfigurationChangedListener(Listener1<Configuration> listener);

  void removeConfigurationChangedListener(Listener1<Configuration> listener);

  void addActivityResultListener(Listener1<ActivityResult> listener);

  void removeActivityResultListener(Listener1<ActivityResult> listener);

  void addPermissionsRequestResultListener(Listener1<PermissionsRequestResult> listener);

  void removePermissionsRequestResultListener(Listener1<PermissionsRequestResult> listener);
}
