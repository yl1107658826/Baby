package com.example.baby;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class Activity_youjiyidemoshi extends Activity {
	private ImageButton btn;
	private ListView listview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_youjiyidemoshi);

		btn = (ImageButton) findViewById(R.id.btn_back2);
		listview = (ListView) findViewById(R.id.listview_wenzihuiyi);
		listview.setAdapter(new ArrayAdapter<String>(this,
				R.layout.listview_mian, getData()));
		btn.setOnClickListener(onClickListener);
	}

	private List<String> getData() {
		List<String> data = new ArrayList<String>();
		data.add("宝宝今天满月了，胖嘟嘟的好可爱啊！希望你长大以后能快快乐乐的。");
		data.add("宝宝今天满月了，胖嘟嘟的好可爱啊！希望你长大以后能快快乐乐的。");
		data.add("宝宝今天满月了，胖嘟嘟的好可爱啊！希望你长大以后能快快乐乐的。");
		data.add("宝宝今天满月了，胖嘟嘟的好可爱啊！希望你长大以后能快快乐乐的。");
		return data;
	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(Activity_youjiyidemoshi.this,
					Note_Fragment.class);
			startActivity(intent);
		}

	};
}
