package com.example.UserManagement.DataBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userId;
    private String name;

//    public Integer getUserId() {
//        return userId;
//    }

    private String userName;
    private String address;
    private String phoneNumber;


}
