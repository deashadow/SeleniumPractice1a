package formydatepicker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class DatePickerTest {
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
    public void datePickerTest() throws InterruptedException {
        //1. Instantiate the driver
        // WebDriver driver = new ChromeDriver();
        //2. navigate to the URL
        driver.get("https://formy-project.herokuapp.com/datepicker");
        //3. Find element //4. check the state   //must use "Duration.ofSeconds"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //find the text input element by its 'id'
        WebElement dateField = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("datepicker")));
        //use sendKeys to just select a future date
        dateField.sendKeys("06/03/2022");
        //This needs to be added to give it time to load!!!
        Thread.sleep(1000);
        //Then need to close the DatePicker
        dateField.sendKeys(Keys.RETURN);

        //test complete
        // driver.quit();
    }
}
