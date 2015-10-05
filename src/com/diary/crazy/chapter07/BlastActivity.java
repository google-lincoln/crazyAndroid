package com.diary.crazy.chapter07;

import java.lang.reflect.Field;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.diary.crazy.R;

public class BlastActivity extends Activity {
	
	private BombView bombView;
	private AnimationDrawable anim;
	private MediaPlayer bombMedia;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		//ʹ��FrameLayout���ֹ�����������������Լ�����λ��
		FrameLayout frame = new FrameLayout(this);
		setContentView(frame);
		//����ʹ�ñ���
		frame.setBackgroundResource(R.drawable.back);
		//������Ч
		bombMedia = MediaPlayer.create(this, R.raw.bomb);
		
		//����bombView������ʾblast����
		bombView = new BombView(this);
		bombView.setBackgroundResource(R.anim.blast);
		//����bombViewĬ��Ϊ����
		bombView.setVisibility(View.INVISIBLE);
		//��ȡ��������
		anim = (AnimationDrawable) bombView.getBackground();
		frame.addView(bombView);
		
		frame.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				//ֻ�������¼�������ÿ�β�����������Ч����
				if(event.getAction()==MotionEvent.ACTION_DOWN)
				{
					//��ֹͣ��������
					anim.stop();
					float x = event.getX();
					float y = event.getY();
					//����bombView����ʾλ��
					bombView.setLocation((int)y-40, (int)x-20);
					bombView.setVisibility(View.VISIBLE);
					//��������
					anim.start();
					//������Ч
					bombMedia.start();
				}
				return false;
			}
		});
		
		
		
	}
	
	//����һ���Զ���View�����Զ���View���ڲ��š���ը��Ч��
	class BombView extends ImageView
	{

		public BombView(Context context) {
			super(context);
		}
		// ����һ���������÷������ڿ���MyView����ʾλ��
		public void setLocation(int top,int left)
		{
			setFrame(left, top, left+40, top+40);
		}
		//��д�÷�������������������ŵ����һ֡ʱ�����ظ�View
		
		@Override
		protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			
			try {
				Field field =AnimationDrawable.class.getDeclaredField("mCurFrame");
				field.setAccessible(true);
				// ��ȡanim�����ĵ�ǰ֡
				int curFrame = field.getInt(anim);
				// ����Ѿ��������һ֡
				if (curFrame == anim.getNumberOfFrames() - 1)
				{
					//�ø�View����
					setVisibility(View.INVISIBLE);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
			
		}
	}

}
