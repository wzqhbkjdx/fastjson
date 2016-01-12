package com.cgtrc.fastjson;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OtherActivity extends Activity {
	
	private TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other);
		
		textView = (TextView) findViewById(R.id.msg);
		Intent intent = getIntent(); 
		String click_flag = intent.getStringExtra("click_flag"); 
		
		if("person".equals(click_flag)) {
			
		}
		
	}
}
