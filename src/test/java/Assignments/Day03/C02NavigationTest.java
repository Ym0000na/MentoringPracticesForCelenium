package Assignments.Day03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02NavigationTest {

    WebDriver driver;
    String url = "https://testpages.eviltester.com/styled/index.html";

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

    @Test
    public void testNavigation() throws InterruptedException {

// TODO: Navigate to test pages
        driver.get(url);

// TODO: Click on "Locators - Find By Playground Test Page"
        driver.findElement(By.id("findbytest")).click();

// TODO: Print current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

// TODO: Navigate back
        driver.navigate().back();

// TODO: Print URL after going back
        System.out.println("URL after going back: " + driver.getCurrentUrl());

// TODO: Click on "WebDriver Example Page"
        driver.findElement(By.id("webdriverexamplepage")).click();

// TODO: Print current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

// TODO: Enter value 20 in number input
        driver.findElement(By.id("numentry")).sendKeys("20");
        driver.findElement(By.id("submit-to-server")).click();
        Thread.sleep(3000); //Had to add sleep because of stale element exception


// TODO: Verify 'two, zero' message appears
        String expectedMessage = "two, zero";
        String actualMessage = driver.findElement(By.id("message")).getText();
        Assertions.assertEquals(expectedMessage, actualMessage, "The message does not match the expected value.");
    }
}
