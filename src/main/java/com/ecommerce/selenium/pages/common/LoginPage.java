package com.ecommerce.selenium.pages.common;

import com.ecommerce.selenium.pages.BasePage;
import com.ecommerce.selenium.pages.admin.AdminHomePage;
import com.ecommerce.selenium.pages.customer.CustomerHomePage;
import com.ecommerce.selenium.pages.customer.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private WebDriver driver = getDriver();

    private static final String EMAIL_INPUT_ID = "email";
    private static final String PASSWORD_INPUT_ID = "password";
    private static final String LOGIN_BUTTON_XPATH = "//button[text()='Login']";
    private static final String LOGIN_HEADING_XPATH = "//h1[text() = 'Login']";
    private static final String REGISTER_LINK_XPATH = "//a[contains(@href,'/register')]";
    private static final String NO_LOGIN_DATA_MESSAGE_XPATH =
            "//p[contains(@class, 'text-danger text-center') and text() = 'Email and Password are required']";
    private static final String INVALID_LOGIN_DATA_MESSAGE_XPATH =
            "//p[contains(@class, 'text-danger text-center') and text() = 'Invalid email or password']";

    @FindBy(xpath = LOGIN_BUTTON_XPATH)
    private WebElement loginButton;

    /**
     * Log in to the application as an admin
     * @param email
     * @param password
     * @return
     */
    public AdminHomePage adminLogin(String email, String password) {
        enterTextIntoTextBox(By.id(EMAIL_INPUT_ID), email);
        enterTextIntoTextBox(By.id(PASSWORD_INPUT_ID), password);
        clickLinkOrBtn(loginButton);
        return new AdminHomePage(driver);
    }

    /**
     * Log in to the application as a customer
     * @param email
     * @param password
     * @return
     */
    public CustomerHomePage customerLogin(String email, String password) {
        enterTextIntoTextBox(By.id(EMAIL_INPUT_ID), email);
        enterTextIntoTextBox(By.id(PASSWORD_INPUT_ID), password);
        clickLinkOrBtn(loginButton);
        return new CustomerHomePage(driver);
    }

    /**
     * Navigate to the Register page
     * @return
     */
    public RegisterPage navigateToRegisterPageLink() {
        clickLinkOrBtn(By.xpath(REGISTER_LINK_XPATH));
        return new RegisterPage(driver);
    }

    /**
     * Get the error message about no login data provided
     * @return
     */
    public String getNoLoginDataProvidedMessage() {
        clickLinkOrBtn(loginButton);
        return getTextFromElement(By.xpath(NO_LOGIN_DATA_MESSAGE_XPATH));
    }

    /**
     * Get the error message about invalid login credentials
     * @return
     */
    public String getInvalidLoginMessage() {
        return getTextFromElement(By.xpath(INVALID_LOGIN_DATA_MESSAGE_XPATH));
    }

    /**
     * Check if the Login heading is visible
     */
    public boolean isLoginHeadingVisible() {
        findElementBy(By.xpath(LOGIN_HEADING_XPATH));
        return true;
    }
}
