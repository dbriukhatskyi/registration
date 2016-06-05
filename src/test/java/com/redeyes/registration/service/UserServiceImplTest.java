package com.redeyes.registration.service;

import com.redeyes.registration.RegistrationApplication;
import com.redeyes.registration.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RegistrationApplication.class)
@WebAppConfiguration
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    private static String email = "admin@gmail.com";

    @Test
    public void testSaveUser() {
        userService.saveUser(new User(email, "password"));
    }

    @Test
    public void testConfirm() {
        userService.confirm(email);
    }

}