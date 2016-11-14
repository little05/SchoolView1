package edu.jju.test3.adapter;

import java.util.List;

import edu.jju.test3.R;
import edu.jju.test3.util.Imgutil;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Myadapter extends BaseAdapter {
	private List<Imgutil> olist;
	private Context ocontext;
	private LayoutInflater oinflater;
	
	public Myadapter ( Context ocontext, List<Imgutil> olist){
		this.ocontext=ocontext; 
		this.olist=olist;
		oinflater=LayoutInflater.from(ocontext);
	}

	@Override
	public int getCount() {
		return olist.size();
	}

	@Override
	public Object getItem(int position) {
		return olist.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		ViewHoulder ohoulder=null;
		if (view==null) {
			ohoulder=new ViewHoulder();
			view=oinflater.inflate(R.layout.listview_item_layout, null);
			ohoulder.list_img=(ImageView) view.findViewById(R.id.list_img);
			ohoulder.list_tv1=(TextView) view.findViewById(R.id.list_tv1);
			ohoulder.list_tv2=(TextView) view.findViewById(R.id.list_tv2);
			view.setTag(ohoulder);
		}else {
			ohoulder=(ViewHoulder) view.getTag();
		}
		ohoulder.list_img.setBackgroundResource(olist.get(position).getImg());
		ohoulder.list_tv1.setText(olist.get(position).getName_one());
		ohoulder.list_tv2.setText(olist.get(position).getNews());
		return view;
	}
	class ViewHoulder{
		ImageView list_img;
		TextView list_tv1,list_tv2;
	}
}
