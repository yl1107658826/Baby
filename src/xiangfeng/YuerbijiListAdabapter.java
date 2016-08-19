package com.example.baby;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class YuerbijiListAdabapter extends BaseAdapter {
	List<YuerbijiBean> list;//数据源
	private LayoutInflater mInflater;

	public YuerbijiListAdabapter(Context context) {
		this.mInflater = LayoutInflater.from(context);
	}
  /**
   * 传入数据源
   * @param list
   */
	public void setdata(List<YuerbijiBean> list){
		this.list=list;
		notifyDataSetInvalidated();
		
	}
	
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list == null ? 0 : list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		viewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.yuerbiji_list_item, null);
			holder = new viewHolder();
			holder.date = (TextView) convertView.findViewById(R.id.date);
			holder.cover = (ImageView) convertView.findViewById(R.id.cover);
			holder.centent = (TextView) convertView.findViewById(R.id.content);
			convertView.setTag(holder);

		} else {
			holder = (viewHolder) convertView.getTag();
		}

		holder.date.setText(list.get(position).date);
		holder.cover.setBackgroundResource(list.get(position).cover);
		holder.centent.setText(list.get(position).content);

		return convertView;
	}

	class viewHolder {
		TextView date;
		ImageView cover;
		TextView centent;

	}

}

