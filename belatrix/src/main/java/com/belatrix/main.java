package main.java.com.belatrix;

import java.io.IOException;

import main.java.com.belatrix.logger.JobLogger;

public class main {

    public static void main(String[] args) throws Exception {
    //	JobLogger tester = new JobLogger();
        try {
        	JobLogger.LogMessage("", true, true, true);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problems with creating the log files");
        }
       // tester.doSomeThingAndLog();
    }

}
