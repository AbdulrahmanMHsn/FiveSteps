package olgor.fivesteps;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* This WebView load and works fine on all Android version prior to Android 9.0,
 * Why doesn't it load on Android 9.0+ ?!
 * Find out why and how to solve this issue.
 *  */

public class SecondStep extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_step);

        webView = findViewById(R.id.webView);
        loadOlgor();
    }

    @SuppressLint("SetJavaScriptEnabled")
    void loadOlgor() {

        webView.setWebViewClient(new MyBrowser());

        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setMinimumFontSize(16);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.setInitialScale((int) (90 * webView.getScale()));

        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl("http://olgor.com");


        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                webView.scrollTo((webView.getRight() + webView.getLeft()) / 2, 0);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

            }

        });

    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
