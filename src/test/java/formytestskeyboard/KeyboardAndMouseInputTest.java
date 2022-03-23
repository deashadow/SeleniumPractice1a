package formytestskeyboard;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class KeyboardAndMouseInputTest {
     WebDriver driver;

    //This method will run once before all the tests in our class
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test
    public void keyBAndMouseTest()
    {
        //1. Instantiate the driver
       // WebDriver driver = new ChromeDriver();
        //2. navigate to the URL
        driver.get("https://formy-project.herokuapp.com/keypress");
        //3. Find element //4. check the state   //must use "Duration.ofSeconds"
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //find the text input element by its 'name'
        WebElement name = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("name")));
       //use "click" first to activate field
        name.click();
       //enter your input
        name.sendKeys("Ron Rendessy");
        //locate 'button' to submit input
        WebElement button = driver.findElement(By.id("button"));
        button.click();
        //test complete

        driver.quit();
    }
}
