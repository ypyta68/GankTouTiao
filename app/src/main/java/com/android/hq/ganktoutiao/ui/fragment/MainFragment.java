package com.android.hq.ganktoutiao.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.hq.ganktoutiao.R;
import com.android.hq.ganktoutiao.ui.adapter.PagerAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private PagerAdapter mPagerAdapter;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //initActionBar();
        return initView(inflater);
    }

    private View initView(LayoutInflater inflater){
        View rootView = inflater.inflate(R.layout.fragment_main, null, false);
        mViewPager = (ViewPager) rootView.findViewById(R.id.view_pager);
        mTabLayout = (TabLayout) rootView.findViewById(R.id.tabs);

        mPagerAdapter = new PagerAdapter(getActivity());

        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOffscreenPageLimit(3);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(mPagerAdapter);

        addPages();
        addTabs();

        return rootView;
    }

    private void initActionBar(){
        getActivity().getActionBar().hide();
    }

    private void addPages(){
        mPagerAdapter.addPage(GankDailyFragment.class,null);
        mPagerAdapter.addPage(GankAndroidFragment.class,null);
        mPagerAdapter.addPage(GankIOSFragment.class,null);
        mPagerAdapter.addPage(GankWebFragment.class,null);
        mPagerAdapter.addPage(GankAppFragment.class,null);
        mPagerAdapter.addPage(GankExpandResFragment.class,null);
    }

    private void addTabs(){
        int defaultID;

        addTab(R.string.tab_daily_recommend, 0, true);
        addTab(R.string.tab_daily_android, 1, false);
        addTab(R.string.tab_daily_ios, 2, false);
        addTab(R.string.tab_daily_web, 3, false);
        addTab(R.string.tab_daily_app, 4, false);
        addTab(R.string.tab_daily_expand_res, 5, false);

        mViewPager.setCurrentItem(0);
    }

    private void addTab(int textID, int position, boolean selected){
        TabLayout.Tab tab = mTabLayout.newTab();
//        LayoutInflater inflater = LayoutInflater.from(getActivity());
//        TextView view = (TextView) inflater.inflate(R.layout.top_tab_layout, null);
//        view.setText(textID);
//
//        tab.setCustomView(view);
        tab.setText(getResources().getString(textID));

        mTabLayout.addTab(tab, position, selected);
    }
}
