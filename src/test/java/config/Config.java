package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final Properties properties = new Properties();

    static {
        String target = System.getProperty("target", "local"); // default to local
        try (FileInputStream fis = new FileInputStream("src/test/resources/" + target + ".properties")) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Could not load properties file: " + target, e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
