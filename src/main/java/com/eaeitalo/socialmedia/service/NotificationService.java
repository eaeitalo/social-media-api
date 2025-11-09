package com.eaeitalo.socialmedia.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Notification Service - Envia notificações via RabbitMQ
 * @author @eaeitalo
 */
@Service
public class NotificationService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${app.exchange.name:socialmedia.exchange}")
    private String exchangeName;

    public NotificationService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendLikeNotification(Long postId, String likerUsername, String authorUsername) {
        String message = String.format(
                " @%s curtiu seu post #%d | Author: @%s",
                likerUsername, postId, authorUsername
        );

        rabbitTemplate.convertAndSend(
                exchangeName,
                "notification.like",
                message
        );

        System.out.println(" Notification sent: " + message);
    }

    public void sendFollowNotification(String followerUsername, String followedUsername) {
        String message = String.format(
                "👥 @%s começou a seguir @%s",
                followerUsername, followedUsername
        );

        rabbitTemplate.convertAndSend(
                exchangeName,
                "notification.follow",
                message
        );

        System.out.println(" Notification sent: " + message);
    }
}
