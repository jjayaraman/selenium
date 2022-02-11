package com.jay.selenium.simple;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class MultipleBrowsersTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @ParameterizedTest
    @ValueSource(classes = {ChromeDriver.class, FirefoxDriver.class, EdgeDriver.class, OperaDriver.class})
    void testManyBrowsers(Class<? extends WebDriver> webDriverClass) {

        driver = WebDriverManager.getInstance(webDriverClass).create();
        driver.get("https://www.google.co.uk/");

        String title = driver.getTitle();
        Assertions.assertEquals("Google", title);

    }
}
