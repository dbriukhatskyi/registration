package com.redeyes.registration.web;

import com.redeyes.registration.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
    private static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private UserService service;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView home() {
        LOG.info("Return main view.");
        return new ModelAndView("registration");
    }

    @RequestMapping(value = "/confirm/{code:.*}", method = RequestMethod.GET)
    public String success(@PathVariable String code) {
        String[] params = new String(Base64Utils.decodeFromString(code)).split(":");
        service.confirm(params[0]);
        return "redirect:/success";
    }

    @RequestMapping("/success")
    public ModelAndView success() {
        return new ModelAndView("success");
    }
}
