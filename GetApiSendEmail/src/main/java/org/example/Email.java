package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

//@Component
public class Email {

    public void sendMail(String  str) throws IOException {

        System.out.println("preparing to send e-mail...");

        String subject="Send object : Created by Manjeet";
        String to="manjeetkumar1572000@gmail.com";

        Properties properties= System.getProperties();

        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");


        Session session= Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("kumar2020manjeet@gmail.com","******");// use your email and password
            }
        });
        session.setDebug(true);

        MimeMessage mm = new MimeMessage(session);

        try {
            mm.setFrom("kumar2020manjeet@gmail.com"); // to set from
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); // to set TO
            mm.setSubject(subject);// set subject

            mm.setText(str); // set message

            // send message using transport class
            Transport.send(mm);

            System.out.println("Message send Successfull...");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


    }
}
