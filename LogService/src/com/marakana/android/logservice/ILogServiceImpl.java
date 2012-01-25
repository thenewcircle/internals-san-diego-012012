package com.marakana.android.logservice;

import android.os.RemoteException;

import com.marakana.android.logcommon.ILogService;
import com.marakana.android.loglib.LogLib;

public class ILogServiceImpl extends ILogService.Stub {

	@Override
	public int log(int priority, String tag, String message) throws RemoteException {
		LogLib.log(priority, tag, message);
		return 0;
	}

}
