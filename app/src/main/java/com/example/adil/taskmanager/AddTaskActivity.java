package com.example.adil.taskmanager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.adil.taskmanager.tasks.Task;

/**
 * Created by Adil on 24-Sep-15.
 */
public class AddTaskActivity extends TaskManagerActivity {
    private EditText taskNameEditText;
    private Button addButton;
    private Button cancelButton;
    private Button takePictureButton;
    private boolean changesPending;
    private AlertDialog unsavedChangesDialog;
    Task t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_tasks);
        setUpViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void setUpViews() {
        taskNameEditText = (EditText) findViewById(R.id.task_name);
        addButton = (Button) findViewById(R.id.add_button);
        takePictureButton = (Button)findViewById(R.id.take_picture);
        cancelButton = (Button) findViewById(R.id.cancel_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addTask();
            }
        });
        takePictureButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                addPictureTask();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
        taskNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                changesPending = true;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void addPictureTask() {
        Intent intent = new Intent(AddTaskActivity.this,AddPictureTask.class);
        startActivity(intent);
    }

    private void addTask() {


            String taskName = taskNameEditText.getText().toString();
             t = new Task(taskName);
            getTaskManagerApplication().addTask(t);
            finish();


    }



    private void cancel(){

        if(changesPending) {
            unsavedChangesDialog = new AlertDialog.Builder(this)
                    .setTitle(R.string.unsaved_changes_title)
                    .setMessage(R.string.unsaved_changes_message)
                    .setPositiveButton(R.string.add_task, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            addTask();
                        }
                    })
                    .setNeutralButton(R.string.discard, new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            unsavedChangesDialog.cancel();
                        }
                    })
                    .create();
            unsavedChangesDialog.show();

        }
            else {
                finish();
            }

    }

}
