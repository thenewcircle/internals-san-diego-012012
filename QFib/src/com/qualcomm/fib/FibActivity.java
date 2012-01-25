package com.qualcomm.fib;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FibActivity extends Activity {
	TextView out;
	EditText in;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        out = (TextView)findViewById(R.id.textView1);
        in = (EditText)findViewById(R.id.editText1);
    }
    
    /** Called when button is clicked. */
    public void onClick(View v) {
    		// Get input from user
    		long n = Long.parseLong( in.getText().toString() );
    		
    		// Java Recursive
    		long start = System.currentTimeMillis();
    		long fibJR = FibLib.fibJR(n);
    		long timeJR = System.currentTimeMillis() - start;
       	out.append( String.format("\nfibJR(%d)=%d (%d ms)", n, fibJR, timeJR) );
    		
    		// Native Recursive
       	start = System.currentTimeMillis();
    		long fibNR = FibLib.fibNR(n);
    		long timeNR = System.currentTimeMillis() - start;
    		out.append( String.format("\nfibNR(%d)=%d (%d ms)", n, fibNR, timeNR) );

    }
}