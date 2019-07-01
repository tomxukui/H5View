package com.xukui.library.h5view;

import android.app.Application;
import android.content.Context;
import android.support.annotation.Nullable;

import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;
import com.xukui.library.h5view.x5.OnX5InitListener;

import java.util.HashMap;

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
    public void setupX5Core(boolean downloadWithoutWifi, @Nullable final OnX5InitListener listener) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER, true);
        QbSdk.initTbsSettings(map);

        QbSdk.initX5Environment(mContext, new QbSdk.PreInitCallback() {

            @Override
            public void onCoreInitFinished() {
                if (listener != null) {
                    listener.onResult(true, "腾讯x5组件初始化成功");
                }
            }

            @Override
            public void onViewInitFinished(boolean b) {
                String message = b ? "腾讯x5组件初始化成功, 使用x5内核" : "腾讯x5组件初始化失败, 使用系统内核";

                if (listener != null) {
                    listener.onResult(b, message);
                }
            }

        });
        QbSdk.setDownloadWithoutWifi(downloadWithoutWifi);
    }

}