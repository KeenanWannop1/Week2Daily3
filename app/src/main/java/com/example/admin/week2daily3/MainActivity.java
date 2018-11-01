package com.example.admin.week2daily3;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.admin.week2daily3.jobs.MyAsyncTask;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    private Handler handler;
    private TextView tvOne;
    private TextView tvTwo;
    private ProgressBar progressBar1;
    private ProgressBar progressBar2;
    private ProgressBar progressBar3;
    private ProgressBar progressBar4;
    private ThreadPoolExecutor executor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvOne = findViewById(R.id.tvOne);
        tvTwo = findViewById(R.id.tvTwo);
        progressBar1 = findViewById(R.id.progressBar1);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar3 = findViewById(R.id.progressBar3);
        progressBar4 = findViewById(R.id.progressBar4);
        handler = new Handler(this);
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
    }

    @Override
    public boolean handleMessage(Message message) {
        return false;
    }
    //4 threads run in parallel
    public void onThreads(View view) {


            MyTask task1 = new MyTask("Task 1", progressBar1);
            System.out.println("Created : Task 1");
            MyTask task2 = new MyTask("Task 2", progressBar2);
            System.out.println("Created : " + task2.getName());
            MyTask task3 = new MyTask("Task 3", progressBar3);
            System.out.println("Created : " + task3.getName());
            MyTask task4 = new MyTask("Task 4", progressBar4);
            System.out.println("Created : " + task4.getName());

            executor.execute(task1);
            executor.execute(task2);
            executor.execute(task3);
            executor.execute(task4);
        }

        public void onRunAsync(View view){
            MyAsyncTask myAsyncTask = new MyAsyncTask(tvOne);
            MyAsyncTask myAsyncTask1 = new MyAsyncTask(tvTwo);
            myAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            myAsyncTask1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }

    }

