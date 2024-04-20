package com.ecommerce.selenium.driver;

import com.ecommerce.selenium.utilities.PropKey;
import com.ecommerce.selenium.utilities.PropertyReader;
import com.ecommerce.selenium.utilities.TimeUtilities;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static com.ecommerce.selenium.utilities.TimeUtilities.getImplicitWait;

public class DriverFactory {
    public static PropertyReader prop;
    protected static WebDriver driver = null;
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    /**
     * Get the Webdriver
     * @return
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            driverThreadLocal.set(getBrowser().getWebDriver());
        }
        driverThreadLocal.get().manage().timeouts().implicitlyWait(getImplicitWait(), TimeUnit.SECONDS);
        return driverThreadLocal.get();
    }

    /**
     * Quit the Webdriver
     */
    public static void quitDriver() {
        driverThreadLocal.get().quit();
    }

    /**
     * Determine the browser
     * @return
     */
    private static BrowserType getBrowser() {
        if (prop.getProperty(PropKey.BROWSER.getPropVal()).equalsIgnoreCase("CHROME")) {
            return BrowserType.CHROME;
        } else {
            return BrowserType.FIREFOX;
        }
    }
}
