package com.ecommerce.selenium.tests;

import com.ecommerce.selenium.steps.EcommerceWebsiteSteps;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.ecommerce.selenium.tags.EcommerceWebsiteTags.REGISTRATION;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(TestListener.class)
@DisplayName("Registration Tests")
public class RegistrationTest extends EcommerceWebsiteSteps {

    @Tag(REGISTRATION)
    @Test
    @DisplayName("Create a new customer account")
    void registerUser() {
        Faker faker = new Faker();

        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String confirmPassword = password;

        navigateToApp();
        navigateToRegisterPage();
        createCustomerAccount(name, email, password, confirmPassword);

        assertTrue(isLoginHeadingVisible());
    }
}
