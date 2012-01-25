package com.qualcomm.fibclient;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.qualcomm.fibcommon.IFibService;

public class FibActivity extends Activity {
	static final String TAG = "QFib";
	TextView out;
	EditText in;
	IFibService service;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		out = (TextView) findViewById(R.id.textView1);
		in = (EditText) findViewById(R.id.editText1);

		Intent intent = new Intent("com.qualcomm.fibcommon.IFibService");
		IFibServiceConnection connection = new IFibServiceConnection();
		boolean success = bindService(intent, connection, BIND_AUTO_CREATE);
		Log.d(TAG, "onCreate bound with: "+success);
	}

	/** Responsible for handing connection to the service. */
	class IFibServiceConnection implements ServiceConnection {
		@Override
		public void onServiceConnected(ComponentName component, IBinder binder) {
			service = IFibService.Stub.asInterface(binder);
			Log.d(TAG, "onServiceConnected");
		}

		@Override
		public void onServiceDisconnected(ComponentName component) {
			service = null;
			Log.d(TAG, "onServiceDisconnected");
		}
	}

	/** Called when button is clicked. */
	public void onClick(View v) {
		// Get input from user
		long n = Long.parseLong(in.getText().toString());

		Log.d(TAG, "onClicked with n="+n);
		
		try {
			// Java Recursive
			long start = System.currentTimeMillis();
			long fibJR = service.fibJR(n);
			long timeJR = System.currentTimeMillis() - start;
			out.append(String
					.format("\nfibJR(%d)=%d (%d ms)", n, fibJR, timeJR));

			// Native Recursive
			start = System.currentTimeMillis();
			long fibNR = service.fibNR(n);
			long timeNR = System.currentTimeMillis() - start;
			out.append(String
					.format("\nfibNR(%d)=%d (%d ms)", n, fibNR, timeNR));

			// Java Iterative
			start = System.nanoTime();
			long fibJI = service.fibJI(n);
			long timeJI = System.nanoTime() - start;
			out.append(String
					.format("\nfibJI(%d)=%d (%d ns)", n, fibJI, timeJI));

			// Native Iterative
			start = System.nanoTime();
			long fibNI = service.fibNI(n);
			long timeNI = System.nanoTime() - start;
			out.append(String
					.format("\nfibNI(%d)=%d (%d ns)", n, fibNI, timeNI));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}