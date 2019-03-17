package com.fan.assistant.entity;

public class goal {
    private int goal_id,goal_userId;
    private String goal_name,goal_intro,goal_startTime,goal_endTime,goal_backImage,goal_mark,goal_state;

    public int getGoal_id() {
        return goal_id;
    }

    public void setGoal_id(int goal_id) {
        this.goal_id = goal_id;
    }

    public int getGoal_userId() {
        return goal_userId;
    }

    public void setGoal_userId(int goal_userId) {
        this.goal_userId = goal_userId;
    }

    public String getGoal_name() {
        return goal_name;
    }

    public void setGoal_name(String goal_name) {
        this.goal_name = goal_name;
    }

    public String getGoal_intro() {
        return goal_intro;
    }

    public void setGoal_intro(String goal_intro) {
        this.goal_intro = goal_intro;
    }

    public String getGoal_startTime() {
        return goal_startTime;
    }

    public void setGoal_startTime(String goal_startTime) {
        this.goal_startTime = goal_startTime;
    }

    public String getGoal_endTime() {
        return goal_endTime;
    }

    public void setGoal_endTime(String goal_endTime) {
        this.goal_endTime = goal_endTime;
    }

    public String getGoal_backImage() {
        return goal_backImage;
    }

    public void setGoal_backImage(String goal_backImage) {
        this.goal_backImage = goal_backImage;
    }

    public String getGoal_mark() {
        return goal_mark;
    }

    public void setGoal_mark(String goal_mark) {
        this.goal_mark = goal_mark;
    }

    public String getGoal_state() {
        return goal_state;
    }

    public void setGoal_state(String goal_state) {
        this.goal_state = goal_state;
    }
}
