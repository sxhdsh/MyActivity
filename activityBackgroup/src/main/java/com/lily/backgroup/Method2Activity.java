package com.lily.backgroup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Method2Activity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.method2);
		Button bt_toMethod1 = (Button) findViewById(R.id.toMethod1);
		bt_toMethod1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Method2Activity.this, Method1Activity.class);
				startActivity(intent);
				finish();
			}
		});
		Button bt_toMethod3 = (Button) findViewById(R.id.toMethod3);
		bt_toMethod3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Method2Activity.this, Method3Activity.class);
				startActivity(intent);
				finish();
			}
		});
	}

}
