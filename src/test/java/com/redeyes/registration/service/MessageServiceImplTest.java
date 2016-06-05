package com.redeyes.registration.service;

import com.redeyes.registration.RegistrationApplication;
import com.redeyes.registration.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.servlet.http.HttpServletRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RegistrationApplication.class)
@WebAppConfiguration
public class MessageServiceImplTest {

    @Autowired
    private MessageService messageService;

    @Autowired
    private HttpServletRequest request;

    @Test
    public void testSendConfirmToUser() {
        messageService.sendConfirmToUser(new User("grigory.leps@gmail.com", "pass"), request);
    }

}