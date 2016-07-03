package com.bdqn.devcom.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bdqn.devcom.R;

import java.util.ArrayList;
import java.util.List;


public class CommonFragment extends Fragment implements View.OnClickListener {

    private View view;
    private ViewPager vp_active_pager;
    private List<Fragment> childFragment;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_common,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        childFragment = new ArrayList<>();
        InfoFragment infoFragment = new InfoFragment();
        BlogFragment blogFragment = new BlogFragment();
        DialogFragment dialogFragment = new DialogFragment();
        ActiveFragment activeFragment = new ActiveFragment();
        childFragment.add(infoFragment);
        childFragment.add(blogFragment);
        childFragment.add(dialogFragment);
        childFragment.add(activeFragment);

        vp_active_pager = (ViewPager) view.findViewById(R.id.vp_active_pager);
        vp_active_pager.setAdapter(new MyAdapter(getChildFragmentManager()));

        TextView tv_common_info = (TextView) view.findViewById(R.id.tv_common_info);
        TextView tv_common_blog = (TextView) view.findViewById(R.id.tv_common_blog);
        TextView tv_common_dialog = (TextView) view.findViewById(R.id.tv_common_dialog);
        TextView tv_common_active = (TextView) view.findViewById(R.id.tv_common_active);

        tv_common_info.setOnClickListener(this);
        tv_common_blog.setOnClickListener(this);
        tv_common_dialog.setOnClickListener(this);
        tv_common_active.setOnClickListener(this);

        vp_active_pager.setCurrentItem(0);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_common_info:
                vp_active_pager.setCurrentItem(0);
                break;
            case R.id.tv_common_blog:
                vp_active_pager.setCurrentItem(1);
                break;
            case R.id.tv_common_dialog:
                vp_active_pager.setCurrentItem(2);
                break;
            case R.id.tv_common_active:
                vp_active_pager.setCurrentItem(3);
                break;
            default:break;
        }
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return childFragment.get(position);
        }

        @Override
        public int getCount() {
            return childFragment.size();
        }
    }
}
