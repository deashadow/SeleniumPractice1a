package com.deashadow.seleniumtests;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class SeleniumEdgeTest {
    //This method will run once before all of the tests in our class
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.edgedriver().setup();
    }
    @Test
    public void heroTest() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void cypressTest() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://example.cypress.io");
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void shoppingCartTest() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://react-shopping-cart-67954.firebaseapp.com");
        Thread.sleep(3000);
        driver.quit();
    }

  /*  @Test
    public void scheduleBeeTest() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://schedule-bee.com");
        Thread.sleep(3000);
        driver.quit();
    } */

}