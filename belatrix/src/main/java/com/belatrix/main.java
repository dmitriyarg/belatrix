package main.java.com.belatrix;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import main.java.com.belatrix.logger.JobLogger;

public class main {

    public static void main(String[] args) throws Exception {
    	JobLogger tester = new JobLogger(false, true, true,
    			true, false, false, (new HashMap<String, String>()));
        try {
        	JobLogger.LogMessage("test 3", true, false, false);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problems with creating the log files");
        }
       // tester.doSomeThingAndLog();
    }

}
