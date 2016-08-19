package com.example.baby;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class LoginActivity extends Activity{
	Button button1;
	Button button2;
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		setContentView(R.layout.login_layout);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		button1=(Button)findViewById(R.id.register_button);
		button1.setOnClickListener(clickListener);
		button2=(Button)findViewById(R.id.login_button);
		button2.setOnClickListener(clickListener);
	}
	OnClickListener clickListener=new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.register_button:
				Intent intent1=new Intent();
				startActivity(intent1);
				break;
			case R.id.login_button:
				Intent intent2=new Intent(LoginActivity.this,MainActivity.class);
				startActivity(intent2);
				break;
			default:
				break;
			}
		}};
}
