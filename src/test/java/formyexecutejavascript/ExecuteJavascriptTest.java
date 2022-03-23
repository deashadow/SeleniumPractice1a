package formyexecutejavascript;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Switch window page on formy--"open new tab"
public class ExecuteJavascriptTest {
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
    public void javascriptTest()  {
        //1. Instantiate the driver
        //WebDriver driver = new ChromeDriver();
        //2. navigate to the URL
        driver.get("https://formy-project.herokuapp.com/modal");
        //3. Find element //4. check the state   //must use "Duration.ofSeconds"--Not Working
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //find the text input element by its 'id'
        WebElement modelButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("modal-button")));
        modelButton.click(); //this will open the 'alert prompt'

        WebElement closeButton = driver.findElement(By.id("close-button"));
        //use the JavascriptExecutor now!!
        JavascriptExecutor js = (JavascriptExecutor) driver;
                             //this will simulate an actual 'click'
        js.executeScript("arguments[0].click()", closeButton);
        //test complete
       // driver.quit();
    }
}
