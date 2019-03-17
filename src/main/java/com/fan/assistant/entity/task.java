package com.fan.assistant.entity;

public class task {
    private int task_id,goal_id;
    private String task_name;
    private String task_intro;
    private String goal_name;
    private String task_repeat;

    public String getTask_startTime() {
        return task_startTime;
    }

    public void setTask_startTime(String task_startTime) {
        this.task_startTime = task_startTime;
    }

    public String getTask_endTime() {
        return task_endTime;
    }

    public void setTask_endTime(String task_endTime) {
        this.task_endTime = task_endTime;
    }

    private String task_startTime;
    private String task_endTime;

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getGoal_id() {
        return goal_id;
    }

    public void setGoal_id(int goal_id) {
        this.goal_id = goal_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_intro() {
        return task_intro;
    }

    public void setTask_intro(String task_intro) {
        this.task_intro = task_intro;
    }

    public String getGoal_name() {
        return goal_name;
    }

    public void setGoal_name(String goal_name) {
        this.goal_name = goal_name;
    }

    public String getTask_repeat() {
        return task_repeat;
    }

    public void setTask_repeat(String task_repeat) {
        this.task_repeat = task_repeat;
    }
}
