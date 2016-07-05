package com.bdqn.devcom.base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class App extends Application {

    public static Context mContext;
    public static RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();
        if (mContext == null) {
            mContext = getApplicationContext();
        }
        if(queue == null){
            queue = Volley.newRequestQueue(mContext);
        }
    }

    public static Context getContext() {
        return mContext;
    }


    public static SharedPreferences getPreferences(String preName) {
        SharedPreferences sp = App.getContext().getSharedPreferences(preName, Context.MODE_APPEND);
        return sp;
    }

    public static void showLongToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
    }

    public static void showShortToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }


}
