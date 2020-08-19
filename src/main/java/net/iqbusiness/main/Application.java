package net.iqbusiness.main;

import java.io.Console;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;

import net.iqbusiness.console.InputStrategy;
import net.iqbusiness.console.InputStrategyFactory;
import net.iqbusiness.messaging.MessageCallbackHandler;

/**
 * main class<br>
 * Reads user input via console and consumes/validates/prints messages from a
 * queue (RabbitMq).
 */
public class Application {

	private static final Logger logger = Logger.getLogger(Application.class);

	public static void main(String[] args) throws IOException, TimeoutException {
		try {
			
			Console console = System.console();
			
			if (console == null) {
				logger.error((Object) "No console provided.");
			}
			
			MessageCallbackHandler messageHandler = new MessageCallbackHandler();
			messageHandler.listen();
			
			do {
				
				String arg = console.readLine("[Type 'help' for manual. CTRL+C to exit] ... \n\n\n", new Object[0]);
				InputStrategy strategy = InputStrategyFactory.getInputStrategy(arg);
				strategy.doOperation();
				
			} while (true);
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
	}

}