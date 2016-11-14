package edu.jju.test3;

import edu.jju.test3.adapter.TelAdapter;
import edu.jju.test3.sqliteopen.MySqlite;
import edu.jju.test3.sqliteopen.SqliteUtil;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import static edu.jju.test3.R.id.ed_text;
import static edu.jju.test3.R.id.popu_back;
import static edu.jju.test3.R.id.popu_tel;

/**
 *
 * @author Administrator
 *
 */
public class TelphoneActivity extends Activity {
	private ExpandableListView eView;
	private TelAdapter tAdapter;
	private SqliteUtil sqliteUtil;
	private TextView popu_tel,popu_back;
	private PopupWindow pWindow;
	public static String into;
	private Button more;
	private EditText ed_name,ed_tel,ed_group;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.telphone_layout);
		more=(Button) findViewById(R.id.more);
		text=(EditText) findViewById(R.id.ed_text);
		eView=(ExpandableListView) findViewById(R.id.expandableListview);
		eView.setGroupIndicator(null);
		tAdapter=new TelAdapter(TelphoneActivity.this);
		eView.setAdapter(tAdapter);
		sqliteUtil=new SqliteUtil(TelphoneActivity.this,"teltab");
		more.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				View view=getLayoutInflater().inflate(R.layout.popu_layout, null);
				popu_tel= (TextView) view.findViewById(R.id.popu_tel);
				popu_back= (TextView) view.findViewById(R.id.popu_back);
				pWindow=new PopupWindow(view, 280, 200);
				ColorDrawable background = new ColorDrawable(000000);
				pWindow.setBackgroundDrawable(background);
				pWindow.setFocusable(true);
				pWindow.showAsDropDown(more,-200,0);
				popu_tel.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						View view1=getLayoutInflater().inflate(R.layout.insert_tel_layout,null);
						ed_name= (EditText) view1.findViewById(R.id.ed_name);
						ed_tel= (EditText) view1.findViewById(R.id.ed_tel);
						ed_group= (EditText) view1.findViewById(R.id.ed_group);
						String name=ed_name.getText().toString();
						String tel=ed_tel.getText().toString();
						String group=ed_group.getText().toString();
						sqliteUtil.insert_(name,tel,group);

					}
				});
				popu_back.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						finish();
					}
				});
			}
		});
	}
	private TextView name,tel;
	private EditText text;
	public void sousuo(View v) {
		into=text.getText().toString();
		View view=getLayoutInflater().inflate(R.layout.tel_child_layout,null);
		name= (TextView) view.findViewById(R.id.child_name);
		tel= (TextView) view.findViewById(R.id.child_tel);
		pWindow=new PopupWindow(view,400,400);
		pWindow.setFocusable(true);
		pWindow.showAsDropDown(text,0,0);
		sqliteUtil.query_(into);
	}
	
}
