package edu.jju.test3;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class PicActivity extends Activity {
	private TextView tv_title;
	private Spinner spinner;
	private ImageView tv_img, img;
	private LinearLayout rel_name;
	private float myX,myY,curX,curY;
	private int[] list_img = new int[] { R.drawable.jiaotong,
			R.drawable.jiaoqiaoxiaoqu, R.drawable.mailuxiaoqu,
			R.drawable.fenglinxiaoqu };

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.pic_layout);
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_img = (ImageView) findViewById(R.id.tv_img);
		img = (ImageView) findViewById(R.id.img);
		rel_name=(LinearLayout) findViewById(R.id.rel_name);
		rel_name.setOnTouchListener(new imgontouch());
		spinner = (Spinner) findViewById(R.id.spinner);
		spinner.setBackgroundResource(0);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				img.setBackgroundResource(list_img[position]);
				String picnamesStr = getResources().getStringArray(
						R.array.pic_array)[position];
			}

			public void onNothingSelected(AdapterView<?> parent) {

			}
		});

	}
//	
//	private class imgontouch implements OnTouchListener {
//		private int start_line;
//
//
//		public boolean onTouch(View v, MotionEvent event) {
//			switch (event.getAction()) {
//			case MotionEvent.ACTION_DOWN:
//				
//				myX=event.getX();
//				myY=event.getY();
//				
//				break;
//			case MotionEvent.ACTION_MOVE:
//				if (event.getPointerCount()==1) {
//					start_line=0;
//				
//				curX=event.getX();
//				curY=event.getY();
//				v.scrollBy((int)(myX-curX),(int)(myY-curY));
//				myX=curX;
//				myY=curY;
//			}
//				if (event.getPointerCount()==2) {
//					
//					float x1 = event.getX(0);
//					float y1 = event.getY(0);
//					float x2 = event.getX(1);
//					float y2 = event.getY(1);
//					int end_line=(int)Math.sqrt(Math.pow(Math.abs(x1-x2), 2)+Math.pow(Math.abs(y1-y2), 2));
//					if (start_line<=0) {
//						start_line=end_line;
//					} else {
//						LayoutParams params=(LayoutParams) img.getLayoutParams();
//						if (end_line-start_line<-5) {
//							params.width=(int) (img.getWidth()*0.8);
//							params.height=(int) (img.getHeight()*0.8);
//							img.setLayoutParams(params);
//							end_line=start_line;
//						} else if(end_line-start_line>5){
//							params.width=(int) (img.getWidth()*1.2);
//							params.height=(int) (img.getHeight()*1.2);
//							img.setLayoutParams(params);
//							end_line=start_line;
//						}
//
//					}
//				}
//				break;
//			case MotionEvent.ACTION_UP:
//				
//				
//				break;
//			default:
//				break;
//			}
//			return true;
//			//return false;
//		}
//
//	}

	private class imgontouch implements OnTouchListener {


		public boolean onTouch(View v, MotionEvent event) {
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				
				myX=event.getX();
				myY=event.getY();
				
				break;
			case MotionEvent.ACTION_MOVE:
				curX=event.getX();
				curY=event.getY();
				v.scrollBy((int)(myX-curX),(int)(myY-curY));
				myX=curX;
				myY=curY;
				
				break;
			case MotionEvent.ACTION_UP:
				
				
				break;
			default:
				break;
			}
			return true;
		}

	}

	
	
	
	public void pic_back(View v) {
		Intent intent = new Intent(PicActivity.this, LifeActivity.class);
		startActivity(intent);
		finish();

	}

}
