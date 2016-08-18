package homepage_adapter;

import java.util.ArrayList;







import com.example.method.R;

import android.R.anim;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

@SuppressLint("ResourceAsColor")
public class Assistant_Adapter extends BaseAdapter{
	 ArrayList<Integer> icon;
     ArrayList<String> bg;
     LayoutInflater inflater;
     public Assistant_Adapter(LayoutInflater inflater,ArrayList<Integer> icon,ArrayList<String> bg) {
	this.inflater=inflater;
    this.icon=icon;
    this.bg=bg;
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


	@Override
	public View getView(int position, View convertview, ViewGroup arg2) {
		convertview=inflater.inflate(R.layout.homepage_baby_asistant, null);
		LinearLayout linearLayout=(LinearLayout)convertview.findViewById(R.id.linearlayout);
		ImageView iv=(ImageView)convertview.findViewById(R.id.iv);
		linearLayout.setBackgroundColor(Color.parseColor(bg.get(position)));
		iv.setImageResource(icon.get(position));
		return convertview;
	}

}
