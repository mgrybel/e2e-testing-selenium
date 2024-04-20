package com.ecommerce.selenium.tests;

import static com.ecommerce.selenium.utilities.PropKey.PORT;
import static com.ecommerce.selenium.utilities.PropKey.URL;

import static org.assertj.core.api.Assertions.assertThat;

import com.ecommerce.selenium.driver.DriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("E-commerce Website Tests")
@DisplayNameGeneration(DisplayNameGenerator.Standard.class)
public class MyFirstTest extends DriverManager {
    @Test
    @DisplayName("My first test")
    void test() {
        String url = prop.getProperty(URL.getPropVal());
        String port = prop.getProperty(PORT.getPropVal());
        String finalUrl = url + port;

        driver.get(finalUrl);
        String title = driver.getTitle();

        // Verify
        assertThat(title).isEqualTo("E-commerce Website");
    }
}
