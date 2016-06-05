package com.redeyes.registration.config.jms;

import com.redeyes.registration.RegistrationApplication;
import com.redeyes.registration.model.Email;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Email send tests.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RegistrationApplication.class)
@WebAppConfiguration
public class JmsEmailProduserTest {

    /**
     * Custom email produser.
     */
    @Autowired
    private JmsEmailProduser emailProduser;

    /**
     * Send email.
     */
    @Test
    public void testSendEmail() {
        Email email = new Email("pupkin@gmail.com", "Confirm!", "Confirm email.");
        emailProduser.sendEmail(email);
    }

    /**
     * Test error email.
     */
    @Test
    public void testSendEmailError() {
        Email email = new Email("pupkingmail.com", "Confirm!", "Confirm email.");
        emailProduser.sendEmail(email);
    }
}