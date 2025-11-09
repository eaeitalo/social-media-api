package com.eaeitalo.socialmedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Social Media API - Backend System
 * Developed by: @eaeitalo
 * GitHub: https://github.com/eaeitalo
 *
 * Sistema de rede social com RabbitMQ para notificações assíncronas
 */
@SpringBootApplication
public class SocialMediaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialMediaApiApplication.class, args);
		System.out.println("Social Media API started successfully!");
		System.out.println("Developed by: @eaeitalo");
	}
}