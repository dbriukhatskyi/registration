package com.redeyes.registration.service;

import com.redeyes.registration.config.jms.JmsEmailProducer;
import com.redeyes.registration.model.User;
import com.redeyes.registration.util.EmailBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Message service implementation.
 */
@Service
public class MessageServiceImpl implements MessageService {
    /**
     * Logger for message service.
     */
    private static final Logger LOG = LoggerFactory.getLogger(MessageServiceImpl.class);

    /**
     * Email constructor.
     */
    @Autowired
    private EmailBuilder constructor;
    /**
     * Custom message sender.
     */
    @Autowired
    private JmsEmailProducer emailProduser;

    @Override
    public final void sendConfirmToUser(final User user, final HttpServletRequest request) {
        LOG.info("Send email to JMS broker.");
        emailProduser.sendEmail(constructor.createForUser(user, request));
    }
}
