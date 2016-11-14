package edu.jju.test3;

import java.util.ArrayList;
import java.util.List;

import edu.jju.test3.adapter.Myadapter;
import edu.jju.test3.util.Imgutil;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class YouwanActivity extends Activity {
	private TextView tv_title;
	private ImageView tv_img;
	private ListView listview;
	private int[] img = new int[] { R.drawable.tengwangge,
			R.drawable.badashanrenjinianguan, R.drawable.hanwangfeng,
			R.drawable.xiangshangongyuan, R.drawable.xishanwanshougong,
			R.drawable.meiling };
	private String[] nameS = new String[] {  "滕王阁", "八大山人纪念馆", "罕王峰", "象山森林公园",
			"西山万寿宫", "梅岭"  };
	private String[] newsS = new String[] { "江南三大名楼之首", "集收藏、陈列、研究、宣传为一体",
			"青山绿水，风景多彩，盛夏气候凉爽", "避暑、休闲、疗养、度假的最佳场所", "江南著名道教宫观和浏览胜地",
			"山势嵯峨，层峦叠翠，四时秀色，气候宜人"  };
	private Myadapter adapter;
	public static int index;
	private List<Imgutil> oList = new ArrayList<Imgutil>();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.youwan_layout);
		listview = (ListView) findViewById(R.id.listview);
		for (int i = 0; i < img.length; i++) {
			Imgutil util = new Imgutil();
			util.setImg(img[i]);
			util.setName_one(nameS[i]);
			util.setNews(newsS[i]);
			oList.add(util);
		}
		adapter = new Myadapter(YouwanActivity.this, oList);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				index = position;
				Intent intent = new Intent(YouwanActivity.this,
						IntrodActivity.class);
				startActivity(intent);
				finish();

			}
		});
	}

}
