package com.redeyes.registration.config.jms;

import com.redeyes.registration.model.Email;
import org.springframework.jms.core.support.JmsGatewaySupport;

import java.util.Map;

/**
 * Custom jms receiver.
 */
public class JmsEmailConsumer extends JmsGatewaySupport {
    /**
     * Receive email message.
     *
     * @return Email message.
     */
    public final Email receiveMessage() {
        Map<String, String> map = (Map<String, String>) getJmsTemplate().receiveAndConvert();
        return new Email(map.get("recipient"), map.get("subject"), map.get("emailText"));
    }
}
