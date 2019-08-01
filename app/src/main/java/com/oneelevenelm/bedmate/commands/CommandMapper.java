/*
 * ********************************************************
 *
 * Copyright (c) 2016.
 * by 111ELM Design, LLC
 *
 * ********************************************************
 */

package com.oneelevenelm.bedmate.commands;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.oneelevenelm.bedmate.events.SceneExecuteEvent;

import roboguice.event.EventManager;
import roboguice.event.Observes;

/**
 * Command handler that listens to the RoboGuice Event manager
 */
public class CommandMapper {
    @Inject
    EventManager eventManager;

    public CommandMapper (){
        init();
    }

    private void init (){}

    //Command to event handler mapping
    protected void handleExecuteScene (@Observes SceneExecuteEvent sceneEvent){
        new ExecuteScene(sceneEvent.getId()).execute();
    }
}
