package com.redeyes.registration.config.jms;

import com.redeyes.registration.model.Email;
import org.springframework.jms.core.support.JmsGatewaySupport;

import java.util.HashMap;
import java.util.Map;

public class JmsEmailProduser extends JmsGatewaySupport {
    public void sendEmail(final Email email) {
        Map<String, String> map = new HashMap<>();
        map.put("recipient", email.getRecipient());
        map.put("subject", email.getSubject());
        map.put("emailText", email.getEmailText());
        getJmsTemplate().convertAndSend(map);
    }
}
