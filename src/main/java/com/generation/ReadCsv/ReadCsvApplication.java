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
		String host = "localhost"; // Replace with your RabbitMQ server host
	    int port = 5672; // Replace with your RabbitMQ server port
	    String username = "guest"; // Replace with your RabbitMQ server username
	    String password = "guest"; // Replace with your RabbitMQ server password

	    // Create a CachingConnectionFactory and set the connection details
	    CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
	    connectionFactory.setHost(host);
	    connectionFactory.setPort(port);
	    connectionFactory.setUsername(username);
	    connectionFactory.setPassword(password);

	    // Create a RabbitTemplate instance and set the connection factory
	    RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		System.out.println("chegou!");
		ReadCsv readCsv = new ReadCsv(rabbitTemplate);
		readCsv.read();
		System.out.println("chegou2!");
		
	}

}
