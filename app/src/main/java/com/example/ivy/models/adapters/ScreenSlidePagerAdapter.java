package com.example.ivy.models.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.ivy.fragments.ScreenSlideHomePageFragment;
import com.example.ivy.fragments.ScreenSlideNewsFragment;
import com.example.ivy.utils.Constants;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
    public ScreenSlidePagerAdapter(FragmentManager fm){
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Override
    public Fragment getItem(int pos){

        switch (pos){
            case 0: return new ScreenSlideHomePageFragment();
            case 1: return new ScreenSlideNewsFragment();
            default: return new ScreenSlideHomePageFragment();

        }
    }


    @Override
    public int getCount(){
       return Constants.NUMBER_OF_PAGES;
    }
}
