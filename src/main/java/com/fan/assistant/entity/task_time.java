package com.fan.assistant.entity;

public class task_time {
    private int time_id,task_id;
    private String task_startTime,endTime;

    public int getTime_id() {
        return time_id;
    }

    public void setTime_id(int time_id) {
        this.time_id = time_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTask_startTime() {
        return task_startTime;
    }

    public void setTask_startTime(String task_startTime) {
        this.task_startTime = task_startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
