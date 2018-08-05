package com.bakery;

import android.app.Application;
import android.content.Context;

public class RamvelTraderApplication extends Application {

    public static Context context;

    @Override public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
