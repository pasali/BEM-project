package com.pasali.bem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.widget.Toast;

public class SenderService extends Service {

	private BufferedReader in;
	private String[] MsgToSend;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		try {
			in = new BufferedReader(new InputStreamReader(
					MainActivity.socket.getInputStream()));
			MsgToSend = in.readLine().split(",");
			System.out.println(MsgToSend[0]);
			SmsManager smsManager = SmsManager.getDefault();
			smsManager.sendTextMessage(MsgToSend[1], null, MsgToSend[0], null, null);
			
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(),
					"SMS gönderilirken bir hata oluştu.", Toast.LENGTH_LONG)
					.show();
			e.printStackTrace();
		}

		return super.onStartCommand(intent, flags, startId);
	}

}
