package com.example.baby.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.baby.R;

public class FaBiaoJiYi_Fragment extends Fragment{
	private Button btn;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		btn.setOnClickListener(onClickListener);
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.activity_addtext, container, false);
		
		return view;
	}
	OnClickListener onClickListener =new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.btn_addtext:
				Intent intent =new Intent();
			}
		}
	 
 };
		 
}
