package Assignments;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05Junit01 {

//    Task 1: Browser History Exploration
//    Setup:
//    Use @BeforeEach to launch Chrome and maximize.
//    Test 1:
//    Navigate to https://www.wikipedia.org/.
//    Navigate to https://www.google.com/.
//    Navigate back and forward multiple times, asserting the correct title at each step.
//    Test 2:
//    Use driver.navigate().refresh() on Google and assert the title still contains "Google".
//    Teardown:
//    Use @AfterEach to close the browser.

    WebDriver driver;


    @Test
    void Test01() {
        // Navigate to Wikipedia
        driver.navigate().to("https://www.wikipedia.org/");
        String wikiTitle = driver.getTitle();
        System.out.println("Wikipedia Title: " + wikiTitle);

        // Navigate to Google
        driver.navigate().to("https://www.google.com/");
        String googleTitle = driver.getTitle();
        System.out.println("Google Title: " + googleTitle);

        // Navigate back to Wikipedia
        driver.navigate().back();
        Assertions.assertEquals(driver.getTitle(), wikiTitle, "Failed to navigate back to Wikipedia");

        // Navigate forward to Google
        driver.navigate().forward();
        Assertions.assertEquals(driver.getTitle(), googleTitle , "Failed to navigate forward to Google");

        // Navigate back to Wikipedia again
        driver.navigate().back();
        Assertions.assertEquals(driver.getTitle(), wikiTitle, "Failed to navigate back to Wikipedia");

        // Navigate forward to Google again
        driver.navigate().forward();
        Assertions.assertEquals(driver.getTitle(), googleTitle , "Failed to navigate forward to Google");
    }


    @Test
    void Test02() {
        driver.navigate().to("https://www.google.com/");
        driver.navigate().refresh();
        Assertions.assertTrue(driver.getTitle().contains("Google"), "Title does not contain 'Google' after refresh");
    }

    @BeforeEach
    void setUp() {
        // Initialize the Chrome driver and maximize the window
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        }

}
