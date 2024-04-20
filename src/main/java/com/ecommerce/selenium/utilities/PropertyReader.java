package com.ecommerce.selenium.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// PropertyReader class using the Singleton Design Pattern

public class PropertyReader {
    private static volatile PropertyReader propInstance;

    private PropertyReader() {
    }

    public static synchronized PropertyReader getInstance() {
        if (propInstance == null) {
            propInstance = new PropertyReader();
        }
        return propInstance;
    }

    /**
     * Method to return a property value
     * @param propertyName
     * @return
     */
    public String getProperty(String propertyName) {
        Properties prop = new Properties();

        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
            prop.load(inputStream);

            if (prop.getProperty(propertyName) != null) {
                return prop.getProperty(propertyName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
