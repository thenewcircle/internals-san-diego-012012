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
    		
    		// Use library to do calculations
    		long fibJR = FibLib.fibJR(n);
    		
    		// Print the output
    		out.append( String.format("\nfibJR(%d)=%d", n, fibJR) );
    }
}