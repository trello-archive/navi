package com.trello.navi2.model;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.google.auto.value.AutoValue;

@AutoValue public abstract class ViewCreated {

  public static ViewCreated create(@NonNull View view, @Nullable Bundle bundle) {
    return new AutoValue_ViewCreated(view, bundle);
  }

  @NonNull public abstract View view();

  @Nullable public abstract Bundle bundle();
}
