package com.redeyes.registration.service;

import com.redeyes.registration.model.User;

public interface UserService {
    void saveUser(User user);

    void confirm(String email);
}
