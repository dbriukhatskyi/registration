package com.redeyes.registration.util;

import com.redeyes.registration.model.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {
    private static final Logger LOG = LoggerFactory.getLogger(EmailSender.class);

    private EmailSender() {
    }

    public static void sendConfirm(Email email) throws MessagingException {
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

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject(email.getSubject());
        message.setContent(email.getEmailText(), "text/html");
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(email.getRecipient()));

        LOG.info("Email send to {}", email.getRecipient());

        Transport transport = mailSession.getTransport();
        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();
        LOG.info("Message send.");
    }
}
