package com.example.method;

import homepage_adapter.Data;
import homepage_adapter.HomePage_PagerAdapter;
import homepage_adapter.MyExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import android.R.anim;
import android.R.integer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.AndroidCharacter;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
public class MainActivity extends Activity {
ExpandableListView expandableView;
String[] titles={"育儿成长","育儿课堂","附近热聊","育儿小助手","亲子旅游","育儿健康小助手"};
int[] icons={R.drawable.icon_parenting_growth,R.drawable.icon_parent_class,R.drawable.icon_near_hot_chat,
		R.drawable.icon_parent_little_helper,R.drawable.icon_parent_child_travel,R.drawable.icon_children_little_helper};
String grouptitle;     //组的标题   
int group_icon;       //组的图片
ArrayList<String> groupup_sort;   //育儿成长分组的文字
ArrayList<String> groupup_game_lable;       //育儿成长娱乐类文字
ArrayList<Integer> groupup_game_icon;     //育儿成长娱乐类的图片
ArrayList<String> groupup_primary_lable;    //育儿成长启迪类文字
ArrayList<Integer> groupup_primary_icon;  //育儿成长启迪类的图片
ArrayList<String> groupup_interact_lable;   //育儿成长互动类文字
ArrayList<Integer> groupup_interact_icon; //育儿成长互动类的图片
ArrayList<Integer> chat_icon; //附近热聊的图片
ArrayList<String> chat_title;    //附近热聊的标题
ArrayList<String> chat_question; //附近热聊的问题
ArrayList<String> chat_answer;  //附近热聊的回答
ArrayList<Integer> assistant_icon; //育儿小助手的图片
ArrayList<String> assistant_bg;   //育儿小助手的背景颜色
ArrayList<String> health_lable;   //健康小助手的文字
ArrayList<Integer> health_icon; //健康小助手的图片
ArrayList<View> view;
ViewPager viewPager;
RadioGroup radioGroup;
boolean run=true;
protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage);
		expandableView=(ExpandableListView)findViewById(R.id.expandlable_listview);
		viewPager=(ViewPager)findViewById(R.id.viewpager);
		radioGroup=(RadioGroup)findViewById(R.id.radiogroup);
		int width=getWindowManager().getDefaultDisplay().getWidth();
		groupup_sort=new ArrayList<String>();
		groupup_game_icon=new ArrayList<Integer>();
		groupup_game_lable=new ArrayList<String>();
		groupup_primary_icon=new ArrayList<Integer>();
		groupup_primary_lable=new ArrayList<String>();
		groupup_interact_lable=new ArrayList<String>();
		groupup_interact_icon=new ArrayList<Integer>();
		chat_icon=new ArrayList<Integer>();
		chat_title=new ArrayList<String>();
		chat_question=new ArrayList<String>();
		chat_answer=new ArrayList<String>();
		assistant_icon=new ArrayList<Integer>();
		assistant_bg=new ArrayList<String>();
		health_icon=new ArrayList<Integer>();
		health_lable=new ArrayList<String>();
		view=new ArrayList<View>();
		/*
		 * 添加育儿成长的数据
		 */
		//育儿成长娱乐类分组文字
		groupup_sort.add("育儿娱乐类");
		groupup_sort.add("育儿启迪类");
		groupup_sort.add("亲子互动类");
		//育儿成长娱乐类图片
		for(int i=0;i<10;i++)
		{
			
		groupup_game_icon.add(R.drawable.ic_launcher);
		}
		groupup_game_lable.add("天天爱儿歌");
		groupup_game_lable.add("宝宝听故事");
		groupup_game_lable.add("宝宝爱游戏");
	   
	    /*
	     * 添加启迪类的数据
	     */
	   for(int i=0;i<8;i++)
		{
		   groupup_primary_icon.add(R.drawable.ic_launcher);
		}
	    groupup_primary_lable.add("寓言篇");
	    groupup_primary_lable.add("成长篇");
	    groupup_primary_lable.add("幼儿英语篇");
	    groupup_primary_lable.add("寓言篇");
	    groupup_primary_lable.add("成长篇");
	    groupup_primary_lable.add("幼儿英语篇");
	    groupup_primary_lable.add("白雪公主");
	    groupup_primary_lable.add("寓言故事");
	    /*
	     * 添加亲子互动类的数据
	     */
	    groupup_interact_lable.add("天天画板");
	    groupup_interact_lable.add("儿童右脑记忆");
	    groupup_interact_lable.add("宝贝美食家");
	    groupup_interact_lable.add("超级拼图");
	    groupup_interact_lable.add("小小歌唱家");
	    groupup_interact_lable.add("跟我学");
	    for(int i=0;i<6;i++)
	    {
	    	groupup_interact_icon.add(R.drawable.ic_launcher);
	    }
	    
	    //添加聊天的图片 , 添加聊天的文字
	    for(int i=0;i<3;i++)
	    {
	    	 chat_icon.add(R.drawable.ic_launcher);  
	    	 chat_question.add("7个月宝宝可以长期坐吗？");
	    	 chat_answer.add("别把你的女人不当回事，总有一天，会有另外一个男人，感激你不懂得她的好。");
	    }
	    chat_title.add("kity");
	    chat_title.add("kangkang");
	    chat_title.add("jing");
	  for(int i=0;i<2;i++)
	  {
		  assistant_icon.add(R.drawable.babay_name); 
		  assistant_icon.add(R.drawable.baby_height); 
	  }
	 
		 assistant_bg.add("#C8F4FF"); 
		 assistant_bg.add("#465A4F"); 
		 assistant_bg.add("#FFCF73"); 
		 assistant_bg.add("#FFECEE"); 
		 
	    for(int i=0;i<4;i++)
	    {
	    	health_icon.add(R.drawable.ic_launcher);
	    }
	    health_lable.add("食谱健康");
	    health_lable.add("水果健康");
	    health_lable.add("运动健康");
	    health_lable.add("宝宝辅食");
	  
	    //expandable  总的数据
	   
			Data data=new Data();
			for(int i=0;i<titles.length;i++)
			{
				data.setGrouptitle(titles);
				data.setGroupicon(icons);
			}
			data.setWidth(width);
			data.setGroupup_sort(groupup_sort);
			data.setGroupup_game_icon(groupup_game_icon);
			data.setGroupup_game_lable(groupup_game_lable);
			data.setGroupup_primary_icon(groupup_primary_icon);
			data.setGroupup_primary_lable(groupup_primary_lable);
			data.setGroupup_interact_lable(groupup_interact_lable);
			data.setGroupup_interact_icon(groupup_interact_icon);
			data.setAssistant_icon(assistant_icon);
			data.setAssistant_bg(assistant_bg);
			data.setChat_icon(chat_icon);
			data.setChat_title(chat_title);
			data.setChat_question(chat_question);
			data.setChat_answer(chat_answer);
	     	data.setHealth_icon(health_icon);
	       	data.setHealth_lable(health_lable);
	    for(int i=0;i<assistant_bg.size();i++)
	    {
	    	View v=new View(this);
	    	v.setBackgroundColor(Color.parseColor(assistant_bg.get(i)));
	    	view.add(v);
	    }
	    MyExpandableListAdapter adapter=new MyExpandableListAdapter(MainActivity.this,data);
	    expandableView.setAdapter(adapter);
	    HomePage_PagerAdapter pagerAdapter=new HomePage_PagerAdapter(view);
	    viewPager.setOnPageChangeListener(pageChangeListener);
	    viewPager.setAdapter(pagerAdapter);
	    RadioButton radioButton=(RadioButton)radioGroup.getChildAt(0);
		radioButton.setChecked(true);
		viewPager.setCurrentItem(4000);
		handler.sendEmptyMessageDelayed(0, 5000);
	}
OnPageChangeListener pageChangeListener=new OnPageChangeListener() {
	
	@Override
	public void onPageSelected(int position) {
		int index=position%view.size();
	RadioButton radioButton=(RadioButton)radioGroup.getChildAt(index);
	radioButton.setChecked(true);
	}
	
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}
};
Handler handler =new Handler()
{
public void handleMessage(Message msg)
{
	if(run)
	{
	viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
	handler.sendEmptyMessageDelayed(0, 5000);
	}
};	
};
protected void onDestroy() 
{
	run=false;
	super.onDestroy();
	
};
}
