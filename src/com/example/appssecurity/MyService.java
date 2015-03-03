package com.example.appssecurity;

import android.app.ActivityManager;
import android.app.Application;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.example.appssecurity:
//            MyPreferences, AppsLocker, MyActivity

public class MyService extends Service
{
    public class LocalBinder extends Binder
    {

        final MyService this$0;

        MyService getService()
        {
            return MyService.this;
        }

        public LocalBinder()
        {
        	super();
            this$0 = MyService.this;
            
        }
    }


    private static final long DELAY_INTERVAL = 0L;
    private static final long UPDATE_INTERVAL = 100L;
    private final IBinder mBinder = new LocalBinder();
    private MyPreferences pref;
    private Timer timer;

    public MyService()
    {
        timer = new Timer();
    }

    public IBinder onBind(Intent intent)
    {
        return mBinder;
    }

    public void onCreate()
    {
        pref = new MyPreferences(getApplicationContext());
        try
        {
            timer.scheduleAtFixedRate(new TimerTask() {

                final MyService serv;

                public void run()
                {
                    int i = pref.getInt("lockEnabled");
                    ActivityManager activitymanager = (ActivityManager)getApplicationContext().getSystemService("activity");
                    String s = ((android.app.ActivityManager.RunningTaskInfo)activitymanager.getRunningTasks(1).get(0)).topActivity.getPackageName();
                    String s1 = ((android.app.ActivityManager.RunningTaskInfo)activitymanager.getRunningTasks(1).get(0)).topActivity.getClassName();
                    int j = pref.getInt(s);
                    if (s.equals("com.sec.android.app.twlauncher") || s.equals("com.sec.android.app.launcher") || s.substring(1 + s.lastIndexOf("."), s.length()).equals("launcher"))
                    {
                        AppsLocker.flag = true;
                    }
                    if (j == 1 && AppsLocker.flag && i == 0)
                    {
                        if (pref.getInt("firstTimeScreen") == 1)
                        {
                            Intent intent = new Intent(getBaseContext(), MyActivity.class);
                            intent.putExtra("pack", s);
                            intent.putExtra("className", s1);
                            intent.addFlags(0x10000000);
                            getApplication().startActivity(intent);
                        } 
                        AppsLocker.flag = false;
                        AppsLocker.pack = s;
                    }
                }

            
            {
            	//super();
                serv = MyService.this;
                
            }
            }, 0L, 100L);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void onDestroy()
    {
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        Log.i("LocalService", (new StringBuilder("Received start id ")).append(j).append(": ").append(intent).toString());
        return 1;
    }

}
