package com.redeyes.registration.config.jms;

import com.redeyes.registration.model.Email;
import com.redeyes.registration.util.EmailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

import static com.redeyes.registration.config.JmsConfig.JMS_QUEUE;

/**
 * Custom jms listener.
 */
@Component
public class JmsEmailListener {
    private static final Logger LOG = LoggerFactory.getLogger(JmsEmailListener.class);

    /**
     * Receive email message and send to user.
     */
    @JmsListener(destination = JMS_QUEUE, containerFactory = "factory")
    public void receiveEmail(Email email) {
        LOG.info("Email received.");
        try {
            EmailSender.sendConfirm(email);
            LOG.info("Email send.");
        } catch (MessagingException e) {
            LOG.info("Send email error: {}", e);
        }
    }

}
