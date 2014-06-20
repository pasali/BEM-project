package com.pasali.bem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	public static Socket socket;
	private static final int PORT = 5353;
	private static String serverIp;
	private BufferedReader in;
	private String[] MsgToSend;
	private Handler h;

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

			}
		});

	}

	class Client implements Runnable {

		@Override
		public void run() {
			try {
				/*
				 * Sunucu ile bağlantıyı kur
				 */
				InetAddress serverAddr = InetAddress.getByName(serverIp);
				socket = new Socket(serverAddr, PORT);
				in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				h = new Handler(getApplicationContext().getMainLooper());
				h.post(new Runnable() {
					@Override
					public void run() {
						Toast.makeText(getApplicationContext(),
								"Bağlantı kuruldu.", Toast.LENGTH_LONG).show();
					}
				});
				/*
				 * Sunucudan gelen mesajı ilgili numaraya ilet
				 */
				while (true) {

					MsgToSend = in.readLine().split("\\|");
					System.out.println(MsgToSend);
					SmsManager smsManager = SmsManager.getDefault();
					if (!MsgToSend[0].equals("")) {
						smsManager.sendTextMessage(MsgToSend[1], null,
								MsgToSend[0], null, null);
					}
				}
			} catch (UnknownHostException e1) {
				System.err.println("Bilinmeyen Sunucu");
			} catch (IOException e1) {
				System.err.println("Bağlantı Kurulamadı.");
			} catch (NullPointerException e1) {
				stopService(new Intent(ReceiverService.SERVICE));
			}

		}

	}

}