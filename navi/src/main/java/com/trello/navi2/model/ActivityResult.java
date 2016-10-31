package com.trello.navi2.model;

import android.content.Intent;
import android.support.annotation.Nullable;
import com.google.auto.value.AutoValue;

@AutoValue public abstract class ActivityResult {

  public static ActivityResult create(int requestCode, int resultCode, @Nullable Intent data) {
    return new AutoValue_ActivityResult(requestCode, resultCode, data);
  }

  public abstract int requestCode();

  public abstract int resultCode();

  @Nullable public abstract Intent data();
}
