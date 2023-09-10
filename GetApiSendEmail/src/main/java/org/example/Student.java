package org.example;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
public class Student {
    private long id;
    private String student_Name;
    private String address;
    private String phoneNo;
    private String email_id;

    public Student(long id, String student_Name, String address, String phoneNo, String email_id) {
        this.id = id;
        this.student_Name = student_Name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email_id = email_id;
    }

    public Student() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudent_Name() {
        return student_Name;
    }

    public void setStudent_Name(String student_Name) {
        this.student_Name = student_Name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }
}
