package com.xukui.library.h5view.x5;

import com.tencent.smtt.sdk.WebView;
import com.xukui.library.h5view.jsbridge.BridgeUtil;

public class X5BridgeUtil extends BridgeUtil {

    /**
     * js 文件将注入为第一个script引用
     *
     * @param view
     * @param url
     */
    public static void webViewLoadJs(WebView view, String url) {
        String js = "var newscript = document.createElement(\"script\");";
        js += "newscript.src=\"" + url + "\";";
        js += "document.scripts[0].parentNode.insertBefore(newscript,document.scripts[0]);";
        view.loadUrl("javascript:" + js);
    }

    public static void webViewLoadLocalJs(WebView view, String path) {
        String jsContent = assetFile2Str(view.getContext(), path);
        view.loadUrl("javascript:" + jsContent);
    }

}