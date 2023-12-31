package com.example.UserManagement.Services;

import com.example.UserManagement.DataBase.User;
import com.example.UserManagement.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UserService {

    @Autowired
    UserRepo userRepo;

    // add new user......
    public String addUser(User newUser){
        userRepo.getUser().add(newUser);
        return "New user added";
    }
    // add multiple users....
    public String addUsers(List<User> newUserList){
        for(User user:newUserList){
            userRepo.getUser().add(user);
        }
        return "New users added";
    }

    // get all user.......
    public List<User> getAllUser(){
        return userRepo.getUser();
    }

    // get user by id......
    public List<User> getUserById(Integer Id){
        List<User> filterUser=new ArrayList<>();

        for(User u: getAllUser()){
            if(u.getUserId().equals(Id)){
                filterUser.add(u);
            }
        }
        return  filterUser;
    }

    // update info of user
    public String updateUserInfo(Integer Id, String str,String val){

        for(User u: getAllUser()){
            if(u.getUserId().equals(Id)) {
                if (str.equals("id")) {
                    u.setUserId(Integer.parseInt(val));
                    return  "User "+Id+" id udated...";
                } else if (str.equals("name")) {
                    u.setName(val);
                    return  "User "+Id+" name udated...";
                } else if (str.equals("userName")) {
                    u.setUserName(val);
                    return  "User "+Id+" user name udated...";
                } else if (str.equals("address")) {
                    u.setAddress(val);
                } else if (str.equals("phoneNumber")) {
                    u.setPhoneNumber(val);
                    return  "User "+Id+" phone number udated...";
                }

            }

        }
        return  "Invalid id";
    }

    // delete user by id
    public String deleteUser(Integer id){
        for(User u: getAllUser()){
            if(u.getUserId().equals(id)){
                getAllUser().remove(u);
                return "User deleted..";
            }
        }
        return "Invalid id..";
    }
}
