package com.xukui.library.h5view;

import android.app.Application;
import android.content.Context;

import com.xukui.library.h5view.builder.X5Builder;

public class H5Client {

    private Application mContext;

    private H5Client() {
    }

    public static H5Client getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final H5Client INSTANCE = new H5Client();
    }

    public void init(Application context) {
        mContext = context;
    }

    public Context getContext() {
        return mContext;
    }

    /**
     * 组建系统浏览器内核
     */
    public void builderCore(Application context) {
        mContext = context;
    }

    /**
     * 组建X5浏览器内核
     */
    public X5Builder builderX5Core() {
        return new X5Builder(mContext);
    }

}