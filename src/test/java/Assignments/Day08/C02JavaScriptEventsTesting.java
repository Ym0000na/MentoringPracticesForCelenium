package Assignments.Day08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilitites.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C02JavaScriptEventsTesting extends TestBase {
    @Test
    void name() throws AWTException, InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);
        Robot robot = new Robot();

//        Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

//        Click all the buttons and verify they are all clicked
        WebElement onblur =  driver.findElement(By.id("onblur"));
        actions
                .moveToElement(onblur)
                .pause(200)
                .click()
                .moveByOffset(50,50)
                .click()
                .perform();
        Assertions.assertTrue(driver.findElement(By.id("onblurstatus")).isDisplayed());


        WebElement onclick = driver.findElement(By.id("onclick"));
        js.executeScript("arguments[0].click();", onclick);
        Assertions.assertTrue(driver.findElement(By.id("onclickstatus")).isDisplayed());


        WebElement oncontextmenu = driver.findElement(By.id("oncontextmenu"));
        actions.contextClick(oncontextmenu).perform();
        //to close the context menu
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        Assertions.assertTrue(driver.findElement(By.id("oncontextmenustatus")).isDisplayed());


        WebElement ondoubleclick = driver.findElement(By.id("ondoubleclick"));
        actions
                .doubleClick(ondoubleclick)
                .perform();
        Assertions.assertTrue(driver.findElement(By.id("ondoubleclick")).isDisplayed());


        WebElement onfocus = driver.findElement(By.id("onfocus"));
        js.executeScript("arguments[0].focus();", onfocus);
        Assertions.assertTrue(driver.findElement(By.id("ondoubleclickstatus")).isDisplayed());


        WebElement onkeydown = driver.findElement(By.id("onkeydown"));
        onkeydown.click(); // give focus
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        Assertions.assertTrue(driver.findElement(By.id("onfocusstatus")).isDisplayed());


        WebElement onkeyup = driver.findElement(By.id("onkeyup"));
        onkeyup.click();
        robot.keyPress(KeyEvent.VK_UP);
        robot.keyRelease(KeyEvent.VK_UP);
        Assertions.assertTrue(driver.findElement(By.id("onkeydownstatus")).isDisplayed());

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(1000);

        WebElement onkeypress = driver.findElement(By.id("onkeypress"));
        onkeypress.click();
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_L);
        Assertions.assertTrue(driver.findElement(By.id("onkeyupstatus")).isDisplayed());


        WebElement onmouseover = driver.findElement(By.id("onmouseover"));
        actions
                .moveToElement(onmouseover)
                .pause(200)
                .perform();
        Assertions.assertTrue(driver.findElement(By.id("onkeypressstatus")).isDisplayed());


        WebElement onmouseleave = driver.findElement(By.id("onmouseleave"));
        actions.moveToElement(onmouseleave).perform();
        actions.pause(200).perform();
        actions.moveByOffset(50,50).perform();
        Assertions.assertTrue(driver.findElement(By.id("onmouseoverstatus")).isDisplayed());


        WebElement onmousedown = driver.findElement(By.id("onmousedown"));
        actions.clickAndHold(onmousedown).perform();
        Assertions.assertTrue(driver.findElement(By.id("onmouseleavestatus")).isDisplayed());


    }
}
