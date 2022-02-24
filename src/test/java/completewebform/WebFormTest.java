package completewebform;

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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class WebFormTest {
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
        driver.get("https://formy-project.herokuapp.com/form");
        //3. Find element //4. check the state   //must use "Duration.ofSeconds"
        //This is an Explicit Wait!!!!
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        //find the text input element by its 'name'
        driver.findElement(By.id("first-name")).sendKeys("Tony");

        driver.findElement(By.id("last-name")).sendKeys("Stark");

        driver.findElement(By.id("job-title")).sendKeys("Arms Dealer");

        driver.findElement(By.id("radio-button-2")).click();

        driver.findElement(By.id("checkbox-1")).click();
        //now is a 'select menu' use css !!
        driver.findElement(By.cssSelector("option[value='1']")).click();

        driver.findElement(By.id("datepicker")).sendKeys("06/06/2025");
        //Then need to close the DatePicker!!!!
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);
        //----------------Do not forget the 'dots' for the class!!!!
        driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();

        //This is an Explicit Wait!!!
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        //This is an Explicit Wait!!!
        WebElement alert = wait1.until(ExpectedConditions.visibilityOfElementLocated
                (By.className("alert")));
        String alertText = alert.getText();
        assertEquals("The form was successfully submitted!", alertText);
       //either one works!!
        // assertTrue(alert.isDisplayed());
        //test complete
        // driver.quit();
    }
}
