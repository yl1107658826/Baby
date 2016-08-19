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

public class TalkingAboutActivity extends Activity{
	ImageView imageview_touxiang;
	ListView listview;
	TextView textview_nicheng;
	TextView textview_pinglun;
	TextView textview_date;
	ImageButton backbutton;
	ArrayAdapter arrayAdapter;
	SimpleAdapter simpleAdapter;
	List<String> lists=new ArrayList<String>();
	List<Map<String,Object>> listData=new ArrayList<Map<String,Object>>();
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.talkingabout_layout);
		listview=(ListView)findViewById(R.id.taolun_listview);
		imageview_touxiang=(ImageView)findViewById(R.id.touxiang_imageview);
		textview_nicheng=(TextView)findViewById(R.id.name_textview);
		textview_pinglun=(TextView)findViewById(R.id.talk_textview);
		textview_date=(TextView)findViewById(R.id.time_textview);
		arrayAdapter=new ArrayAdapter(TalkingAboutActivity.this,R.layout.talkingabout_listview_layout,R.id.name_textview);
		String[] keys={"imageview_touxiang","textview_nicheng","textview_pinglun","textview_date"};
		int[] viewIds={R.id.touxiang_imageview,R.id.name_textview,R.id.talk_textview,R.id.time_textview};
		simpleAdapter=new SimpleAdapter(TalkingAboutActivity.this,listData,R.layout.talkingabout_listview_layout,keys,viewIds);
		listview.setAdapter(simpleAdapter);
		backbutton=(ImageButton)findViewById(R.id.back_button);
		backbutton.setOnClickListener(clickListener);
		getData();
	};
	OnClickListener clickListener=new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent=new Intent(TalkingAboutActivity.this,MainActivity.class);
			startActivity(intent);
		}};
		public void getData(){
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("imageview_touxiang", R.drawable.touxiang_one);
			map.put("textview_nicheng", "paxoap");
			map.put("textview_pinglun", "说说你们俩口子的口味是否相同");
			map.put("textview_data", "2016/05/06");
			listData.add(map);
			map=new HashMap<String,Object>();
			map.put("imageview_touxiang", R.drawable.touxiang_two);
			map.put("textview_nicheng", "paxoap");
			map.put("textview_pinglun", "雨雨欣宝宝的穿衣搭配");
			map.put("textview_data", "2016/05/06");
			listData.add(map);
			map=new HashMap<String,Object>();
			map.put("imageview_touxiang", R.drawable.touxiang_three);
			map.put("textview_nicheng", "paxoap");
			map.put("textview_pinglun", "看见你老公手机里有黄片，你会生气么？");
			map.put("textview_data", "2016/05/06");
			listData.add(map);
			map=new HashMap<String,Object>();
			map.put("imageview_touxiang", R.drawable.touxiang_four);
			map.put("textview_nicheng", "paxoap");
			map.put("textview_pinglun", "别忽视“话少又乖巧的孩子”");
			map.put("textview_data", "2016/05/06");
			listData.add(map);
			map=new HashMap<String,Object>();
			map.put("imageview_touxiang", R.drawable.touxiang_five);
			map.put("textview_nicheng", "paxoap");
			map.put("textview_pinglun", "宝宝老吐奶");
			map.put("textview_data", "2016/05/06");
			listData.add(map);
			map=new HashMap<String,Object>();
			map.put("imageview_touxiang",R.drawable.touxiang_six);
			map.put("textview_nicheng", "paxoap");
			map.put("textview_pinglun", "求推荐一款不易上火的奶粉3段的");
			map.put("textview_data", "2016/05/06");
			listData.add(map);
			map=new HashMap<String,Object>();
			map.put("imageview_touxiang", R.drawable.touxiang_seven);
			map.put("textview_nicheng", "paxoap");
			map.put("textview_pinglun", "急急急急急急，宝宝拉的屎有颗粒是不是消化不良？需要怎么办？");
			map.put("textview_data", "2016/05/06");
			listData.add(map);
		}
}
