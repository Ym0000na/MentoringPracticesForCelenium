package Assignments.Day04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02CheckboxInteraction {
    WebDriver driver;
    String url = "https://the-internet.herokuapp.com/checkboxes";

    /*
    Task: Go to "https://the-internet.herokuapp.com/checkboxes"
.   Write a method that:

    Checks the current state of both checkboxes
    Ensures both checkboxes are selected (click only if not already selected)
    Verify both checkboxes are checked after the operations
    Print the status of each checkbox to console */

    @Test
    void test() {
        driver.get(url);

        WebElement checkbox1 = driver.findElement(org.openqa.selenium.By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(org.openqa.selenium.By.xpath("//input[@type='checkbox'][2]"));
        if (!checkbox1.isSelected()) {
            System.out.println("Checkbox 1 is not selected. Selecting it now.");
            checkbox1.click();
        }else{
            System.out.println("Checkbox 1 is already selected.");
        }
        if (!checkbox2.isSelected()) {
            System.out.println("Checkbox 2 is not selected. Selecting it now.");
            checkbox2.click();
        }else{
            System.out.println("Checkbox 2 is already selected.");
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

