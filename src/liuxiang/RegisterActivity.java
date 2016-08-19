package com.example.baby;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class RegisterActivity extends Activity{
	Button button;
	ImageButton imagebutton;
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		setContentView(R.layout.register_layout);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		button=(Button)findViewById(R.id.register_button);
		button.setOnClickListener(clickListener);
		imagebutton=(ImageButton)findViewById(R.id.back_button);
		imagebutton.setOnClickListener(clickListener);
	}
	OnClickListener clickListener=new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.register_button:
				Intent intent1=new Intent(RegisterActivity.this,MainActivity.class);
				startActivity(intent1);
				break;
			case R.id.back_button:
				Intent intent2=new Intent(RegisterActivity.this,LoginActivity.class);
				startActivity(intent2);
				break;
			default:
				break;
			}
		}};
}
