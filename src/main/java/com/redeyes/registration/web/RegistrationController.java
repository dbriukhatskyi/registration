package com.redeyes.registration.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView home() {
        LOGGER.info("IN GET");
        return new ModelAndView("registration");
    }
}
