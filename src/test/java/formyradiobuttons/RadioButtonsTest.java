package formyradiobuttons;

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


public class RadioButtonsTest {
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
    public void radioButtonTest() throws InterruptedException {
        //1. Instantiate the driver
        // WebDriver driver = new ChromeDriver();
        //2. navigate to the URL
        driver.get("https://formy-project.herokuapp.com/radiobutton");
        //3. Find element //4. check the state   //must use "Duration.ofSeconds"
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //find the text input element by its 'name'
        WebElement radioButton1 = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("radio-button-1")));
        //use "click" first to activate field
         radioButton1.click();
         //This needs to be added to give it time to load!!!
        Thread.sleep(1000);
        //locate 'drop down' to submit input--- this className is 'pac-item'
        WebElement radioButton2 = driver.findElement(By.cssSelector("input[value='option2']"));
        radioButton2.click();
        //This needs to be added to give it time to load!!!
        Thread.sleep(1000);
        WebElement radioButton3 = driver.findElement(By.xpath("/html/body/div/div[3]/input")); //Right click over element to get xpath
        radioButton3.click();

        //test complete
        // driver.quit();
    }
}
