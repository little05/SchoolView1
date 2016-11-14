package edu.jju.test3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class ChuxinActivity extends Activity {
	private TextView querylocation, queryline, myposition, tv_title;
	private ImageView tv_img;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.chuxin_layout);
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_img = (ImageView) findViewById(R.id.tv_img);
		myposition = (TextView) findViewById(R.id.myposition);
		querylocation = (TextView) findViewById(R.id.querylocation);
		queryline = (TextView) findViewById(R.id.queryline);
		myposition.setOnClickListener(oList);
		querylocation.setOnClickListener(oList);
		queryline.setOnClickListener(oList);

	}

	private OnClickListener oList = new OnClickListener() {

		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.queryline:
				
				break;
			case R.id.querylocation:

				break;
			case R.id.myposition:

				break;

			}
		}
	};

	public void back(View v) {

	}

}
