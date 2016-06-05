package com.redeyes.registration.config;

import com.redeyes.registration.config.jms.JmsEmailProduser;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

/**
 * JMS Configuration.
 */
@Configuration
public class JmsConfig {
    /**
     * ActiveMQ email confirm queue name.
     */
    public static final String EMAIL_QUEUE_NAME = "confirm.email";

    /**
     * ActiveMQ connection factory.
     *
     * @return ActiveMQ connection factory.
     */
    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(
                "vm://localhost?broker.persistent=false");
        activeMQConnectionFactory.setTrustAllPackages(true);
        return activeMQConnectionFactory;
    }

    /**
     * SpringJms container factory.
     *
     * @return SpringJms container factory.
     */
    @Bean
    public JmsListenerContainerFactory<?> factory() {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        return factory;
    }

    /**
     * JMS Template.
     *
     * @return JMS Template.
     */
    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory());
        jmsTemplate.setDefaultDestination(new ActiveMQQueue(EMAIL_QUEUE_NAME));
        return jmsTemplate;
    }

    /**
     * Custom jms send message.
     *
     * @return Custom jms sender.
     */
    @Bean
    public JmsEmailProduser jmsEmailProduser() {
        JmsEmailProduser jmsEmailProduser = new JmsEmailProduser();
        jmsEmailProduser.setJmsTemplate(jmsTemplate());
        return jmsEmailProduser;
    }
}
