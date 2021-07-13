package com.example.alarm_app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.Calendar;

public class SaveData {
    SharedPreferences ShredRef;
    Context context;
    public SaveData(Context context){
        this.context=context;
        ShredRef=context.getSharedPreferences("myRef",Context.MODE_PRIVATE);
    }

    public  void SaveData(int hour,int
            minute){
        SharedPreferences.Editor editor=ShredRef.edit();
        editor.putInt("hour",hour);
        editor.putInt("minute",minute);
        editor.commit();
    }

    public void LoadData(){
        int minute=ShredRef.getInt("minute",0);
        int hour=ShredRef.getInt("hour",0);
        alarmSet(hour,minute);

    }
    void  alarmSet(int hour,int
            minute){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);

        AlarmManager am = (AlarmManager)context.getSystemService (Context.ALARM_SERVICE);
        Intent intent = new Intent(context, MyReceiver.class);
        intent.setAction("com.example.alarm_app");
        intent.putExtra("MyMessage","hello from alarm");
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY , pi);
        //save data

    }
}
