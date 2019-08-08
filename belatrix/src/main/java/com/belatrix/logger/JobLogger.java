package main.java.com.belatrix.logger;

import java.util.Map;

import javax.naming.ConfigurationException;

public class JobLogger {
	private static boolean logToFile;
	private static boolean logToConsole;
	private static boolean logMessage;
	private static boolean logWarning;
	private static boolean logError;
	private static boolean logToDatabase;
	private static Map<String, String> dbParams;

	public JobLogger(boolean logToFileParam, boolean logToConsoleParam, boolean logToDatabaseParam,
			boolean logMessageParam, boolean logWarningParam, boolean logErrorParam, Map<String, String> dbParamsMap)
			throws ConfigurationException {
		logError = logErrorParam;
		logMessage = logMessageParam;
		logWarning = logWarningParam;
		logToDatabase = logToDatabaseParam;
		logToFile = logToFileParam;
		logToConsole = logToConsoleParam;
		dbParams = dbParamsMap;
		validateAtributes();
	}

	private void validateAtributes() throws ConfigurationException {
		if (!logToConsole && !logToFile && !logToDatabase) {
			throw new ConfigurationException("Invalid configuration");
		}
		if (!logError && !logMessage && !logWarning) {
			throw new ConfigurationException("Log Type must be specified");
		}
		if (dbParams == null) {
			throw new ConfigurationException("DB Params must be specified");
		}
	}

	public static void LogMessage(String messageText, boolean message, boolean warning, boolean error)
			throws Exception {

		if (messageText == null || messageText.length() == 0) {
			return;
		}
		if (!message && !warning && !error) {
			throw new IllegalArgumentException("Error or Warning or Message must be specified");
		}
		Log log = null;
		if (message) {
			log = new LogMassage(logMessage, logWarning, logError);
		}
		if (warning) {
			log = new LogWarning(logMessage, logWarning, logError);
		}
		if (error) {
			log = new LogError(logMessage, logWarning, logError);
		}

		if (logToFile) {
			log.logToFile(dbParams.get("logFileFolder"), messageText);
		}

		if (logToConsole) {
			log.logToConsole(messageText);
		}

		if (logToDatabase) {
			log.logToDatabase(dbParams, messageText);
		}
	}
}
