package com.banking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main( String[] args ) {
        logger.trace("Entering application.");
        System.out.println( "Hello World!" );
        logger.trace("Exiting application.");
        logger.info("End of app");
        logger.warn("End of app");
    }
}
