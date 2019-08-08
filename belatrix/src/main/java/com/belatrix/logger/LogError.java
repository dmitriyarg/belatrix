package main.java.com.belatrix.logger;

import java.util.logging.Level;

public class LogError extends Log {
	private final static String COUNTER = "2";
	private final static String TYPE = "error";

	public LogError(boolean logMessage, boolean logWarning, boolean logError) {
		super(logMessage, logWarning, logError);
		setLevel(Level.SEVERE);
		setCounter(COUNTER);
		setType(TYPE);
	}
}