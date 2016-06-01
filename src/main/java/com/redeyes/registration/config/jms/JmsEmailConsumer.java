package com.redeyes.registration.config.jms;

import com.redeyes.registration.model.Email;
import org.springframework.jms.core.support.JmsGatewaySupport;

import java.util.Map;

public class JmsEmailConsumer extends JmsGatewaySupport {
    public Email receiveMessage() {
        Map<String, String> map = (Map<String, String>) getJmsTemplate().receiveAndConvert();
        return new Email(map.get("recipient"), map.get("subject"), map.get("emailText"));
    }
}
