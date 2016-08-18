package homepage_adapter;

import java.util.ArrayList;

import com.example.method.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Groupup_child_Adapter extends BaseAdapter {
	LayoutInflater inflater;
	int width;
	int distant;
	ArrayList<Integer> icon;
	ArrayList<String> lable;

	public Groupup_child_Adapter(LayoutInflater inflater, int width,int distant,
			ArrayList<Integer> icon, ArrayList<String> lable) {
		this.inflater = inflater;
		this.width = width;
		this.distant=distant;
		this.icon = icon;
		this.lable = lable;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return icon.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	public View getView(int position, View convertview, ViewGroup arg2) {
		// TODO Auto-generated method stub
		convertview = inflater.inflate(R.layout.gridview_layout, null);
		ImageView iv = (ImageView) convertview.findViewById(R.id.iv);
		TextView title = (TextView) convertview.findViewById(R.id.tv);
		iv.setLayoutParams(new LayoutParams(-1, (width-distant*2)/3));
		iv.setImageResource(icon.get(position));
		title.setText(lable.get(position));
		return convertview;
	}

}
