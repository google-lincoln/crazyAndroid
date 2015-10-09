package com.diary.crazy.lecture;

import java.util.Timer;
import java.util.TimerTask;

import com.diary.crazy.R;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class SurfaceViewDemo extends SurfaceView implements Callback {
	
	private SurfaceHolder holder;
	private Paint paint;
	public int mWidth,mHeight;
	private Canvas canvas;
	private Timer timer;
	private float fx,fy;

	public SurfaceViewDemo(Context context) {
		super(context);

		paint = new Paint();
		paint.setColor(Color.WHITE);
		holder=getHolder();
		holder.addCallback(this);
		
		timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				fx++;
				fy++;
				canvas=holder.lockCanvas();
				canvas.drawRect(0, 0,mWidth,mHeight,paint);
				canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher), fx, fy,paint);
				holder.unlockCanvasAndPost(canvas);
				
			}
		}, 1000,10);
		
		

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
//		holder=getHolder();
//		holder.addCallback(this);
//		canvas=holder.lockCanvas();
//		canvas.drawRect(0, 0,mWidth,mHeight,paint);
//		paint.setColor(Color.RED);
//		canvas.drawText("here", 20, 20, paint);
//		holder.unlockCanvasAndPost(canvas);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		mWidth=width;
		mHeight=height;
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

}
