package com.redeyes.registration.config;

import com.redeyes.registration.config.jms.JmsEmailConsumer;
import com.redeyes.registration.config.jms.JmsEmailProduser;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JmsConfig {
    public static final String JMS_QUEUE = "RED_EYES_CONFIRM";

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(new ActiveMQConnectionFactory("tcp://localhost:61616"));
        jmsTemplate.setDefaultDestination(new ActiveMQQueue(JMS_QUEUE));
        return jmsTemplate;
    }

    @Bean
    public JmsEmailProduser emailProduser() {
        JmsEmailProduser jmsEmailProduser = new JmsEmailProduser();
        jmsEmailProduser.setJmsTemplate(jmsTemplate());
        return jmsEmailProduser;
    }

    @Bean
    public JmsEmailConsumer emailConsumer() {
        JmsEmailConsumer jmsEmailConsumer = new JmsEmailConsumer();
        jmsEmailConsumer.setJmsTemplate(jmsTemplate());
        return jmsEmailConsumer;
    }
}
