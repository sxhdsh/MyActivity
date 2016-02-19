package com.fragmentdemo5_commute;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

/**
 * 一、Fragment从Activity获取数据。
 */
public class MainActivity extends Activity {
	private FragmentManager manager;
	private FragmentTransaction transaction;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		manager = getFragmentManager();
		transaction = manager.beginTransaction();

		MyFragment1 fragment1 = new MyFragment1();
		Bundle bundle1 = new Bundle();
		bundle1.putString("id", "Activity发送给MyFragment1的数据");
		fragment1.setArguments(bundle1);
		transaction.replace(R.id.left, fragment1, "left");

		MyFragment2 fragment2 = new MyFragment2();
		Bundle bundle2 = new Bundle();
		bundle2.putString("id", "Activity发送给MyFragment2的数据");
		fragment2.setArguments(bundle2);
		transaction.replace(R.id.right, fragment2, "right");

		transaction.commit();


	}

}
