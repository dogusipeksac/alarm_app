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



        SaveData saveData=new SaveData(this);
        saveData.alarmSet(Hour,Minute);
        saveData.SaveData(Hour,Minute);

    }
}