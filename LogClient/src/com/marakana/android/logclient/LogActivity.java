package com.marakana.android.logclient;

import com.marakana.android.loglib.LogLib;

import android.app.Activity;
import android.os.Bundle;

public class LogActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        LogLib.log(3, "MrknLog", "LogClient: onCreate");
    }
}