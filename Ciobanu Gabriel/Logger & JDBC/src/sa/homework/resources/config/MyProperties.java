package sa.homework.resources.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class MyProperties {
    private static final Properties fileProperties = new Properties();

    static {
        try {
            fileProperties.load(Files.newInputStream(Path.of("src/sa/homework/resources/application.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getFilePath() {
        return fileProperties.getProperty("file.path");
    }

    public static String getFileExtension() {
        return fileProperties.getProperty("file.extension");
    }

    public static String getFileName() {
        return fileProperties.getProperty("file.name");
    }

    public static String getDatabaseUrl() {
        return fileProperties.getProperty("database.url");
    }

    public static String getDatabaseUser() {
        return fileProperties.getProperty("database.user");
    }

    public static String getDatabasePassword() {
        return fileProperties.getProperty("database.password");
    }

    public static String getDatabaseName(){
        return fileProperties.getProperty("database.name");
    }

}
