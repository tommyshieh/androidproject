package com.example.kinectevent;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.TextView;



public class searchresult extends Activity {
	 
	private TextView status,role,method,roomnum;
	
	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	    	super.onCreate(savedInstanceState);
	        setContentView(R.layout.searchresult);  
	        status = (TextView)findViewById(R.id.textView11);
	        role = (TextView)findViewById(R.id.textView33);
	        role.setMovementMethod(ScrollingMovementMethod.getInstance());
	        method = (TextView)findViewById(R.id.textView22);
	        roomnum = (TextView)findViewById(R.id.textView4);
	        Bundle bundle =this.getIntent().getExtras();
            String username = bundle.getString("username");
	        String password = bundle.getString("password");
	        String start = bundle.getString("start");
	        String end = bundle.getString("end");
	       // textView4.setText(password);
	        new SigninActivity(this,roomnum,status,role,method,0).execute(username,password,start,end);

	       
	    }
	    
}