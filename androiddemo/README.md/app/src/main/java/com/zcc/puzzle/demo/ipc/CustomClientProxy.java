package com.zcc.puzzle.demo.ipc;

import android.os.IBinder;

/**
 * Created by Hengyun on 06/03/2017.
 */

public class CustomClientProxy {
    IBinder remoteService;

    public CustomClientProxy(IBinder remoteService) {
        this.remoteService = remoteService;
    }

    public void doFunc (){

    }
}
