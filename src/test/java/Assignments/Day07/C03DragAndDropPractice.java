package Assignments.Day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilitites.TestBase;

public class C03DragAndDropPractice extends TestBase {

    @Test
    void name() {

        //    Go to https://claruswaysda.github.io/dragAndDrop.html
        driver.get("https://claruswaysda.github.io/dragAndDrop.html");

//    Drag the items in their right places
        Actions action = new Actions(driver);
        action
                .dragAndDrop(driver.findElement(By.id("piece1")), driver.findElement(By.id("slot1")))
                .pause(1000)
                .dragAndDrop(driver.findElement(By.id("piece2")), driver.findElement(By.id("slot2")))
                .pause(1000)
                .dragAndDrop(driver.findElement(By.id("piece3")), driver.findElement(By.id("slot3")))
                .pause(1000)
                .perform();

//    Assert the success message
        Assertions.assertTrue(driver.findElement(By.id("celebrate")).isDisplayed());

    }
}