package com.diary.crazy.chapter07;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View {

	private float prevX;
	private float prevY;
	private Path path;
	Paint paint;
	private int VIEW_WIDTH = 320;
	private int VIEW_HEIGHT = 480;
	// ����һ���ڴ��е�ͼƬ����ͼƬ����Ϊ������
	private Bitmap cacheBitmap;
	// ����cacheBitmap�ϵ�Canvas����
	private Canvas cacheCanvas;

	public DrawView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// ����һ�����View��ͬ��С�Ļ�����
		cacheBitmap = Bitmap.createBitmap(VIEW_WIDTH, VIEW_HEIGHT,
				Config.ARGB_8888);

		cacheCanvas = new Canvas();

		path = new Path();
		// ����cacheCanvas������Ƶ��ڴ��е�cacheBitmap��
		cacheCanvas.setBitmap(cacheBitmap);

		// ���û��ʵ���ɫ
		paint = new Paint(Paint.DITHER_FLAG);
		paint.setColor(Color.RED);

		// ���û��ʷ��
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(1);

		// �����
		paint.setAntiAlias(true);
		paint.setDither(true);

	}

	@Override
	protected void onDraw(Canvas canvas) {

		Paint bmpPaint = new Paint();
		// ��cacheBitmap���Ƶ���View�����
		canvas.drawBitmap(cacheBitmap, 0, 0, bmpPaint);
		// ����path����
		canvas.drawPath(path, paint);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// ��ȡ�϶��¼��ķ���λ��
		float x = event.getX();
		float y = event.getY();
		
		switch (event.getAction())
		{
			case MotionEvent.ACTION_DOWN:
				path.moveTo(x, y);
				prevX = x;
				prevY = y;				
				break;
			case MotionEvent.ACTION_MOVE:
				path.quadTo(prevX , prevY , x, y);
				prevX = x;
				prevY = y;
				break;
			case MotionEvent.ACTION_UP:
				cacheCanvas.drawPath(path, paint);     //��
				path.reset();
				break;
		}
		invalidate();
		// ����true�����������Ѿ�������¼�
		return true;

	}

}
