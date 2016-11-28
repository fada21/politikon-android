package com.fada21.android.politikon;

import android.app.Application;
import android.content.Context;

import net.danlew.android.joda.JodaTimeAndroid;

public class PolitikonApp extends Application {

    private static PolitikonApp singleton;

    public static PolitikonApp get() {
        return singleton;
    }

    @Override public void onCreate() {
        super.onCreate();
        singleton = this;
        JodaTimeAndroid.init(this);
    }
}
