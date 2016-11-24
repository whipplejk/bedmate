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

import net.danlew.android.joda.JodaTimeAndroid;

/**
 * Custom application file for the BedmateApplication.
 *
 * @author Jay Whipple
 * @see android.app.Application
 * @version 1.0
 */

public class BedmateApplication extends Application {
    @Override
    public void onCreate (){
        super.onCreate();
        //Need to init the joda date framework
        JodaTimeAndroid.init(this);
    }
}
