package Assignments.Day06;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilitites.TestBase;

public class C02MultipleiFrames extends TestBase {


    @Test
    void name() {


//Go to URL: http://demo.guru99.com/test/guru99home/
        driver.get("http://demo.guru99.com/test/guru99home/");

//1. Find the number of iframes on the page
        int numberOfIframes = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iframes on the page: " + numberOfIframes);

//2. Switch to the second iframe (JMeter Made Easy)
        driver.switchTo().frame(1);

 //3. Click the link (https://www.guru99.com/live-selenium-project.html)
        driver.findElement(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']")).click();

//4. Exit the iframe and return to the main page
        driver.switchTo().defaultContent();

    }
}
