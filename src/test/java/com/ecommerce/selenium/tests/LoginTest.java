package com.ecommerce.selenium.tests;

import com.ecommerce.selenium.steps.EcommerceWebsiteSteps;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Login Tests")
public class LoginTest extends EcommerceWebsiteSteps {
    @Test
    @DisplayName("Log in to the app with valid customer credentials")
    @Description("Log in to the app as a customer")
    void doLogin() {
        navigateToApp();
        navigateToLoginPage();
        customerLogin("bochenek@test.com", "pass1234!A");

        assertTrue(isAccountButtonVisible());
    }

    @Test
    @DisplayName("A customer cannot log in with invalid credentials")
    void invalidLogin() {
        navigateToApp();
        navigateToLoginPage();
        customerLogin("test@test.com", "test");

        assertEquals("Invalid email or password", getInvalidLoginMessage());
    }
}
