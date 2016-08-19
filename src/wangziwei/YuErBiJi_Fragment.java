package com.example.baby;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class YuErBiJi_Fragment extends Fragment {
	private TextView tv;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_main, null);
		tv = (TextView) view.findViewById(R.id.btn_wenzihuiyi);
		tv.setOnClickListener(clickListener);
		return view;
	}

	OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(getActivity(), Note_Fragment.class);
			startActivity(intent);

		}
	};
}
