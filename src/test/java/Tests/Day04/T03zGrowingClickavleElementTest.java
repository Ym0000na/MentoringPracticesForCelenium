package Tests.Day04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class T03zGrowingClickavleElementTest {

    WebDriver driver;
    String url = "https://testpages.herokuapp.com/styled/challenges/growing-clickable.html";

    //using xpath bcs it have different class value before and after growing.
    By clickMeButton = By.xpath("//button[@class= 'styled-click-button showgrow grown']");
    By eventTriggeredText = By.id("growbuttonstatus");


    @Test
    void test() {
//    Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
        driver.get(url);

        Wait<WebDriver> wait = new FluentWait<>(driver);

//    Click "click me" button
        wait.until(ExpectedConditions.elementToBeClickable(clickMeButton)).click();
//    you can use this solution with id rather than xpath
//        wait.until(ExpectedConditions.attributeToBe(eventTriggeredText,"class","styled-click-button showgrow grown"));
//        driver.findElement(eventTriggeredText).click();

//    Verify "Event Triggered" appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(eventTriggeredText));
        Assertions.assertEquals("Event Triggered", driver.findElement(eventTriggeredText).getText());
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
