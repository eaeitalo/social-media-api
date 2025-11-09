package com.eaeitalo.socialmedia.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Notification Consumer - Processa mensagens do RabbitMQ
 * @author @eaeitalo
 */
@Service
public class NotificationConsumer {

    @Value("${app.queue.notifications:notification.queue}")
    private String notificationQueue;

    @RabbitListener(queues = "${app.queue.notifications:notification.queue}")
    public void receiveNotification(String message) {
        System.out.println("✅ [RABBITMQ] Notification received: " + message);
        // Aqui você pode: salvar no banco, enviar email, push notification, etc.
    }
}
