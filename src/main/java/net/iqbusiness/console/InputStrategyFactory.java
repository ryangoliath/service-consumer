package net.iqbusiness.console;

import net.iqbusiness.console.ClearOperation;
import net.iqbusiness.console.ExitOperation;
import net.iqbusiness.console.HelpOperation;
import net.iqbusiness.console.InputStrategy;
import net.iqbusiness.console.InvalidOperation;
import net.iqbusiness.console.ListOperation;
import net.iqbusiness.console.Operation;

/**
 * Factory used to return a corresponding InputStrategy based on the user input.
 * */
public class InputStrategyFactory {
	
	public static InputStrategy getInputStrategy(String arg) {
		InputStrategy strategy = null;

		Operation operation = Operation.getOperation(arg);

		if (operation == null) {
			return new InvalidOperation();
		}

		switch (operation) {
			case CLEAR: {
				strategy = new ClearOperation();
				break;
			}
			case EXIT: {
				strategy = new ExitOperation();
				break;
			}
			case HELP: {
				strategy = new HelpOperation();
				break;
			}
			case LIST: {
				strategy = new ListOperation();
				break;
			}
		}
		return strategy;
	}

}
