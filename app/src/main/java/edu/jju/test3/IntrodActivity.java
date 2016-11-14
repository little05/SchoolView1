package edu.jju.test3;

import edu.jju.test3.util.Introimgutil;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class IntrodActivity extends Activity {
	private TextView intro_text, tv_title;
	private ImageView tv_img, intro_img;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.imgintroduce_layout);
		tv_img = (ImageView) findViewById(R.id.tv_img);
		tv_title = (TextView) findViewById(R.id.tv_title);
		intro_img = (ImageView) findViewById(R.id.intro_img);
		intro_text = (TextView) findViewById(R.id.intro_text);
		intro_img.setBackgroundResource(Introimgutil.group_img[YouwanActivity.index]);
		intro_text.setText(Introimgutil.group_new[YouwanActivity.index]);

	}

	public void intro_back(View v) {
		Intent intent = new Intent(IntrodActivity.this, YouwanActivity.class);
		startActivity(intent);
		finish();
	}

}
