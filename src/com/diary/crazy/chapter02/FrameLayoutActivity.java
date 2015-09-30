package com.diary.crazy.chapter02;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.diary.crazy.R;

public class FrameLayoutActivity extends Activity {
	private int colorIndex = 0;
	final int[] colors = new int[] { R.color.color7, R.color.color6,
			R.color.color5, R.color.color4, R.color.color3, R.color.color2,
			R.color.color1, };
	
	final int[] names = new int[] { R.id.View01, R.id.View02, R.id.View03,
			R.id.View04, R.id.View05, R.id.View06, R.id.View07 };
	
	TextView[] views = new TextView[7];
	
	private Handler handler = new Handler()
	{
		public void handleMessage(Message msg) {
			if(msg.what==0x1122)
			{
				for (int i = 0; i < 7-colorIndex; i++) {
					views[i].setBackgroundResource(colors[i+colorIndex]);
				}
				
				for (int i = 7-colorIndex,j=0; i < 7; i++,j++) {
					views[i].setBackgroundResource(colors[j]);
				}
			}
		};
		
	};
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chapter02_frame_layout);
		
		for (int i = 0; i < 7; i++) {
			views[i]=(TextView) findViewById(names[i]);
		}
		
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				colorIndex++;
				if(colorIndex>=6)
				{
					colorIndex=0;
				}
				
				Message msg = new Message();
				msg.what=0x1122;
				
				handler.sendMessage(msg);
				
			}
		}, 0,100);
	}

}
