package com.xukui.library.h5view.jsbridge;

public interface WebViewJavascriptBridge {
	
	void send(String data);
	void send(String data, CallBackFunction responseCallback);

}