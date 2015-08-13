package com.dmacan.wvapp;

import android.app.Activity;
import android.os.Bundle;

public class WVActivity extends Activity {

    private CoolWebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wv);
        webView = (CoolWebView) findViewById(R.id.webView);
        webView.load(getString(R.string.wv_url));
    }

}
