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
import com.example.baby.Xiangcehuiyi_Activity;

public class XiangCeHuiYi_Fragment extends Fragment{
	private Button btn;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view =inflater.inflate(R.layout.activity_xiangcehuiyi_contain, container,false);
		btn=(Button)view.findViewById(R.id.btn_addimg);
		btn.setOnClickListener(onClickListener);
		return view;
	}
OnClickListener onClickListener=new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent =new Intent(getActivity(),Xiangcehuiyi_Activity.class);
		startActivity(intent);
	}
};
}
