package com.example.UserManagement.Repository;

import com.example.UserManagement.DataBase.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserRepo {

    @Autowired
    private List<User> userList;

    public List<User> getUser(){
        return userList;
    }
}
