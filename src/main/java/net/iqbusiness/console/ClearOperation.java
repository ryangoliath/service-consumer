package net.iqbusiness.console;

import org.apache.log4j.Logger;

import net.iqbusiness.messaging.RabbitMqMessageBroker;

/**
 * Clears the messages stack containing consumed messages
 */
public class ClearOperation implements InputStrategy {

	private static final Logger logger = Logger.getLogger(ClearOperation.class);

	@Override
	public void doOperation() {
		RabbitMqMessageBroker.clearMessages();
		logger.info((Object) "Cleared messages list");
	}
}
