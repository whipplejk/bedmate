package com.oneelevenelm.bedmate.model;

import com.oneelevenelm.bedmate.model.entities.Scene;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by whipplejk on 11/4/16.
 */

public class SceneModelImpl implements SceneModel {

    private List<Scene> mScenes;

    /**
     * Standard constructor with no elements
     */
    public SceneModelImpl (){
        init();
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
            init();
        }
        mScenes = scenes;
    }

    @Override
    public void addSceneList(ArrayList<Scene> scenes, boolean reset) {
        if ( reset ) {
            destroy();
            init();
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
    }

    private void init() {
        mScenes = new ArrayList<Scene>();
    }
}
