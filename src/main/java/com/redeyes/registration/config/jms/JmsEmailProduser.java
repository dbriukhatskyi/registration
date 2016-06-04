package com.redeyes.registration.config.jms;

import com.redeyes.registration.model.Email;
import org.springframework.jms.core.support.JmsGatewaySupport;

/**
 * Custom jms message sender.
 */
public class JmsEmailProduser extends JmsGatewaySupport {
    /**
     * Send email to activeMQ.
     *
     * @param email Email to send.
     */
    public final void sendEmail(final Email email) {
        getJmsTemplate().convertAndSend(email);
    }
}
