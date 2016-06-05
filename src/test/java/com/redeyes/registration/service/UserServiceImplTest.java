package com.redeyes.registration.service;

import com.redeyes.registration.RegistrationApplication;
import com.redeyes.registration.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * User service tests.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RegistrationApplication.class)
@WebAppConfiguration
public class UserServiceImplTest {

    /**
     * User service.
     */
    @Autowired
    private UserService userService;

    /**
     * User email.
     */
    private static String email = "admin@gmail.com";

    /**
     * Test save user.
     */
    @Test
    public void testSaveUser() {
        userService.saveUser(new User(email, "password"));
    }

    /**
     * Test confirm user.
     */
    @Test
    public void testConfirm() {
        userService.confirm(email);
    }

}