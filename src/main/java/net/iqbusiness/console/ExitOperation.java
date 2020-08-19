package net.iqbusiness.console;

import net.iqbusiness.console.InputStrategy;
import org.apache.log4j.Logger;

public class ExitOperation implements InputStrategy {
	
	private static final Logger logger = Logger.getLogger(ExitOperation.class);

	/**
	 * Output the exit to the user.<br>
	 * Terminate JVM
	 * */
	@Override
	public void doOperation() {
		logger.info((Object) "Exiting...");
		System.exit(0);
	}
	
}
