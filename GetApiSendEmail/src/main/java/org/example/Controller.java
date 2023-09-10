package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
public class Controller {
    @Autowired // look for student bean
    private Student student;

//    @Autowired // look for email bean
//    private Email email;

//    @Autowired
//    private StudentAPI studentAPI;
    @GetMapping("/student")
    public Student getStudent() throws IOException {
        this.student.setId(12341);
        this.student.setStudent_Name("Manjeet");
        this.student.setPhoneNo("89123245670");
        this.student.setAddress("Lucknow");
        this.student.setEmail_id("manjeetkumar1572000@gmail.com");

//        String str=this.studentAPI.getData();
        // to call sendMail of Email Class
//        this.email.sendMail(str);

        return  this.student;
    }

}
