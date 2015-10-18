package com.example.adil.taskmanager.tasks;



/**
 * Created by Adil on 24-Sep-15.
 */
public class Task {
    private String name;
    private boolean complete = false;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }

    public Task(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public void toggleComplete() {
        complete = !complete;
    }
}
