package com.pasali.bem;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

public class RoutingService extends Service {

	private Socket socket;
	private static final int PORT = 1238;
	private static final String serverIp = "192.168.1.34";
	private String message;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onStart(Intent intent, int startId) {
		new Thread(new ClientThread()).start();	
		Bundle b = intent.getExtras();
		if (b != null) {
			message = b.getString("msg");
		}
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream())), true);
			out.println(message);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class ClientThread implements Runnable {

		@Override
		public void run() {

			try {
				InetAddress serverAddr = InetAddress.getByName(serverIp);
				socket = new Socket(serverAddr, PORT);
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

	}
}
