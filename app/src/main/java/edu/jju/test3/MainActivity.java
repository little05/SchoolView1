package edu.jju.test3;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private ImageView tel, life, youwan, chuxing,tv_img;
	private TextView tv_title;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		tv_title =  (TextView) findViewById(R.id.tv_title);
		tv_img =  (ImageView) findViewById(R.id.tv_img);
		tel = (ImageView) findViewById(R.id.tel);
		life = (ImageView) findViewById(R.id.life);
		youwan = (ImageView) findViewById(R.id.youwan);
		chuxing = (ImageView) findViewById(R.id.chuxing);
		tel.setOnClickListener(oListener);
		life.setOnClickListener(oListener);
		youwan.setOnClickListener(oListener);
		chuxing.setOnClickListener(oListener);

	}

	private OnClickListener oListener = new OnClickListener() {

		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.life:
				Intent intent=new Intent(MainActivity.this, LifeActivity.class);
				startActivity(intent);
				break;
			case R.id.tel:
				Intent intent3=new Intent(MainActivity.this, TelphoneActivity.class);
				startActivity(intent3);
				break;
			case R.id.youwan:
				Intent intent2=new Intent(MainActivity.this, YouwanActivity.class);
				startActivity(intent2);
				break;
			case R.id.chuxing:
				Intent intent4=new Intent(MainActivity.this, ChuxinActivity.class);
				startActivity(intent4);
				break;

			default:
				break;
			}
		}
	};

}
