package com.diary.crazy.lecture;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.diary.crazy.R;

public class SinSurfaceActivity extends Activity implements OnClickListener{
	private Button btn_simple,btn_timer;
	private SurfaceView sfv;
	private SurfaceHolder holder;
	
	private Timer timer;
	 private MyTimerTask mTimerTask;  
	int Y_axis[],//�������Ҳ���Y���ϵĵ�  
    centerY,//������  
    oldX,oldY,//��һ��XY��   
    currentX;//��ǰ���Ƶ���X���ϵĵ�  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lecture_surface_sin_draw);
		
		btn_simple = (Button) findViewById(R.id.btn_simple);
		btn_timer = (Button) findViewById(R.id.btn_timer);
		
		btn_simple.setOnClickListener(this);
		btn_timer.setOnClickListener(this);
		
		sfv = (SurfaceView) findViewById(R.id.sv_01);
		holder = sfv.getHolder();
		
		//��̬�������Ҳ��Ķ�ʱ��  
        timer = new Timer();  
        mTimerTask = new MyTimerTask();  
        
     // ��ʼ��y������  
        centerY = (getWindowManager().getDefaultDisplay().getHeight() - sfv  
                .getTop()) / 2;  
        Y_axis = new int[getWindowManager().getDefaultDisplay().getWidth()];  
        for (int i = 1; i < Y_axis.length; i++) {// �������Ҳ�  
            Y_axis[i - 1] = centerY  
                    - (int) (100 * Math.sin(i * 2 * Math.PI / 180));  
        }  
		
		
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.btn_simple://ֱ�ӻ������Ҳ�  
			simpleDraw(Y_axis.length-1);
			break;

		case R.id.btn_timer:
			oldY = centerY;
			timer.schedule(mTimerTask, 0,5);//��̬�������Ҳ�
			break;
		default:
			break;
		}
		
	}
	
	 class MyTimerTask extends TimerTask {

		@Override
		public void run() {
			simpleDraw(currentX);  
            currentX++;//��ǰ��  
            if (currentX == Y_axis.length - 1) {//��������յ㣬����������  
                clearDraw();  
                currentX = 0;  
                oldY = centerY;  
            }  
			
		} 
	 
	 }
	 
	 void simpleDraw(int length)
	 {
		  if (length == 0)  
	            oldX = 0;  
	        Canvas canvas = holder.lockCanvas(new Rect(oldX, 0, oldX + length,  
	                getWindowManager().getDefaultDisplay().getHeight()));// �ؼ�:��ȡ����  
	        Paint mPaint = new Paint();  
	        mPaint.setColor(Color.GREEN);// ����Ϊ��ɫ  
	        mPaint.setStrokeWidth(2);// ���û��ʴ�ϸ  
	  
	        int y;  
	        for (int i = oldX + 1; i < length; i++) {// �滭���Ҳ�  
	            y = Y_axis[i - 1];  
	            canvas.drawLine(oldX, oldY, i, y, mPaint);  
	            oldX = i;  
	            oldY = y;  
	        }  
	        holder.unlockCanvasAndPost(canvas);// �����������ύ���õ�ͼ��  
	 
	 }
	 
	 void clearDraw() {  
	        Canvas canvas = holder.lockCanvas(null);  
	        canvas.drawColor(Color.BLACK);// �������  
	        holder.unlockCanvasAndPost(canvas);  
	  
	    }  

}
