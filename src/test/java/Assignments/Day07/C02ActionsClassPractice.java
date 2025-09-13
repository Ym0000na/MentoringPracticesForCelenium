package Assignments.Day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilitites.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C02ActionsClassPractice extends TestBase {

    @Test
    void name() {


// Go to https://claruswaysda.github.io/submit-button.html
        driver.get("https://claruswaysda.github.io/submit-button.html");

// Click on submit
        driver.findElement(By.id("submitButton")).click();

// Verify link contains 'actionsClickDrag' Used a Method from Selenium user guide
        Object[] windowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
        String title=driver.getCurrentUrl();
        System.out.println("title = " + title);
        Assertions.assertTrue(title.contains("actionsClickDrag"),"Title does not contain 'actionsClickDrag'");

// Drag 'Drag me' to 'Drop here'
       Actions action = new Actions(driver);
       action
                .dragAndDrop(driver.findElement(By.id("drag1")),driver.findElement(By.id("drop1")))
                .pause(1000)
                .perform();
        assertEquals("Item successfully dropped!",driver.findElement(By.id("dragSuccessMessage")).getText());


// Right-click on 'Right-click' me
         action
                .contextClick(driver.findElement(By.id("showSuccessButton")))
                .pause(1000)
                .perform();
        assertEquals("Button right-clicked!",driver.findElement(By.id("rightClickSuccessMessage")).getText());


// Double-click on 'Double-click me'
            action
                    .doubleClick(driver.findElement(By.id("doubleClickButton")))
                    .pause(1000)
                    .perform();
        assertEquals("Button double-clicked!",driver.findElement(By.id("doubleClickSuccessMessage")).getText());


// Hover on 'Hover over me'
            action
                    .moveToElement(driver.findElement(By.id("hoverButton")))
                    .pause(1000)
                    .perform();
        assertEquals("Button hovered!",driver.findElement(By.id("hoverSuccessMessage")).getText());


// Verify all actions' success messages.
        //it's done in each step above


    }
}
