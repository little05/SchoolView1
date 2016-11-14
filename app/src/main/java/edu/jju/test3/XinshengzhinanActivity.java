package edu.jju.test3;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class XinshengzhinanActivity extends Activity {
	private ImageView xins_title;
	private TextView xins_title2,xins_tx1,xins_tx2,xins_tx3,xins_tx4,xins_tx5,xins_tx6,xins_tx7,xins_tx8;
    public static int index;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.xingshengzhin_layout);
		xins_tx1 =  (TextView) findViewById(R.id.xins_tx1);
		xins_tx2 =  (TextView) findViewById(R.id.xins_tx2);
		xins_tx3 =  (TextView) findViewById(R.id.xins_tx3);
		xins_tx4 =  (TextView) findViewById(R.id.xins_tx4);
		xins_tx5 =  (TextView) findViewById(R.id.xins_tx5);
		xins_tx6 =  (TextView) findViewById(R.id.xins_tx6);
		xins_tx7 =  (TextView) findViewById(R.id.xins_tx7);
		xins_tx8 =  (TextView) findViewById(R.id.xins_tx8);
		xins_title2=(TextView) findViewById(R.id.xins_title2);
		xins_title =  (ImageView) findViewById(R.id.xins_title);
		xins_tx1.setOnClickListener(oListener);
		xins_tx2.setOnClickListener(oListener);
		xins_tx3.setOnClickListener(oListener);
		xins_tx4.setOnClickListener(oListener);
		xins_tx5.setOnClickListener(oListener);
		xins_tx6.setOnClickListener(oListener);
		xins_tx7.setOnClickListener(oListener);
		xins_tx8.setOnClickListener(oListener);

	}

	private OnClickListener oListener = new OnClickListener() {

		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.xins_tx1:
				index=0;
				Intent intent=new Intent(XinshengzhinanActivity.this, XinshengitemActivity.class);
				startActivity(intent);
				finish();
				break;
			case R.id.xins_tx2:
				index=1;
				Intent intent3=new Intent(XinshengzhinanActivity.this, XinshengitemActivity.class);
				startActivity(intent3);
				finish();
				break;
			case R.id.xins_tx3:
				index=2;
				Intent intent2=new Intent(XinshengzhinanActivity.this, XinshengitemActivity.class);
				startActivity(intent2);
				finish();
				break;
			case R.id.xins_tx4:
				index=3;
				Intent intent4=new Intent(XinshengzhinanActivity.this, XinshengitemActivity.class);
				startActivity(intent4);
				finish();
				break;
			case R.id.xins_tx5:
				index=4;
				Intent intent5=new Intent(XinshengzhinanActivity.this, XinshengitemActivity.class);
				startActivity(intent5);
				finish();
				break;

			case R.id.xins_tx6:
				index=5;
				Intent intent6=new Intent(XinshengzhinanActivity.this, XinshengitemActivity.class);
				startActivity(intent6);
				finish();
				break;

			case R.id.xins_tx7:
				index=6;
				Intent intent7=new Intent(XinshengzhinanActivity.this, XinshengitemActivity.class);
				startActivity(intent7);
				finish();
				break;

			case R.id.xins_tx8:
				index=7;
				Intent intent8=new Intent(XinshengzhinanActivity.this, XinshengitemActivity.class);
				startActivity(intent8);
				finish();
				break;

			}
		}
	};

}
