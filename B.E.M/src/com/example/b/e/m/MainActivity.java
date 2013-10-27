package com.example.b.e.m;

import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import android.view.View;

public class MainActivity extends Activity {
	private Button bt;
	private EditText et;
	private Client istemci;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bt = (Button) findViewById(R.id.button1);
		istemci = new Client();
		bt.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				new Thread(new Runnable() {
					public void run() {
						et = (EditText) findViewById(R.id.editText1);
						String str = et.getText().toString();
						try {
							istemci.Connect();
							istemci.SendMsg(str);

						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}).start();
			}
		});
	}
}