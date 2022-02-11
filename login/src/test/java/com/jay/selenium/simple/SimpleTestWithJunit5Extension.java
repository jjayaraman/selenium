package com.jay.selenium.simple;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

@ExtendWith(SeleniumJupiter.class)
public class SimpleTestWithJunit5Extension {


    @Test
    void testInChrome(ChromeDriver driver) {

        driver.get("https://www.google.co.uk/");
        String title = driver.getTitle();
        Assertions.assertEquals("Google", title);
    }

    @Test
    void testInFirefox(FirefoxDriver driver) {

        driver.get("https://www.google.co.uk/");
        String title = driver.getTitle();
        Assertions.assertEquals("Google", title);
    }

    @Test
    void testInEdge(EdgeDriver driver) {

        driver.get("https://www.google.co.uk/");
        String title = driver.getTitle();
        Assertions.assertEquals("Google", title);
    }

    @Test
    void testInOpera(OperaDriver driver) {

        driver.get("https://www.google.co.uk/");
        String title = driver.getTitle();
        Assertions.assertEquals("Google", title);
    }
}
