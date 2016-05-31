package com.redeyes.registration.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JmsConfig {

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(new ActiveMQConnectionFactory("tcp://localhost:61616"));
        jmsTemplate.setDefaultDestination(new ActiveMQQueue("RED_EYES_CONFIRM"));
        return jmsTemplate;
    }
}
