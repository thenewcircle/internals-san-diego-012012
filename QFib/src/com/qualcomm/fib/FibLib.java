package com.qualcomm.fib;


public class FibLib {

	public static long fibJR(long n) {
		if(n==0) return 0;
		if(n==1) return 1;
		return fibJR(n-1)+fibJR(n-2);
	}
	
	public static long fibJI(long n) {
        long previous = -1;
        long result = 1;
        for (long i = 0; i <= n; i++) {
            long sum = result + previous;
            previous = result;
            result = sum;
        }
        return result;
    }
	
	public static native long fibNR(long n);
	public static native long fibNI(long n);
	
	static {
		System.loadLibrary("fib");
	}
}
