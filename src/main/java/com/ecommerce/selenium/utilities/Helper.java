package com.ecommerce.selenium.utilities;

public class Helper {
    /**
     * Get the app URL from the application.properties file
     * @return
     */
    public static String getAppUrl() {
        String baseUrl = PropertyReader.getInstance().getProperty(PropKey.URL.getPropVal());
        String port = PropertyReader.getInstance().getProperty(PropKey.PORT.getPropVal());
        String finalUrl = baseUrl + port;
        return finalUrl;
    }
}
