package com.example.adil.taskmanager;

import android.app.Activity;
import android.app.Application;

/**
 * Created by Adil on 24-Sep-15.
 */
public class TaskManagerActivity extends Activity {

    public TaskManagerApplication getTaskManagerApplication() {

        TaskManagerApplication tma = (TaskManagerApplication) getApplication();
        return tma;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
