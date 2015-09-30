package com.diary.crazy.chapter02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyDrawView extends View {

	public float currX=40;
	public float currY=50;
	
	public MyDrawView(Context context) {
		super(context);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		Paint paint = new Paint();
		
		paint.setColor(Color.RED);
		
		canvas.drawCircle(currX, currY, 15, paint);
	}
	

}
