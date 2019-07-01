package com.xukui.library.h5view;

import android.app.Application;
import android.content.Context;

import com.xukui.library.h5view.builder.X5Builder;

public class H5Client {

    private Context mContext;

    private H5Client() {
    }

    public static H5Client getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final H5Client INSTANCE = new H5Client();
    }

    public H5Client init(Application application) {
        mContext = application.getApplicationContext();
        return this;
    }

    public Context getContext() {
        return mContext;
    }

    /**
     * 组建X5浏览器内核
     */
    public X5Builder setupX5Core() {
        return new X5Builder(mContext);
    }

}