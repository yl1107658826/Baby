package homepage_adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AbsListView.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.method.MainActivity;
import com.example.method.R;
public class MyExpandableListAdapter  extends BaseExpandableListAdapter{
    LayoutInflater inflater;
    Data data;
    Context context;
   public MyExpandableListAdapter (Context context,Data data)
   {
	  
	   this.context=context;
	   this.data=data;
	   inflater=LayoutInflater.from(context);
   }
	@Override
	public boolean areAllItemsEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object getChild(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getChildId(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return arg1;
	}

	@SuppressLint("NewApi")
	@Override
	public View getChildView(int groupId, int childId, boolean bool, View v,ViewGroup viewGroup) {
	
	
	if(groupId==0)
	{
	ListView listView =(ListView) inflater.inflate(R.layout.homepage_listview, null);
	Growupitem_Adapter adapter=new Growupitem_Adapter(inflater,data);
	listView.setAdapter(adapter);
	int count=adapter.getCount();
	int height=0;
	for(int i=0;i<count;i++)
	{
		View view=adapter.getView(i, null, listView);
		view.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
		height+=view.getMeasuredHeight();
	}
	int total=height+(count-1)*listView.getDividerHeight();
	listView.setLayoutParams(new LayoutParams(-1, total));
	System.out.println("total"+total);
	return listView;
	}
	if(groupId==3)
	{
	ListView listView =(ListView) inflater.inflate(R.layout.homepage_listview, null);
	Assistant_Adapter adapter=new Assistant_Adapter(inflater, data.getAssistant_icon(), data.getAssistant_bg());
	listView.setAdapter(adapter);
	int count=adapter.getCount();
	System.out.println("c"+count);
	int height =0;
	//View为RelativeLayout时,view.measure会报空指针。解决办法在相对布局外面套一个线性布局。
	for(int i=0;i<count;i++)
	{
		View view=adapter.getView(i, null, listView);
		view.measure(MeasureSpec.UNSPECIFIED,MeasureSpec.UNSPECIFIED);
		height+=view.getMeasuredHeight();
	}
	int total=height+(count-1)*listView.getDividerHeight();
	listView.setLayoutParams(new LayoutParams(-1, total));
	return listView;
	}
	if(groupId==2)
	{
	  ListView listView =(ListView)inflater.inflate(R.layout.homepage_listview, null);
	  Chat_ListView_Adapter adapter=new Chat_ListView_Adapter(inflater, data.getChat_icon(),data.getChat_title(),
		 data.getChat_question(), data.getChat_answer());
	 int count=adapter.getCount();
	 int height=0;
	 for(int i=0;i<count;i++)
	 {
		View view=adapter.getView(i, null, listView);
		view.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
		height+=view.getMeasuredHeight();
	 }
	 View foot=inflater.inflate(R.layout.homepage_join_chat,null);
	 TextView textView=(TextView) foot.findViewById(R.id.join_chat);
	 textView.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			
			 /*        点击之后跳转到热聊页面。
			 *  Intent intent=new Intent(context, MainActivity.class);
			 *  context.startActivity(intent);
			 */
		
		}
	});
	 foot.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
	 int total=height+(count-1)*listView.getDividerHeight();
	 listView.addFooterView(foot);//添加FooterView必须在设置适配器之前才能显示。
	 listView.setLayoutParams(new LayoutParams(-1, total+foot.getMeasuredHeight()));
	 listView.setChoiceMode(ListView.CHOICE_MODE_NONE);
	 listView.setAdapter(adapter);
	 return listView;
	}
	if(groupId==5)
	{
		GridView gridView=(GridView) inflater.inflate(R.layout.homepage_health_gridlayout,null);
		int distant=gridView.getHorizontalSpacing();
		Groupup_child_Adapter adapter=new Groupup_child_Adapter(inflater, data.getWidth(), distant, data.getHealth_icon(), data.getHealth_lable());
	    gridView.setAdapter(adapter);
	    int count=gridView.getCount();
	    int num=count%3>0?count/3+1:count/3;
	    int total=0;
	    for(int i=0;i<num;i++)
	    {
	    	View view=adapter.getView(i, null, gridView);
	    	view.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
	    	total+=view.getMeasuredHeight();
	    }
	    gridView.setLayoutParams(new LayoutParams(-1, total));
		return gridView;
	}
	return v;
	}

	@Override
	public int getChildrenCount(int group){
         
		if(group==0||group==3||group==5||group==2)
		{
			return 1;
		}
		return 0;
	}

	@Override
	public long getCombinedChildId(long arg0, long arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getCombinedGroupId(long arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getGroup(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGroupCount() {
		
		return data.getGroupicon().length;			
	}

	@Override
	public long getGroupId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getGroupView(int position, boolean bool, View view, ViewGroup viewgroup) {
		// TODO Auto-generated method stub
		View v=inflater.inflate(R.layout.homepage_expandablelistview_item, null);
		TextView title=(TextView)v.findViewById(R.id.tv_group_titles);
		ImageView icon=(ImageView)v.findViewById(R.id.iv_group_icon);
	    title.setText(data.getGrouptitle()[position]);
	    icon.setImageResource(data.getGroupicon()[position]);
		ImageView selector=(ImageView) v.findViewById(R.id.iv_down_up);
		if(bool)
		{
			selector.setEnabled(true);
		}
		else {
			selector.setEnabled(false);
		}
		return v;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public void onGroupCollapsed(int groupId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onGroupExpanded(int groupId) {
		// TODO Auto-generated method stub
		
	}


}
