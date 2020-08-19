package net.iqbusiness.console;

import net.iqbusiness.console.InputStrategy;
import org.apache.log4j.Logger;

/**
 * Logs the available operations to the user.
 * */
public class HelpOperation implements InputStrategy {
	
	private static final Logger logger = Logger.getLogger(HelpOperation.class);

	@Override
	public void doOperation() {
		logger.info((Object) "clear -- clears the stored list of consumed messages");
		logger.info((Object) "exit -- exists JVM and terminates the consumer service");
		logger.info((Object) "help -- this manual");
		logger.info((Object) "ls -- lists the consumed messages");
	}
	
}
