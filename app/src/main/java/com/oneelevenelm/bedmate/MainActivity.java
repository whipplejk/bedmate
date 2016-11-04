package com.oneelevenelm.bedmate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import roboguice.activity.RoboActivity;

public class MainActivity extends RoboActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
