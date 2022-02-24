package google;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;
import java.time.Duration;

public class GoogleTest {
    WebDriver driver;

    //This method will run once before all the tests in our class
    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void googleElement() {
        //1. Instantiate the driver
       // WebDriver driver = new ChromeDriver();
        //2. navigate to the URL
        driver.get("https://www.google.com/");
        //3. Find element //4. check the state   //must use "Duration.ofSeconds"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       //find the text input element by its 'name'
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.name("q")));
        //Enter something to search for
        element.sendKeys("Cheese!");
        //Now submit the form
        element.submit();
        //5. take action //6. record the result
        assertTrue(element.isDisplayed());
        //7. quit the driver
        driver.quit();
    }
 /*   @Test
    public void cypressTest() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://example.cypress.io");
        Thread.sleep(3000);
        driver.quit();
    } */
}