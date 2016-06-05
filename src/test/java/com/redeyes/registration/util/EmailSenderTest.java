package com.redeyes.registration.util;

import com.redeyes.registration.RegistrationApplication;
import com.redeyes.registration.model.Email;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(RegistrationApplication.class)
@WebAppConfiguration
public class EmailSenderTest {

    @Test
    public void testSendConfirm() throws MessagingException {
        Email email = new Email("pupkin@gmail.com", "Confirm", "Confirm email!");
        EmailSender.sendConfirm(email);
    }

    @Test(expected = SendFailedException.class)
    public void testSendConfirmError() throws MessagingException {
        Email email = new Email("pupkingmail.com", "Confirm", "Confirm email!");
        EmailSender.sendConfirm(email);
    }
}