package com.jay.selenium.simple;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Uses the template information from the browsers.json file and run various tests based on those information
 *
 * Source: https://bonigarcia.dev/selenium-jupiter/
 *
 */
public class SimpleTestWithScreenshots {


    @RegisterExtension
    static SeleniumJupiter seleniumJupiter = new SeleniumJupiter();


    @BeforeAll
    static void beforeAll() {
        seleniumJupiter.getConfig().enableScreenshot();
        seleniumJupiter.getConfig().setOutputFolder("screenshots");
        seleniumJupiter.getConfig().takeScreenshotAsPng();
    }

    @BeforeEach
    void setUp() {

    }

    @Test
    void testInChrome(ChromeDriver driver) {

        driver.get("https://www.google.co.uk/");
        String title = driver.getTitle();
        Assertions.assertEquals("Google", title);
    }

}
