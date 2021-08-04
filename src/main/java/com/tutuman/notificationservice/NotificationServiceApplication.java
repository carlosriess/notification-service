package com.tutuman.notificationservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;


import java.util.function.Consumer;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	@Bean
	public Consumer<Message<String>> notificationEventSupplier(){

		return message->{
			String orderNumber=message.getPayload();
			log.info("Order Placed Successfully - Order Number is {}", orderNumber);
			log.info("Email Sent For Order Id {}", orderNumber);
		};
	}
}
