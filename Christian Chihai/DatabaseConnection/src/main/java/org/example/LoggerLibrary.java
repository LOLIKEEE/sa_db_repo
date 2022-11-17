package org.example;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerLibrary {
    private Logger logger;
    private FileHandler fl;

    public LoggerLibrary() {
        logger = Logger.getLogger(this.getClass().getName());
        try {
            fl = new FileHandler("myLogs.log", true);
            logger.addHandler(fl);
            SimpleFormatter formatter = new SimpleFormatter();
            fl.setFormatter(formatter);
        } catch (IOException e) {
            System.out.println("IOException - " + e);
        }
    }

    public Logger getConfiguredLogger() {
        return logger;
    }
}
