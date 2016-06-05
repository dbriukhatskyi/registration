package com.redeyes.registration.controller;

import com.redeyes.registration.model.User;
import com.redeyes.registration.model.UserTo;
import com.redeyes.registration.service.MessageService;
import com.redeyes.registration.service.UserService;
import com.redeyes.registration.util.UserValidationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
     * User service.
     */
    @Autowired
    private UserService service;

    /**
     * Message service.
     */
    @Autowired
    private MessageService messageService;

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
     * @param userTo        Registration user data.
     * @param bindingResult Result.
     * @param request       Servlet request.
     * @return Validation result.
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public final UserValidationResult post(@Valid final UserTo userTo,
                                           final BindingResult bindingResult, final HttpServletRequest request) {
        User user = userTo.asUser();
        service.saveUser(user);
        messageService.sendConfirmToUser(user, request);
        return new UserValidationResult(bindingResult);
    }

    /**
     * @param e DataAccessException.
     * @return Validation result.
     */
    @ExceptionHandler(DataAccessException.class)
    @ResponseBody
    public final UserValidationResult uniqueEmail(final DataAccessException e) {
        LOG.error("Repository error: {}", e.getMessage());
        return new UserValidationResult("User with this email is registered.");
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
