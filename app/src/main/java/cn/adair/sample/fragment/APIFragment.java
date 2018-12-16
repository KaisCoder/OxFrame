package cn.adair.sample.fragment;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import cn.adair.iframe.base.IBaseFragment;
import cn.adair.sample.R;

public class APIFragment extends IBaseFragment {

    WebView webView;

    @Override
    public int initLayout() {
        return R.layout.api_fragment;
    }

    @Override
    public void initView() {
        webView = _mView.findViewById(R.id.webview);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void initData(Bundle savedInstanceState) {
//        webView.loadUrl("https://github.com/youth5201314/XFrame/wiki");
        webView.loadUrl("http://www.122fu.com/");
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        webView.addJavascriptInterface(new InJavaScriptLocalObj(), "java_obj");
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.setWebViewClient(new CustomWebViewClient());
    }

    final class CustomWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            view.loadUrl("javascript:window.java_obj.getSource('<head>'+" +
                    "document.getElementsByTagName('html')[0].innerHTML+'</head>');");
            super.onPageFinished(view, url);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
        }
    }

    /**
     * 逻辑处理
     *
     * @author linzewu
     */
    final class InJavaScriptLocalObj {
        @JavascriptInterface
        public void getSource(String html) {
            Log.d("html=", html);
        }
    }

}
