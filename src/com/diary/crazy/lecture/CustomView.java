package com.diary.crazy.lecture;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.diary.crazy.R;

public class CustomView extends View {
	
	private Paint paint;
	private int x;
	private String width,height,id;

	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		paint = new Paint();
		paint.setColor(Color.BLUE);
		paint.setStyle(Style.STROKE);
		paint.setStrokeWidth(5);
		
		
		for (int i = 0; i < attrs.getAttributeCount(); i++) {
			
			if ("layout_width".equals(attrs.getAttributeName(i))) {
				width=attrs.getAttributeValue(i);
			}
			else if("layout_height".equals(attrs.getAttributeName(i)))
			{
				height = attrs.getAttributeValue(i);					
			}
			else if("id".equals(attrs.getAttributeName(i)))
			{
				id = attrs.getAttributeValue(i);
			}
			
		}
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				x++;
				postInvalidate();
			}
		}, 1000,10);

	}
	
	@Override
	protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher), 10.0f,10.0f, paint);
			
			RectF oval =new RectF(0,0,50,50);
			
			if(x==360)
			{
				x=0;
			}
			
			canvas.drawArc(oval, 0, x, false, paint);
			System.out.println("draw");
			
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		System.out.println("widthMeasureSpec="+widthMeasureSpec);
		System.out.println("heightMeasureSpec="+heightMeasureSpec);
		
		int width = MeasureSpec.getSize(widthMeasureSpec);
		int height = MeasureSpec.getSize(heightMeasureSpec);
		
		System.out.println("width="+width);
		System.out.println("height="+height);
		
		int width_mode = MeasureSpec.getMode(widthMeasureSpec);
		int height_mode = MeasureSpec.getMode(heightMeasureSpec);
		
		System.out.println("width_mode="+width_mode);
		System.out.println("height_mode="+height_mode);
		
		
		System.out.println("AT_MOST=" + MeasureSpec.AT_MOST + " EXACTLY="
				+ MeasureSpec.EXACTLY + " UNSPECIFIED="
				+ MeasureSpec.UNSPECIFIED);
				
		
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
	
	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		// TODO Auto-generated method stub
		super.onLayout(changed, left, top, right, bottom);
		System.out.println("changed="+changed);
		System.out.println("left="+left);
		System.out.println("top="+top);
		System.out.println("right="+right);
		System.out.println("bottom="+bottom);
	}

}
