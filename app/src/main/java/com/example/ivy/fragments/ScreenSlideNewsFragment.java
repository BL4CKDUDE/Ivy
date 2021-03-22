package com.example.ivy.fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.fragment.app.Fragment;

import com.example.ivy.databinding.FragmentNewsSlideBinding;
import com.example.ivy.helpers.TimeGetter;
import com.example.ivy.helpers.WallpaperSetter;


public class ScreenSlideNewsFragment extends Fragment {

    private FragmentNewsSlideBinding mFragmentNewsSlideBinding;
    private String mTime;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        mFragmentNewsSlideBinding = FragmentNewsSlideBinding.inflate(inflater, container, false);
        View view = mFragmentNewsSlideBinding.getRoot();

       timeSetter();
        return view;
    }

    public void timeSetter(){

        String dateAndTime = TimeGetter.getTime();
        String [] timeStampArray = dateAndTime.split(" ");
        mTime = timeStampArray[1];
        wallpaperSetter();

    }
    public void wallpaperSetter(){

        Bitmap bitmap = WallpaperSetter.wallpaperSetter(getActivity(), getResources(), mTime);
        mFragmentNewsSlideBinding.ivBackgroudViewBlur.setImageBitmap(bitmap);

    }



}
