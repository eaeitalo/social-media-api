package com.eaeitalo.socialmedia.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ Configuration - Configura exchanges e queues
 * @author @eaeitalo
 */
@Configuration
public class RabbitMQConfig {

    @Value("${app.exchange.name:socialmedia.exchange}")
    private String exchangeName;

    @Value("${app.queue.notifications:notification.queue}")
    private String notificationQueue;

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue(notificationQueue, true);
    }

    @Bean
    public Binding binding(Queue notificationQueue, TopicExchange exchange) {
        return BindingBuilder.bind(notificationQueue)
                .to(exchange)
                .with("notification.#");
    }
}