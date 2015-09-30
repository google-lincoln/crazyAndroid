package com.diary.crazy.chapter02;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;

import com.diary.crazy.R;

public class CustomViewActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chapter02_custom_view);
		
		LinearLayout ll_root = (LinearLayout) findViewById(R.id.ll_root);
		
		final MyDrawView draw = new MyDrawView(this);
		
		draw.setMinimumHeight(300);
		draw.setMinimumWidth(500);
		
		draw.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				
				draw.currX = event.getX();
				draw.currY = event.getY();
				
				draw.invalidate();
				
				return true;
			}
		});
		
		ll_root.addView(draw);
		
	}
	

}
