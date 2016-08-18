package homepage_adapter;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class HomePage_PagerAdapter extends PagerAdapter{
ArrayList<View> view;
public HomePage_PagerAdapter(ArrayList<View> view) {
	this.view=view;
}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		// TODO Auto-generated method stub
		return view==object;
	}
@Override
	public Object instantiateItem(ViewGroup container, int position) {
	
	    View v=view.get(position%view.size());
	    container.addView(v);
		return v;
	}
@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View)object);
	}
}
