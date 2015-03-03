package com.example.appssecurity;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPreferences
{

    public static final String PREFS_NAME = "MyPrefsFile";
    private Context activity;
    private SharedPreferences prefs;

    MyPreferences(Context context)
    {
        activity = context;
        prefs = context.getSharedPreferences("MyPrefsFile", 4);
    }

    public int getInt(String s)
    {
        if (s.equals("firstTimeScreen"))
        {
            return prefs.getInt(s, 1);
        } else
        {
            return prefs.getInt(s, 0);
        }
    }

    public String getString(String s)
    {
        return prefs.getString(s, "0");
    }

    public void saveInt(String s, int i)
    {
        android.content.SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(s, i);
        editor.commit();
    }

    public void saveString(String s, String s1)
    {
        android.content.SharedPreferences.Editor editor = prefs.edit();
        editor.putString(s, s1);
        editor.commit();
    }
}
