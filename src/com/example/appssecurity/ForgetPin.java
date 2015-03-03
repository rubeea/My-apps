package com.example.appssecurity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetPin {
	 	
		private Activity activity;
	    private Button bHint;
	    private Button cancelButton;
	    private EditText conpwd;
	    private Dialog dialog;
	    private Dialog dialog2;
	    private Button hintButton;
	    private EditText hintEditText;
	    private boolean hintFlag;
	    private String hintString;
	    private EditText newpwd;
	    private MyPreferences pref;
	    private Button resetButton;

	    public ForgetPin(Activity activity1)
	    {
	        activity = activity1;
	    }

	    public void alertDismiss()
	    {
	        hintString = hintEditText.getText().toString();
	        if (hintString.trim().equals(""))
	        {
	            Toast.makeText(activity, "Security Key is Empty", 0).show();
	        } else
	        {
	            if (!hintString.trim().equals(pref.getString("securityKey")))
	            {
	                Toast.makeText(activity, "Security Key is Wrong", 0).show();
	                hintEditText.setText("");
	                return;
	            }
	            if (hintString.trim().equals(pref.getString("securityKey")))
	            {
	                //Toast.makeText(activity, (new StringBuilder("Your Pin:")).append(pref.getString("passwordValue")).toString(), 0).show();
	            	newpwd.setEnabled(true);
	            	conpwd.setEnabled(true);
	                //dialog2.hide();
	                //return;
	            }
	        }
	    }

	    public void alertShow()
	    {
	        dialog2 = new Dialog(activity);
	        dialog2.requestWindowFeature(1);
	        View view = activity.getLayoutInflater().inflate(R.layout.hintalert, null);
	        hintEditText = (EditText)view.findViewById(R.id.hintEditText);
	        hintButton = (Button)view.findViewById(R.id.hintbutton);
	        newpwd = (EditText)view.findViewById(R.id.newpwd);
	        conpwd = (EditText)view.findViewById(R.id.conpwd);
	        resetButton = (Button)view.findViewById(R.id.resetbtn);
	        dialog2.setContentView(view);
	        dialog2.show();
	        hintButton.setOnClickListener(new android.view.View.OnClickListener() {

	            final ForgetPin this$0;

	            public void onClick(View view1)
	            {
	                alertDismiss();
	            }

	            
	            {
	                this$0 = ForgetPin.this;
	            }
	        });
	        
	        resetButton.setOnClickListener(new android.view.View.OnClickListener() {

	            final ForgetPin this$0;

	            public void onClick(View view1)
	            {
	                okFunction();
	            }

	            
	            {
	                this$0 = ForgetPin.this;
	            }
	        });
	    }

	    public void createAlert()
	    {
	        pref = new MyPreferences(activity);
	        alertShow();
	    }
	    
	    public void okFunction()
	    {
	        if (newpwd.getText().toString().trim().equals(""))
	        {
	            Toast.makeText(activity, "Your Pin is Empty", Toast.LENGTH_SHORT).show();
	            return;
	        }
	        if (conpwd.getText().toString().trim().equals(""))
	        {
	            Toast.makeText(activity, "Your Re-Pin is Empty", Toast.LENGTH_SHORT).show();
	            return;
	        }
	       
	        if (!newpwd.getText().toString().trim().equals(conpwd.getText().toString().trim()))
	        {
	            Toast.makeText(activity, "Pin and Re-Pin donot Not Match", Toast.LENGTH_SHORT).show();
	            return;
	        } else
	        {
	            pref.saveInt("first_Time_Open", 1);
	            pref.saveString("passwordValue", newpwd.getText().toString().trim());
	            dialog2.hide();
	            return;
	        }
	    }

}

