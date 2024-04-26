package com.ecommerce.selenium.utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    /**
     * Take a screenshot
     * @param driver
     * @param name
     * @return
     */
    public static synchronized boolean takeScreenshot(WebDriver driver, String name) {
        boolean isScreenshotEnabled = PropertyReader.getInstance()
                .getProperty(PropKey.SCREENSHOT.getPropVal())
                .equalsIgnoreCase("ENABLED");

        if (isScreenshotEnabled) {
            attachScreenshot(driver, name);
            return true;
        }
        return false;
    }

    /**
     * Attach a screenshot
     * @param driver
     * @param name
     * @return
     */
    @Attachment(value = "{name}", type = "image/png")
    private static synchronized byte[] attachScreenshot(WebDriver driver, String name) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * Take an element screenshot
     * @param element
     * @param name
     * @return
     */
    public static synchronized boolean takeElementScreenshot(WebElement element, String name) {
        boolean isScreenshotEnabled = PropertyReader.getInstance()
                .getProperty(PropKey.ELEMENT_SCREENSHOT.getPropVal())
                .equalsIgnoreCase("ENABLED");

        if (isScreenshotEnabled) {
            attachElementScreenshot(element, name);
            return true;
        }
        return false;
    }

    /**
     * Attach an element screenshot
     * @param element
     * @param name
     * @return
     */
    @Attachment(value = "{name}", type = "image/png")
    private static synchronized byte[] attachElementScreenshot(WebElement element, String name) {
        return element.getScreenshotAs(OutputType.BYTES);
    }
}
