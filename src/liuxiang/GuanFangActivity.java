package com.example.baby;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.method.Homepage_Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class GuanFangActivity extends Activity {
	ImageButton imageButton;
	ImageView imageView;
	TextView textview1;
	TextView textview2;
	ListView listview;
	ArrayAdapter arrayAdapter;
	SimpleAdapter simpleAdapter;
	List<String> lists=new ArrayList<String>();
    List<Map<String,Object>> listData=new ArrayList<Map<String,Object>>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.guanfangtuijian_layout);
		listview=(ListView)findViewById(R.id.tuijian_listview);
		imageButton=(ImageButton)findViewById(R.id.back_button);
		imageButton.setOnClickListener(clickListener);
		textview1=(TextView)findViewById(R.id.title_textview);
		//textview1.setOnClickListener(clickListener);
		textview2=(TextView)findViewById(R.id.abstract_textview);
		//textview2.setOnClickListener(clickListener);
		arrayAdapter=new ArrayAdapter(GuanFangActivity.this,R.layout.tuijian_listview_layout,R.id.title_textview,lists);
		String[] keys={"image","text1","text2"};
		int[] viewIds={R.id.listview_image,R.id.title_textview,R.id.abstract_textview};
		simpleAdapter=new SimpleAdapter(GuanFangActivity.this,listData,R.layout.tuijian_listview_layout,keys,viewIds);
		listview.setAdapter(simpleAdapter);
		getData();
		
	}
	OnClickListener clickListener=new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent=new Intent(GuanFangActivity.this,MainActivity.class);
			startActivity(intent);
		}};
	public void getData(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("image", R.id.listview_image);
		map.put("text1", "1岁以上宝宝安全注意事项大全");
		map.put("text2", "能够站起来后，你的宝宝周围就成为了一个全新的可以探索的世界—桌面、书架、抽屉盒其他从前够不到的地方......");
		listData.add(map);
		map=new HashMap<String,Object>();
		map.put("image",R.id.listview_image);
		map.put("text1", "半岁以后的宝宝为什么容易生病");
		map.put("text2", "不少妈妈都有这样的困惑：半岁以前，孩子身体特别健康，很少感冒、发烧，可是过了半岁，发烧、咳嗽、打喷嚏等小病不断。 专家解释说，半岁以前，孩子在胎儿期从母体中获得的免疫抗体还在.....");
		listData.add(map);
		map=new HashMap<String,Object>();
		map.put("image", R.id.listview_image);
		map.put("text1", "1岁以上宝宝安全注意事项大全");
		map.put("text2", "能够站起来后，你的宝宝周围就成为了一个全新的可以探索的世界—桌面、书架、抽屉盒其他从前够不到的地方......");
		listData.add(map);
	}
}
