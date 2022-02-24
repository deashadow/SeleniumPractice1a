package com.deashadow.seleniumtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HelloSeleniumTest {
    WebDriver driver;

    //This method will run once before all the tests in our class
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        //test complete
        driver.quit();
    }
    @Test
    public void smarterTest()
    {
       // WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
      //  driver.quit();
    }
}

