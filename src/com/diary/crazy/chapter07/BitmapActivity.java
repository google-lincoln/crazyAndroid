package com.diary.crazy.chapter07;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.diary.crazy.R;

public class BitmapActivity extends Activity {
	private int imageIndex;
	private AssetManager assetManager;
	private ImageView iv_image;
	private String[] names;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chapter07_bitmap_recycle);
	
		iv_image = (ImageView) findViewById(R.id.iv_image);
		
		assetManager= getAssets();
		try {
			
			names=assetManager.list("");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		final Button btn_next =(Button) findViewById(R.id.btn_next);
		
		btn_next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
					
				if (imageIndex>=names.length) {
					imageIndex=0;
				}
				
				while(!names[imageIndex].endsWith(".png")
						&&!names[imageIndex].endsWith(".jpg")
						&&!names[imageIndex].endsWith(".gif"))
				{
					imageIndex++;
					if(imageIndex>=names.length)
					{
						imageIndex=0;
					}
					
				}
				
				InputStream assetFile = null;
				
				try {
					assetFile = assetManager.open(names[imageIndex++]);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				BitmapDrawable bitmapDrawable = (BitmapDrawable) iv_image.getDrawable();
				
				if (bitmapDrawable !=null && !bitmapDrawable.getBitmap().isRecycled()) 
				{
					bitmapDrawable.getBitmap().recycle();
				}
				
				iv_image.setImageBitmap(BitmapFactory.decodeStream(assetFile));
			}
		});

	}
	
	

}
