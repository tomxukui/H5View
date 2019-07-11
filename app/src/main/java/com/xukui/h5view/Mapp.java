package com.xukui.h5view;

import android.app.Application;
import android.util.Log;

import com.xukui.library.h5view.H5Client;

public class Mapp extends Application {

    private static final String TAG = "Mapp";

    @Override
    public void onCreate() {
        super.onCreate();
        //如果需要使用x5内核, 则需要执行下面代码, 否则直接用，无需配置
        H5Client.setupX5Core(this, true, (isSuccess, msg) -> {
            if (isSuccess) {
                Log.i(TAG, msg);

            } else {
                Log.e(TAG, msg);
            }
        });
    }

}