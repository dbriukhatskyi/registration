package com.redeyes.registration.util;

import com.redeyes.registration.model.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Email sender.
 */
public final class EmailSender {
    /**
     * Logger for email sender.
     */
    private static final Logger LOG = LoggerFactory.getLogger(EmailSender.class);
    /**
     * Mail session.
     */
    private static Session mailSession = getMailSession();

    /**
     * Non.. constructor.
     */
    private EmailSender() {
    }

    /**
     * Sending confir email.
     *
     * @param email User email.
     * @throws MessagingException Messaging Exception.
     */
    public static void sendConfirm(final Email email) throws MessagingException {

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject(email.getSubject());
        message.setContent(email.getEmailText(), "text/html");
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getRecipient()));

        LOG.info("Email send to {} ...", email.getRecipient());

        Transport transport = mailSession.getTransport();
        transport.connect();
        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        transport.close();
        LOG.info("Email send success.");
    }

    /**
     * Returned mail session with default configuration.
     *
     * @return Mail session.
     */
    private static Session getMailSession() {
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.port", "587");

        return Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("red.eyes.developers@gmail.com", "redeyes2");
                    }
                });
    }
}
