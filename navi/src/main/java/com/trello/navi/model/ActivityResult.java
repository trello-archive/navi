package com.trello.navi.model;

import android.content.Intent;
import android.support.annotation.Nullable;

public final class ActivityResult {

  private final int requestCode;
  private final int resultCode;
  private final Intent data;

  public ActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    this.requestCode = requestCode;
    this.resultCode = resultCode;
    this.data = data;
  }

  public int requestCode() {
    return requestCode;
  }

  public int resultCode() {
    return resultCode;
  }

  @Nullable public Intent data() {
    return data;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ActivityResult that = (ActivityResult) o;

    if (requestCode != that.requestCode) return false;
    if (resultCode != that.resultCode) return false;
    return !(data != null ? !data.equals(that.data) : that.data != null);
  }

  @Override public int hashCode() {
    int result = requestCode;
    result = 31 * result + resultCode;
    result = 31 * result + (data != null ? data.hashCode() : 0);
    return result;
  }

  @Override public String toString() {
    return "ActivityResult{" +
        "requestCode=" + requestCode +
        ", resultCode=" + resultCode +
        ", data=" + data +
        '}';
  }
}
