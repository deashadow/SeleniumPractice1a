package explicitwait;

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



public class AutoCompleteExplicitWaitTest {
    //1. Instantiate the driver at Class level
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

        //2. navigate to the URL
        driver.get("https://formy-project.herokuapp.com/autocomplete");
        //3. Find element //4. check the state   //must use "Duration.ofSeconds"
        //This is an Explicit Wait!!!!
        WebDriverWait wait = new WebDriverWait(driver, 8);
        //find the text input element by its 'name'
        WebElement autocomplete = wait.until(
                //   ExpectedConditions.visibilityOfElementLocated();
                ExpectedConditions.presenceOfElementLocated(By.id("autocomplete")));
        //enter your input--the entire 'address' !!
        autocomplete.sendKeys("1125 SE 32nd St, Cape Coral, Fl 33904");

        //locate 'drop down' to submit input--- this className is 'pac-container'
        //This is an Explicit Wait!!!
        WebElement autocompleteResult = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.className("pac-container")));
        autocompleteResult.click();
        //test complete
        // driver.quit();
    }
}
