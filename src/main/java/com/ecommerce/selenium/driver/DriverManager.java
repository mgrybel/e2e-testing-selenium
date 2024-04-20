package com.ecommerce.selenium.driver;

import com.ecommerce.selenium.utilities.PropertyReader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class DriverManager extends DriverFactory {
    @BeforeAll
    public static void setUp() {
        prop = PropertyReader.getInstance();
        driver = getDriver();
    }

    @BeforeEach
    public void beforeEachMethod() {
        getDriver().manage().deleteAllCookies();
    }

    @AfterAll
    public static void tearDown() {
        driver = null;
        quitDriver();
    }
}
