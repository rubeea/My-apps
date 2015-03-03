package com.example.appssecurity;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class CustomAdapter extends ArrayAdapter<PInfo>{
private final Context context;
private final int resourceID;
ArrayList<PInfo> values1;
private MyPreferences pref;


    public CustomAdapter(Context context, int resource, ArrayList<PInfo> arr1) {
        super(context, resource,arr1);

        this.context = context;
        this.resourceID = resource;
        this.values1= arr1;
        pref = new MyPreferences(context);
    }
    
    static class ViewHolder {
        protected TextView textView;
        protected ToggleButton tb;
        protected ImageView imageView;
      }

    

    @Override
    public View getView(int position, View view, ViewGroup parent) {
    	
    	ViewHolder viewHolder;
        if (view == null) {
          LayoutInflater inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          view = inflator.inflate(R.layout.row, null);
          viewHolder = new ViewHolder();
          viewHolder.textView = (TextView) view.findViewById(R.id.label);
          viewHolder.imageView = (ImageView) view.findViewById(R.id.icon);
          viewHolder.tb = (ToggleButton) view.findViewById(R.id.toggle1);
          viewHolder.tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            
            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag) {
        		// TODO Auto-generated method stub
            	try{
        	
        		 int j = ((Integer)compoundbutton.getTag()).intValue();
        		 ((PInfo)values1.get(j)).setSelected(compoundbutton.isChecked());
        		 if(flag){
        			
        			 pref.saveInt(((PInfo)values1.get(j)).pname, 1);
        			 
        		 }
        		 
        		 else{
                         pref.saveInt(((PInfo)values1.get(j)).pname, 0);
        		 }
                 Log.i("Click item", "");
            	 }catch(Exception ex){
               		Toast.makeText(context, ex.getMessage(), Toast.LENGTH_LONG).show();
               	}	
            }
        	
           
          });
         
       
          view.setTag(viewHolder);
          view.setTag(R.id.icon, viewHolder.imageView);
          view.setTag(R.id.label, viewHolder.textView);
          view.setTag(R.id.toggle1, viewHolder.tb);
         
        } else {
          
        	 viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.tb.setTag(Integer.valueOf(position));
        viewHolder.imageView.setImageDrawable(((PInfo)values1.get(position)).icon);
        viewHolder.textView.setText(((PInfo)values1.get(position)).appname);
        if (pref.getInt(((PInfo)values1.get(position)).pname) == 1)
        {
            viewHolder.tb.setChecked(true);
        } else
        {
            viewHolder.tb.setChecked(false);
        }
       
    	
    	 return view;
    }
    
	
	
}
