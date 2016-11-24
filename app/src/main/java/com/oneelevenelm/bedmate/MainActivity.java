/*
 * ********************************************************
 *
 * Copyright (c) 2016.
 * by 111ELM Design, LLC
 *
 * ********************************************************
 */

package com.oneelevenelm.bedmate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import net.danlew.android.joda.DateUtils;

import org.joda.time.DateTime;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

/**
 * Main activity for the Bedmate Android application.
 *
 * @author Jay Whipple
 * @version 1.0
 *          <p>
 *          Provides the ability to show the date and time for the current application.
 */

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboActivity {

    @InjectView(R.id.txtDate)
    TextView dateText;
    @InjectView(R.id.txtTime)
    TextView timeText;
    private BroadcastReceiver timeTickReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            renderCurrentTime();
            renderCurrentDate();
        }
    };
    private BroadcastReceiver activeViewReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Render the current date and time
        renderCurrentDate();
        renderCurrentTime();

        //Register with the time tick to change the current date and time when appropriate
        IntentFilter timeIntentFilter = new IntentFilter(Intent.ACTION_TIME_TICK);
        IntentFilter actionViewFilter = new IntentFilter(Intent.ACTION_VIEW);

        registerReceiver(activeViewReceiver, actionViewFilter);
        registerReceiver(timeTickReceiver, timeIntentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(timeTickReceiver);
    }

    private void renderCurrentTime() {
        DateTime now = DateTime.now();
        timeText.setText(DateUtils.formatDateTime(this, now, DateUtils.FORMAT_SHOW_TIME));
    }

    private void renderCurrentDate() {
        //Need to retrieve the current date
        DateTime now = DateTime.now();
        dateText.setText(DateUtils.formatDateTime(this, now, DateUtils.FORMAT_SHOW_DATE));
    }

}
