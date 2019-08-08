package main.java.com.belatrix.logger;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

public class LogFileHandler {

	private static final String FILE_NAME = "/logFile.txt";

	public static FileHandler getFileHandler(String folder) throws IOException {
		File logFile = new File(folder + FILE_NAME);
		if (!logFile.exists()) {
			logFile.createNewFile();
		}
		FileHandler fh = new FileHandler(folder + FILE_NAME);
		return fh;
	}
}
