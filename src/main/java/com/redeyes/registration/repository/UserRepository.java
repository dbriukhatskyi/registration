package com.redeyes.registration.repository;

import com.redeyes.registration.model.User;

/**
 * User repository.
 */
public interface UserRepository {
    /**
     * Save user to repository.
     * @param user User for save.
     * @return int.
     */
    int save(final User user);

    /**
     * Find user by email.
     * @param email Email for search.
     * @return User from repository.
     */
    User getByEmail(final String email);

    /**
     * Confirm user.
     * @param email Email to confirm user.
     */
    void confirm(final String email);
}
