package com.bdqn.devcom.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bdqn.devcom.R;


/**
 * Created by heshuhui on 2016/7/2.
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
                Log.e("---","----");
            }
        });
    }
}
