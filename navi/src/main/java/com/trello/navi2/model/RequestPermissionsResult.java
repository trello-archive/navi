package com.trello.navi2.model;

import android.support.annotation.NonNull;
import java.util.Arrays;

public final class RequestPermissionsResult {

  private final int requestCode;
  private final String[] permissions;
  private final int[] grantResults;

  public RequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    this.requestCode = requestCode;
    this.permissions = permissions;
    this.grantResults = grantResults;
  }

  public int requestCode() {
    return requestCode;
  }

  @NonNull public String[] permissions() {
    return permissions;
  }

  @NonNull public int[] grantResults() {
    return grantResults;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    RequestPermissionsResult that = (RequestPermissionsResult) o;

    if (requestCode != that.requestCode) return false;
    // Probably incorrect - comparing Object[] arrays with Arrays.equals
    if (!Arrays.equals(permissions, that.permissions)) return false;
    return Arrays.equals(grantResults, that.grantResults);
  }

  @Override public int hashCode() {
    int result = requestCode;
    result = 31 * result + Arrays.hashCode(permissions);
    result = 31 * result + Arrays.hashCode(grantResults);
    return result;
  }

  @Override public String toString() {
    return "RequestPermissionsResult{" +
        "requestCode=" + requestCode +
        ", permissions=" + Arrays.toString(permissions) +
        ", grantResults=" + Arrays.toString(grantResults) +
        '}';
  }
}
