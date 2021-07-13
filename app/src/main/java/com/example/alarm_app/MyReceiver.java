package com.example.alarm_app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
       if(intent.getAction().equalsIgnoreCase("com.example.alarm_app")){
           Bundle b=intent.getExtras();
           Toast.makeText(context, b.getString("MyMessage"), Toast.LENGTH_SHORT).show();
       }
    }
}