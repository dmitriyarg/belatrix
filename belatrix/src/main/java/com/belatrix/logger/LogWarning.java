package main.java.com.belatrix.logger;

import java.util.logging.Level;

public class LogWarning extends Log {
	private final static String COUNTER = "3";
	private final static String TYPE = "warning";

	public LogWarning(boolean logMessage, boolean logWarning, boolean logError) {
		super(logMessage, logWarning, logError);
		setLevel(Level.WARNING);
		setCounter(COUNTER);
		setType(TYPE);
	}
}
