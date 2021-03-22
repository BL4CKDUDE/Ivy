package com.example.ivy.scapers;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import com.example.ivy.databinding.FragmentHomeSlideBinding;
import com.example.ivy.helpers.StringDebugger;
import com.example.ivy.utils.Constants;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.w3c.dom.Element;

import java.io.IOException;

public class WeatherScapper {

    static String tempString;

    public static String temp(FragmentHomeSlideBinding fragmentHomeSlideBinding) {
        new Thread(new Runnable(){
            @Override
            public void run() {


                Document document;
                try{
                    document = Jsoup.connect(Constants.WEATHER_GOOGLE_URL).ignoreHttpErrors(true).timeout(4000).get();
                    Elements temp = document.getElementsByClass("wob_t TVtOme");
                
                    tempString = temp.text();
                    StringDebugger.Logger(tempString);
                    fragmentHomeSlideBinding.tvtemperature.setText(tempString+"°");
                }catch (IOException e){
                    tempString = "0";
                    e.printStackTrace();
                }
            }
        }).start();
        return tempString;
    }


}
