package com.redeyes.registration.config;

import com.redeyes.registration.config.jms.JmsEmailConsumer;
import com.redeyes.registration.config.jms.JmsEmailProduser;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

/**
 * JMS Configuration.
 */
@Configuration
public class JmsConfig {
    /**
     * ActiveMQ queue name.
     */
    private static final String JMS_QUEUE = "RED_EYES_CONFIRM";

    /**
     * JMS Template.
     *
     * @return JMS Template.
     */
    @Bean
    public final JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(new ActiveMQConnectionFactory("tcp://localhost:61616"));
        jmsTemplate.setDefaultDestination(new ActiveMQQueue(JMS_QUEUE));
        return jmsTemplate;
    }

    /**
     * Custom jms send message.
     *
     * @return Custom jms sender.
     */
    @Bean
    public final JmsEmailProduser emailProduser() {
        JmsEmailProduser jmsEmailProduser = new JmsEmailProduser();
        jmsEmailProduser.setJmsTemplate(jmsTemplate());
        return jmsEmailProduser;
    }

    /**
     * Custom jms receive message.
     *
     * @return Custom jms receiver.
     */
    @Bean
    public final JmsEmailConsumer emailConsumer() {
        JmsEmailConsumer jmsEmailConsumer = new JmsEmailConsumer();
        jmsEmailConsumer.setJmsTemplate(jmsTemplate());
        return jmsEmailConsumer;
    }
}
