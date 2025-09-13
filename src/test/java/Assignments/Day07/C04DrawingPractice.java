package Assignments.Day07;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilitites.TestBase;

public class C04DrawingPractice extends TestBase {
    By canvasId = By.id("myCanvas");


    @Test
    void name() {

//        Go to https://claruswaysda.github.io/Draw.html
        driver.get("https://claruswaysda.github.io/Draw.html");
        WebElement canvas = driver.findElement(canvasId);

//        Draw a triangle
        Actions action = new Actions(driver);
        action
                .dragAndDropBy(canvas, -100,200 )
                .pause(1000)
                .dragAndDropBy(canvas, 100,200 )
                .pause(1000)
                .perform();

        action.moveToElement(canvas, 0, 0)
                .moveByOffset(100, 200)    // bottom-right
                .clickAndHold()
                .moveByOffset(-200, 0)     // bottom-right → bottom-left
                .release()
                .perform();

//        Reset
        driver.findElement(By.id("resetButton")).click();
    }
}
