package homepage_adapter;

import java.util.ArrayList;

import com.example.method.R;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Chat_ListView_Adapter extends BaseAdapter{
LayoutInflater inflater;
ArrayList<Integer> chat_icon; //附近热聊的图片
ArrayList<String> chat_title;    //附近热聊的标题
ArrayList<String> chat_question; //附近热聊的问题
ArrayList<String> chat_answer;  //附近热聊的回答
public Chat_ListView_Adapter(LayoutInflater inflater,ArrayList<Integer> chat_icon,ArrayList<String> chat_title,
		ArrayList<String> chat_question,ArrayList<String> chat_answer)
{
	this.inflater=inflater;
	this.chat_icon=chat_icon;
	this.chat_title=chat_title;
	this.chat_question=chat_question;
	this.chat_answer=chat_answer;
}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return chat_icon.size();
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
		// TODO Auto-generated method stub
		convertview=inflater.inflate(R.layout.homepage_chat_listview_item, null);
		ImageView icon=(ImageView) convertview.findViewById(R.id.icon);
		TextView nickname=(TextView) convertview.findViewById(R.id.tv_nickname);
		TextView question=(TextView)convertview.findViewById(R.id.tv_question);
		TextView answer=(TextView)convertview.findViewById(R.id.tv_answer);
		icon.setImageResource(chat_icon.get(position));
		nickname.setText(chat_title.get(position));
		question.setText(chat_question.get(position));
		 answer.setText(chat_answer.get(position));
		return convertview;
	}

}
