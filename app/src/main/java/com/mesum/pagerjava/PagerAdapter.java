package com.mesum.pagerjava;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter  extends FragmentPagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(@NonNull FragmentManager fm, int NumberofTabs) {
        super(fm);
        this.mNumOfTabs = NumberofTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
            switch (position){
                case 0 : return new Tab1Fragment();
                case 1: return new Tab2Fragment();
                case 2: return new Tab3Fragment();
                default: return null;
            }

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
