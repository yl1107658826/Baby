package com.example.baby;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Activity_xiangcehuiyi extends Activity{
	private Button btn;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_gexindiy);
	//btn.setOnClickListener(clickListener);
}
OnClickListener clickListener=new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent=new Intent(Activity_xiangcehuiyi.this,Note_Fragment.class);
		startActivity(intent);
	}
};
}
