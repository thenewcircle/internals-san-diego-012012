package com.marakana.android.logclient;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;

import com.marakana.android.logcommon.ILogService;
import com.marakana.android.logcommon.Message;

public class LogActivity extends Activity {
	static final Intent INTENT = new Intent(
			"com.marakana.android.logcommon.ILogService");
	ILogService service;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ILogServiceConnection connection = new ILogServiceConnection();
		boolean success = bindService(INTENT, connection, BIND_AUTO_CREATE);
	}

	/** Handles connection to the remote service. */
	class ILogServiceConnection implements ServiceConnection {
		@Override
		public void onServiceConnected(ComponentName component, IBinder binder) {
			service = ILogService.Stub.asInterface(binder);
		}
		
		@Override
		public void onServiceDisconnected(ComponentName component) {
			service = null;
		}
	}
	
	/** Called when button is clicked. */
	public void onClick(View v) {
		try {
			Message message = new Message(3, "MrknLog", "onClicked!");
			service.logMessage(message);
			service.logd("MrknLog", "onClicked logd");
//			service.log(3, "MrknLog", "onClicked!");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}