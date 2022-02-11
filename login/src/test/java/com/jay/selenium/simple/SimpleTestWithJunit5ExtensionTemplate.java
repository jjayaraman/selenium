package com.jay.selenium.simple;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

/**
 * Uses the template information from the browsers.json file and run various tests based on those information
 *
 * @author Jayakumar Jayaraman
 */
@ExtendWith(SeleniumJupiter.class)
public class SimpleTestWithJunit5ExtensionTemplate {


    @TestTemplate
    void testInChrome(WebDriver driver) {

        driver.get("https://www.google.co.uk/");
        String title = driver.getTitle();
        Assertions.assertEquals("Google", title);
    }

}
