package com.example.adil.taskmanager;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.adil.taskmanager.adapter.TaskListAdapter;
import com.example.adil.taskmanager.tasks.Task;


public class viewTasksActivity extends ListActivity {

    private Button addButton;
    private TaskManagerApplication app;
    private TaskListAdapter adapter;
    private Button removeButton;
    private Button editButton;
    private Button pictureButton;
    Task t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tasks);
        setUpViews();

        app = (TaskManagerApplication) getApplication();
        adapter = new TaskListAdapter(app.getCurrentTasks(), this);
        setListAdapter(adapter);
    }

        protected void onResume(){
        super.onResume();
            editButton.setEnabled(false);
        //showTasks();
            adapter.forceReload();
    }

    @Override
    protected void onPause() {
        super.onPause();
        adapter.forceReload();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        editButton.setEnabled(true);
        adapter.toggleTaskCompleteAtPosition(position);
        t = adapter.getItem(position);
        app.saveTask(t); //Saves the checked instance of the field
    }


   /* private void showTasks(){
        ArrayList<Task> tasks = getTaskManagerApplication().getCurrentTasks();

    }*/
    private void setUpViews() {
        addButton = (Button)findViewById(R.id.add_button);
        removeButton = (Button)findViewById(R.id.remove_button);
        editButton = (Button)findViewById(R.id.edit_button);
        pictureButton = (Button)findViewById(R.id.take_picture);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewTasksActivity.this, AddTaskActivity.class);
                startActivity(intent);

            }
        });
        pictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeCompletedTasks();

            }
        });
        editButton.setEnabled(false);
        editButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                editSelectedTask();
                //app.updateTask(t.getId(),t.getName());
            }
        });

    }

    private void editSelectedTask() {

        //app.updateTask(t.getId(),t.getName());

       // app.deleteTasks(ids);

       Intent intent = new Intent(viewTasksActivity.this,EditTasksActivity.class);
        intent.putExtra("Task_id_view",t.getId());
        intent.putExtra("Task_name_view", t.getName());
        removeCompletedTasks();
        startActivity(intent);

       // app.updateTask(t.getId(),getIntent().getExtras().getString("Task_name"));
    }

    protected void removeCompletedTasks() {
        Long[] ids = adapter.removeCompletedTasks();
        app.deleteTasks(ids);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_tasks, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
