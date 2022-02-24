package implicitwait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class AutoCompleteImplicitWaitTest {
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
    public void AutofillTest()  {
        //1. Instantiate the driver
        // WebDriver driver = new ChromeDriver();
        //2. navigate to the URL
        driver.get("https://formy-project.herokuapp.com/autocomplete");
        //3. Find element //4. check the state   //must use "Duration.ofSeconds"
        //This is an Explicit Wait!!!!
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //find the text input element by its 'name'
        WebElement autocomplete = wait.until(
             //   ExpectedConditions.visibilityOfElementLocated();
                ExpectedConditions.presenceOfElementLocated(By.id("autocomplete")));
        //use "click" first to activate field
        // name.click();
        //enter your input--the entire 'address' !!
        autocomplete.sendKeys("1125 SE 32nd St, Cape Coral, Fl 33904");
        //This is alternative to Thread.sleep!!! Implicit!!  no exception...
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //locate 'drop down' to submit input--- this className is 'pac-item'
        WebElement autocompleteResult = driver.findElement(By.className("pac-container"));
        autocompleteResult.click();
        //test complete
        // driver.quit();
    }
}
