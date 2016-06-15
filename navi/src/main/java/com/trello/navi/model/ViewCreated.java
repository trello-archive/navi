package com.trello.navi.model;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class ViewCreated {
    private final Bundle bundle;
    private final View view;
    public ViewCreated(View view, @Nullable Bundle bundle) {
        this.view = view;
        this.bundle = bundle;
    }
    @Nullable
    public Bundle getBundle() {
        return bundle;
    }
    public View getView() {
        return view;
    }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewCreated that = (ViewCreated) o;
        if (bundle != null ? !bundle.equals(that.bundle) : that.bundle != null) return false;
        return view.equals(that.view);
    }
    @Override public int hashCode() {
        int result = bundle != null ? bundle.hashCode() : 0;
        result = 31 * result + view.hashCode();
        return result;
    }
    @Override public String toString() {
        return "ViewCreated{" +
                "bundle=" + bundle +
                ", view=" + view +
                '}';
    }
}
