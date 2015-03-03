package com.example.appssecurity;

import android.graphics.drawable.Drawable;

public class PInfo {

	    String appname = "";
	    String pname = "";
	    Drawable icon;
	    public boolean selected;
	    private void prettyPrint() {
	        //Log.v("",appname + "\t" + pname + "\t" + versionName + "\t" + versionCode);
	    }
	    
	    public void setSelected(boolean flag)
	    {
	        selected = flag;
	    }
	
	    public boolean getSelected()
	    {
	        return selected;
	    }
}
