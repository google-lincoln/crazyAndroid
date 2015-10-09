package com.diary.crazy.chapter03;

import com.diary.crazy.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

//ʵ���¼��������ӿ�
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
		//ֱ��ʹ��Activity��Ϊ�¼�������
		btn_show.setOnClickListener(this);
		//AnonymousListener
		btn_show.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				et_show.setText("btn��ť�������ˣ�");
				
			}
		});
	}
	
	
	
	@Override
	public void onClick(View v) {
		et_show.setText("bn��ť�������ˣ�");
	}
	
	//����һ���¼�������
		//����source���������¼�Դ
	public void clickHandler(View v)
	{
		et_show.setText("btn01��ť�������ˣ�");
	}

}
