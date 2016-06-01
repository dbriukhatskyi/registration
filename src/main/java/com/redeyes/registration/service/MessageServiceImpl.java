package com.redeyes.registration.service;

import com.redeyes.registration.config.jms.JmsEmailConsumer;
import com.redeyes.registration.config.jms.JmsEmailProduser;
import com.redeyes.registration.model.User;
import com.redeyes.registration.util.EmailConstructor;
import com.redeyes.registration.util.EmailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class MessageServiceImpl implements MessageService {
    private static final Logger LOG = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired
    private JmsEmailProduser emailProduser;

    @Autowired
    private JmsEmailConsumer emailConsumer;

    @Override
    public void sendConfirmToUser(User user) {
        emailProduser.sendEmail(EmailConstructor.createForUser(user));
        LOG.info("Message send to queue.");
        try {
            LOG.info("Receive message..");
            EmailSender.sendConfirm(emailConsumer.receiveMessage());
        } catch (MessagingException e) {
            LOG.info("Email send error: {}", e);
        }

    }
}
