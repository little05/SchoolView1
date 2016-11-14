package edu.jju.test3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.WallpaperManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher.ViewFactory;

public class CampViewActivity extends Activity {
	private ImageSwitcher imgswitch;
	private LinearLayout imgline;
	private int position = 0;
	private int[] imgStr = new int[] { R.drawable.baosige, R.drawable.beihu,
			R.drawable.chayuan, R.drawable.fengyuan, R.drawable.guiyuan,
			R.drawable.huzhongting, R.drawable.jiaogonglou, R.drawable.jiaohu,
			R.drawable.liyuan, R.drawable.lumiyuan, R.drawable.mailu,
			R.drawable.qifeiting, R.drawable.sanbulang, R.drawable.taoyuan,
			R.drawable.tiyuguan, R.drawable.waijiaoshenghuoqu,
			R.drawable.xiaomen, R.drawable.yinyuanguanchang,
			R.drawable.youyongchi, R.drawable.zonghedalou };
	private List<ImageView> oList = new ArrayList<ImageView>();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.campview_layout);
		imgswitch = (ImageSwitcher) findViewById(R.id.imgswitch);
		imgline = (LinearLayout) findViewById(R.id.imgline);

		imgswitch.setFactory(new ViewFactory() {

			public View makeView() {
				ImageView image = new ImageView(CampViewActivity.this);
				return image;
			}
		});
		imgswitch.setImageResource(imgStr[position]);
		init();
		imgswitch.setOnLongClickListener(new OnLongClickListener() {

			public boolean onLongClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						CampViewActivity.this);
				builder.setTitle("提示");
				builder.setMessage("是否设置为桌面壁纸");
				builder.setPositiveButton("确定",
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog,
									int which) {
								WallpaperManager manager = WallpaperManager
										.getInstance(CampViewActivity.this);
								try {
									manager.setResource(imgStr[position]);
								} catch (IOException e) {
									e.printStackTrace();
								}

							}
						});
				builder.setNegativeButton("取消", null);
				builder.show();
				return true;
			}
		});

	}

	public void init() {
		for (int i = 0; i < imgStr.length; i++) {
			ImageView image = new ImageView(this);
			LayoutParams params = new LayoutParams(120, 120);
			image.setAlpha(100);
			image.setOnClickListener(new myonclick(i));
			image.setImageResource(imgStr[i]);
			image.setPadding(0, 0, 5, 0);
			image.setLayoutParams(params);
			imgline.addView(image);
			oList.add(image);
		}
		oList.get(0).setAlpha(255);
	}

	public class myonclick implements OnClickListener {
		int index;

		public myonclick(int index) {
			this.index = index;
			position = index;
		}
		public void onClick(View v) {
			imgswitch.setImageResource(imgStr[index]);
			for (int i = 0; i < imgStr.length; i++) {
				oList.get(i).setAlpha(100);
			}
			oList.get(index).setAlpha(255);

		}

	}
	public void camp_back(View v) {
		finish();
	}

}
