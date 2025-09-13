package Tests.Day05;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilitites.TestBase;

public class T02Action02 extends TestBase {
    @Test
    void name() {

//Go to https://claruswaysda.github.io/iframe.html
        driver.get("https://claruswaysda.github.io/iframe.html");
//Type your name in input
        Faker faker = new Faker();
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(faker.name().fullName());

//Click on 'Bold' button
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//button[@aria-label='Bold']")).click();

//Assert the alert message
        String alertMsg = driver.switchTo().alert().getText();
        System.out.println("Alert Message: " + alertMsg);
        driver.switchTo().alert().accept();

    }
}
