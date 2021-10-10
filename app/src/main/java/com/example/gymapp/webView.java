package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webView extends AppCompatActivity {
    private static final String TAG = "webView";
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = (WebView) findViewById(R.id.webview);
        try {
            String Url = getIntent().getStringExtra("Url");
            if(Url != null){
                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl(Url);
                webView.getSettings().getJavaScriptEnabled();
            }
        }catch (NullPointerException e){
            Log.d(TAG, "onCreate: intent not receive");
        }

    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}