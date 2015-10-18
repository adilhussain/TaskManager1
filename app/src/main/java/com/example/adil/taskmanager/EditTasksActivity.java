package com.example.adil.taskmanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.adil.taskmanager.tasks.Task;

/**
 * Created by Adil on 27-Sep-15.
 */
public class EditTasksActivity extends TaskManagerActivity {

    private Button editButton;
    private Button backButton;
    private EditText editText;
    private TaskManagerApplication app;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_tasks_activity);
        setUpViews();
        app = (TaskManagerApplication) getApplication();

    }

    protected void onResume(){
        super.onResume();

        //showTasks();

    }

    private void setUpViews() {

        editButton = (Button)findViewById(R.id.edit_button);
        backButton = (Button)findViewById(R.id.back_button);
        editText = (EditText)findViewById(R.id.task_name);

        final String editedTask = getIntent().getExtras().getString("Task_name_view");
        final Long editedTaskId = getIntent().getExtras().getLong("Task_id_view");
        editText.setText(editedTask + " " + editedTaskId);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Task t = new Task(editedTask);
                getTaskManagerApplication().addTask(t);
                finish();

            }
        });
        editButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                editTask();

                //app.updateTask(editedTaskId, editText.getText().toString());
                // finish();
                /*Intent intent = new Intent(EditTasksActivity.this,viewTasksActivity.class);
                intent.putExtra("Task_name",editText.getText().toString());
                startActivity(intent);*/

            }
        });
    }

    private void editTask() {
       // getTaskManagerApplication().updateTask(getIntent().getExtras().getLong("Task_id_view"),
              //  editText.getText().toString());
        String taskName = editText.getText().toString();
        Task t = new Task(taskName);
    getTaskManagerApplication().updateTask(t);

        finish();
    }


}
