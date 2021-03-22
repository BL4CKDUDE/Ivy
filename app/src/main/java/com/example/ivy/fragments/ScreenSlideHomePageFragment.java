package com.example.ivy.fragments;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import androidx.fragment.app.Fragment;

import com.example.ivy.R;
import com.example.ivy.databinding.FragmentHomeSlideBinding;
import com.example.ivy.databinding.FragmentNewsSlideBinding;
import com.example.ivy.helpers.StringDebugger;
import com.example.ivy.helpers.TimeGetter;
import com.example.ivy.helpers.WallpaperSetter;
import com.example.ivy.scapers.WeatherScapper;
import com.example.ivy.utils.Constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ScreenSlideHomePageFragment extends Fragment {

    private FragmentHomeSlideBinding mFragmentHomeSlideBinding;
    private FragmentNewsSlideBinding mFragmentNewsSlideBinding;

    public static String mTemperature = "-0";
    public static Activity mActivity;

    String mDateString;
    String mTimeString;

    Timer timer = new Timer();

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {

        mFragmentHomeSlideBinding = FragmentHomeSlideBinding.inflate(inflater, container, false);
        View view = mFragmentHomeSlideBinding.getRoot();
        mFragmentHomeSlideBinding.tvUsername.setText(Constants.NAME);

        timeSetter();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeSetter();
            }
        }, 1000, 1000);

        wallpaperSetter();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                temperatureSetter();
            }
        }, 1000,300000);

        return view;
    }

    private void timeSetter(){

        String dateAndTime = TimeGetter.getTime();
        String [] timeStampArray = dateAndTime.split(" ");
        mDateString = timeStampArray[0];
        mTimeString = timeStampArray[1];
        mFragmentHomeSlideBinding.tvdate.setText(mDateString);
        mFragmentHomeSlideBinding.tvtime.setText(mTimeString);

    }

    private void wallpaperSetter(){

        Bitmap bitmap = WallpaperSetter.wallpaperSetter(getActivity(), getResources(), mTimeString);
        mFragmentHomeSlideBinding.ivBackgroudView.setImageBitmap(bitmap);

    }

    private void temperatureSetter(){
        WeatherScapper.temp(mFragmentHomeSlideBinding);
    }
}
