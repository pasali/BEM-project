package com.pasali.bem;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button bt = (Button) findViewById(R.id.button1);
		bt.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// EditText et = (EditText) findViewById(R.id.editText1);
				// String str = et.getText().toString();

			}
		});

	}
}