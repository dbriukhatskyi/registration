package com.redeyes.registration.web;

import com.redeyes.registration.model.UserTo;
import com.redeyes.registration.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
    private static final Logger LOG = LoggerFactory.getLogger(RestController.class);

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.POST)
    public void getUser(UserTo user) {
        LOG.info("Rest. Save user");
        service.saveUser(user.asUser());
    }
}
