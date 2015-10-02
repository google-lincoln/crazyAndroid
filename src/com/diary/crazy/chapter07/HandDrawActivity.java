package com.diary.crazy.chapter07;

import android.app.Activity;
import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.diary.crazy.R;

public class HandDrawActivity extends Activity {
	private EmbossMaskFilter emboss;
	private BlurMaskFilter blur;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chapter07_hand_drawing);
		
		emboss = new EmbossMaskFilter(new float[]
				{1.5f,1.5f,1.5f}, 0.6f, 6, 4.2f);
		blur = new BlurMaskFilter(8, BlurMaskFilter.Blur.NORMAL);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflator = new MenuInflater(this);
		inflator.inflate(R.menu.hand_draw, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	// 菜单项被单击后的回调方法
		public boolean onOptionsItemSelected(MenuItem mi)
		{
			DrawView dv = (DrawView)findViewById(R.id.draw);
			//判断单击的是哪个菜单项，并针对性的作出响应。
			switch (mi.getItemId())
			{
				case R.id.red:
					dv.paint.setColor(Color.RED);
					mi.setChecked(true);				
					break;
				case R.id.green:
					dv.paint.setColor(Color.GREEN);
					mi.setChecked(true);	
					break;
				case R.id.blue:
					dv.paint.setColor(Color.BLUE);
					mi.setChecked(true);	
					break;
				case R.id.width_1:
					dv.paint.setStrokeWidth(1);
					break;
				case R.id.width_3:
					dv.paint.setStrokeWidth(3);
					break;
				case R.id.width_5:
					dv.paint.setStrokeWidth(5);
					break;
				case R.id.blur:
					dv.paint.setMaskFilter(blur);
					break;
				case R.id.emboss:
					dv.paint.setMaskFilter(emboss);
					break;				
			}
			return true;
		}	

}
