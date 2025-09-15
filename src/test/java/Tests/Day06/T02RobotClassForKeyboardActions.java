package Tests.Day06;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import utilitites.TestBase;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class T02RobotClassForKeyboardActions extends TestBase {

    @Test
    void name() throws AWTException {

//        Go to https://claruswaysda.github.io/downloadUpload.html
        driver.get("https://claruswaysda.github.io/downloadUpload.html");

//        Click on 'Upload'
        WebElement upload = driver.findElement(By.xpath("//label[.//text()[normalize-space()='Upload']]"));
        Robot robot = new Robot();
        robot.setAutoDelay(500);
        Point point = upload.getLocation();
        int x = point.getX();
        int y = point.getY();
        robot.mouseMove( x+100, y+150);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

//        Close the opening page using 'CTRL+F4'
        robot.keyPress(KeyEvent.VK_CONTROL); // Windows users
        robot.keyPress(KeyEvent.VK_F4); // Windows users
        robot.keyRelease(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }
}
