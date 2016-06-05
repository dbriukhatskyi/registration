package com.redeyes.registration.controller;

import com.redeyes.registration.model.User;
import org.junit.Test;

import static com.redeyes.registration.controller.ConfirmController.CONFIRM_URI;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class ConfirmControllerTest extends AbstractControllerTest {

    @Test
    public void testSuccess() throws Exception {
        repository.save(new User("pupkin@gmail.com", "12345"));
        mockMvc.perform(get(CONFIRM_URI + "/cHVwa2luQGdtYWlsLmNvbToxMjM0NQ=="))
                .andExpect(redirectedUrl("/success"));
    }

    @Test
    public void testView() throws Exception {
        mockMvc.perform(get("/success"))
                .andExpect(view().name("success"))
                .andExpect(status().isOk());
    }

    @Test
    public void testConfirmError() throws Exception {
        mockMvc.perform(get(CONFIRM_URI + "/dmFzeWFwdXBraW5AZ21haWwuY29tOnF3ZXJ0eQ=="));
    }
}