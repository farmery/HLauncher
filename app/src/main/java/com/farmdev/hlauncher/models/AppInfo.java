package com.farmdev.hlauncher.models;

import android.graphics.drawable.Drawable;

public class AppInfo {
    private String packageName;
    private String label;
    private Drawable icon;

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getLabel() {
        return label;
    }

    public Drawable getIcon() {
        return icon;
    }
}

