/*
 * ********************************************************
 *
 * Copyright (c) 2016.
 * by 111ELM Design, LLC
 *
 * ********************************************************
 */

package com.oneelevenelm.bedmate;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import net.danlew.android.joda.JodaTimeAndroid;

import roboguice.RoboGuice;

/**
 * Custom application file for the BedmateApplication.
 *
 * @author Jay Whipple
 * @see android.app.Application
 * @version 1.0
 */

public class BedmateApplication extends Application {

    private static final String TAG_NAME = "Application";

    @Override
    public void onCreate (){
        super.onCreate();
        //Need to init the joda date framework
        JodaTimeAndroid.init(this);
        Log.i(TAG_NAME, "Application started");
    }

}
