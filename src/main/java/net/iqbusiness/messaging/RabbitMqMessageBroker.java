package net.iqbusiness.messaging;

import java.io.IOException;
import java.util.Stack;
import java.util.concurrent.TimeoutException;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import net.iqbusiness.messaging.queue.Queue;
import net.iqbusiness.properties.AppProperties;

public class RabbitMqMessageBroker {
	
	private static final Logger logger = Logger.getLogger(RabbitMqMessageBroker.class);
	
	private static final RabbitMqMessageBroker instance = new RabbitMqMessageBroker();
	private static Stack<String> messages;
	private ConnectionFactory factory = new ConnectionFactory();

	private RabbitMqMessageBroker() {
		this.factory.setUsername(AppProperties.getProperty("app.rabbit.username:guest"));
		this.factory.setPassword(AppProperties.getProperty("app.rabbit.password:guest"));
		this.factory.setHost(AppProperties.getProperty("app.rabbit.host:localhost"));
		this.factory.setPort(Integer.parseInt(AppProperties.getProperty("app.rabbit.port:5672")));
		
		messages = new Stack<String>();
		
		logger.info(String.format("Message Engine Configured for %s:%s",
				AppProperties.getProperty("app.rabbit.host:localhost"),
				AppProperties.getProperty("app.rabbit.port:5672")));
	}

	public void listen(Queue queue, ConsumerCallback callback) throws IOException, TimeoutException {
		
		if (StringUtils.isBlank(queue.getName())) {
			logger.error("Error configuring consumer. No queue provided.");
		}
		
		Connection connection = this.factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(Queue.ASSESSMENT.getName(), false, false, false, null);
		
		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			messages.add(message);
			callback.callback(message);
		};
		
		channel.basicConsume(Queue.ASSESSMENT.getName(), true, deliverCallback, consumerTag -> {});
		
		logger.info("Listening for messages...");
	}

	public static RabbitMqMessageBroker getInstance() {
		return instance;
	}

	public static Object[] getMessages() {
		return messages.toArray();
	}

	public static void clearMessages() {
		messages.removeAllElements();
	}
}
