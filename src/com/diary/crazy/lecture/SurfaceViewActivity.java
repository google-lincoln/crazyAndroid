package com.diary.crazy.lecture;

import com.diary.crazy.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class SurfaceViewActivity extends Activity {
	private RelativeLayout rl_main;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lecture_surface_view);
		rl_main = (RelativeLayout) findViewById(R.id.rl_main);
		
		SurfaceViewDemo view = new SurfaceViewDemo(this);
		
		rl_main.addView(view);
		
		
	}
}
