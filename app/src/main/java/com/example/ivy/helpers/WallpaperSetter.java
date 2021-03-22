package com.example.ivy.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.view.Display;

import com.example.ivy.R;

public class WallpaperSetter {

    public static Bitmap wallpaperSetter(Activity activity, Resources resources, String time){
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        Bitmap bmp;
        display.getSize(point);

        String [] splitTime = time.split(":");
        String hour = splitTime[0];
        int hourInt = Integer.parseInt(hour);

//        if(hourInt >= 0 &&  hourInt <= 10){
            bmp = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                    resources, R.mipmap.morning_tower), point.x, point.y, true);
//
//        }else if(hourInt > 10 && hourInt < 18){
//            bmp = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
//                    resources, R.mipmap.midday_palms), point.x, point.y, true);
//        } else {
//            bmp = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
//                    resources, R.mipmap.night_city), point.x, point.y, true);
//
//        }

        return bmp;
    }

}
