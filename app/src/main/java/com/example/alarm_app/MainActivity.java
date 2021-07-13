package com.example.alarm_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm=this.getSupportFragmentManager();
        PopTime popTime=new PopTime();
        popTime.show(fm,"Show fragment");
    }

    void SetTime(int Hour ,int Minute ){


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, Hour);
        calendar.set(Calendar.MINUTE, Minute);
        calendar.set(Calendar.SECOND, 0);

        AlarmManager am = (AlarmManager)getSystemService  (Context.ALARM_SERVICE);
        Intent intent = new Intent(this, MyReceiver.class);
        intent.setAction("com.example.alarm_app");
        intent.putExtra("MyMessage","hello from alarm");
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY , pi);


    }
}