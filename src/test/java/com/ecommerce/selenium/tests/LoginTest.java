package com.ecommerce.selenium.tests;

import com.ecommerce.selenium.steps.EcommerceWebsiteSteps;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.ecommerce.selenium.tags.EcommerceWebsiteTags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(TestListener.class)
@DisplayName("Login Tests")
public class LoginTest extends EcommerceWebsiteSteps {
    @Tag(SMOKE)
    @Test
    @DisplayName("Log in to the app with valid customer credentials")
    @Description("Log in to the app as a customer")
    void doLogin() {
        navigateToApp();
        navigateToLoginPage();
        customerLogin("customer@test.com", "test123");

        assertTrue(isAccountButtonVisible());
    }

    @Test
    @DisplayName("A customer cannot log in with invalid credentials")
    void invalidLogin() {
        navigateToApp();
        navigateToLoginPage();
        customerLogin("test@test.com", "test123");

        assertEquals("Invalid email or password", getInvalidLoginMessage());
    }
}
