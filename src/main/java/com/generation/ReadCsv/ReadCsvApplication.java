package com.generation.ReadCsv;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class ReadCsvApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ReadCsvApplication.class, args);
		
		String host = "localhost";
		int port = 5672;
		String username = "guest";
		String password = "guest";

		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		
		connectionFactory.setHost(host);
		connectionFactory.setPort(port);
		connectionFactory.setUsername(username);
		connectionFactory.setPassword(password);

		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		ReadCsv readCsv = new ReadCsv(rabbitTemplate);
		readCsv.read();

	}

}
