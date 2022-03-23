package formytestscroll;

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


public class ScrollToElementTest {
    WebDriver driver;
    //This method will run once before all the tests in our class
    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test
    public void scrollTest()  {
        //1. Instantiate the driver
       // WebDriver driver = new ChromeDriver();
        //2. navigate to the URL
        driver.get("https://formy-project.herokuapp.com/scroll");
        //3. Find element //4. check the state   //must use "Duration.ofSeconds"
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //find the text input element by its 'name'
        WebElement name = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("name")));
        //use "Actions" to be able to move to location!!
        Actions actions = new Actions(driver);
        //Use the newly created object "actions" to moveToElement!!
        actions.moveToElement(name); //use the element created in line 34!!!
        //Now you can sendKeys to it!!
        name.sendKeys("Ronald Rendessy");

        //Create a new WebElement "date"
        WebElement date = driver.findElement(By.id("date"));
        //sendKeys!!
        date.sendKeys("02/22/2022");
        //test complete

        driver.quit();
    }
}
