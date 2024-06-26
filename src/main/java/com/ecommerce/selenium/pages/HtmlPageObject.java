package com.ecommerce.selenium.pages;

import static com.ecommerce.selenium.utilities.TimeUtilities.getExplicitWait;

import com.ecommerce.selenium.driver.DriverManager;
import com.ecommerce.selenium.utilities.Helper;
import com.ecommerce.selenium.utilities.LogHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

    /**
     * Enter text into a text box
     * @param by
     * @param text
     */
    public void enterTextIntoTextBox(By by, String text) {
        WebElement textBox = findElementBy(by);
        textBox.clear();
        textBox.sendKeys(text);

        Helper.takeElementScreenshot(textBox, "textBox");
    }

    /**
     * Enter text into a text box
     * @param element
     * @param text
     */
    public void enterTextIntoTextBox(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);

        Helper.takeElementScreenshot(element, "textBox");
        LogHelper.logToReport("Typing text: " + text + " inside text box with locator: " + element.toString());
    }

    /**
     * Method to click a link or button
     * @param by
     */
    public void clickLinkOrBtn(By by) {
        WebElement btnOrLink = findElementBy(by);
        btnOrLink.click();
    }

    /**
     * Method to click a link or button
     * @param element
     */
    public void clickLinkOrBtn(WebElement element) {
        element.click();
    }

    /**
     * Method to return text
     * @param by
     * @return
     */
    public String getTextFromElement(By by) {
        WebElement element = findElementBy(by);
        return element.getText();
    }

    /**
     * Method to return text
     * @param element
     * @return
     */
    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    /**
     * Method to return the attribute value
     * @param by
     * @param attr
     * @return
     */
    public String getAttribute(By by, String attr) {
        WebElement element = findElementBy(by);
        return element.getAttribute(attr);
    }

    /**
     * Method to return the attribute value
     * @param element
     * @param attr
     * @return
     */
    public String getAttribute(WebElement element, String attr) {
        return element.getAttribute(attr);
    }

    /**
     * Method to select by visible text
     * @param by
     * @param textValue
     */
    public void selectByVisibleText(By by, String textValue) {
        WebElement selectBox = findElementBy(by);
        Select select = new Select(selectBox);
        select.selectByVisibleText(textValue);
    }

    /**
     * Method to select by visible text
     * @param element
     * @param textValue
     */
    public void selectByVisibleText(WebElement element, String textValue) {
        Select select = new Select(element);
        select.selectByVisibleText(textValue);
    }

    /**
     * Method to select checkbox
     * @param by
     * @return
     */
    public boolean selectCheckBox(By by) {
        WebElement webElement = findElementBy(by);
        if (webElement.isSelected()) {
            return true;
        }
        webElement.click();
        return true;
    }

    /**
     * Method to select checkbox
     * @param webElement
     * @return
     */
    public boolean selectCheckBox(WebElement webElement) {
        if (webElement.isSelected()) {
            return true;
        }
        webElement.click();
        return true;
    }

    /**
     * Method to check if text is present on page
     * @param text
     * @return
     */
    public boolean isTextPresentOnPage(String text) {
        String pageSource = driver.getPageSource();
        if (pageSource.contains(text)) {
            return true;
        }
        return false;
    }
}
