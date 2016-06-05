package com.redeyes.registration.repository;

import com.redeyes.registration.RegistrationApplication;
import com.redeyes.registration.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RegistrationApplication.class)
@WebAppConfiguration
public class UserRepositoryImplTest {

    @Autowired
    private UserRepository repository;

    private static String email = "mike@gmail.com";

    @Test
    public void testSave() {
        User user = new User(email, "pass");
        repository.save(user);
    }

    @Test
    public void testGetByEmail() {
        User user = new User(email, "pass");
        assertEquals(user, repository.getByEmail(email));
    }

    @Test(expected = DuplicateKeyException.class)
    public void testSaveSameEmail() {
        repository.save(new User(email, "qwerty"));
    }

    @Test
    public void testConfirm() {
        String email = "tim@gmail.com";
        User user = new User(email, "qwerty");
        repository.save(user);
        repository.confirm(email);
    }

}