package com.bdqn.devcom.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;

import com.bdqn.devcom.R;

/**
 * Created by Administrator on 2016/7/2 0002.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActionBar();
        initViews();
        initDatas();
    }

    protected void initActionBar(){
        //得到actionBar，注意我的是V7包，使用getSupportActionBar()
        ActionBar actionBar = getSupportActionBar();
        //在使用v7包的时候显示icon和标题需指定一下属性。
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }



    protected abstract void initViews();

    protected abstract void initDatas();




}
