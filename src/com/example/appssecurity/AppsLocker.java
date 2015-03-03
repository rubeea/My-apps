package com.example.appssecurity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
//import android.content.res.Resources;
import android.os.Bundle;
//import android.text.Editable;
//import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


// Referenced classes of package com.example.appssecurity:
//            MyPreferences, MainActivity

public class AppsLocker extends Activity
    implements android.view.View.OnFocusChangeListener, android.view.View.OnClickListener
{

    public static boolean flag = true;
    public static String pack = "";
    private Button b0;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button bclear;
    private Button bdelete;
    private Button bkey;
    private Button bok;
    private Dialog dialog;
    private EditText hintEditText;
    private String pinString;
    private MyPreferences prefs;
    private EditText pin,rePin;
    private String rePinString;
    private boolean securityFlag;

    public AppsLocker()
    {
        securityFlag = false;
        pinString = "";
        rePinString = "";
        
    }

    private void setPassword()
    {
        if (pin.isFocused())
        {
            pin.setText(pinString);
            pin.setSelection(pin.getText().length());
            return;
        } else
        {
            rePin.setText(rePinString);
            rePin.setSelection(rePin.getText().length());
            return;
        }
    }

    public void okFunction()
    {
        if (pin.getText().toString().trim().equals(""))
        {
            Toast.makeText(getApplicationContext(), "Your Pin is Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (rePin.getText().toString().trim().equals(""))
        {
            Toast.makeText(getApplicationContext(), "Your Re-Pin is Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!securityFlag)
        {
            Toast.makeText(getApplicationContext(), "Enter Security Key", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!pin.getText().toString().trim().equals(rePin.getText().toString().trim()))
        {
            Toast.makeText(getApplicationContext(), "Pin and Re-Pin are Not Match", Toast.LENGTH_SHORT).show();
            return;
        } else
        {
            prefs.saveInt("first_Time_Open", 1);
            prefs.saveString("passwordValue", pin.getText().toString().trim());
            startActivity(new Intent(this, MainActivity.class));
            //startActivity(i);
            finish();
            return;
        }
    }

    public void onBackPressed()
    {
        super.onBackPressed();
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        case 2131099656: 
        default:
            return;

        case R.id.b0: 
            if (pin.isFocused())
            {
                pinString = (new StringBuilder(String.valueOf(pinString))).append("0").toString();
            } else
            {
                rePinString = (new StringBuilder(String.valueOf(rePinString))).append("0").toString();
            }
            setPassword();
            return;

        case R.id.b1: 
            if (pin.isFocused())
            {
                pinString = (new StringBuilder(String.valueOf(pinString))).append("1").toString();
            } else
            {
                rePinString = (new StringBuilder(String.valueOf(rePinString))).append("1").toString();
            }
            setPassword();
            return;

        case R.id.b2: 
            if (pin.isFocused())
            {
                pinString = (new StringBuilder(String.valueOf(pinString))).append("2").toString();
            } else
            {
                rePinString = (new StringBuilder(String.valueOf(rePinString))).append("2").toString();
            }
            setPassword();
            return;

        case R.id.b3: 
            if (pin.isFocused())
            {
                pinString = (new StringBuilder(String.valueOf(pinString))).append("3").toString();
            } else
            {
                rePinString = (new StringBuilder(String.valueOf(rePinString))).append("3").toString();
            }
            setPassword();
            return;

        case R.id.b4: 
            if (pin.isFocused())
            {
                pinString = (new StringBuilder(String.valueOf(pinString))).append("4").toString();
            } else
            {
                rePinString = (new StringBuilder(String.valueOf(rePinString))).append("4").toString();
            }
            setPassword();
            return;

        case R.id.b5: 
            if (pin.isFocused())
            {
                pinString = (new StringBuilder(String.valueOf(pinString))).append("5").toString();
            } else
            {
                rePinString = (new StringBuilder(String.valueOf(rePinString))).append("5").toString();
            }
            setPassword();
            return;

        case R.id.b6: 
            if (pin.isFocused())
            {
                pinString = (new StringBuilder(String.valueOf(pinString))).append("6").toString();
            } else
            {
                rePinString = (new StringBuilder(String.valueOf(rePinString))).append("6").toString();
            }
            setPassword();
            return;

        case R.id.b7: 
            if (pin.isFocused())
            {
                pinString = (new StringBuilder(String.valueOf(pinString))).append("7").toString();
            } else
            {
                rePinString = (new StringBuilder(String.valueOf(rePinString))).append("7").toString();
            }
            setPassword();
            return;

        case R.id.b8: 
            if (pin.isFocused())
            {
                pinString = (new StringBuilder(String.valueOf(pinString))).append("8").toString();
            } else
            {
                rePinString = (new StringBuilder(String.valueOf(rePinString))).append("8").toString();
            }
            setPassword();
            return;

        case R.id.b9 : 
            if (pin.isFocused())
            {
                pinString = (new StringBuilder(String.valueOf(pinString))).append("9").toString();
            } else
            {
                rePinString = (new StringBuilder(String.valueOf(rePinString))).append("9").toString();
            }
            setPassword();
            return;

        case R.id.bclear: 
            if (pin.isFocused())
            {
                if (pinString.length() > 0)
                {
                    pinString = "";
                }
            } else
            if (rePinString.length() > 0)
            {
                rePinString = "";
            }
            setPassword();
            return;

        case R.id.bdelete: 
            if (pin.isFocused())
            {
                if (pinString.length() > 0)
                {
                    pinString = pinString.substring(0, -1 + pinString.length());
                }
            } else
            if (rePinString.length() > 0)
            {
                rePinString = rePinString.substring(0, -1 + rePinString.length());
            }
            setPassword();
            return;

        case R.id.bkey: 
            onClickHintButton();
            return;

        case R.id.bok: 
            okFunction();
            return;
        }
    }

    public void onClickHintButton()
    {
        dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        View view = getLayoutInflater().inflate(R.layout.savekey, null);
        hintEditText = (EditText)view.findViewById(R.id.hintEditText);
        dialog.setContentView(view);
        dialog.show();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        
        requestWindowFeature(1);
        setContentView(R.layout.activity_apps_locker);
        pin = (EditText)findViewById(R.id.password);
        rePin = (EditText)findViewById(R.id.repassword);
        pin.setOnFocusChangeListener(this);
        rePin.setOnFocusChangeListener(this);
        pin.setOnTouchListener(new android.view.View.OnTouchListener() {

            final AppsLocker this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                int i = pin.getInputType();
                pin.setInputType(0);
                pin.onTouchEvent(motionevent);
                pin.setInputType(i);
                return true;
            }

            
            {
            	this$0 = AppsLocker.this;
               // super();
            }
        });
        rePin.setOnTouchListener(new android.view.View.OnTouchListener() {

            final AppsLocker this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                int i = rePin.getInputType();
                rePin.setInputType(0);
                rePin.onTouchEvent(motionevent);
                rePin.setInputType(i);
                return true;
            }

            
            {
            	this$0 = AppsLocker.this;
                //super();
            }
        });
        b0 = (Button)findViewById(R.id.b0);
        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        b3 = (Button)findViewById(R.id.b3);
        b4 = (Button)findViewById(R.id.b4);
        b5 = (Button)findViewById(R.id.b5);
        b6 = (Button)findViewById(R.id.b6);
        b7 = (Button)findViewById(R.id.b7);
        b8 = (Button)findViewById(R.id.b8);
        b9 = (Button)findViewById(R.id.b9);
        bclear = (Button)findViewById(R.id.bclear);
        bdelete = (Button)findViewById(R.id.bdelete);
        bkey = (Button)findViewById(R.id.bkey);
        bok = (Button)findViewById(R.id.bok);
        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        bclear.setOnClickListener(this);
        bdelete.setOnClickListener(this);
        bkey.setOnClickListener(this);
        bok.setOnClickListener(this);
        prefs = new MyPreferences(this);
    }

    public void onFocusChange(View view, boolean flag1)
    {
        if (flag1)
        {
            view.setBackgroundDrawable(getResources().getDrawable(R.drawable.edit_focus_background));
            return;
        } else
        {
            view.setBackgroundDrawable(getResources().getDrawable(R.drawable.edit_unfocus_background));
            return;
        }
    }

    public void saveSecurityKey(View view)
    {
        String s = hintEditText.getText().toString();
        if (s.trim().equals(""))
        {
            Toast.makeText(getApplicationContext(), "Security Key can't Empty", Toast.LENGTH_SHORT).show();
            return;
        } else
        {
            securityFlag = true;
            prefs.saveString("securityKey", s);
            dialog.hide();
            return;
        }
    }
 }


