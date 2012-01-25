#include "com_qualcomm_fib_FibLib.h"

jlong fibR(jlong n) {
	if(n==0) return 0;
	if(n==1) return 1;
	return fibR(n-1)+fibR(n-2);
}

JNIEXPORT jlong JNICALL Java_com_qualcomm_fib_FibLib_fibNR
  (JNIEnv *env, jclass clazz, jlong n) {
	return fibR(n);
}
