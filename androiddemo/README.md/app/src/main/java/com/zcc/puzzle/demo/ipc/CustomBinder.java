package com.zcc.puzzle.demo.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/**
 * Created by Hengyun on 06/03/2017.
 */

public class CustomBinder extends Binder implements android.os.IInterface {


    @Override
    public IBinder asBinder() {
        return null;
    }


    @Override
    protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {



        return super.onTransact(code, data, reply, flags);
    }
}
