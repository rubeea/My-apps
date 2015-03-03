package com.example.appssecurity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

// Referenced classes of package com.example.appssecurity:
//            MyPreferences, MyService, AppsLocker, Login, 

public class SplashScreen extends Activity
{
    private class IntentLauncher extends Thread
    {

        final SplashScreen splashs;

        public void run()
        {
            try
            {
                Thread.sleep(1000L * SplashScreen.SLEEP_TIME);
            }
            catch (Exception exception)
            {
                Log.e(SplashScreen.TAG, exception.getMessage());
            }
            
            startService(new Intent(SplashScreen.this, MyService.class));
            if (pref.getInt("firstTimeScreen") == 1)
            {
                if (pref.getInt("first_Time_Open") == 0)
                {
                    Intent intent1 = new Intent(SplashScreen.this, AppsLocker.class);
                    startActivity(intent1);
                    finish();
                } else
                {
                    Intent intent2 = new Intent(SplashScreen.this, Login.class);
                    startActivity(intent2);
                    finish();
                }
            } else
            {
                /*Intent intent;
                if (pref.getInt("patternCreated") == 0)
                {
                    intent = new Intent(SplashScreen.this, com/example/owaisgoldi/appslocker/LockPatternActivity);
                } else
                {
                    intent = new Intent(SplashScreen.this, com/example/owaisgoldi/appslocker/LockPatternActivity2);
                }
                startActivity(intent);
                finish();*/
            }
            finish();
        }

        private IntentLauncher()
        {
        	super();
            splashs = SplashScreen.this;
           
        }

        IntentLauncher(IntentLauncher intentlauncher)
        {
            this();
        }
    }


    private static long SLEEP_TIME = 2L;
    private static String TAG = SplashScreen.class.getName();
    private MyPreferences pref;

    public SplashScreen()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.splash_layout);
        pref = new MyPreferences(this);
        (new IntentLauncher(null)).start();
    }


}
