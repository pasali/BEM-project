package com.pasali.bem;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {

	private String msg, sender;
	private String data;
	private SmsMessage[] msgs = null;

	@Override
	/*
	 * Telefona gelen mesajları yakala, paketleyip ReceiverService'e gönder
	 */
	public void onReceive(Context context, Intent intent) {

		Bundle bundle = intent.getExtras();
		if (bundle != null) {
			try {
				Object[] pdus = (Object[]) bundle.get("pdus");
				msgs = new SmsMessage[pdus.length];
				for (int i = 0; i < msgs.length; i++) {
					msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
					msg = msgs[i].getMessageBody();
					sender = msgs[i].getOriginatingAddress();
				}
			} catch (Exception e) {
				Log.d("Hata !", "" + e.getMessage());
			}
		}

		data = msg + "|" + sender;
		Intent i = new Intent();
		i.setClassName("com.pasali.bem", "com.pasali.bem.ReceiverService");
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
				| Intent.FLAG_ACTIVITY_CLEAR_TOP
				| Intent.FLAG_ACTIVITY_NEW_TASK);
		i.putExtra("data", data);
		context.startService(i);

	}
}
