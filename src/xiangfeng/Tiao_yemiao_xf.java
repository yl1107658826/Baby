package com.example.baby;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



public class Tiao_yemiao_xf extends Activity{
	TextView textview;
	Button button;
	ImageView image;
	

	ListView list_view;//申明list控件
	
	/**
	 * 创建数据源
	 */
	String[] dateArr = new String[] { "2016-8-17", "2016-8-19","2016-8-19","2016-8-19"};
	int[] coverArr = new int[] { R.drawable.mei, R.drawable.xiaorong ,R.drawable.mengnan,R.drawable.qinzui};
     String[] contentArr=new String[]{"好萌啊~~~~","好乖呀~~~","哈哈哈哈哈~~~","亲亲~~~~"};
     /**
      * 创建集合用来装数据源
      */
     List<YuerbijiBean> yuerbijilistBeans=new ArrayList<YuerbijiBean>();
     /**
      * 申明适配器
      */
     YuerbijiListAdabapter adabapter;
     
     
     
     /**
      * 创建视图，相当于程序入口
      */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		/**
		 * 设置内容时图
		 */
		setContentView(R.layout.xiangcehuiyi_2);
/**
 * 初始化listview控件
 */
		list_view = (ListView) findViewById(R.id.list_view);
		
		/**
		 * 初始化适配器
		 */
	adabapter=new YuerbijiListAdabapter(this);
	
	/**
	 * 初始化数据源
	 */
	for (int i = 0; i < dateArr.length; i++) {
		/**
		 * 实现数据类型
		 */
		YuerbijiBean bean=new YuerbijiBean();
		/**
		 * 给日期赋值
		 */
		bean.date=dateArr[i];
		/**
		 * 给图片赋值
		 */
		bean.cover=coverArr[i];
		/**
		 * 给内容赋值
		 */
		bean.content=contentArr[i];
		/**
		 * 将这一个数据装入集合
		 */
		yuerbijilistBeans.add(bean);
		
	}
	/**
	 * 绑定适配器
	 */
	list_view.setAdapter(adabapter);
	/**
	 * 将数据放入listview
	 */
	adabapter.setdata(yuerbijilistBeans);
	
	button=(Button) findViewById(R.id.tianjiatupian);
	button.setOnClickListener(l);
	image=(ImageView) findViewById(R.id.imageView1);
	image.setOnClickListener(l);
	}
	OnClickListener l = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			
			case R.id.imageView1:
			Intent intent3=new Intent(Tiao_yemiao_xf.this,Xiangcehuiyi_Activity.class);
			startActivity(intent3);
			break;
			
			case R.id.tianjiatupian:
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
				// Intent intent = new
				// Intent("android.media.action.IMAGE_CAPTURE");
				// Uri fromFile = Uri.fromFile(mCurrentPhotoFile);
				// String string = fromFile.toString();
				// Log.i("gp", string);
				// intent.putExtra(MediaStore.EXTRA_OUTPUT,
				// Uri.fromFile(mCurrentPhotoFile));
				//startActivityForResult(intent, CAPTURE_CODE);
				/**
				 * 选图片
				 */
				Intent intent1 = new Intent();
		        intent1.setAction(Intent.ACTION_VIEW);
		        intent1.setType("image/*");
		        startActivity(intent1);
		        
		        Intent intent2= new Intent();
		        intent2.setAction(Intent.ACTION_GET_CONTENT);
		        intent2.setType("image/*");
		        startActivityForResult(Intent.createChooser(intent2, "Select Picture"),1);
               break;
}
}
};


}
