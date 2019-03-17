package com.fan.assistant.Dao;

import com.fan.assistant.entity.User;
import com.fan.assistant.entity.goal;
import com.fan.assistant.entity.task;
import com.fan.assistant.entity.task_time;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface mapper {


    User isExist(String user_name);

    void regin(User user);

    User login(String user_name, String user_pass);

    void UpdatePassword(String user_name, String new_pass);

    User getQuestion(String user_name);

    void addGoal(goal goal);

    ArrayList<HashMap> getGoals(String user_id);

    void deleteGoal(String goal_id);

    void addTask(task task);

    ArrayList<HashMap> getTasks(String goal_id);

    void deleteTask(String task_id);

    void addTask_Time(task_time taskTime);

    ArrayList<HashMap> getTask_Time(String task_id);

    void deleteTask_Time(String time_id);
}
