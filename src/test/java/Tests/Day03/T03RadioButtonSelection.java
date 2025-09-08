package Tests.Day03;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

/*
    Task: Navigate to "https://demoqa.com/radio-button"
        . Create a test that:

        Attempts to select each radio button (Yes, Impressive, No)
        Prints whether each option is enabled/disabled
        For enabled options, select them and verify selection
        Print confirmation message for each successful selection
    */

public class T03RadioButtonSelection {
    WebDriver driver;
    String url = "https://demoqa.com/radio-button";
    @Test
    void testRadioButtonSelection() {
        driver.get(url);

        WebElement yesLabel = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        WebElement yesInput = driver.findElement(By.id("yesRadio"));

        WebElement impressiveLabel = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        WebElement impressiveInput = driver.findElement(By.id("impressiveRadio"));

        WebElement noLabel = driver.findElement(By.xpath("//label[@for='noRadio']"));
        WebElement noInput = driver.findElement(By.id("noRadio"));

        yesLabel.click();
        if (yesInput.isEnabled()) {
            System.out.println("Yes radio button is selected.");
        } else {
            System.out.println("Yes radio button is not selectable.");
        }

        impressiveLabel.click();
        if (impressiveInput.isEnabled()) {
            System.out.println("Impressive radio button is selected.");
        } else {
            System.out.println("Impressive radio button is not selectable.");
        }

        noLabel.click();
        if (noInput.isEnabled()) {
            System.out.println("No radio button is selected.");
        } else {
            System.out.println("No radio button is not selectable.");
        }

        }

        @BeforeEach
        void setUp () {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

        }

        @AfterEach
        void tearDown () {
            driver.quit();
        }
    }
