package com.pasali.bem;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	public static Socket socket;
	private static final int PORT = 1238;
	private static String serverIp;

	public static String getServerIp() {
		return serverIp;
	}

	public static void setServerIp(String serverIp) {
		MainActivity.serverIp = serverIp;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button bt = (Button) findViewById(R.id.button1);
		bt.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				/*
				 * ip adresini al ve serverIp'ye ata
				 */
				EditText et = (EditText) findViewById(R.id.editText1);
				String str = et.getText().toString();
				setServerIp(str);
				new Thread(new Client()).start();
				Toast.makeText(getApplicationContext(),
						str + " ip adresine bağlanıldı.", Toast.LENGTH_SHORT).show();
			}
		});

	}

	class Client implements Runnable {

		@Override
		public void run() {
			try {
				InetAddress serverAddr = InetAddress.getByName(serverIp);
				socket = new Socket(serverAddr, PORT);
			} catch (UnknownHostException e1) {
				System.err.println("Bilinmeyen Sunucu");
			} catch (IOException e1) {
				System.err.println("Bağlantı Kurulamadı.");
			}

		}

	}

}