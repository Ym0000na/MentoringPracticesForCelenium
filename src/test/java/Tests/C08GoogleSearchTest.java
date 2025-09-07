package Tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08GoogleSearchTest {

    static WebDriver driver;
    @BeforeAll
    public static void setUp() {

// TODO: Initialize static WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // add wait

// TODO: Navigate to Google
        driver.get("https://www.google.com/");
    }
    @Test
    public void searchMovies() {
        String[] movies = {"Green Mile","Premonition","The Curious Case of Benjamin Button"};

        for(String movie : movies) {

// TODO: Find search box
        driver.findElement(By.xpath("//textarea[@class='gLFyf']"));

// TODO: Clear and enter movie name
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).clear();
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys(movie);

// TODO: Submit search
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).submit();

// TODO: Get and print result count

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String resultStats = driver.findElement(By.xpath("//div[@id='result-stats']")).getText();
        System.out.println("Search results for '" + movie + "': " + resultStats);

// TODO: Clear search box for next iteration
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).clear();

        }
    }
    @AfterAll
    public static void tearDown() {
// TODO: Close driver
        driver.quit();
    }
}
