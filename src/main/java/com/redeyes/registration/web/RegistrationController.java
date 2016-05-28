package com.redeyes.registration.web;

import com.redeyes.registration.model.User;
import com.redeyes.registration.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private UserRepository repository;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView home() {
        LOGGER.info("IN GET");
        return new ModelAndView("registration");
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam String email, @RequestParam String password) {
        LOGGER.info("IN POST");
        ModelAndView modelAndView = new ModelAndView("registration");
        User user = new User(email, password);
        repository.save(user);
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
