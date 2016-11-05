package com.oneelevenelm.bedmate.models;

import com.oneelevenelm.bedmate.model.SceneModel;
import com.oneelevenelm.bedmate.model.SceneModelImpl;
import com.oneelevenelm.bedmate.model.entities.Scene;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * Created by whipplejk on 11/4/16.
 */

@RunWith(MockitoJUnitRunner.class)
public class SceneModelTest {
    @Mock
    private SceneModel mSceneModel;


    @Before
    public final void setUp (){

    }

    @After
    public void tearDown(){
        mSceneModel.destroy();
    }

    @Test
    public void sceneListNotNull (){
        assertNotNull(mSceneModel.getScenes());
    }

    @Test
    public void sceneCount (){
        assertEquals(mSceneModel.getScenes().size(), 0);
    }

    @Test
    public void retrieveScenes (){

        ArrayList<Scene> scenes = new ArrayList<Scene>();
        scenes.add(new Scene());
        //Mock the return value of scenes
        when (mSceneModel.getScenes()).thenReturn(scenes);

        assertEquals(mSceneModel.getScenes().size(), 1);
    }

    @Test
    public void addSceneListViaConstructorThenTestSize (){
        ArrayList<Scene> scenes = new ArrayList<Scene>();
        scenes.add(new Scene());

        mSceneModel = new SceneModelImpl(scenes);

        assertEquals(mSceneModel.getScenes().size(), 1);
    }

    @Test
    public void addScenesViaMethodThenTestSize(){
        ArrayList<Scene> scenes = new ArrayList<Scene>();
        scenes.add(new Scene());
        mSceneModel = new SceneModelImpl();
        mSceneModel.addSceneList(scenes);
        assertEquals(mSceneModel.getScenes().size(), 1);
    }

    @Test
    public void addScenesAndResetViaMethodThenTestSize(){
        ArrayList<Scene> scenes = new ArrayList<Scene>();
        scenes.add(new Scene());
        ArrayList<Scene> scenesTwo = new ArrayList<Scene>();
        scenesTwo.add(new Scene());
        mSceneModel = new SceneModelImpl(scenes);
        mSceneModel.addSceneList(scenesTwo, true);
        assertEquals(mSceneModel.getScenes().size(), 1);
    }

    @Test
    public void addScenesButDontViaMethodThenTestSize(){
        ArrayList<Scene> scenes = new ArrayList<Scene>();
        scenes.add(new Scene());
        ArrayList<Scene> scenesTwo = new ArrayList<Scene>();
        scenesTwo.add(new Scene());
        mSceneModel = new SceneModelImpl();
        mSceneModel.addSceneList(scenes);
        assertEquals(mSceneModel.getScenes().size(), 1);
        mSceneModel.addSceneList(scenesTwo, false);
        assertEquals(mSceneModel.getScenes().size(), 2);
    }
}
