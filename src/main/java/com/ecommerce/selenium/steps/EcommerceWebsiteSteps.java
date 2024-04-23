package com.ecommerce.selenium.steps;

import com.ecommerce.selenium.driver.DriverManager;
import com.ecommerce.selenium.pages.BasePage;
import com.ecommerce.selenium.pages.admin.AdminHomePage;
import com.ecommerce.selenium.pages.common.HomePage;
import com.ecommerce.selenium.pages.common.LoginPage;
import com.ecommerce.selenium.pages.common.ProductsPage;
import com.ecommerce.selenium.pages.common.ProfilePage;
import com.ecommerce.selenium.pages.customer.CustomerHomePage;
import com.ecommerce.selenium.pages.customer.OrdersPage;
import com.ecommerce.selenium.pages.customer.RegisterPage;
import io.qameta.allure.Step;

public class EcommerceWebsiteSteps extends DriverManager {
    private BasePage basePage = new BasePage(getDriver());
    private HomePage homePage = new HomePage(getDriver());
    private RegisterPage registerPage = new RegisterPage(getDriver());
    private LoginPage loginPage = new LoginPage(getDriver());
    private ProfilePage profilePage = new ProfilePage(getDriver());
    private OrdersPage ordersPage = new OrdersPage(getDriver());
    private ProductsPage productsPage = new ProductsPage(getDriver());

    /**
     ================================================================
     * BASE PAGE STEPS
     ================================================================
     */

    @Step("Navigate to the E-commerce Website")
    public void navigateToApp() {
        basePage.navigateToApp();
    }

    @Step("Navigate to the Home page")
    public HomePage navigateToHomePage() {
        return basePage.navigateToHomePage();
    }

    @Step("Navigate to the Register page")
    public RegisterPage navigateToRegisterPage() {
        return basePage.navigateToRegisterPage();
    }

    @Step("Navigate to the Login page")
    public LoginPage navigateToLoginPage() {
        return basePage.navigateToLoginPage();
    }

    @Step("Logout")
    public HomePage logOut() {
        return basePage.logOut();
    }

    @Step("Navigate to the Profile page")
    public ProfilePage navigateToProfilePage() {
        return basePage.navigateToProfilePage();
    }

    @Step("Check if the Account button is visible")
    public boolean isAccountButtonVisible() {
        return basePage.isAccountButtonVisible();
    }

    @Step("Navigate to the Orders page")
    public OrdersPage navigateToOrdersPage() {
        return basePage.navigateToOrdersPage();
    }

    @Step("Search for a product: {0}")
    public ProductsPage searchForProduct(String productName) {
        return basePage.searchForProduct(productName);
    }


    /**
     ================================================================
     * LOGIN PAGE STEPS
     ================================================================
     */

    @Step("Log in as an admin with email: {0} and password: {1}")
    public AdminHomePage adminLogin(String email, String password) {
        return loginPage.adminLogin(email, password);
    }

    @Step("Log in as a customer with email: {0} and password: {1}")
    public CustomerHomePage customerLogin(String email, String password) {
        return loginPage.customerLogin(email, password);
    }

    @Step("Navigate to the Register page via link")
    public RegisterPage navigateToRegisterPageLink() {
        return loginPage.navigateToRegisterPage();
    }

    @Step("Get the error message about no login data provided")
    public String getNoLoginDataProvidedMessage() {
        return loginPage.getNoLoginDataProvidedMessage();
    }

    @Step("Get the error message about invalid login credentials")
    public String getInvalidLoginMessage() {
        return loginPage.getInvalidLoginMessage();
    }


    /**
     ================================================================
     * REGISTER PAGE STEPS
     ================================================================
     */
}
