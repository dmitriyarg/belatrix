package main.java.com.belatrix.logger;

import java.util.logging.Level;

public class LogMassage extends Log {
	private final static String COUNTER = "1";
	private final static String TYPE = "message";

	public LogMassage(boolean logMessage, boolean logWarning, boolean logError) {
		super(logMessage, logWarning, logError);
		setLevel(Level.INFO);
		setCounter(COUNTER);
		setType(TYPE);
	}
}
