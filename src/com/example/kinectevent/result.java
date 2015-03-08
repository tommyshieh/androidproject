package com.example.kinectevent;

import java.util.Calendar;

import android.app.TimePickerDialog;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
public class result extends Activity {
private ListView listView;
private String[] list = {"鉛筆","原子筆","鋼筆","毛筆","彩色筆"};
private ArrayAdapter<String> listAdapter;
@Override
public void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   setContentView(R.layout.result);
   listView = (ListView)findViewById(R.id.listView);
   listAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
   listView.setAdapter(listAdapter);
   listView.setOnItemClickListener(new OnItemClickListener(){
       public void onItemClick(AdapterView<?> parent, View view, int position, long id){
          Toast.makeText(getApplicationContext(),                                                          "你選擇的是"+list[position], Toast.LENGTH_SHORT).show();
       }
   });
}}