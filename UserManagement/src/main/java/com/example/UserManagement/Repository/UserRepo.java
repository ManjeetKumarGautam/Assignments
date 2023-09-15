package com.example.UserManagement.Repository;

import com.example.UserManagement.DataBase.User;
import com.example.UserManagement.DataBase.UserDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
public class UserRepo {

    @Autowired
    private List<User> userList;

    public List<User> getUser(){
        return userList;
    }
}
