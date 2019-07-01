package com.xukui.library.h5view;

import android.app.Application;
import android.content.Context;

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

}