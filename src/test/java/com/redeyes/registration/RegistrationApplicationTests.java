package com.redeyes.registration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RegistrationApplication.class)
@WebAppConfiguration
public class RegistrationApplicationTests {

    /**
     * Test spring context load.
     */
    @Test
    public void contextLoads() {
        //NOP
    }

}
