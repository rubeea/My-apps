package com.example.appssecurity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


// Referenced classes of package com.example.appssecurity:
//            MyPreferences, MainActivity, ForgetPin

public class Login extends Activity
    implements android.view.View.OnFocusChangeListener, android.view.View.OnClickListener
{
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
    private Button bok;
    private Dialog dialog;
    private EditText hintEditText;
    private EditText pin;
    private String pinString;
    private MyPreferences prefs;
    private Button bkey;

    public Login()
    {
        pinString = "";
    }

    private void setPassword()
    {
        pin.setText(pinString);
        pin.setSelection(pin.getText().length());
    }

    public void getPassword(View view)
    {
        String s = hintEditText.getText().toString();
        if (s.trim().equals(""))
        {
            Toast.makeText(getApplicationContext(), "Security Key can't Empty", 0).show();
            return;
        }
        if (!prefs.getString("securityKey").equals(s))
        {
            Toast.makeText(getApplicationContext(), "Security Key is Invalid", 0).show();
            return;
        } else
        {
            Toast.makeText(getApplicationContext(), (new StringBuilder("Pin : ")).append(prefs.getString("passwordValue")).toString(), 0).show();
            dialog.hide();
            return;
        }
    }

    public void okFunction()
    {
        if (pin.getText().toString().trim().equals(""))
        {
            Toast.makeText(getApplicationContext(), "Your Pin is Empty", 0).show();
            return;
        }
        if (!pin.getText().toString().trim().equals(prefs.getString("passwordValue")))
        {
            Toast.makeText(getApplicationContext(), "Pin is invalid", 0).show();
            pin.setText("");
            pinString = "";
            return;
        } else
        {
            startActivity(new Intent(this, MainActivity.class));
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
            pinString = (new StringBuilder(String.valueOf(pinString))).append("0").toString();
            setPassword();
            return;

        case R.id.b1: 
            pinString = (new StringBuilder(String.valueOf(pinString))).append("1").toString();
            setPassword();
            return;

        case R.id.b2: 
            pinString = (new StringBuilder(String.valueOf(pinString))).append("2").toString();
            setPassword();
            return;

        case R.id.b3: 
            pinString = (new StringBuilder(String.valueOf(pinString))).append("3").toString();
            setPassword();
            return;

        case R.id.b4: 
            pinString = (new StringBuilder(String.valueOf(pinString))).append("4").toString();
            setPassword();
            return;

        case R.id.b5: 
            pinString = (new StringBuilder(String.valueOf(pinString))).append("5").toString();
            setPassword();
            return;

        case R.id.b6: 
            pinString = (new StringBuilder(String.valueOf(pinString))).append("6").toString();
            setPassword();
            return;

        case R.id.b7: 
            pinString = (new StringBuilder(String.valueOf(pinString))).append("7").toString();
            setPassword();
            return;

        case R.id.b8: 
            pinString = (new StringBuilder(String.valueOf(pinString))).append("8").toString();
            setPassword();
            return;

        case R.id.b9: 
            pinString = (new StringBuilder(String.valueOf(pinString))).append("9").toString();
            setPassword();
            return;

        case R.id.bclear: 
            if (pinString.length() > 0)
            {
                pinString = "";
            }
            setPassword();
            return;

        case R.id.bdelete: 
            if (pinString.length() > 0)
            {
                pinString = pinString.substring(0, -1 + pinString.length());
            }
            setPassword();
            return;

        case R.id.bok: 
            okFunction();
            return;
            
        case R.id.bkey: 
            onClickHintButton();
            return;

        }
    }

    public void onClickHintButton()
    {
        (new ForgetPin(this)).createAlert();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.login);
        pin = (EditText)findViewById(R.id.password);
        pin.setOnTouchListener(new android.view.View.OnTouchListener() {

            final Login this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                pin.setCursorVisible(true);
                return true;
            }

            
            {
                this$0 = Login.this;
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
        bok = (Button)findViewById(R.id.bok);
        bkey = (Button)findViewById(R.id.bkey);
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
        bok.setOnClickListener(this);
        bkey.setOnClickListener(this);
        prefs = new MyPreferences(this);
    }

    public void onFocusChange(View view, boolean flag)
    {
        if (flag)
        {
            view.setBackgroundDrawable(getResources().getDrawable(R.drawable.edit_focus_background));
            return;
        } else
        {
            view.setBackgroundDrawable(getResources().getDrawable(R.drawable.edit_unfocus_background));
            return;
        }
    }


}

