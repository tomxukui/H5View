package com.xukui.library.h5view.builder;

import android.content.Context;
import android.support.annotation.Nullable;

import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;
import com.xukui.library.h5view.callback.OnX5WebInitListener;

import java.util.HashMap;

public class X5Builder {

    private Context mContext;
    private boolean mDownloadWithoutWifi;
    private OnX5WebInitListener mOnX5WebInitListener;

    public X5Builder(Context context) {
        mContext = context;
        mDownloadWithoutWifi = true;
    }

    public X5Builder setDownloadWithoutWifi(boolean downloadWithoutWifi) {
        mDownloadWithoutWifi = downloadWithoutWifi;
        return this;
    }

    public X5Builder setOnX5WebInitListener(@Nullable OnX5WebInitListener listener) {
        mOnX5WebInitListener = listener;
        return this;
    }

    public void execute() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER, true);
        QbSdk.initTbsSettings(map);

        QbSdk.initX5Environment(mContext, new QbSdk.PreInitCallback() {

            @Override
            public void onCoreInitFinished() {
                if (mOnX5WebInitListener != null) {
                    mOnX5WebInitListener.onResult(true, "腾讯x5组件初始化成功");
                }
            }

            @Override
            public void onViewInitFinished(boolean b) {
                String message = b ? "腾讯x5组件初始化成功, 使用x5内核" : "腾讯x5组件初始化失败, 使用系统内核";

                if (mOnX5WebInitListener != null) {
                    mOnX5WebInitListener.onResult(b, message);
                }
            }

        });
        QbSdk.setDownloadWithoutWifi(mDownloadWithoutWifi);
    }

}