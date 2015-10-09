package com.diary.crazy.chapter03;

import com.diary.crazy.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

//实现事件监听器接口
public class ActivityListener extends Activity implements OnClickListener{

	private EditText et_show;
	private Button btn_show;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chapter03_activity_listener);
		et_show = (EditText)findViewById(R.id.et_show);
		btn_show = (Button)findViewById(R.id.btn_show);
		//直接使用Activity作为事件监听器
		btn_show.setOnClickListener(this);
		//AnonymousListener
		btn_show.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				et_show.setText("btn按钮被单击了！");
				
			}
		});
	}
	
	
	
	@Override
	public void onClick(View v) {
		et_show.setText("bn按钮被单击了！");
	}
	
	//定义一个事件处理方法
		//其中source参数代表事件源
	public void clickHandler(View v)
	{
		et_show.setText("btn01按钮被单击了！");
	}

}
