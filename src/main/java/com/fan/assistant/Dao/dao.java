package com.fan.assistant.Dao;

import com.fan.assistant.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class dao {
    mapper mapper;
    @Autowired
    public dao(mapper mapper) {
        this.mapper = mapper;
    }


    public User isExist(String user_name) {
        return mapper.isExist(user_name);
    }



    public User login(String user_name, String user_pass) {
        return mapper.login(user_name,user_pass);
    }

    public void UpdatePassword(String user_name, String new_pass) {
        mapper.UpdatePassword(user_name,new_pass);
    }

    public User getQuestion(String user_name) {
        return mapper.getQuestion( user_name);
    }
}
