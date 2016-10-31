package com.trello.navi2.model;

import android.support.annotation.NonNull;
import com.google.auto.value.AutoValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@AutoValue public abstract class RequestPermissionsResult {

  public static RequestPermissionsResult create(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    return new AutoValue_RequestPermissionsResult(requestCode,
        Collections.unmodifiableList(Arrays.asList(permissions)), grantResults);
  }

  public abstract int requestCode();

  @NonNull public abstract List<String> permissions();

  @NonNull public abstract int[] grantResults();
}
