package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06JunitTest02 {
    // Go to google homepage
    WebDriver driver;
    String url = "https://www.google.com/";
// Do the following tasks by creating 3 different test methods.
// Print "Tests are starting to run" before each test() method
    @BeforeEach
    void setUp(){
        System.out.println("Tests are starting to run");

         driver = new ChromeDriver();

         driver.get(url);
    }

// Print "Tests have finished running" after each test() method
    @AfterEach
    void tearDown(){
        System.out.println("Tests have finished running");
        driver.quit();
    }



// Test if the title is the same when the page window is maximize and minimize
// Test if the title does not contain "Video" when the page window is fullscreen
// Test if the URL contains "google"

    @Test
    void test01(){
        //photo in phone
    }
}
