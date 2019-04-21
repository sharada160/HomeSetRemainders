package com.example.homealarm;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.security.AccessController.getContext;

public class ShowNotificationJob extends Job{

    static final String TAG = "show_notification_job_tag";

    @NonNull
    @Override
    protected Result onRunJob(Params params) {
        PendingIntent pi = PendingIntent.getActivity(getContext(), 0,
                new Intent(getContext(), DataActivity.class), 0);

        Notification notification = new NotificationCompat.Builder(getContext())
                .setContentTitle("Android Job Demo")
                .setContentText("Notification from Android Job Demo App.")
                .setAutoCancel(true)
                .setContentIntent(pi)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setShowWhen(true)
                .setColor(Color.RED)
                .setLocalOnly(true)
                .build();

        NotificationManagerCompat.from(getContext())
                .notify(new Random().nextInt(), notification);

        return Job.Result.SUCCESS;
    }

    static void schedulePeriodic() {
        new JobRequest.Builder(ShowNotificationJob.TAG)
                .setPeriodic(TimeUnit.MINUTES.toMillis(15), TimeUnit.MINUTES.toMillis(5))
                .setUpdateCurrent(true)
                .setPersisted(true)
                .build()
                .schedule();
    }
}

