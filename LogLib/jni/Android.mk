LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_SRC_FILES := com_marakana_android_loglib_LogLib.c
LOCAL_LDLIBS += -llog
LOCAL_MODULE    := mrknlog

include $(BUILD_SHARED_LIBRARY)
