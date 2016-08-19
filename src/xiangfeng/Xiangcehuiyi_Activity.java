package com.example.baby;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Xiangcehuiyi_Activity extends Activity{
	/*ImageView fanhui;
	TextView yuerbiji;
	TextView bianji;
	TextView wenzihuiyi;
	TextView diy;
	TextView xiangcehuiyi;
	TextView shouye;
	TextView biji;
	TextView wode;*/
	Button baocun;
	ImageView image;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xiangcehuiyi);
		/*fanhui = (ImageView) findViewById(R.id.fanhui_view);
		fanhui.setOnClickListener(l);
		yuerbiji = (TextView) findViewById(R.id.yuerbiji_view);
		yuerbiji.setOnClickListener(l);
		bianji = (TextView) findViewById(R.id.bianji_view);
		bianji.setOnClickListener(l);
		wenzihuiyi = (TextView) findViewById(R.id.wenzihuiyi_view);
		wenzihuiyi.setOnClickListener(l);
		diy = (TextView) findViewById(R.id.diy_view);
		diy.setOnClickListener(l);
		xiangcehuiyi = (TextView) findViewById(R.id.xiangcehuiyi_view);
		xiangcehuiyi.setOnClickListener(l);
		shouye = (TextView) findViewById(R.id.shuoye_view);
		shouye.setOnClickListener(l);
		biji = (TextView) findViewById(R.id.biji_view);
		biji.setOnClickListener(l);
		wode = (TextView) findViewById(R.id.wode_view);
		wode.setOnClickListener(l);*/
		baocun = (Button) findViewById(R.id.baocun_button);
		baocun.setOnClickListener(l);
		image=(ImageView) findViewById(R.id.fanhui_view);
		image.setOnClickListener(l);

	}

	OnClickListener l = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			/*case R.id.fanhui_view:
				break;
			case R.id.yuerbiji_view:
				break;
			case R.id.bianji_view:
				break;
			case R.id.wenzihuiyi_view:
				break;
			case R.id.diy_view:
				
				break;
			case R.id.xiangcehuiyi_view:
				Intent  intent=new Intent(Xiangcehuiyi_Activity.this,Tiao_yemiao_xf.class);
				  startActivity(intent);
				break;
			case R.id.shuoye_view:
				Intent  intent3=new Intent(Xiangcehuiyi_Activity.this,Zhuye_xf.class);
				  startActivity(intent3);
				break;
			case R.id.biji_view:
				
				break;
			case R.id.wode_view:
				Intent intent1=new Intent(Xiangcehuiyi_Activity.this,Text_shouye.class);
				startActivity(intent1);
				break;*/
			case R.id.baocun_button:
				Intent intent=new Intent(Xiangcehuiyi_Activity.this,Tiao_yemiao_xf.class);
				   startActivity(intent);
				break;
			case R.id.fanhui_view:
				Intent intent2=new Intent(Xiangcehuiyi_Activity.this,Activity_gexingdiy.class);
				startActivity(intent2);
				break;
			}
		}

	};

}
