package com.oneelevenelm.bedmate.model;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.oneelevenelm.bedmate.BedmateApplication;
import com.oneelevenelm.bedmate.model.entities.Scene;
import com.oneelevenelm.bedmate.model.events.SceneModelUpdateEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import roboguice.RoboGuice;
import roboguice.activity.RoboActivity;
import roboguice.event.EventManager;

/**
 * Repoistory for the scenes that are available for the application.
 */

@Singleton
public class SceneModelImpl implements SceneModel {

    private static final String LOG_TAG = "SceneModelImpl";

    @Inject EventManager eventManager;

    private List<Scene> mScenes;

    /**
     * Standard constructor with no elements
     */
    public SceneModelImpl (){
        Log.i(LOG_TAG, "SceneModelImpl Constructor : " + this);
    }

    public SceneModelImpl (List<Scene> sceneList){
        mScenes = sceneList;
    }

    @Override
    public List<Scene> getScenes() {
        return mScenes;
    }

    @Override
    public void addSceneList(ArrayList<Scene> scenes) {
        if ( mScenes != null ) {
            destroy ();
            //init();
        }
        mScenes = scenes;
    }

    @Override
    public void addSceneList(ArrayList<Scene> scenes, boolean reset) {
        if ( reset ) {
            destroy();
            //init();
        }

        //iterate through the list and push each scene
        Iterator<Scene> iterator = scenes.iterator();

        for (Scene scene :
                scenes) {
            mScenes.add(scene);
        }
    }

    @Override
    public void destroy() {
        mScenes.clear();
        mScenes = null;
        eventManager = null;
    }

    public void init(Context context) {

        Log.i("SceneModelImpl", "Context : " + context);

        //mScenes = new ArrayList<Scene>();

        RoboGuice.getInjector(context).injectMembers(this);
        //Log.i("SceneModelImpl", "EventManager : " + this.eventManager);


        /*Log.i("SceneModelImpl", "Initialized.");
        //Log.i("SceneModelImpl", "Event Manager:"+eventManager);

        if ( eventManager != null ){
            Log.i("SceneModelImpl", "Sending an event that the scene model is initialized.");
            eventManager.fire(new SceneModelUpdateEvent());
        }*/


    }


}
