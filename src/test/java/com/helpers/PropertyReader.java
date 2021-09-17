package com.helpers;

import com.patterns.driver_factory.Browser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    public static String getBaseUrl() {
        return getProperty("url");
    }

    public static Browser getBrowser() {
        return Browser.valueOf(getProperty("browser"));
    }

    public static boolean isBrowserWindowMaximize() {
        return Boolean.parseBoolean(getProperty("maximize_window"));
    }

    private static String getProperty(String propertyName) {
        if (System.getProperty(propertyName) == null)
            return getPropertyFromFile(propertyName);
        else return System.getProperty(propertyName);
    }

    private static String getPropertyFromFile(String propertyName) {
        Properties properties = new Properties();
//        InputStream input = null;

        try (InputStream input = new FileInputStream("src/test/resources/framework.properties")) {
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Cannot read property value for " + propertyName);
            e.printStackTrace();
        }

        return properties.getProperty(propertyName);
    }
}