package com.marakana.android.logcommon;

import com.marakana.android.logcommon.Message;
import com.marakana.android.logcommon.ILogListener;

interface ILogService {
	int log(int priority, String tag, String message);
	void logMessage(in Message message);
	void logd(String tag, String message);
	void asyncLog(in Message message, in ILogListener listener);
}