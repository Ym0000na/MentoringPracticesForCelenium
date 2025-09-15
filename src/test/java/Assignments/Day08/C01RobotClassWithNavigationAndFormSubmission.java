package Assignments.Day08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilitites.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C01RobotClassWithNavigationAndFormSubmission extends TestBase {


    @Test
    void name() throws AWTException {
        Robot robot = new Robot();

//* Open a demo login page (e.g. https://the-internet.herokuapp.com/login).
        driver.get("https://the-internet.herokuapp.com/login");

// * Click into the username field.
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

//* Type the username using sendKeys.
        driver.findElement(By.id("username")).sendKeys("tomsmith");

//* Use the Robot class to:
//  * Press Tab → go to password field.
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

//  * Type the password using sendKeys.
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");

//  * Press Enter → submit the form.
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

//* Verify login success or error message.
        //it should print error msg because username is wrong
        Assertions.assertTrue(driver.findElement(By.id("flash")).isDisplayed());
    }
}
