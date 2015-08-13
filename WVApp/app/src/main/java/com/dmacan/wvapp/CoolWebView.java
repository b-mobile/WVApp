package com.dmacan.wvapp;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by dmacan on 13.8.2015..
 */
public class CoolWebView extends WebView {

    private static final String HTML = "text/html";
    private static final String ENCODING = "utf-8";
    private static final String TAG = "CoolWebView";

    public CoolWebView(Context context) {
        super(context);
        init();
    }

    public CoolWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CoolWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CoolWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void init() {
        Log.i(TAG, "Init");
        this.getSettings().setJavaScriptEnabled(true);
        this.getSettings().setLoadsImagesAutomatically(true);
        this.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        this.setWebViewClient(new CoolWebViewClient());
    }

    public void load(String url) {
        this.loadUrl(url);
    }

    /**
     * Loads pure html with utf-8 encoding set
     *
     * @param html HTML code to be displayed
     */
    public void loadHtml(String html) {
        this.loadDataWithBaseURL(null, html, HTML, ENCODING, null);
    }

    /**
     * Custom web client which displays URL within the application, instead of opening it within the browser
     */
    private class CoolWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }


}
