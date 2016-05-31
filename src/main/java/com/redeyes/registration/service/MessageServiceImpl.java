package com.redeyes.registration.service;

import com.redeyes.registration.model.User;
import com.redeyes.registration.util.EmailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class MessageServiceImpl implements MessageService {
    private static final Logger LOG = LoggerFactory.getLogger(MessageServiceImpl.class);
    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendConfirmToUser(User user) {
        jmsTemplate.convertAndSend(user.getEmail() + " : " + user.getPassword());
        try {
            EmailSender.sendConfirm(user);
        } catch (MessagingException e) {
            LOG.error("Email send error: ", e);
        }
        LOG.info("Message send.");
    }
}
