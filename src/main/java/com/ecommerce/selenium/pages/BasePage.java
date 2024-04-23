package com.ecommerce.selenium.pages;

import static com.ecommerce.selenium.utilities.Helper.getAppUrl;

import com.ecommerce.selenium.pages.common.HomePage;
import com.ecommerce.selenium.pages.common.LoginPage;
import com.ecommerce.selenium.pages.common.ProductsPage;
import com.ecommerce.selenium.pages.common.ProfilePage;
import com.ecommerce.selenium.pages.customer.OrdersPage;
import com.ecommerce.selenium.pages.customer.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class BasePage extends HtmlPageObject {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Navbar elements common for all pages
    private static final String HOME_BUTTON_XPATH = "//button[text()='Home']";
    private static final String PRODUCTS_BUTTON_XPATH = "//button[text()='Products']";
    private static final String SIGN_IN_BUTTON_XPATH = "//button[text()='Sign in']";
    private static final String CREATE_AN_ACCOUNT_BUTTON_XPATH = "//button[text()='Create an account']";
    private static final String SEARCH_INPUT_XPATH = "//form/input";
    private static final String SEARCH_BUTTON_XPATH = "//button[text()='Search']";
    private static final String ACCOUNT_BUTTON_XPATH = "//button[text()='Account']";
    private static final String CART_LINK_XPATH = "//a[contains(@href,'/cart')]";
    private static final String ACCOUNT_DROP_DOWN_BUTTON_ID = "btnGroupDrop";
    private static final String PROFILE_LINK_XPATH = "//a[contains(@href,'/profile')]";
    private static final String MY_ORDERS_LINK_XPATH = "//a[contains(@href,'/orders')]";
    private static final String LOGOUT_LINK_XPATH = "//a[contains(@href,'/logout')]";

    @FindBy(xpath = SIGN_IN_BUTTON_XPATH)
    private WebElement signInButton;

    /**
     * Navigate to the app
     */
    public void navigateToApp() {
        try {
            driver.navigate().to(new URL(getAppUrl()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        isTextPresentOnPage("Home | E-commerce Website");
    }

    /**
     * Navigate to the Home page
     * @return
     */
    public HomePage navigateToHomePage() {
        clickLinkOrBtn(By.xpath(HOME_BUTTON_XPATH));
        return new HomePage(driver);
    }

    /**
     * Navigate to the Register page
     * @return
     */
    public RegisterPage navigateToRegisterPage() {
        clickLinkOrBtn(By.xpath(CREATE_AN_ACCOUNT_BUTTON_XPATH));
        return new RegisterPage(driver);
    }

    /**
     * Navigate to the Login page
     * @return
     */
    public LoginPage navigateToLoginPage() {
        clickLinkOrBtn(signInButton);
        return new LoginPage(driver);
    }

    /**
     * Log out
     * @return
     */
    public HomePage logOut() {
        clickLinkOrBtn(By.id(ACCOUNT_DROP_DOWN_BUTTON_ID));
        clickLinkOrBtn(By.xpath(LOGOUT_LINK_XPATH));
        return new HomePage(driver);
    }

    /**
     * Find the Account button
     */
    public boolean isAccountButtonVisible() {
        findElementBy(By.xpath(ACCOUNT_BUTTON_XPATH));
        return true;
    }

    /**
     * Navigate to the Profile page
     * @return
     */
    public ProfilePage navigateToProfilePage() {
        clickLinkOrBtn(By.id(ACCOUNT_DROP_DOWN_BUTTON_ID));
        clickLinkOrBtn(By.xpath(PROFILE_LINK_XPATH));
        return new ProfilePage(driver);
    }

    /**
     * Navigate to the Orders paga
     * @return
     */
    public OrdersPage navigateToOrdersPage() {
        clickLinkOrBtn(By.id(ACCOUNT_DROP_DOWN_BUTTON_ID));
        clickLinkOrBtn(By.xpath(MY_ORDERS_LINK_XPATH));
        return new OrdersPage(driver);
    }

    /**
     * Search for a product
     * @param productName
     * @return
     */
    public ProductsPage searchForProduct(String productName) {
        enterTextIntoTextBox(By.xpath(SEARCH_INPUT_XPATH), productName);
        clickLinkOrBtn(By.xpath(SEARCH_BUTTON_XPATH));
        return new ProductsPage(driver);
    }
}
