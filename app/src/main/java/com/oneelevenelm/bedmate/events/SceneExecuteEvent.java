/*
 * ********************************************************
 *
 * Copyright (c) 2016.
 * by 111ELM Design, LLC
 *
 * ********************************************************
 */

package com.oneelevenelm.bedmate.events;

/**
 * Basic scene execute event
 */

public class SceneExecuteEvent {
    private final int mId;

    public SceneExecuteEvent (int id){
        mId = id;
    }

    public int getId() {
        return mId;
    }
}
