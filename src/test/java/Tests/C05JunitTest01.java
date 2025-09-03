package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05JunitTest01 {

    // Go to YouTube homepage



// Do the following tasks by creating 4 different test methods.
// Print "Test is running" before each test() method
// Print "Test finished" after each test() method
// Test if the currentURL contains "youtube"
// Test if the title does not contain "Video".
// Test if the URL contains "youtube".
// Test if the sourcePage contains "youtube"

    static WebDriver driver;
    @Test
    void urlTest() {
        System.out.println("current url cintains youtube test is running.... ");
        String url = driver.getCurrentUrl();
        Assertions.assertTrue(url.contains("youtube"));
    }

    @Test
    void  titleTest() {
        String title = driver.getTitle();
        Assertions.assertFalse(title.contains("Video"));
    }

    @Test
    void pageSourceTest01() {
        System.out.println("page source test is running.... ");
        String pageSource = driver.getPageSource();
        Assertions.assertTrue(pageSource.contains("youtube"));

    }

    @BeforeEach
     void beforreEach() {
        System.out.println("Test is running");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.youtube.com/");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Test finished");
        driver.quit();
    }


}
