package com.bdqn.devcom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bdqn.devcom.base.App;
import com.bdqn.devcom.utils.UrlUtil;

import org.json.JSONException;
import org.json.JSONObject;

public class InitActivity extends AppCompatActivity {

    private WebView webView;
    public static final String ACCRSS_TOKEN = "access_token";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);

        webView = (WebView) findViewById(R.id.webView);
        getAccessToken();
    }

    private void getAccessToken() {
        webView.loadUrl(UrlUtil.AUTHORIZEURL);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                String newUrl = split(url);
                String authorize_code = UrlUtil.getAuthorizeCode(newUrl);
                getToken(authorize_code);
                redirectTo();
                return true;
            }

        });


    }

    private void getToken(String authorize_code) {
        StringRequest str = new StringRequest(authorize_code, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject json = new JSONObject(response);
                    String access_token = json.getString("access_token");
                    SharedPreferences sp = App.getPreferences("user_token");
                    sp.edit().putString(ACCRSS_TOKEN,access_token).commit();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", "请求失败");
            }
        });
        App.queue.add(str);
    }

    private String split(String url) {
        String code = null;
        String[] split1 = url.split("&");
        for (int i = 0; i < split1.length; i++) {
            String str = split1[i];
            if(str.contains("code=")){
                String [] split2 = str.split("=");
                code = split2[1];
                return code;
            }
        }
        return code;
    }

    private void redirectTo() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

}
