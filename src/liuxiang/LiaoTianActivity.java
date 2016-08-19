package com.example.baby;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class LiaoTianActivity extends Activity{
	ListView listview;
	ImageButton imagebutton;
	TextView textview;
	ImageView imageview;
	ArrayAdapter arrayAdapter;
	SimpleAdapter simpleAdapter;
	List<String> lists=new ArrayList<String>();
	List<Map<String,Object>> listdata=new ArrayList<Map<String,Object>>();
	protected void onCreate(Bundle bundle){
	super.onCreate(bundle);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.consult_layout);
	imagebutton=(ImageButton)findViewById(R.id.back_button);
	imagebutton.setOnClickListener(clickListener);
	listview=(ListView)findViewById(R.id.liaotian_listview);
	arrayAdapter=new ArrayAdapter(LiaoTianActivity.this,R.layout.consult_layout_listview,R.id.sender_text);
	String[] keys={"image","text"};
	int[]  viewIds={R.id.send_touxiang_image,R.id.sender_text};
	simpleAdapter=new SimpleAdapter(LiaoTianActivity.this,listdata,R.layout.consult_layout_listview,keys,viewIds);
	listview.setAdapter(simpleAdapter);
	getData();
	}
	
	OnClickListener clickListener=new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent=new Intent(LiaoTianActivity.this,MainActivity.class);
			startActivity(intent);
		}};
	public void getData(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("image", R.drawable.zhuanjia_image);
		map.put("text", "你好，欢迎来到育儿问答请问有什么可以帮到你的吗？");
		listdata.add(map);
		map=new HashMap<String,Object>();
		map.put("image", R.drawable.zhuanjia_image);
		map.put("text", "你好，欢迎来到育儿问答请问有什么可以帮到你的吗？");
		listdata.add(map);
		map=new HashMap<String,Object>();
		map.put("image", R.drawable.zhuanjia_image);
		map.put("text", "你好，欢迎来到育儿问答请问有什么可以帮到你的吗？");
		listdata.add(map);
		map=new HashMap<String,Object>();
		map.put("image", R.drawable.zhuanjia_image);
		map.put("text", "你好，欢迎来到育儿问答请问有什么可以帮到你的吗？");
		listdata.add(map);
	}
}
