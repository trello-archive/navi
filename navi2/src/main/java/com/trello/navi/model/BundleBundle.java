package com.trello.navi.model;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

public final class BundleBundle {

  private final Bundle bundle;

  private final PersistableBundle persistableBundle;

  public BundleBundle(@Nullable Bundle bundle, @Nullable PersistableBundle persistableBundle) {
    this.bundle = bundle;
    this.persistableBundle = persistableBundle;
  }

  @Nullable
  public Bundle bundle() {
    return bundle;
  }

  @Nullable
  public PersistableBundle persistableBundle() {
    return persistableBundle;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    BundleBundle that = (BundleBundle) o;

    if (bundle != null ? !bundle.equals(that.bundle) : that.bundle != null) return false;
    return !(persistableBundle != null ? !persistableBundle.equals(that.persistableBundle)
        : that.persistableBundle != null);
  }

  @Override public int hashCode() {
    int result = bundle != null ? bundle.hashCode() : 0;
    result = 31 * result + (persistableBundle != null ? persistableBundle.hashCode() : 0);
    return result;
  }

  @Override public String toString() {
    return "BundleBundle{" +
        "bundle=" + bundle +
        ", persistableBundle=" + persistableBundle +
        '}';
  }
}
