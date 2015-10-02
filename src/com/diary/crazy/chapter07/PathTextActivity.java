package com.diary.crazy.chapter07;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;

public class PathTextActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(new TextView(this));
	}
	
	class TextView extends View
	{
		private String DRAW_STRING="CRAZY ANDROID LECTURE";
		Path[] paths = new Path[3];
		Paint paint;

		public TextView(Context context) {
			super(context);
			
			paths[0] = new Path();
			paths[0].moveTo(0, 0);
			
			for (int i = 0; i <=7; i++) {
				//����7���㣬����������ǵ�Y���ꡣ������������һ��Path
				paths[0].lineTo(i*30, (float)Math.random()*30);
			}
			
			
			//��ʼ������
			paint = new Paint();
			paint.setAntiAlias(true);
			paint.setColor(Color.CYAN);
			paint.setStrokeWidth(1);
		}
		
		
		@Override
		protected void onDraw(Canvas canvas) {

			canvas.drawColor(Color.WHITE);
			canvas.translate(40, 40);
			
			//���ô��ұ߿�ʼ���ƣ��Ҷ��룩
			paint.setTextAlign(Paint.Align.RIGHT);
			paint.setTextSize(20);
			
			//����·��
			paint.setStyle(Paint.Style.STROKE);
			canvas.drawPath(paths[0], paint);
		}
		
		
	}

}
