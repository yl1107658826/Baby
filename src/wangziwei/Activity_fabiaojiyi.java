package com.example.baby;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_fabiaojiyi extends Activity {
	private ImageButton btn2,btn3;
	private Button btn;
	private EditText edittext;
	private TextView textview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_fabiaojiyi);
		
		btn=(Button)findViewById(R.id.btn_addhuiyi);
		btn2=(ImageButton)findViewById(R.id.btn_back3);
		btn3=(ImageButton)findViewById(R.id.btn_addimg2);
		edittext=(EditText)findViewById(R.id.edittext);
		textview=(TextView)findViewById(R.id.btn_wenzihuiyi2);
		btn.setOnClickListener(onClickListener);
		btn2.setOnClickListener(onClickListener);
		btn3.setOnClickListener(onClickListener);
		textview.setOnClickListener(onClickListener);
	
		
	}
	OnClickListener onClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.btn_addhuiyi:
			String code =edittext.getText().toString().trim();
			SharedPreferences.Editor editor=getSharedPreferences("text", MODE_WORLD_WRITEABLE).edit();
			editor.putString("code", code);
			editor.commit();
			Toast.makeText(getApplicationContext(), "保存成功", Toast.LENGTH_LONG).show();
				break;
			case R.id.btn_back3:
				Intent intent=new Intent(Activity_fabiaojiyi.this,Note_Fragment.class);
				startActivity(intent);
				break;
			case R.id.btn_wenzihuiyi2:
					Intent intent2 =new Intent(Activity_fabiaojiyi.this,Activity_youjiyidemoshi.class);
					startActivity(intent2);
					SharedPreferences read = getSharedPreferences("text", MODE_WORLD_READABLE); 
	                //步骤2：获取文件中的值 
					String value = read.getString("code", ""); 
	                
				break;
			case R.id.btn_addimg2:
				Intent intent1 = new Intent();
		        intent1.setAction(Intent.ACTION_VIEW);
		        intent1.setType("image/*");
		        startActivity(intent1);
		   
		        Intent intent3= new Intent();
		        intent3.setAction(Intent.ACTION_GET_CONTENT);
		        intent3.setType("image/*");
		        startActivityForResult(Intent.createChooser(intent3, "Select Picture"),1);
		        break;
				default:
					break;
			}
			
			
		}
	};

}
