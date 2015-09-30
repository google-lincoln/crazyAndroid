package com.diary.crazy.chapter02;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.diary.crazy.R;

public class MixViewActivity extends Activity {
	
	int[] images = new int[]{
			R.drawable.java,
			R.drawable.ee,
			R.drawable.classic,
			R.drawable.ajax,
			R.drawable.xml,
		};
	int imageIndex=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chapter02_custom_view);
		
		LinearLayout ll_root =(LinearLayout) findViewById(R.id.ll_root);
		
		final ImageView image = new ImageView(this);
		
		ll_root.addView(image);
		
		image.setImageResource(images[0]);
		
		image.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (imageIndex>=4) {
					imageIndex=-1;					
				}				
				image.setImageResource(images[++imageIndex]);
			}
		});
		
	}
	

}
