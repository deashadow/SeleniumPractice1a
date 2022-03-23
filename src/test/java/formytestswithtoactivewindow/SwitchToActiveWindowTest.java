package formytestswithtoactivewindow;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Switch window page on formy--"open new tab"
public class SwitchToActiveWindowTest {
    WebDriver driver;
    //This method will run once before all the tests in our class
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test //new tab button!!
    public void activeWindowTest()  {
        //1. Instantiate the driver
       // WebDriver driver = new ChromeDriver();
        //2. navigate to the URL
        driver.get("https://formy-project.herokuapp.com/switch-window");
        //3. Find element //4. check the state   //must use "Duration.ofSeconds"
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //find the text input element by its 'name'
        WebElement newTabButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("new-tab-button")));
        newTabButton.click(); //this will open new tab(window)

        //use ".getWindowHandle" to be able to obtain original window ID!!
        String originalHandle = driver.getWindowHandle();
        //create a for loop with iterate between the 2 opened tabs(windows)
        for (String handle1: driver.getWindowHandles()) {
            driver.switchTo().window(handle1);//this will get tab(window) 2
        }

        driver.switchTo().window(originalHandle);

        //test complete
        driver.quit();
    }
}

