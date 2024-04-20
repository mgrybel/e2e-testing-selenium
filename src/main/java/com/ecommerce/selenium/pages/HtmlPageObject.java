package com.ecommerce.selenium.pages;

import static com.ecommerce.selenium.utilities.TimeUtilities.getExplicitWait;

import com.ecommerce.selenium.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HtmlPageObject extends DriverManager {
    private WebDriver driver = getDriver();

    /**
     * Find an element by CSS selector
     * @param cssLocator
     * @return
     */
    private WebElement findElementByCss(String cssLocator) {
        try {
            By by = By.cssSelector(cssLocator);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getExplicitWait()));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch(TimeoutException e) {
            throw new TimeoutException();
        }
    }

    /**
     * Find an element by XPath
     * @param xpathLocator
     * @return
     */
    public WebElement findElementByXpath(String xpathLocator) {
        try {
            By by = By.xpath(xpathLocator);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getExplicitWait()));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            throw new TimeoutException();
        }
    }

    /**
     * Find an element by ID
     * @param idLocator
     * @return
     */
    public WebElement findElementById(String idLocator) {
        try {
            By by = By.id(idLocator);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getExplicitWait()));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            throw new TimeoutException();
        }
    }

    /**
     * Find an element by using the By locator
     * @param by
     * @return
     */
    public WebElement findElementBy(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getExplicitWait()));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            throw new TimeoutException();
        }
    }

    /**
     * Find elements by using the By locator
     * @param by
     * @return
     */
    public List<WebElement> findElementsBy(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getExplicitWait()));
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        } catch (TimeoutException e) {
            throw new TimeoutException();
        }
    }
}
