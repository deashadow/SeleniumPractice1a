package formycheckboxes;

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


public class CheckBoxesTest {
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
    public void checkBoxesTest() throws InterruptedException {
        //1. Instantiate the driver
        // WebDriver driver = new ChromeDriver();
        //2. navigate to the URL
        driver.get("https://formy-project.herokuapp.com/checkbox");
        //3. Find element //4. check the state   //must use "Duration.ofSeconds"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //find the text input element by its 'name'
        WebElement checkBox1 = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("checkbox-1")));
        //use "click" first to activate field
        checkBox1.click();
        //This needs to be added to give it time to load!!!
        Thread.sleep(1000);
        //locate 'drop down' to submit input--- this className is 'pac-item'
        WebElement checkBox2 = driver.findElement(By.id("checkbox-2"));
        checkBox2.click();
        //This needs to be added to give it time to load!!!
        Thread.sleep(1000);
        WebElement checkBox3 = driver.findElement(By.xpath("//*[@id=\"checkbox-3\"]")); //Right click over element to get xpath
        checkBox3.click();

        //test complete
        // driver.quit();
    }
}
