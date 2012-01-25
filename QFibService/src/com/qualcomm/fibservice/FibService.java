package com.qualcomm.fibservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.qualcomm.fibcommon.IFibService;

public class FibService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return new IFibServiceImpl();
	}

	
}

/** Implementation of our IFibService. */
class IFibServiceImpl extends IFibService.Stub {

	@Override
	public long fibJI(long n) throws RemoteException {
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
