package com.fan.assistant.Service;

import com.fan.assistant.Dao.dao;
import com.fan.assistant.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class service {
    dao dao;
    @Autowired
    public service(dao dao) {
        this.dao = dao;
    }


    public boolean isExist(String user_name) {
        return dao.isExist(user_name) == null;
    }



    public User login(String user_name, String user_pass) {
        return dao.login(user_name,user_pass);
    }

    public void UpdatePassword(String user_name, String new_pass) {
        dao.UpdatePassword(user_name,new_pass);
    }

    public User getQuestion(String user_name) {
        return dao.getQuestion(user_name);
    }
}
