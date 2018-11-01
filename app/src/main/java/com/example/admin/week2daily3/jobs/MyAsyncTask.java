package com.example.admin.week2daily3.jobs;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

public class MyAsyncTask extends AsyncTask<String, Integer, String> {
    public static final String TAG = MyAsyncTask.class.getSimpleName()+"_TAG";
    TextView tvMain;

    public MyAsyncTask(TextView tvMain) {
        this.tvMain = tvMain;
    }

    @Override
    protected String doInBackground(String... strings) {

        for (int i = 0; i < 5 ; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
        }
        return "Background task result";
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        tvMain.setText("Task Starting");

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        tvMain.setText(String.valueOf(values[0]));
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        tvMain.setText("Task Completed");
    }
}
