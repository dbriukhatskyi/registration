package com.redeyes.registration.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;


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
        return new ModelAndView("registration", "start", true);
    }

    /**
     *
     *
     * @param path
     *        path to a local directory with photos
     *
     * @return view
     */
    @RequestMapping(method = RequestMethod.POST)
    public final ModelAndView post(@RequestParam final String path) {
        ModelAndView model = getModelAndView();

        return model;
    }

    /**
    *
    * @param email
    *        e-mail to register
    *
    * @param password
    *        user password
    *
    * @return view
    */
   @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
   @ResponseBody
   public final Map<String, String> create(@RequestParam final String email, @RequestParam final String password) {
       Map<String, String> result = new HashMap<>();
       result.put("email", email);
       result.put("password", password);
       return result;
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
        return modelAndView;
    }
}
