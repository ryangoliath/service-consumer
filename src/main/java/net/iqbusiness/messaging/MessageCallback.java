package net.iqbusiness.messaging;

import net.iqbusiness.messaging.ConsumerCallback;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class MessageCallback implements ConsumerCallback {
	
	private static final Logger logger = Logger.getLogger(MessageCallback.class);
	
	public static final String QUEUE_NAME = "IQ_BUSINESS.ASSESSMENT.RYAN.GOLIATH";
	private static final String MSG_PREFIX = "Hello my name is, ";
	private static final String OUTPUT_MSG_FORMAT = "Hello %s, I am your father!";

	@Override
	public void callback(String message) {
		String name = this.extractName(message);
		
		if (name != null) {
			logger.info(String.format(OUTPUT_MSG_FORMAT, name));
		}
	}

	private String extractName(String message) {
		String name = null;
		
		if (this.isValidMessage(message)) {
			name = StringUtils.substringAfterLast(message, MSG_PREFIX);
		} else {
			logger.error(String.format("Message does not conform to expected formatting pattern. Name: %s",
					message));
		}
		return name;
	}

	private boolean isValidMessage(String message) {
		if (StringUtils.isBlank(message)) {
			return false;
		}
		
		if(!message.startsWith(MSG_PREFIX)) {
			return false;
		}
		
		return true;
	}
}
