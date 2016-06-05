package com.redeyes.registration.controller;

import com.redeyes.registration.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Confirm controller.
 */
@Controller
public class ConfirmController {
    /**
     * Confirm URI.
     */
    public static final String CONFIRM_URI = "/confirm";

    /**
     * Logger for ConfirmController class.
     */
    private static final Logger LOG = LoggerFactory.getLogger(ConfirmController.class);

    /**
     * User service.
     */
    @Autowired
    private UserService service;

    /**
     * @param confirmCode Encode code to confirm user.
     * @return Confirmation success view.
     */
    @RequestMapping(value = CONFIRM_URI + "/{confirmCode:.*}", method = RequestMethod.GET)
    public final String success(@PathVariable final String confirmCode) {
        String[] params = new String(Base64Utils.decodeFromString(confirmCode)).split(":");
        service.confirm(params[0]);
        return "redirect:/success";
    }

    /**
     * @return Confirmation success view.
     */
    @RequestMapping("/success")
    public final ModelAndView success() {
        return new ModelAndView("success");
    }

    /**
     * @param e Confirm exception.
     * @return Error information.
     */
    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseBody
    public final String confirmError(final EmptyResultDataAccessException e) {
        LOG.error("Error confirm user: {}", e.getMessage());
        return "<h2>Incorrect URL, to activate a user, enter the correct link</h2>";
    }
}
