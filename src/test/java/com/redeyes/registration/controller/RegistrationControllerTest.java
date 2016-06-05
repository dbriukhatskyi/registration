package com.redeyes.registration.controller;

import org.junit.Test;

import static com.redeyes.registration.controller.RegistrationController.REGISTRATION_URI;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
        mockMvc.perform(post(REGISTRATION_URI)
                .param("email", "user@gmail.com")
                .param("password", "12345"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUniqueEmail() throws Exception {
        mockMvc.perform(post(REGISTRATION_URI)
                .param("email", "user@gmail.com")
                .param("password", "12345"));
    }

    @Test
    public void testPostEmptyUser() throws Exception {
        mockMvc.perform(post(REGISTRATION_URI)
                .param("email", "")
                .param("password", ""));
    }

    @Test
    public void testPostInvalidEmail() throws Exception {
        mockMvc.perform(post(REGISTRATION_URI)
                .param("email", "usergmail.com")
                .param("password", "12345"))
                .andExpect(status().isOk());
    }
}