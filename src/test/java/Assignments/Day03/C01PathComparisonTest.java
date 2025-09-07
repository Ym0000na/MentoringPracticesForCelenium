package Assignments.Day03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01PathComparisonTest {

    WebDriver driver;
    String url = "https://opensource-demo.orangehrmlive.com/";

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }

    // Navigate to: https://opensource-demo.orangehrmlive.com/

    // TODO: Locate username using absolute XPath
    String absoluteUsernameXPath = "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"; // Fill absolute path

    // TODO: Locate username using relative XPath
    String relativeUsernameXPath = "//input[@name='username']"; // Fill relative path

    // TODO: Locate password using both methods
    String absolutePasswordXPath = "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"; // Fill absolute path
    String relativePasswordXPath = "//input[@name='password']";

    // TODO: Locate login button using both methods
    String absoluteLoginButtonXPath = "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"; // Fill absolute path
    String relativeLoginButtonXPath = "//button[@type='submit']";

    // TODO: Test both approaches work

    @Test
    void relativeXpathTest() {

        driver.findElement(By.xpath(relativeUsernameXPath)).sendKeys("Admin");
        driver.findElement(By.xpath(relativePasswordXPath)).sendKeys("admin123");
        driver.findElement(By.xpath(relativeLoginButtonXPath)).click();
    }

    @Test
    void absoltuXpathTest() {

        driver.findElement(By.xpath(absoluteUsernameXPath)).sendKeys("Admin");
        driver.findElement(By.xpath(absolutePasswordXPath)).sendKeys("admin123");
        driver.findElement(By.xpath(absoluteLoginButtonXPath)).click();

    }
}
