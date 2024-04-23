package com.ecommerce.selenium.pages.customer;

import com.ecommerce.selenium.pages.BasePage;
import com.ecommerce.selenium.pages.common.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private WebDriver driver = getDriver();

    private static final String NAME_INPUT_ID = "name";
    private static final String EMAIL_INPUT_ID = "email";
    private static final String PASSWORD_INPUT_ID = "password";
    private static final String CONFIRM_PASSWORD_INPUT_ID = "confirmPassword";
    private static final String REGISTER_BUTTON_XPATH = "//button[text()='Register']";
    private static final String LOGIN_LINK_XPATH = "//a[contains(@href,'/login')]";

    /**
     * Create a new customer account
     * @param name
     * @param email
     * @param password
     * @param confirmPassword
     * @return
     */
    public LoginPage createCustomerAccount(String name, String email, String password, String confirmPassword) {
        enterTextIntoTextBox(By.id(NAME_INPUT_ID), name);
        enterTextIntoTextBox(By.id(EMAIL_INPUT_ID), email);
        enterTextIntoTextBox(By.id(PASSWORD_INPUT_ID), password);
        enterTextIntoTextBox(By.id(CONFIRM_PASSWORD_INPUT_ID), confirmPassword);
        clickLinkOrBtn(By.xpath(REGISTER_BUTTON_XPATH));
        return new LoginPage(driver);
    }

    /**
     * Navigate to the Login page
     * @return
     */
    public LoginPage navigateToLoginPageLink() {
        clickLinkOrBtn(By.xpath(LOGIN_LINK_XPATH));
        return new LoginPage(driver);
    }
}
