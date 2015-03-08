package com.example.kinectevent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;

public class SigninActivity extends AsyncTask<String,Void,String>{
   
   private String name;
   private String username;
   private String password,start,end;
   String link;
   
   private TextView statusField,roleField,chooseField,methodField,roomField;
   private Context context;
   private int byGetOrPost = 0; 
   
   //flag 0 means get and 1 means post.(By default it is get.)

   public SigninActivity(Context context,TextView roomField,TextView statusField,TextView roleField,TextView methodField,int flag) {
	   this.context = context;
	   this.roomField = roomField;
      this.statusField = statusField;
      this.roleField = roleField;
      this.methodField= methodField;
      byGetOrPost = flag;
     // this.chooseField= chooseField;
      //TextView choose = chooseField;
   }
  // TextView choose = chooseField;
  
   protected void onPreExecute(){
	 
   }
   @Override
   protected String doInBackground(String... arg0) {
      if(byGetOrPost == 0){ //means by Get Method
         try{
            username = (String)arg0[0];
            password = (String)arg0[1];
            start=(String)arg0[2];
            end=(String)arg0[3];
          link = "http://129.105.36.214/loginserver.php?username="
            +username+"&password="+password+"&start="+start+"&end="+end;
            //link = "http://10.101.52.172:8888/test/loginme.php?username="
           //+username+"&password="+password+"&start="+start+"&end="+end;
           // choose.setText(username);
           // this.chooseField.setText(username);
            //this.statusField.setText(password);
            //String link = "http://10.101.52.114/test/login.php";
            URL url = new URL(link);
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(link));
            HttpResponse response = client.execute(request);
            BufferedReader in = new BufferedReader
          (new InputStreamReader(response.getEntity().getContent(),"UTF-8"));
           // (new InputStreamReader(response.getEntity().getContent()));
 
           StringBuffer sb = new StringBuffer("");
           String line="";
           while ((line = in.readLine()) != null) {
        
        	  //sb.append(line);
              //break;
           char[] bb = line.toCharArray();
           String cc = "";
           
  int j=0;
  int f=1;
           
            for(char i:bb )
            {	
            	//String dd = new String(i);
            	
            	if(i=='<'&&f==1)
            	{
                  name=cc;
            	  cc="";
            	  f=0;
            	}
            	if(i=='<'&&f==0)
            	{
            	 j=3;
            	 cc = cc + "\n";
            	 sb.append(cc);
            	 cc = "";
            	}
            	else{
            	if(j==0)
            	{		
            	cc = cc + Character.toString(i);
            	}
            	else
            	{j--;}
            	}
             
             }
            		
                //sb.append(line);	
            		
            	
            }
           
     
            in.close();
            return sb.toString();
      }catch(Exception e){
         return new String("Exception: " + e.getMessage());
      }
      }
      else{
         try{
            username = (String)arg0[0];
            String password = (String)arg0[1];
            String link="http://10.101.52.114/login.php";
            String data  = URLEncoder.encode("username", "UTF-8") 
            + "=" + URLEncoder.encode(username, "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") 
            + "=" + URLEncoder.encode(password, "UTF-8");
            URL url = new URL(link);
            URLConnection conn = url.openConnection(); 
            conn.setDoOutput(true); 
            OutputStreamWriter wr = new OutputStreamWriter
            (conn.getOutputStream()); 
            wr.write( data ); 
            wr.flush(); 
            BufferedReader reader = new BufferedReader
            (new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            // Read Server Response
            while((line = reader.readLine()) != null)
            {
               sb.append(line);
               break;
            }
            return sb.toString();
         }catch(Exception e){
            return new String("Exception: " + e.getMessage());
         }
      }
   }
   @Override
   protected void onPostExecute(String result){
	 // Intent intent = new Intent(SigninActivity.this, result.class);
	   
	 //  startActivity(intent); 
	   this.roomField.setText(username);
	   this.roleField.setText(result);
      this.methodField.setText(name);
      this.statusField.setText(password);
      
   }
}