package Assignments.Day02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class C07Junit03 {

    WebDriver driver;

//    Task 3: Browser Size and Position
//    Setup:
//    Open Chrome in @BeforeEach.
//            Test 1:
//    Navigate to https://www.bbc.com/.
//    Set browser size to 800x600 and assert the window size.
//            Test 2:
//    Move the window to position (100, 100) and assert its position.
//    Teardown:
//    Close the browser.


    @Test
    void Test01() {
        driver.navigate().to("https://www.bbc.com/");
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(800, 600));
        Assertions.assertTrue(driver.manage().window().getSize().getWidth() == 800 &&
                driver.manage().window().getSize().getHeight() == 600, "Window size is not 800x600");
    }

    @Test
    void Test02() {
        driver.navigate().to("https://www.bbc.com/");
        driver.manage().window().setPosition(new org.openqa.selenium.Point(100, 100));
        Assertions.assertTrue(driver.manage().window().getPosition().getX() == 100 &&
                driver.manage().window().getPosition().getY() == 100, "Window position is not (100,100)");
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();

    }
}
