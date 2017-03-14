package com.android.mdw.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Jaume and Nil on 10/03/2017.
 *
 */

public class ElBroadcast extends BroadcastReceiver{

    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Broadcast Iniciado", Toast.LENGTH_LONG).show();
        String state = intent.getStringExtra("state");

        if (state.equals("run")){
            Intent myIntent1 = new Intent(context, ElServicio.class);
            String data = intent.getStringExtra("sound");
            myIntent1.putExtra("sound", data);
            context.startService(myIntent1);
        } else {
            context.stopService(new Intent(context, ElServicio.class));
        }
    }
}
