package com.android.mdw.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Jaume and Nil on 10/03/2017.
 *
 */

public class ElReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BATTERY_LOW)) {
            Toast.makeText(context, "Intent Recibido - Plug Headset", Toast.LENGTH_LONG).show();
            Intent intent1 = new Intent(context, ElServicio.class);
            intent1.putExtra("sound","music");
            context.startService(intent1);
        }
        if (intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            Toast.makeText(context, "Intent Recibido - AIRPLANE", Toast.LENGTH_LONG).show();
            Intent intent1 = new Intent(context, ElServicio.class);
            context.stopService(intent1);
        }
    }
}
