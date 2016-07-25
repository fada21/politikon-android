package com.fada21.android.politikon;

import android.app.Application;

import net.danlew.android.joda.JodaTimeAndroid;

public class Politikon extends Application {

    @Override public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);
    }
}
