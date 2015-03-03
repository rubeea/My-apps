package com.example.appssecurity;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ArrayList<PInfo> myStringArray1=new ArrayList<PInfo>();
	ListView lv;
	AppslockReceiver rec;
	private MyPreferences pref;
	ArrayAdapter<PInfo> ltadapter;
	
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv= (ListView) findViewById(R.id.listView1);
		rec = new AppslockReceiver();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void show_Click(View v){
		
		
		final PackageManager pm = getPackageManager();
		//get a list of installed apps.
		List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);
		
		for (ApplicationInfo packageInfo : packages) {
		    
		    PInfo newInfo = new PInfo();
	        newInfo.appname = pm.getApplicationLabel(packageInfo).toString();
	        newInfo.pname = packageInfo.packageName; 
	        newInfo.icon = pm.getApplicationIcon(packageInfo);
	        myStringArray1.add(newInfo);

			}
		
		ltadapter = new CustomAdapter(this, R.layout.row, myStringArray1);
    	lv.setAdapter(ltadapter);
		
		
	}
	
	public void exit_Click(View arg){
		
		(new android.app.AlertDialog.Builder(this)).setTitle("AppsSecurity").setMessage("Exit AppsSecurity?").setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

            final MainActivity this$0;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                finish();
            }

        
        {
            this$0 = MainActivity.this;
            //super();
        }
        }).setNegativeButton("CANCEL", new android.content.DialogInterface.OnClickListener() {

            final MainActivity this$0;

            public void onClick(DialogInterface dialoginterface, int j)
            {
            }

        
        {
            this$0 = MainActivity.this;
            //super();
        }
        }).show();
	   }
	
	 public boolean onKeyDown(int i, KeyEvent keyevent)
	    {
	        if (i == 4)
	        {
	            (new android.app.AlertDialog.Builder(this)).setTitle("AppsSecurity").setMessage("Exit AppsSecurity?").setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

	                final MainActivity this$0;

	                public void onClick(DialogInterface dialoginterface, int j)
	                {
	                    finish();
	                }

	            
	            {
	                this$0 = MainActivity.this;
	                //super();
	            }
	            }).setNegativeButton("CANCEL", new android.content.DialogInterface.OnClickListener() {

	                final MainActivity this$0;

	                public void onClick(DialogInterface dialoginterface, int j)
	                {
	                }

	            
	            {
	                this$0 = MainActivity.this;
	                //super();
	            }
	            }).show();
	        }
	        return false;
	    }

	   
}
