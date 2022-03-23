package formytestopenalert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Switch window page on formy--"open new tab"
public class SwitchToAlertTest {
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

    @Test //new tab button!!
    public void alertTest()  {
        //1. Instantiate the driver
       // WebDriver driver = new ChromeDriver();
        //2. navigate to the URL
        driver.get("https://formy-project.herokuapp.com/switch-window");
        //3. Find element //4. check the state   //must use "Duration.ofSeconds"
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //find the text input element by its 'name'
        WebElement alertButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("alert-button")));
        alertButton.click(); //this will open the 'alert prompt'

        //use to switch attention to the alert now!!
        Alert alert = driver.switchTo().alert();
        alert.accept(); //this accepts and clicks on the 'ok' to close alert!!!


        //test complete
      //  driver.quit();
    }
}
