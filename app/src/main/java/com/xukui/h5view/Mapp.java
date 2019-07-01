package com.xukui.h5view;

import android.app.Application;

import com.xukui.library.h5view.H5Client;

public class Mapp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        H5Client.getInstance()
                .init(this)
                .setupX5Core(true, null);
    }

}