package com.example.utsav.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static android.webkit.WebSettings.RenderPriority.HIGH;

public class MainActivity extends AppCompatActivity {


    WebView wv;
    @Override
    public void onBackPressed(){
        if(wv.canGoBack())
        {
            wv.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv = (WebView)findViewById(R.id.wv);
        //Enable javascript
        wv.getSettings().getJavaScriptEnabled();
        wv.setFocusable(true);
        wv.getSettings().setRenderPriority(HIGH);
        wv.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        wv.getSettings().setDomStorageEnabled(true);
        wv.getSettings().setDatabaseEnabled(true);
        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        String s=" <iframe src=\"https://www.google.com\" width=\"760\" height=\"500\" frameborder=\"0\" marginheight=\"0\" marginwidth=\"0\">Loading...</iframe>";

        wv.loadDataWithBaseURL (null, s, "text/html", "utf-8",   "about:blank");

        //wv.loadUrl("https://www.google.com");


        wv.setWebViewClient(new WebViewClient());
    }
}
