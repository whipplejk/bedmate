/*
 * ********************************************************
 *
 * Copyright (c) 2016.
 * by 111ELM Design, LLC
 *
 * ********************************************************
 */

package com.oneelevenelm.bedmate.modules;

import android.util.Log;

import com.google.inject.AbstractModule;
import com.oneelevenelm.bedmate.model.SceneModel;
import com.oneelevenelm.bedmate.model.SceneModelImpl;

import roboguice.inject.ContextSingleton;

/**
 * Created by whipplejk on 11/28/16.
 */

public class MainActivityModule extends AbstractModule {
    @Override
    protected void configure() {
        Log.i("MainActivityModule", "Configuring");
        bind(SceneModel.class).to(SceneModelImpl.class).in(ContextSingleton.class);
    }
}
