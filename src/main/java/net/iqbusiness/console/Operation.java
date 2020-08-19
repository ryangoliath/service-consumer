package net.iqbusiness.console;

/**
 * Contains the operations available when taking console input
 */
public enum Operation {

	EXIT("exit"),
	CLEAR("clear"),
	HELP("help"),
	LIST("ls");

	private String name;

	private Operation(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public static Operation getOperation(String operation) {
		for (Operation op : Operation.values()) {
			if (op.getName().equalsIgnoreCase(operation)) {
				return op;
			}
		}
		return null;
	}
}
