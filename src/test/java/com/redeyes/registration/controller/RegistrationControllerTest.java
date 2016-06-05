package com.redeyes.registration.controller;

import com.redeyes.registration.model.UserTo;
import org.junit.Test;

import static com.redeyes.registration.controller.RegistrationController.REGISTRATION_URI;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class RegistrationControllerTest extends AbstractControllerTest {

    @Test
    public void testHome() throws Exception {
        mockMvc.perform(get(REGISTRATION_URI))
                .andExpect(status().isOk())
                .andExpect(view().name("registration"));
    }

    @Test
    public void testPost() throws Exception {
        UserTo userTo = new UserTo();
        userTo.setEmail("user@gmail.com");
        userTo.setPassword("12345");

//        mockMvc.perform(post(REGISTRATION_URI, userTo));
    }

    @Test
    public void testUniqueEmail() {

    }

}