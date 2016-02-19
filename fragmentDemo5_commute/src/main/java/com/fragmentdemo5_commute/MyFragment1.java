package com.fragmentdemo5_commute;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment1 extends Fragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f1, null);
		
		TextView textView = (TextView) view.findViewById(R.id.textView);
		Bundle bundle1 = getArguments();
		textView.setText(bundle1.getString("id"));
		return view;
	}

}
