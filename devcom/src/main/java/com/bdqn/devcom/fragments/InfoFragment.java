package com.bdqn.devcom.fragments;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bdqn.devcom.InitActivity;
import com.bdqn.devcom.R;
import com.bdqn.devcom.base.App;
import com.bdqn.devcom.utils.UrlUtil;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * 资讯页面
 */
public class InfoFragment extends android.support.v4.app.Fragment{
     private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_info,container,false);
        return view;
    }

    private SwipeRefreshLayout srlayout;
    private ListView lv_active_info;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        srlayout = (SwipeRefreshLayout) view.findViewById(R.id.srlayout);
        srlayout.setColorSchemeColors(Color.BLUE,Color.RED,Color.YELLOW);
        srlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                SharedPreferences sp = App.getPreferences("user_token");
                String token = sp.getString(InitActivity.ACCRSS_TOKEN,null);
                String newsUrl = UrlUtil.getNewsList(token,1);
                Log.e("newurl",newsUrl);
                requestData(newsUrl);
            }
        });
    }

    private void requestData(String url) {

        srlayout.setRefreshing(true);

        StringRequest res = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("ssss",response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               Log.e("===","请求出错");
            }
        });
        srlayout.setRefreshing(false);
        App.queue.add(res);
    }

}
