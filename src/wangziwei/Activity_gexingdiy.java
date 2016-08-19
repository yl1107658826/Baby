package com.example.baby;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Activity_gexingdiy extends Activity{
	private Button btn,btn2;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_xiangcehuiyi);
/*	btn=(Button)findViewById(R.id.btn_back3);
	btn2=(Button)findViewById(R.id.btn_addimg);
	btn.setOnClickListener(onClickListener);*/
}
OnClickListener onClickListener=new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btn_back3:
			Intent intent=new Intent(Activity_gexingdiy.this,Note_Fragment.class);
			startActivity(intent);
			break;
			default:
				break;
		}
	}
};
}
