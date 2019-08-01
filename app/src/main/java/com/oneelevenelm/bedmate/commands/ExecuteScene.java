/*
 * ********************************************************
 *
 * Copyright (c) 2016.
 * by 111ELM Design, LLC
 *
 * ********************************************************
 */

package com.oneelevenelm.bedmate.commands;

/**
 * Command to execute a scene.
 */

public class ExecuteScene implements Command {
    private final int mId;

    public ExecuteScene(int id){
        mId = id;
    }
    @Override
    public void execute() {
        //Need to execute the scene associated with the correct id
    }
}
