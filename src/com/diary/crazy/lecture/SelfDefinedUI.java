package com.diary.crazy.lecture;

import com.diary.crazy.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SelfDefinedUI extends View {

	private Paint shapePaint;//shape paint
	private Paint txtPaint;//text paint
	private float centerX,centerY;//UI x and y coordination
	private float mInnerRadius;//inner radius of circle
	private float mOuterRadius;//outer radius of circle
	private boolean mStatus;//status
	private String mText;//content of caption
	
	
	public SelfDefinedUI(Context context, AttributeSet attrs) {
		super(context, attrs);
		shapePaint = new Paint();
		shapePaint.setColor(Color.BLUE);
		
		

		txtPaint = new Paint();
		txtPaint.setColor(Color.RED);
		
		Typeface font = Typeface.create("ËÎÌו", Typeface.NORMAL);
		txtPaint.setTypeface(font);
		txtPaint.setTextSize(35);
		
		mOuterRadius = (txtPaint.getFontMetrics().descent-txtPaint.getFontMetrics().ascent)/2;
		mInnerRadius = 5;
		
		centerX = 50;
		centerY = 50;
		
		mText="SelfDefinedUI";
		
		TypedArray typeArray = context.obtainStyledAttributes(attrs,R.styleable.com_diary_crazy_lecture_SelfDefinedUI);
		mText = typeArray.getString(R.styleable.com_diary_crazy_lecture_SelfDefinedUI_text);
		
		mStatus = typeArray.getInt(R.styleable.com_diary_crazy_lecture_SelfDefinedUI_select, 0)==1;
		typeArray.recycle();
	
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		shapePaint.setStyle(Paint.Style.STROKE);
		canvas.drawCircle(centerX, centerY,mOuterRadius, shapePaint);
		
		canvas.drawText(mText, centerX+mOuterRadius+10, centerY+mOuterRadius/2, txtPaint);
		
		if(mStatus)
		{
			shapePaint.setStyle(Paint.Style.FILL_AND_STROKE);
			canvas.drawCircle(centerX, centerY, mInnerRadius, shapePaint);
			
		}
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		mStatus =!mStatus;
		invalidate();
		
		return super.onTouchEvent(event);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		
		int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
		int parentHeight = 200;
		
		setMeasuredDimension(parentWidth, parentHeight);
		
		
	}

}
