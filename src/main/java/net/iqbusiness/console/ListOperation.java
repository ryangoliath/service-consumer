package net.iqbusiness.console;

import net.iqbusiness.console.InputStrategy;
import net.iqbusiness.messaging.RabbitMqMessageBroker;
import org.apache.log4j.Logger;

/**
 * Lists the consumed messages stored on the message stack
 * */
public class ListOperation implements InputStrategy {
	
	private static final Logger logger = Logger.getLogger(ListOperation.class);

	@Override
	public void doOperation() {
		if (RabbitMqMessageBroker.getMessages().length == 0) {
			logger.info((Object) "No messages to display.");
		} else {
			logger.info((Object) "Logging consumed messages: ");
			for (Object message : RabbitMqMessageBroker.getMessages()) {
				logger.info("--> " + message);
			}
		}
	}
}
