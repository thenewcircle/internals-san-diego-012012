#include "com_marakana_android_loglib_LogLib.h"
#include <stdio.h>
#include <android/log.h>

JNIEXPORT jint JNICALL
JNI_OnLoad(JavaVM *vm, void *reserved) {
	return JNI_VERSION_1_6;
}

JNIEXPORT void JNICALL Java_com_marakana_android_loglib_LogLib_log
  (JNIEnv *env, jclass clazz, jint priority, jstring tag, jstring message) {
	const jbyte *str_tag;
	const jbyte *str_message;
	str_tag = (*env)->GetStringUTFChars(env, tag, NULL);
	str_message = (*env)->GetStringUTFChars(env, message, NULL);
	__android_log_write(priority, str_tag, str_message);
	(*env)->ReleaseStringUTFChars(env, tag, str_tag);
	(*env)->ReleaseStringUTFChars(env, message, str_message);
}
