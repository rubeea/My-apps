package com.example.appssecurity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

// Referenced classes of package com.example.appssecurity:
//            MyService

public class AppslockReceiver extends BroadcastReceiver
{

    public AppslockReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Log.i("Appslocker Boot After:", "");
        Intent intent1 = new Intent(context, MyService.class);
        intent1.addFlags(0x10000000);
        context.startService(intent1);
    }
}
