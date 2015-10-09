package com.diary.crazy.lecture;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.diary.crazy.R;

public class HandDrawActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(new MyView(this));
	}

	class MyView extends View {
		private Paint paint;
		private Bitmap bitmap;
		private float x,y;
		private Context context;
		
		public MyView(Context context) {
			super(context);
			paint = new Paint();
			this.context = context;
			paint.setColor(Color.RED);
			paint.setStyle(Paint.Style.STROKE);
			bitmap = BitmapFactory.decodeResource(getResources(),
					R.drawable.ic_launcher);

			setOnTouchListener(new OnTouchListener() {

				@Override
				public boolean onTouch(View v, MotionEvent event) {

					switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN:
					Toast.makeText(MyView.this.context, "down", 1).show();
						break;
					case MotionEvent.ACTION_UP:
						x = event.getX();
						y = event.getY();
//						Thread thread = new Thread()
//						{
//							public void run() {
//								
//								while(true)
//								{
//									y=y+10;
//									try {
//										Thread.sleep(300);
//										postInvalidate();
//									} catch (InterruptedException e) {
//										// TODO Auto-generated catch block
//										e.printStackTrace();
//									}
//								}
//								
//							};
//						};
//						thread.start();
						Toast.makeText(MyView.this.context, "up", 1).show();
						break;
					case MotionEvent.ACTION_MOVE:

						break;

					default:
						break;
					}

					//return false;
					return false;
				}
			});
			
			
			
			setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					//System.out.println("");
					Toast.makeText(MyView.this.context, "click", 1).show();
				}
			});

		}
		
		@Override
		public boolean onTouchEvent(MotionEvent event) {
			// TODO Auto-generated method stub
			return super.onTouchEvent(event);
		}

		@Override
		protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);

			paint.setColor(Color.RED);
			paint.setStyle(Paint.Style.FILL_AND_STROKE);
			paint.setStrokeWidth(5);
			canvas.drawRect(200, 300, 400, 600, paint);
			paint.setStyle(Paint.Style.FILL);
			paint.setColor(Color.BLUE);
			canvas.drawRect(200, 300, 400, 600, paint);

			canvas.drawBitmap(bitmap, x, y, paint);

		}

	}

}
