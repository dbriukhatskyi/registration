package com.redeyes.registration.service;

import com.redeyes.registration.model.User;
import com.redeyes.registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User service implementation.
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * User repository.
     */
    @Autowired
    private UserRepository repository;

    @Override
    public final void saveUser(final User user) {
        repository.save(user);
    }

    @Override
    public final void confirm(final String email) {
        repository.confirm(email);
    }
}
