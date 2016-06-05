package com.redeyes.registration.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * User model tests.
 */
public class UserTest {
    /**
     * Equals tests.
     */
    @Test
    public void testEquals() {
        User admin = new User("admin@gmail.com", "123");
        User confirmAdmin = new User("admin@gmail.com", "123", true);
        User fakeAdmin = new User("admin@gmail.com", "qwerty");
        User user = new User("user@gmail.com", "qwerty");

        assertFalse(admin.equals(confirmAdmin));
        assertFalse(admin.equals(fakeAdmin));
        assertFalse(admin.equals(user));
    }

}