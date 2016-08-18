package homepage_adapter;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.example.method.R;
public class Growupitem_Adapter extends BaseAdapter{
	int width;
	ArrayList<String> sort;   //育儿成长分组的文字
	LayoutInflater inflater;
    ArrayList<String> groupupgame_lable;       //育儿成长娱乐类文字
    ArrayList<Integer> groupupgame_icon;     //育儿成长娱乐类的图片
    ArrayList<String> groupupprimary_lable;    //育儿成长启迪类文字
    ArrayList<Integer> groupupprimary_icon;  //育儿成长启迪类的图片
    ArrayList<String> groupupinteract_lable;   //育儿成长互动类文字
    ArrayList<Integer> groupupinteract_icon; //育儿成长互动类的图片
	public  Growupitem_Adapter(LayoutInflater inflater,Data data) {
		this.inflater=inflater;
		this.width=data.getWidth();
		this.sort=data.getGroupup_sort();
		this.groupupgame_lable=data.getGroupup_game_lable();
		this.groupupgame_icon=data.getGroupup_game_icon();
		this.groupupprimary_lable=data.getGroupup_primary_lable();
		this.groupupprimary_icon=data.getGroupup_primary_icon();
		this.groupupinteract_lable=data.getGroupup_interact_lable();
		this.groupupinteract_icon=data.getGroupup_interact_icon();
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return sort.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	@SuppressLint("NewApi")
	@Override
	public View getView(int position, View convertview, ViewGroup viewgroup) {
		convertview=inflater.inflate(R.layout.homepage_groupup_gridview, null);
		TextView growuptitle=(TextView)convertview.findViewById(R.id.tv_group_title);
		GridView gridView=(GridView)convertview.findViewById(R.id.gridview);
		growuptitle.setText(sort.get(position));
		int distant=gridView.getHorizontalSpacing();
		if(position==0)
		{
			Groupup_child_Adapter adapter=new Groupup_child_Adapter(inflater, width,distant,groupupgame_icon, groupupgame_lable);
			gridView.setAdapter(adapter);
		}
		if(position==1)
		{
			
			Groupup_child_Adapter adapter=new Groupup_child_Adapter(inflater, width,distant,groupupprimary_icon, groupupprimary_lable);
			int count=(adapter.getCount()%3>0)?(int)adapter.getCount()/3+1:adapter.getCount()/3;
			int height=0;
			for(int i=0;i<count;i++)
			{
				View view=adapter.getView(i, null, gridView);
				view.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
				height+=view.getMeasuredHeight();
			}
			
			int total=height+(count-1)*gridView.getVerticalSpacing();
			gridView.setLayoutParams(new LayoutParams(-1, total));
			System.out.println(total);
			gridView.setAdapter(adapter);	
		
		}
		if(position==2)
		{
			Groupup_child_Adapter adapter=new Groupup_child_Adapter(inflater,width,distant,groupupinteract_icon, groupupinteract_lable);
			gridView.setAdapter(adapter);
		}
		return convertview;
	}

}
