package main.java.com.belatrix.logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {
	private static Logger logger = Logger.getLogger(Log.class.getName());

	protected Level level;
	protected String counter = "0";
	protected String type = "";

	public Log(boolean logMessage, boolean logWarning, boolean logError) {
		Level levelLog = Level.INFO;
		if (logWarning) {
			levelLog = Level.WARNING;
		}
		if (logError) {
			levelLog = Level.SEVERE;
		}
		logger.setLevel(levelLog);
	}

	public void logToFile(String folder, String messageText) throws IOException {
		logger.addHandler(LogFileHandler.getFileHandler(folder));
		logger.log(level, format(messageText));
	}

	public void logToConsole(String messageText) {
		ConsoleHandler ch = new ConsoleHandler();
		logger.addHandler(ch);
		logger.log(level, format(messageText));

	}

	public void logToDatabase(Map<String, String> dbParams, String messageText) throws Exception {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionManager.getConexion(dbParams);
			stmt = connection.createStatement();

			stmt.executeUpdate("insert into Log_Values('" + messageText + "', " + counter + ")");

		} catch (Exception e) {
			throw new SQLException("Fail to persist on DB");
		} finally {
			stmt.close();
			ConnectionManager.closeDbConnection(connection);
		}
	}

	private String format(String messageText) {
		return type + " " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " " + messageText;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public String getCounter() {
		return counter;
	}

	public void setCounter(String counter) {
		this.counter = counter;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
