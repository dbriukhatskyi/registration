package com.redeyes.registration.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.redeyes.registration.model.User;
import com.redeyes.registration.model.UserValidationResult;



/**
 * Registration service controller.
 *
 * @author Dmytro Briukhatskyi
 * @author Oleksandr Dres
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {
    /**
     * Logger for photo controller.
     */
    private static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);

    /**
     * Returns main screen with a prompt to pick a directory.
     *
     * @return View with form
     */
    @RequestMapping(method = RequestMethod.GET)
    public final ModelAndView home() {
        LOG.debug("Returning initial view.");
        return getModelAndView();
    }

    /**
     *
     * @param bindingResult
     *        model
     *
     * @param user
     *        user registration data
     *
     * @return ajax
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public final UserValidationResult post(@ModelAttribute @Valid final User user,
            final BindingResult bindingResult) {
        LOG.info("email: '{}', password: '{}'", user.getEmail(), user.getPassword());
        return new UserValidationResult(bindingResult);
    }

    /**
     *
     * @param hash
     *        a hash to verify
     *
     * @return view
     */
    @RequestMapping(value = "/confirm/{hash:[A-Za-z0-9]+}", method = RequestMethod.GET)
    public final ModelAndView confirm(@PathVariable final String hash) {
        ModelAndView model = getModelAndView();
        model.addObject("data", hash);
        return model;
    }

    /**
     * Creates a ModelAndView instance with default parameters.
     *
     * @return default ModelAndView instance
     */
    private ModelAndView getModelAndView() {
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("data", new User());
        return modelAndView;
    }
}
