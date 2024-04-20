package com.ecommerce.selenium.tests;

import com.ecommerce.selenium.utilities.PropKey;
import com.ecommerce.selenium.utilities.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
    static WebDriver driver;
    static PropertyReader prop = PropertyReader.getInstance();

    @BeforeAll
    static void setup() {
        if (prop.getProperty(PropKey.BROWSER.getPropVal()).equalsIgnoreCase("CHROME")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
    }

    @AfterAll
    static void cleanup() {
        driver.quit();
    }
}
