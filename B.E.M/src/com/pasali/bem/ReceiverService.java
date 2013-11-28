package com.pasali.bem;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

public class ReceiverService extends Service {

	private String data;

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public int onStartCommand(Intent intent, int flags, int startId) {
		Bundle b = intent.getExtras();
		if (b != null) {
			data = b.getString("data");
		}
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(
							MainActivity.socket.getOutputStream())), true);
			out.println(data);
		} catch (UnknownHostException e1) {
			System.err.println("Bilinmeyen Sunucu");
		} catch (IOException e1) {
			System.err.println("Bağlantı Kurulamadı.");
		}
		return START_NOT_STICKY;
	}

}
