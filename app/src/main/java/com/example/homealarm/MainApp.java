package com.example.homealarm;

import android.app.Application;

import com.evernote.android.job.JobManager;

public class MainApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        JobManager.create(this).addJobCreator(new TheJobCreator());
        JobManager.instance().getConfig().setAllowSmallerIntervalsForMarshmallow(true);
    }
}
