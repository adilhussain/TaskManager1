package com.example.adil.taskmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Adil on 11-Oct-15.
 */
public class TasksSelectActivity extends Activity {
    private Button pictureButton;
    private Button textButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks_select_activity);
        setUpViews();
    }

    private void setUpViews() {
        pictureButton = (Button) findViewById(R.id.picture_view);
        textButton = (Button) findViewById(R.id.text_views);
        pictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TasksSelectActivity.this, viewPictureActivity.class);
                startActivity(intent);

            }
        });
        textButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TasksSelectActivity.this, viewTasksActivity.class);
                startActivity(intent);

            }
        });
    }
}
