package com.qualcomm.fibservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.qualcomm.fibcommon.IFibService;

public class FibService extends Service {
	static final String TAG = "QFib";

	@Override
	public IBinder onBind(Intent intent) {
		Log.d(TAG, "onBind");
		return new IFibServiceImpl();
	}
	
}

/** Implementation of our IFibService. */
class IFibServiceImpl extends IFibService.Stub {

	@Override
	public long fibJI(long n) throws RemoteException {
		Log.d(FibService.TAG, "fibJI with n:"+n);
		return FibLib.fibJI(n);
	}

	@Override
	public long fibJR(long n) throws RemoteException {
		return FibLib.fibJR(n);
	}

	@Override
	public long fibNI(long n) throws RemoteException {
		return FibLib.fibNI(n);
	}

	@Override
	public long fibNR(long n) throws RemoteException {
		return FibLib.fibNR(n);
	}
	
}
