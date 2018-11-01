package com.example.admin.week2daily3;

import android.os.Handler;
import android.os.Looper;
import android.widget.ProgressBar;

import java.util.concurrent.TimeUnit;

public class MyTask implements Runnable {
    public static final String TAG = MyTask.class.getSimpleName() + "_TAG";
    private String name;
    private static int progressStatus;
    private ProgressBar progressBar;
    private static Handler handler = new Handler(Looper.getMainLooper());


    public MyTask(String name, ProgressBar progressBar) {
        this.name = name;
        this.progressBar = progressBar;
    }


    public String getName() {
        return name;
    }


    @Override
    public void run() {
        Long n = (long) (Math.random() * 10);
        while (progressStatus < 100) {
            progressStatus++;
            handler.post(new Runnable() {
                public void run() {
                    progressBar.setProgress(progressStatus);
                }
            });
            try {
                TimeUnit.SECONDS.sleep(n);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

