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
import android.util.Log;
import android.widget.TextView;

import com.google.inject.Inject;
import com.oneelevenelm.bedmate.model.SceneModel;
import com.oneelevenelm.bedmate.model.SceneModelImpl;
import com.oneelevenelm.bedmate.model.events.SceneModelUpdateEvent;

import net.danlew.android.joda.DateUtils;

import org.joda.time.DateTime;

import roboguice.RoboGuice;
import roboguice.activity.RoboActivity;
import roboguice.event.EventManager;
import roboguice.event.Observes;
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

    private static final String LOG_TAG = "MainActivity";

    @Inject
    SceneModel sceneModel;
    @InjectView(R.id.txtDate)
    TextView dateText;
    @InjectView(R.id.txtTime)
    TextView timeText;
    @InjectView(R.id.txtWelcome)
    TextView welcomeText;

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

    public MainActivity (){
        Log.i("MainActivity", "Constructor");

    }

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

        Log.i("Main Activity", "Started Main Activity.");
        Log.i("Main Activity", "Event Manager " + super.eventManager);

        if( sceneModel == null ){
            Log.d(LOG_TAG, "Scene Model is not injected");
            RoboGuice.getInjector(this).injectMembers(this);
            Log.i(LOG_TAG, "Context : " + this );
            Log.i(LOG_TAG, "SceneModel : " + sceneModel);

            //sceneModel.init(this);

        }else {
            Log.i(LOG_TAG, "Context : " + this );
            Log.i(LOG_TAG, "SceneModel : " + sceneModel);
            sceneModel.init(this);
        }



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(timeTickReceiver);
        unregisterReceiver(activeViewReceiver);

        sceneModel.destroy();
        sceneModel = null;

    }

    private void renderCurrentTime() {
        DateTime now = DateTime.now();
        if(timeText!=null)
            timeText.setText(DateUtils.formatDateTime(this, now, DateUtils.FORMAT_SHOW_TIME));
    }

    private void renderCurrentDate() {
        //Need to retrieve the current date
        DateTime now = DateTime.now();
        if (dateText != null)
            dateText.setText(DateUtils.formatDateTime(this, now, DateUtils.FORMAT_SHOW_DATE));
    }

    public void handleSceneModelInit (@Observes SceneModelUpdateEvent evt){
        Log.i("Main Activity", "Received a scene model init event.");
    }
}
