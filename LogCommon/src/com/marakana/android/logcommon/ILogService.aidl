package com.marakana.android.logcommon;

import com.marakana.android.logcommon.Message;

interface ILogService {
	int log(int priority, String tag, String message);
	void logMessage(in Message message);
	void logd(String tag, String message);
}