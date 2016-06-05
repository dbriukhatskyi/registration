package com.redeyes.registration.controller;

import com.redeyes.registration.RegistrationApplication;
import com.redeyes.registration.repository.UserRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Abstract contrpller test class.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(RegistrationApplication.class)
@WebAppConfiguration
public abstract class AbstractControllerTest {

    /**
     * User repository.
     */
    @Autowired
    protected UserRepository repository;

    /**
     * Registration controller.
     */
    @Autowired
    protected RegistrationController registrationController;

    /**
     * Confirm controller.
     */
    @Autowired
    protected ConfirmController confirmController;

    /**
     * Web application context.
     */
    @Autowired
    private WebApplicationContext context;

    /**
     * Mock mvc.
     */
    protected MockMvc mockMvc;

    /**
     * Run before each test.
     */
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }
}
