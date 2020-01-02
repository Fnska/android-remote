package com.example.admin.remote;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    private WebView web;

    private SharedPreferences sPref;

    public static final String LOGIN_TEXT = "login_text";
    public static final String PASSWORD_TEXT = "password_text";
    public static final String CODE_TEXT = "code_text";

    private String URL;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        sPref = getSharedPreferences("Params", MODE_PRIVATE);
        String LOGIN = sPref.getString(LOGIN_TEXT, "");
        String PASSWORD = sPref.getString(PASSWORD_TEXT, "");
        String CODE = sPref.getString(CODE_TEXT, "");

        URL = "https://" + LOGIN + ":" + PASSWORD + "@" + CODE + ".ngrok.io/";

        web = (WebView) findViewById(R.id.webView);
        WebSettings ws = web.getSettings();
        ws.setJavaScriptEnabled(true);
        web.loadUrl(URL);
        web.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if (web.canGoBack()) {
            web.goBack();
        } else {
            super.onBackPressed();
        }
    }


}
