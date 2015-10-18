package com.example.adil.taskmanager.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.adil.taskmanager.R;
import com.example.adil.taskmanager.tasks.Task;
import com.example.adil.taskmanager.views.TaskListItem;


import java.util.ArrayList;

/**
 * Created by Adil on 25-Sep-15.
 */
public class TaskListAdapter extends BaseAdapter {

    private ArrayList<Task> tasks;
    private Context context;

    public TaskListAdapter(ArrayList<Task> tasks, Context context) {
        this.tasks = tasks;
        this.context = context;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Task getItem(int position) {
        return (tasks == null) ? null : tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TaskListItem tli;
        if(convertView == null){
            tli = (TaskListItem)View.inflate(context, R.layout.task_list_item,null);
        }
        else{
            tli = (TaskListItem)convertView;
        }
        tli.setTask(tasks.get(position));
        return tli;
    }

    public void forceReload() {
        notifyDataSetChanged();
    }

    public void toggleTaskCompleteAtPosition(int position) {
        Task t = tasks.get(position);
        t.toggleComplete();
        notifyDataSetChanged();
    }

    public Long[] removeCompletedTasks() {
        ArrayList<Task> completedTasks = new ArrayList<Task>();
        ArrayList<Long> completedIds = new ArrayList<Long>();
        for(Task t : tasks){
            if(t.isComplete()){
                completedIds.add(t.getId());
                completedTasks.add(t);

            }
        }
        tasks.removeAll(completedTasks);
        notifyDataSetChanged();

        return completedIds.toArray(new Long[]{});
    }

    }
