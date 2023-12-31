package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {

        SpringApplication.run(Main.class, args);

        StudentAPI stu=new StudentAPI();// for fetch data from student
        String str=stu.getData();

        Email em=new Email(); // send to email
        em.sendMail(str);
    }
}