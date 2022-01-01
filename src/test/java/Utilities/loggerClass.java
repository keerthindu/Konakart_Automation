package Utilities;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;


public class loggerClass {
    private static final Logger logger = LogManager.getLogger(loggerClass.class.getName());

    public static void main(String[] args){
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");

            Random random = new Random();
            int email = random.nextInt();
        System.out.println("username" + email + "@gmail.com");

    }
}
