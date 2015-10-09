package com.diary.crazy.game;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;

public class SnakeView extends TileView {

	
	public SnakeView(Context context,AttributeSet attrs) {
		super(context,attrs);
	
		initSnakeView(context);
	}

	private void initSnakeView(Context context) {
		setFocusable(true);
		
		Resources resource = getResources();
		
		resetTiles(4);
		
		
	}
	
	

}
