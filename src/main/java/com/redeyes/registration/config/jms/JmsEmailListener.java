package com.redeyes.registration.config.jms;

import com.redeyes.registration.model.Email;
import com.redeyes.registration.util.EmailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

import static com.redeyes.registration.config.JmsConfig.EMAIL_QUEUE_NAME;

/**
 * Custom jms listener.
 */
@Component
public class JmsEmailListener {
    /**
     * Logger for jms listener.
     */
    private static final Logger LOG = LoggerFactory.getLogger(JmsEmailListener.class);

    /**
     * Receive email message and send to user.
     *
     * @param email Email to send confirm.
     */
    @JmsListener(destination = EMAIL_QUEUE_NAME, containerFactory = "factory")
    public final void receiveEmail(final Email email) {
        try {
            EmailSender.sendConfirm(email);
        } catch (MessagingException e) {
            LOG.info("Send email error: {}", e);
        }
    }

}
