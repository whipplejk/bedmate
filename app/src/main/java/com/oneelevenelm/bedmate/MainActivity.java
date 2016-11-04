package com.oneelevenelm.bedmate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.inject.Inject;

import roboguice.activity.RoboActivity;
import roboguice.context.event.OnCreateEvent;
import roboguice.context.event.OnDestroyEvent;
import roboguice.event.Observes;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
