package formytestautocomplete;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
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


public class AutocompleteTest {
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
    public void AutofillTest() throws InterruptedException {
        //1. Instantiate the driver
       // WebDriver driver = new ChromeDriver();
        //2. navigate to the URL
        driver.get("https://formy-project.herokuapp.com/autocomplete");
        //3. Find element //4. check the state   //must use "Duration.ofSeconds"
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //find the text input element by its 'name'
        WebElement autocomplete = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("autocomplete")));
        //use "click" first to activate field
       // name.click();
        //enter your input--the entire 'address' !!
        autocomplete.sendKeys("1125 SE 32nd St, Cape Coral, Fl 33904");
        //This needs to be added to give it time to load!!!
        Thread.sleep(1000);
        //locate 'drop down' to submit input--- this className is 'pac-item'
        WebElement autocompleteResult = driver.findElement(By.className("pac-container"));
        autocompleteResult.click();
        //test complete
       // driver.quit();
    }
}
