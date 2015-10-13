package com.trello.navi;

import android.content.Context;
import android.os.Bundle;
import rx.functions.Action0;
import rx.functions.Action1;

public interface NaviFragment {
  void addAttachListener(Action1<Context> listener);

  void removeAttachListener(Action1<Context> listener);

  void addCreateListener(Action1<Bundle> listener);

  void removeCreateListener(Action1<Bundle> listener);

  void addCreateViewListener(Action1<Bundle> listener);

  void removeCreateViewListener(Action1<Bundle> listener);

  void addActivityCreatedListener(Action1<Bundle> listener);

  void removeActivityCreatedListener(Action1<Bundle> listener);

  void addViewStateRestoredListener(Action1<Bundle> listener);

  void removeViewStateRestoredListener(Action1<Bundle> listener);

  void addStartListener(Action0 listener);

  void removeStartListener(Action0 listener);

  void addResumeListener(Action0 listener);

  void removeResumeListener(Action0 listener);

  void addPauseListener(Action0 listener);

  void removePauseListener(Action0 listener);

  void addStopListener(Action0 listener);

  void removeStopListener(Action0 listener);

  void addDestroyViewListener(Action0 listener);

  void removeDestroyViewListener(Action0 listener);

  void addDestroyListener(Action0 listener);

  void removeDestroyListener(Action0 listener);

  void addDetachListener(Action0 listener);

  void removeDetachListener(Action0 listener);

  void addSaveInstanceStateListener(Action1<Bundle> listener);

  void removeSaveInstanceStateListener(Action1<Bundle> listener);
}
