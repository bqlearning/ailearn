package com.bdqn.devcom.utils;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by Administrator on 2016/7/2 0002.
 */
public class Utils {

    /**
     * 获取屏幕的宽高
     *
     * @return
     */
    public static int[] getScreenWH(Activity act) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        act.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int w = displayMetrics.widthPixels;
        int h = displayMetrics.heightPixels;
        return new int[]{w, h};
    }

}
