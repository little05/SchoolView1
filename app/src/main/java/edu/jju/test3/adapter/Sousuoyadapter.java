package edu.jju.test3.adapter;

import java.util.List;

import edu.jju.test3.R;
import edu.jju.test3.util.Imgutil;
import edu.jju.test3.util.TelSqlutil;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Sousuoyadapter extends BaseAdapter {
	private List<TelSqlutil> olist;
	private Context ocontext;
	private LayoutInflater oinflater;
	
	public Sousuoyadapter ( Context ocontext, List<TelSqlutil> telolist){
		this.ocontext=ocontext; 
		this.olist=telolist;
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
			view=oinflater.inflate(R.layout.sousuo_item_layout, null);
			ohoulder.tv_name=(TextView) view.findViewById(R.id.tv_name);
			ohoulder.tv_tel=(TextView) view.findViewById(R.id.tv_tel);
			ohoulder.group_name= (TextView) view.findViewById(R.id.group_name);
			view.setTag(ohoulder);
		}else {
			ohoulder=(ViewHoulder) view.getTag();
		}
		ohoulder.tv_name.setText(olist.get(position).getChild_name());
		ohoulder.tv_tel.setText(olist.get(position).getChild_tel());
		ohoulder.group_name.setText(olist.get(position).getGroup_name());
		return view;
	}
	class ViewHoulder{
		TextView tv_name,tv_tel,group_name;
	}
}
