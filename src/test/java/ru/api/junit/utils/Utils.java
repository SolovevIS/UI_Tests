package ru.api.junit.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Utils {

    public static Properties readProperties() {
        try {
            Properties properties = new Properties();
            properties.load(Files.newInputStream(Paths.get("src/test/resources/properities/api.properties")));
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
