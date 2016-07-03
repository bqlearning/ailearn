package com.bdqn.devcom.widget;

import android.content.Context;
import android.support.v4.app.FragmentTabHost;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2016/7/3 0003.
 */
public class MyTabHost extends FragmentTabHost{

    private String mCurrentTag;

    private String mNoTabChangedTag;

    public MyTabHost(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onTabChanged(String tag) {
        if (tag.equals(mNoTabChangedTag)) {
            setCurrentTabByTag(mCurrentTag);
        } else {
            super.onTabChanged(tag);
            mCurrentTag = tag;
        }
    }

    public void setNoTabChangedTag(String tag) {
        this.mNoTabChangedTag = tag;
    }
}
