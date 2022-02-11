package com.jay.selenium.simple;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

/**
 * Selenium Webdriver testing
 * <p>
 * Example for XPath element lookup
 */
@ExtendWith(SeleniumJupiter.class)
public class BBCTest {


    @ParameterizedTest
    @ValueSource(classes = {ChromeDriver.class, FirefoxDriver.class})
    void testInChrome(Class<? extends WebDriver> webDriverClass) {

        WebDriver webDriver = WebDriverManager.getInstance(webDriverClass).create();
        validate(webDriver);
    }



    private void validate(WebDriver driver) {
        driver.get("https://www.bbc.co.uk/");

        String title = driver.getTitle();
        Assertions.assertEquals("BBC - Home", title);

        String xpath_header1 = "//*[@id=\"header-content\"]/div[3]/div/div/div/div/div";
        String xpath_header2 = "/html/body/div/div/header/div[3]/div/div/div/div/div";
        WebElement heading = driver.findElement(By.xpath(xpath_header1));
        Assertions.assertEquals("Welcome to the BBC", heading.getText());
    }

}
