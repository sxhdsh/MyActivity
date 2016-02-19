package com.fragmentdemo5_commute;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment2 extends Fragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f2, null);
		
		TextView textView = (TextView) view.findViewById(R.id.textView);
		Bundle bundle2 = getArguments();
		textView.setText(bundle2.getString("id"));
		return view;
	}

}
