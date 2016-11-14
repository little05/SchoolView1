package edu.jju.test3;

import java.util.ArrayList;
import java.util.List;

import edu.jju.test3.adapter.Sousuoyadapter;
import edu.jju.test3.sqliteopen.SqliteUtil;
import edu.jju.test3.util.TelSqlutil;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

import static edu.jju.test3.TelphoneActivity.into;

public class SuosuoActivity extends Activity {
	private ListView listview;
	private Sousuoyadapter tAdapter;
	private List<TelSqlutil> telolist=new ArrayList<TelSqlutil>();
	private SqliteUtil sqliteUtil;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.suosuo_layout);
		listview=(ListView) findViewById(R.id.listview);
		//telolist=mytelsqlutil.select(TelphoneActivity.db, TelphoneActivity.nameStr, TelphoneActivity.telStr);
		sqliteUtil=new SqliteUtil(SuosuoActivity.this,"teltab");
		telolist=sqliteUtil.query_(into);
		tAdapter=new Sousuoyadapter(SuosuoActivity.this, telolist);
		listview.setAdapter(tAdapter);
	}

}
