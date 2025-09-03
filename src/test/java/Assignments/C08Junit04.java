package Assignments;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C08Junit04 {

    static WebDriver driver;

//    Task 4: Multiple Navigation and Verification
//    Setup:
//    Launch Chrome and maximize in @BeforeEach.
//            Test 1:
//    Navigate Google → YouTube → LinkedIn.
//    Assert titles contain "Google", "YouTube", "LinkedIn" respectively.
//            Test 2:
//    Navigate back twice and assert the URL of Google.
//    Navigate forward twice and assert URL of LinkedIn.
//            Teardown:
//    Use @AfterAll to quit the browser.


    @Test
    void Test01() {
        driver.navigate().to("https://www.google.com/");
        Assertions.assertTrue(driver.getTitle().contains("Google"), "Title does not contain 'Google'");

        driver.navigate().to("https://www.youtube.com/");
        Assertions.assertTrue(driver.getTitle().contains("YouTube"), "Title does not contain 'YouTube'");

        driver.navigate().to("https://www.linkedin.com/");
        Assertions.assertTrue(driver.getTitle().contains("LinkedIn"), "Title does not contain 'LinkedIn'");
    }

    @Test
    void Test02() {
        driver.navigate().back();
        driver.navigate().back();
        Assertions.assertTrue(driver.getCurrentUrl().contains("google"), "URL does not contain 'Google'");

        driver.navigate().forward();
        driver.navigate().forward();
        Assertions.assertTrue(driver.getCurrentUrl().contains("linkedin"), "URL does not contain 'LinkedIn'");
    }

    @BeforeAll
    static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();

    }
}
