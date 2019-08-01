package com.oneelevenelm.bedmate.model;

import android.content.Context;

import com.oneelevenelm.bedmate.model.entities.Scene;
import com.oneelevenelm.bedmate.utils.Disposable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whipplejk on 11/4/16.
 */

public interface SceneModel extends Disposable {

    /**
     * Returns the current list of scenes that are available.
     * @return List of scenes
     */
    public List<Scene> getScenes();

    void addSceneList(ArrayList<Scene> scenes);
    void addSceneList(ArrayList<Scene> scenes, boolean reset);
    void init (Context context);
}