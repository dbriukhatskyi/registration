package com.redeyes.registration.service;

import com.redeyes.registration.model.User;

/**
 * User service.
 */
public interface UserService {
    /**
     * Save user to repository.
     *
     * @param user User for save.
     */
    void saveUser(final User user);

    /**
     * Confirm user.
     *
     * @param email User email.
     */
    void confirm(final String email);
}
