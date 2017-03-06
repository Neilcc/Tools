package com.zcc.puzzle.demo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.zcc.puzzle.demo.ipc.CustomBinder;
import com.zcc.puzzle.demo.ipc.CustomClientProxy;

/**
 * Created by Hengyun on 06/03/2017.
 */

public class CustomClient extends Activity{

    private CustomClientProxy customClientProxy;

    public void bind(){
        Intent intent = new Intent();
        intent.setClassName(this, "com.zcc.puzzle.demo.service.MyRemoteServer");
        bindService(intent,mConection, Context.BIND_AUTO_CREATE);

    }

    private ServiceConnection mConection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            customClientProxy = new CustomClientProxy(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            customClientProxy = null;
        }
    };

}
