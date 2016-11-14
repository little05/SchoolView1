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

public class LifeActivity extends Activity {
	private TextView pic, fenj,zhin,tv_title,back;
	private ImageView tv_img;


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.life_layout);
		tv_title =  (TextView) findViewById(R.id.tv_title);
		tv_img =  (ImageView) findViewById(R.id.tv_img);
		pic =  (TextView) findViewById(R.id.pic);
		fenj =  (TextView) findViewById(R.id.fenj);
		zhin =  (TextView) findViewById(R.id.zhin);
		back =  (TextView) findViewById(R.id.back);
		pic.setOnClickListener(oList);
		fenj.setOnClickListener(oList);
		zhin.setOnClickListener(oList);
		back.setOnClickListener(oList);

	}

	private OnClickListener oList = new OnClickListener() {

		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.pic:
				Intent intent=new Intent(LifeActivity.this, PicActivity.class);
				startActivity(intent);
				finish();
				break;
			case R.id.fenj:
				Intent intent2=new Intent(LifeActivity.this, CampViewActivity.class);
				startActivity(intent2);
				finish();
				break;
			case R.id.zhin:
				Intent intent3=new Intent(LifeActivity.this, XinshengzhinanActivity.class);
				startActivity(intent3);
				finish();
				break;
			case R.id.back:
				finish();
			default:
				break;
			}
		}
	};

}
