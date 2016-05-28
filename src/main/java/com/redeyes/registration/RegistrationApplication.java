package com.redeyes.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/***
 * Entry point for Registration Service.
 *
 * @author Oleksandr Dres
 * @author Dmytro Briukhatskyi
 */
@SpringBootApplication
@ComponentScan
public class RegistrationApplication {
    /**
     * An entry point for application.
     *
     * @param args
     *        command-line arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(RegistrationApplication.class, args);
    }
}
