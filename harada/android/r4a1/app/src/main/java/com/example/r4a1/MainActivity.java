package com.example.r4a1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class MainActivity extends AppCompatActivity {

    static final String URL = "http://10.23.104.39:8080/book/firstselect/Cookiejudge.action";
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Web Viewの初期設定
        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient()); // WebViewを設定する
        webView.getSettings().setJavaScriptEnabled(true); // JavaScriptを有効にする
        webView.loadUrl(URL); // URLを読み込む
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent e){
        if(keyCode == KeyEvent.KEYCODE_BACK){ // 戻るボタンがタップされた時
            if(webView != null && webView.canGoBack()){ // WebViewがNULLでなく、閲覧履歴があるなら
                webView.goBack(); // 一つ前のウェブページを表示する
            }
            return true;
        }else{
            return super.onKeyDown(keyCode, e);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();// バックグラウンドからフォアグランドに戻った時など
        if(webView != null){ // WebViewが空でなければ
            String url = webView.getUrl(); // 現在のウェブページを
            webView.loadUrl(url); // 再表示する
        }
    }
}