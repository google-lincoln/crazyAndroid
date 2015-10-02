package com.diary.crazy.chapter02;

import com.diary.crazy.R;

import android.app.Activity;
import android.os.Bundle;

public class RelativeLayoutActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chapter02_relative_layout);
		
		findViewById(R.id.view01).setPadding(15, 15, 15, 15);
		//findViewById(R.id.view01).setLayoutParams(params);

		
		findViewById(R.id.view02).setPadding(15, 15, 15, 15);
		findViewById(R.id.view03).setPadding(15, 15, 15, 15);
		findViewById(R.id.view04).setPadding(15, 15, 15, 15);
		findViewById(R.id.view05).setPadding(15, 15, 15, 15);
		
//		findViewById(R.id.view02).setPadding(5, 5, 5, 5);
//		findViewById(R.id.view03).setPadding(5, 5, 5, 5);
//		findViewById(R.id.view04).setPadding(5, 5, 5, 5);
//		findViewById(R.id.view05).setPadding(5, 5, 5, 5);
	}

}
