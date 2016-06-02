package com.redeyes.registration.service;

import com.redeyes.registration.config.jms.JmsEmailProduser;
import com.redeyes.registration.model.User;
import com.redeyes.registration.util.EmailConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * Custom message sender.
     */
    @Autowired
    private JmsEmailProduser emailProduser;

    @Override
    public final void sendConfirmToUser(final User user) {
        LOG.info("Send email to activeMQ.");
        emailProduser.sendEmail(EmailConstructor.createForUser(user));
    }
}
