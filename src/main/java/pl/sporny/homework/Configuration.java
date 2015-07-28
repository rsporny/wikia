package pl.sporny.homework;

import java.io.IOException;
import java.util.Properties;

public class Configuration {

    private static Configuration instance = null;
    private static Properties properties;

    private Configuration() {
    }

    public static synchronized Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
            loadProperties();
        }
        return instance;
    }

    private static void loadProperties() {
        properties = new Properties();
        try {
            properties.load(getInstance().getClass().getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            throw new IllegalStateException("Error while loading properties");
        }
    }

    public String get(String key) {
        return properties.getProperty(key);
    }

}
