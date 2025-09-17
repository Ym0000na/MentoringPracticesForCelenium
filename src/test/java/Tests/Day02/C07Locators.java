package Tests.Day02;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07Locators {

    static WebDriver driver;
    static String url = "https://www.linkedin.com/login";
    static String testEmail = "0e96c80fb1@webxios.pro";
    static String testPass = "Test1234!";

    @BeforeAll
    public static void setUp() {
// TODO: Initialize WebDriver
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // add wait implicitly 10s

// TODO: Navigate to LinkedIn
        driver.get(url);
    }
    @Test
    public void testLoginElements() {

// TODO: Locate email field using By.id
        By emailById = By.id("username");

// TODO: Locate password field using By.name
        By passwordByName = By.name("session_password");

// TODO: Locate sign-in button using By.xpath
        By signInByXpath = By.xpath("//button[@type='submit']");

// TODO: Enter test credentials
        WebElement emailField = driver.findElement(emailById);
        emailField.sendKeys(testEmail);

        WebElement passField = driver.findElement(passwordByName);
        passField.sendKeys(testPass);

        WebElement signInButton = driver.findElement(signInByXpath);


// TODO: Verify elements are displayed
        Assertions.assertTrue(emailField.isDisplayed());
        Assertions.assertTrue(passField.isDisplayed());
        Assertions.assertTrue(signInButton.isDisplayed());

        signInButton.click();
    }
    @AfterAll
    public static void tearDown() {
// TODO: Close driver
        if (driver != null) {
            driver.quit();
        }

    }
}