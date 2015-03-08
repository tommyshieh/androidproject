package com.example.kinectevent;

import java.util.Calendar;

import android.app.TimePickerDialog;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {

   private EditText usernameField,passwordField;
   private TextView status,role,method;
   private EditText sellStartTime; 
   private EditText sellEndTime;
   private EditText sellStartTime1; 
   private EditText sellEndTime1;
   private Calendar calendar;
   String start,end,startdate,starttime,enddate,endtime;
   int timeFlag;
   int mYear, mMonth, mDay;
   int mhour,mminiute;
   int hourSelected;
   int minuteSelected;
   @Override 
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      usernameField = (EditText)findViewById(R.id.editText1);
      passwordField = (EditText)findViewById(R.id.editText2);
     // status = (TextView)findViewById(R.id.textView6);
     // role = (TextView)findViewById(R.id.textView7);
   //   method = (TextView)findViewById(R.id.textView9);
      
      calendar = Calendar.getInstance();
      mYear = calendar.get(Calendar.YEAR);
      mMonth = calendar.get(Calendar.MONTH);
      mDay = calendar.get(Calendar.DAY_OF_MONTH);
      
      sellStartTime = (EditText)findViewById(R.id.editSellStartTime); 
      sellEndTime = (EditText)findViewById(R.id.editSellEndTime);
      sellStartTime1 = (EditText)findViewById(R.id.editSellStartTime1); 
     sellEndTime1 = (EditText)findViewById(R.id.editSellEndTime1); 
      sellStartTime.setOnFocusChangeListener(new OnFocusChangeListener(){ 
       public void onFocusChange(View v, boolean hasFocus) { 
           if (hasFocus == true) { 
               timeFlag = 0; 
               hideIM(v);
               showDialog(0);
               
           } 
       } 
      });
      sellEndTime.setOnFocusChangeListener(new OnFocusChangeListener() {  
          public void onFocusChange(View v, boolean hasFocus) {  
              if (hasFocus == true) {  
                  timeFlag = 1;  
                  hideIM(v);  
                  showDialog(0);    
              }  
          }  
      });
      sellStartTime1.setOnFocusChangeListener(new OnFocusChangeListener(){ 
          public void onFocusChange(View v, boolean hasFocus) { 
              if (hasFocus == true) { 
                  timeFlag = 0; 
                  hideIM(v);
                  showDialog(1);
              } 
          } 
         });
     sellEndTime1.setOnFocusChangeListener(new OnFocusChangeListener() {  
          public void onFocusChange(View v, boolean hasFocus) {  
              if (hasFocus == true) {  
                  timeFlag = 1;  
                  hideIM(v);  
                  showDialog(1);    
              }  
         }  
      });
   
   }
   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.main, menu);
      return true;
   }
   /*public void tryy(View view){
      String username = usernameField.getText().toString();
      String password = passwordField.getText().toString();
      startdate = sellStartTime.getText().toString();
      starttime = sellStartTime1.getText().toString();
      enddate = sellEndTime.getText().toString();
      endtime = sellEndTime1.getText().toString();

      start=startdate+"%20"+starttime;
      end=enddate+"%20"+endtime;
      hideIM(view);
      //夾在這 start=
      //super.setContentView(R.layout.activity_main);
      // method.setText("Get Method");
      //new SigninActivity(this,status,role,method,0).execute(username,password);
      // SigninActivity(this,status,role,method,0).execute(username,password,start,end);
   } */ 
   public void reset(View view){
	   sellStartTime.setText("");  
	   sellStartTime1.setText(""); 
	   sellEndTime.setText(""); 
	   sellEndTime1.setText(""); 
	   
   }
   public void resetevent(View view){
	   passwordField.setText("");  
	  
   }
   public void login(View view){
	   String username = usernameField.getText().toString();
	      String password = passwordField.getText().toString();
	      startdate = sellStartTime.getText().toString();
	      starttime = sellStartTime1.getText().toString();
	      enddate = sellEndTime.getText().toString();
	      endtime = sellEndTime1.getText().toString();

	      start=startdate+"%20"+starttime;
	      end=enddate+"%20"+endtime;
	      hideIM(view);
	 Intent intent = new Intent();
	  intent.setClass(MainActivity.this, searchresult.class);
	  Bundle bundle = new Bundle();
      bundle.putString("username",username );
      bundle.putString("password",password);
      bundle.putString("start",start );
      bundle.putString("end",end);
      intent.putExtras(bundle);
	  startActivity(intent); 
	  // MainActivity.this.finish(); 
	  
   }
  // public void loginPost(View view){
    //  String username = usernameField.getText().toString();
     // String password = passwordField.getText().toString();
      //method.setText("Post Method");
      //ew SigninActivity(this,status,role,1).execute(username,password);

   //}
   protected Dialog onCreateDialog(int id) { 
       switch (id) {    
           case 0: 
               return new DatePickerDialog(this, mDateSetListener, mYear, mMonth, mDay); 
           case 1: 
               return new TimePickerDialog(this, mTimeSetListener,mhour,mminiute,true); 
       } 
       return null; 
   } 
   private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() { 
       public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) { 
               int mYear = year; 
           String mm; 
           String dd;
           int mMonth;
           int mDay;
           
             
           if (monthOfYear <= 9) { 
               mMonth = monthOfYear + 1; 
               mm = "0" + mMonth; 
           } 
           else { 
               mMonth = monthOfYear + 1; 
               mm = String.valueOf(mMonth); 
           } 
             
           if (dayOfMonth <= 9) { 
               mDay = dayOfMonth; 
               dd = "0" + mDay; 
           } 
           else{ 
               mDay = dayOfMonth; 
               dd = String.valueOf(mDay); 
           } 
             
           mDay = dayOfMonth; 
             
           if (timeFlag == 0) { 
               sellStartTime.setText(String.valueOf(mYear) + "-" + mm + "-" + dd); 
              // startdate = String.valueOf(mYear) + "-" + mm + "-" + dd;
           } 
           else { 
               sellEndTime.setText(String.valueOf(mYear) + "-" + mm + "-" + dd); 
              // enddate = String.valueOf(mYear) + "-" + mm + "-" + dd;
           } 
       } 
   }; 
   private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
// the callback received when the user "sets" the TimePickerDialog in the dialog
               public void onTimeSet(TimePicker view, int hourOfDay, int min) {
                   int hour;
                   int minute; 
                   String hh,mm;
                   if (hourOfDay <= 9) { 

                	   hh = "0" + hourOfDay; 
                   } 
                   else { 
                       hh = String.valueOf(hourOfDay); 
                   } 
                     
                   if (min <= 9) { 
                   
                       mm = "0" + min; 
                   } 
                   else{ 

                       mm = String.valueOf(min); 
                   } 
  if (timeFlag == 0) { 
      sellStartTime1.setText(hh + ":" +mm + ":00"); 
      //starttime=hh + ":" +mm + ":00";
  } 
  else { 
      sellEndTime1.setText(hh + ":" + mm + ":00");
      //endtime=hh + ":" +mm + ":00";
  }                                       
               
               }
   };

   
     
   // 隐藏手机键盘 
   private void hideIM(View edt){ 
       try { 
           InputMethodManager im = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE); 
           IBinder windowToken = edt.getWindowToken(); 
             
           if (windowToken != null) { 
               im.hideSoftInputFromWindow(windowToken, 0); 
           } 
       } 
       catch (Exception e) { 
             
       } 
   }
   //android:background="@drawable/selector"

}