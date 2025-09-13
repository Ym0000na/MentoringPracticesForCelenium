package Assignments.Day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilitites.TestBase;

import java.util.Iterator;
import java.util.Set;

public class C01WindowHandlePractice extends TestBase {

    @Test
    void name() {

// Go to https://claruswaysda.github.io/
        driver.get("https://claruswaysda.github.io/");
        String mainWindow = driver.getWindowHandle();

// Click on Window Handle
        driver.findElement(By.linkText("Window Handle")).click();
        String nowHandle = driver.getWindowHandle();

// Click on 'Open Index Page'

        //This is the best way I found for switching between handles from selenium user guide
        Object[] firstWindowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) firstWindowHandles[1]);
        driver.findElement(By.id("openIndex")).click();


        Object[] secondWindowHandles2=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) secondWindowHandles2[2]);
        String title=driver.getCurrentUrl();
        System.out.println("title = " + title);


// Verify the link 'https://claruswaysda.github.io/index.html'
        String expectedUrl = "https://claruswaysda.github.io/index.html";
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);
        Assertions.assertEquals(expectedUrl, currentUrl, "URL did not match!");

    }
}
