package schedulebee;

import allytests.AmazonAllyTest;
import com.deque.axe.AXE;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.URL;

public class FDMGroupAllyTest {
    //Softassert will continue execution!!!
    SoftAssert softAssert = new SoftAssert();
    WebDriver driver;
    private static final URL scriptUrl = FDMGroupAllyTest.class.getResource("/axe.min.js");

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //  "https://www.ea.com/sports"
        driver.get("https://www.fdmgroup.com"); //problem with Amazon site??? and schedule-bee!!!
    }

    @Test
    public void fdmGroupAllyTest() {
        //this will analyze particular application(scriptUrl)
        JSONObject responseJson = new AXE.Builder(driver, scriptUrl).analyze();
        //store 'violations' in variable
        JSONArray violations = responseJson.getJSONArray("violations");

        if (violations.length() == 0) {
            System.out.println("Current report has no errors");
        } else {
            AXE.writeResults("fdmGroupAllyTest", responseJson);
            softAssert.assertTrue(false, AXE.report(violations));
        }

        softAssert.assertAll();

    }

    /*
        Test a specific selector or selectors
     */
    @Test
    public void testAccessibilityWithSelectorTest () {
        //this will analyze particular application(scriptUrl)
        JSONObject responseJson = new AXE.Builder(driver, scriptUrl).include("title").analyze();
        //store 'violations' in variable
        JSONArray violations = responseJson.getJSONArray("violations");

        if (violations.length() == 0) {
            System.out.println("Current report has no errors");
        } else {
            AXE.writeResults("testAccessibilityWithSelectorTest", responseJson);
            softAssert.assertTrue(false, AXE.report(violations));
        }

        softAssert.assertAll();

    }

    @Test
    public void testAccessibilityWithWebElementTest () {
        //this will analyze particular application(scriptUrl)
        JSONObject responseJson = new AXE.Builder(driver, scriptUrl)
                .analyze(driver.findElement(By.linkText("Learn more")));
        //store 'violations' in variable
        JSONArray violations = responseJson.getJSONArray("violations");

        if (violations.length() == 0) {
            System.out.println("Current report has no errors");
        } else {
            AXE.writeResults("testAccessibilityWithWebElementTest", responseJson);
            softAssert.assertTrue(false, AXE.report(violations));
        }

        softAssert.assertAll();

    }

        @AfterMethod
        public void tearDown () {
            driver.quit();
        }

    }

