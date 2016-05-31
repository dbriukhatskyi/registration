package com.redeyes.registration.util;

import com.redeyes.registration.model.User;
import org.springframework.util.Base64Utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {
    private EmailSender() {
    }

    public static void sendConfirm(User user) throws MessagingException {
        String link =  "http://localhost:8080/confirm/" +
                Base64Utils.encodeToString((user.getEmail() + ":" + user.getPassword()).getBytes());

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.port", "587");

        Session mailSession = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("red.eyes.developers@gmail.com", "redeyes2");
                    }
                });
        Transport transport = mailSession.getTransport();

        char[] chars = user.getPassword().toCharArray();
        for (int i = 0; i < chars.length-2; i++) {
            chars[i] = '*';
        }
        String passStar = new String(chars);

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("Confirm your email.");
        message.setContent("<h1>Thank you for registration.</h1><br>" +
                "You have succesfully created account on our site.<br>" +
                "You email is " + user.getEmail() + " and you pass ends on " + passStar + "<br><br>" +
                "To confirm your account please click on this link<br>" +
                link, "text/html");
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(user.getEmail()));

        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();
    }
}
