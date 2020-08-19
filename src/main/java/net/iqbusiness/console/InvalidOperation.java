package net.iqbusiness.console;

import net.iqbusiness.console.InputStrategy;
import org.apache.log4j.Logger;

public class InvalidOperation implements InputStrategy {
	
	private static final Logger logger = Logger.getLogger(InvalidOperation.class);

	@Override
	public void doOperation() {
		logger.error("Invalid command provided.");
	}
}
