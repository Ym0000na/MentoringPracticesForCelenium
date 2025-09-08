package Tests.Day03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

/*
    Task: Create a test method that opens a browser with the following configurations:
    Maximize window on startup
    Disable extensions
    Run in incognito mode
    Disable infobars Navigate to "https://www.example.com" and verify the title contains "Example"
     */

public class T01ChromeOptionsConfigurationTest {

    WebDriver driver;
    String url = "https://www.example.com";

    @Test
    void test() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Maximize window on startup
        options.addArguments("--disable-extensions"); // Disable extensions
        options.addArguments("--incognito"); // Run in incognito mode
        options.addArguments("disable-infobars"); // Disable infobars
        driver = new ChromeDriver(options);
        driver.get(url);
        String title = driver.getTitle();
        if (title.contains("Example")) {
            System.out.println("Title contains the word 'Example': Test Passed");
        } else {
            System.out.println("Title does not contain the word 'Example3': Test Failed");
        }
    }

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }


}
