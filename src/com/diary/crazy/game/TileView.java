package com.diary.crazy.game;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.diary.crazy.R;

public class TileView extends View {
	
	protected static int mTileSize;
	protected static int mXTileCount;
	protected static int mYTileCount;
	
	private static int mXOffset;
	private static int mYOffset;
	
	private final Paint mPaint = new Paint();
	
	private Bitmap[] mTileArray;
	
	private int[][] mTileGrid;

	public TileView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		TypedArray typeArray = context.obtainStyledAttributes(attrs,R.styleable.TileView);
		
		mTileSize = typeArray.getDimensionPixelSize(R.styleable.TileView_tileSize, 12);
				
		typeArray.recycle();
	}
	
	public void clearTitles()
	{
		for (int x = 0; x <mXTileCount; x++) {
			for (int y = 0; y < mYTileCount; y++) {
				setTitle(0,x,y);
			}
		}
	}
	
	public void setTitle(int titleIndex,int x,int y)
	{
		mTileGrid[x][y]=titleIndex;
	}
	
	public void loadTitle(int key,Drawable tile)
	{
		Bitmap bitmap = Bitmap.createBitmap(mTileSize,mTileSize,Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		tile.setBounds(0,0,mTileSize,mTileSize);
		tile.draw(canvas);
		
		mTileArray[key] = bitmap;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		for (int x = 0; x < mXTileCount; x++) {
			for (int y = 0; y < mYTileCount; y++) {
				if(mTileGrid[x][y]>0)
				{
					canvas.drawBitmap(mTileArray[mTileGrid[x][y]], mXOffset+x*mTileSize, mYOffset+y*mTileSize,mPaint);
				}
			}
		}
		
		
	}
	
	public void resetTiles(int tileCount)
	{
		mTileArray = new Bitmap[tileCount];
	}
	
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		mXTileCount = (int)Math.floor(w/mTileSize);
		mYTileCount = (int)Math.floor(h/mTileSize);
		
		mXOffset = ((w-(mTileSize*mXTileCount))/2);
		mYOffset = ((h-(mTileSize*mYTileCount))/2);
		
		mTileGrid =new int[mXTileCount][mYTileCount];
		clearTitles();
	}

}
