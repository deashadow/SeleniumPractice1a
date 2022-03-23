package allytests;

import com.deque.axe.AXE;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.URL;

public class AmazonAllyTest {
    SoftAssert softAssert = new SoftAssert();
    WebDriver driver;
    private static final URL scriptUrl =    AmazonAllyTest.class.getResource("/axe.min.js");

    @BeforeMethod
    public  void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com"); //problem with Amazon site???
    }

   @Test
   public void amazonAllyTest(){
        //this will analyze particular application(scriptUrl)
       JSONObject responseJson =  new AXE.Builder(driver, scriptUrl).analyze();
       //store 'violations' in variable
       JSONArray violations = responseJson.getJSONArray("violations");

       if (violations.length() == 0) {
           System.out.println("Current report has no errors");
       }
       else {
           AXE.writeResults("amazonAllyTest", responseJson);
           softAssert.assertTrue(false, AXE.report(violations));
       }

       softAssert.assertAll();
   }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
