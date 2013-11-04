package com.pasali.bem;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {

	private String msgBody;
	private final String ACTION = "android.provider.Telephony.SMS_RECEIVED";
	private SmsMessage[] msgs = null;

	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals(ACTION)) {
			Bundle bundle = intent.getExtras();
			if (bundle != null) {
				try {
					Object[] pdus = (Object[]) bundle.get("pdus");
					msgs = new SmsMessage[pdus.length];
					for (int i = 0; i < msgs.length; i++) {
						msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
						msgBody = msgs[i].getMessageBody();
					}
				} catch (Exception e) {
					Log.d("Exception caught", e.getMessage());
				}
			}
		}
		Intent i = new Intent();
		i.setClassName("com.pasali.bem", "com.pasali.bem.RoutingService");
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
				| Intent.FLAG_ACTIVITY_CLEAR_TOP
				| Intent.FLAG_ACTIVITY_NEW_TASK);
		i.putExtra("msg", msgBody);
		context.startService(i);

	}
}
