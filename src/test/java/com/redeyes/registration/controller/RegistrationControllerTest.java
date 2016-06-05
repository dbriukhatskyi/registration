package com.redeyes.registration.controller;

import com.redeyes.registration.model.RegistrationForm;
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
        RegistrationForm formData = new RegistrationForm();
        formData.setEmail("user@gmail.com");
        formData.setPassword("12345");

//        mockMvc.perform(post(REGISTRATION_URI, userTo));
    }

    @Test
    public void testUniqueEmail() {

    }

}