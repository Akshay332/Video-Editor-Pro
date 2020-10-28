package com.my_video_editor_pro.pro.ActivityPhotoVideo.TablayoutSlideshow;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;



public abstract class AdapterSlidingTab extends FragmentPagerAdapter {

    protected abstract String getTitle(int position);

    protected abstract int getIcon(int position);

    public AdapterSlidingTab(FragmentManager fm) {
        super(fm);
    }
}