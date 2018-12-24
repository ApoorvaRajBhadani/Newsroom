package com.woc.apoorva.newsroom;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public PagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.mNoOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int postition) {
        switch (postition) {
            case 0:
                TabCult tabCult = new TabCult();
                return tabCult;
            case 1:
                TabSports tabSports = new TabSports();
                return tabSports;
            case 3:
                TabTech tabTech = new TabTech();
                return tabTech;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
