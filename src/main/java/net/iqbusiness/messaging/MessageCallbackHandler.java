package net.iqbusiness.messaging;

import org.apache.log4j.Logger;

import net.iqbusiness.messaging.queue.Queue;

public class MessageCallbackHandler implements MessageHandler {
	
	private static final Logger logger = Logger.getLogger(MessageCallbackHandler.class);

	@Override
	public void listen() {
		try {
			RabbitMqMessageBroker.getInstance().listen(Queue.ASSESSMENT, new MessageCallback());
		} catch (Exception e) {
			logger.error(String.format("Error configuring consumer for queue: '%s'", Queue.ASSESSMENT.getName()), e);
		}
	}
}
