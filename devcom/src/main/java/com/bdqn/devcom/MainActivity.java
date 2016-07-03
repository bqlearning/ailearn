package com.bdqn.devcom;

import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.bdqn.devcom.base.BaseActivity;
import com.bdqn.devcom.fragments.CommonFragment;
import com.bdqn.devcom.fragments.ExploreFragment;
import com.bdqn.devcom.fragments.MeFragment;
import com.bdqn.devcom.fragments.TweetFragment;
import com.bdqn.devcom.widget.MyTabHost;

public class MainActivity extends BaseActivity implements TabHost.OnTabChangeListener{

    private MyTabHost tabHost;

    private String[] names = {"综合","动弹","add","发现","我的"};
    private Class<?>[] clazz = {CommonFragment.class,TweetFragment.class,CommonFragment.class,ExploreFragment.class,MeFragment.class};
    private int[] drawables = {R.drawable.tab_icon_new,R.drawable.tab_icon_tweet,0,R.drawable.tab_icon_explore,R.drawable.tab_icon_me};


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_main);

        tabHost = (MyTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this,getSupportFragmentManager(),R.id.tabContent);

        for (int i = 0; i < clazz.length; i++) {
            View indicator = getIndicatorView(names[i],drawables[i]);
            TabHost.TabSpec spec = tabHost.newTabSpec(names[i]).setIndicator(indicator);
            if(i==2){
                tabHost.setNoTabChangedTag(names[i]);
                indicator.setVisibility(View.INVISIBLE);
            }
            tabHost.addTab(spec,clazz[i],null);
        }

    }

    @Override
    protected void initDatas() {

    }

    private View getIndicatorView(String name,int img){
        View view = getLayoutInflater().inflate(R.layout.tab_spec,null,false);
        TextView tvName = (TextView) view.findViewById(R.id.tv_tab_name);
        ImageView ivImg = (ImageView) view.findViewById(R.id.iv_tab_img);

        tvName.setText(name);
        ivImg.setImageResource(img);
        return  view;
    }

    @Override
    public void onTabChanged(String tabId) {


    }
}
