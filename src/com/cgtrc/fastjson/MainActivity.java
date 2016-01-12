package com.cgtrc.fastjson;

import java.io.Serializable;

import com.cgtrc.data.Person;
import com.cgtrc.http.HttpUtils;
import com.cgtrc.tools.FastJsonTools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button person, persons, listString, listMap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		closeStrictMode();//关闭严苛模式   
		
		person = (Button) findViewById(R.id.person);  
        persons = (Button) findViewById(R.id.persons);  
        listString = (Button) findViewById(R.id.listString);  
        listMap = (Button) findViewById(R.id.listMap);  
        person.setOnClickListener(this);  
        persons.setOnClickListener(this);  
        listString.setOnClickListener(this);  
        listMap.setOnClickListener(this); 
	}
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.person:
			String url_path = "http://192.168.228.133:8080/fastjson_Project/FastJsonAction?action_flag=person";
			String jsonString = HttpUtils.getJsonContent(url_path, "utf-8");                  
            Person person = FastJsonTools.getPerson(jsonString, Person.class);
            Intent intent = new Intent(MainActivity.this, OtherActivity.class);  
            intent.putExtra("click_flag", "person");  
            intent.putExtra("person", (Serializable) person);         
            startActivity(intent); 
			break;
		case R.id.persons:
			String url_path2 = "http://192.168.228.133:8080/fastjson_Project/FastJsonAction?action_flag=persons";
			String jsonString2 = HttpUtils.getJsonContent(url_path2, "utf-8");
			break;
		case R.id.listString:
			String url_path3 = "http://192.168.228.133:8080/fastjson_Project/FastJsonAction?action_flag=listString";
			break;
		case R.id.listMap:
			String url_path4 = "http://192.168.228.133:8080/fastjson_Project/FastJsonAction?action_flag=listMap";
			break;
		default:
			break;
		}
	}
	
}






