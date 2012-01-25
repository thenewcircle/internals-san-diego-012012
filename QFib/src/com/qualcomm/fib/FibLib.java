package com.qualcomm.fib;


public class FibLib {

	public static long fibJR(long n) {
		if(n==0) return 0;
		if(n==1) return 1;
		return fibJR(n-1)+fibJR(n-2);
	}
	
	public static native long fibNR(long n);
	
	static {
		System.loadLibrary("fib");
	}
}
