package com.diary.crazy.chapter02;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CodeViewActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		LinearLayout ll = new LinearLayout(this);
		setContentView(ll);
		
		ll.setOrientation(LinearLayout.VERTICAL);
		
		final TextView tv_show = new TextView(this);
		
		Button btn = new Button(this);
		btn.setText(R.string.ok);
		btn.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		
		ll.addView(tv_show);
		ll.addView(btn);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				tv_show.setText("Hello,Android ,"+new java.util.Date());
			}
		});
		
	}
	

}
