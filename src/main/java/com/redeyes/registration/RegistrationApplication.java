package com.redeyes.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;

import java.util.Properties;

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
     * @return Velocity Engine.
     */
    @Bean
    public VelocityEngineFactoryBean velocityEngine() {
        VelocityEngineFactoryBean velocityEngineFactoryBean = new VelocityEngineFactoryBean();
        Properties props = new Properties();
        props.setProperty("resource.loader", "class");
        props.setProperty("class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        velocityEngineFactoryBean.setVelocityProperties(props);
        return velocityEngineFactoryBean;
    }
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
