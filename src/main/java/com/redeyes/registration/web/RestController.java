package com.redeyes.registration.web;

import com.redeyes.registration.model.User;
import com.redeyes.registration.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
    Logger logger = LoggerFactory.getLogger(RestController.class);
    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.POST)
    public void getUser(@Valid User user) {
        logger.info("Rest save!.");
        service.saveUser(user);
    }
}
