package com.trello.navi2.model;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import com.google.auto.value.AutoValue;

@AutoValue public abstract class BundleBundle {

  public static BundleBundle create(@Nullable Bundle bundle,
      @Nullable PersistableBundle persistableBundle) {
    return new AutoValue_BundleBundle(bundle, persistableBundle);
  }

  @Nullable public abstract Bundle bundle();

  @Nullable public abstract PersistableBundle persistableBundle();
}
