package com.redeyes.registration.service;

import com.redeyes.registration.model.User;
import com.redeyes.registration.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository repository;

    @Override
    public void saveUser(User user) {
        repository.save(user);
    }

    @Override
    public void confirm(String email) {
        repository.confirm(email);
    }
}
