package com.redeyes.registration.web;

import com.redeyes.registration.model.User;
import com.redeyes.registration.model.UserTo;
import com.redeyes.registration.service.MessageService;
import com.redeyes.registration.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Rest controller.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
    /**
     * Logger for controller.
     */
    private static final Logger LOG = LoggerFactory.getLogger(RestController.class);

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
     * Saving user.
     *
     * @param userTo User for save.
     */
    @RequestMapping(method = RequestMethod.POST)
    public final void saveUser(final UserTo userTo) {
        LOG.info("Rest. Save user");
        User user = userTo.asUser();
        service.saveUser(user);
        messageService.sendConfirmToUser(user);
    }
}
