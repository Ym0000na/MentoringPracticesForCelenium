package Tests.Day05;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilitites.TestBase;

public class T1ActionsForm extends TestBase {
    @Test
    void name() {
        Faker faker = new Faker();
//        Go to https://claruswaysda.github.io/ActionsForm.html
        driver.get("https://claruswaysda.github.io/ActionsForm.html");

//        Fill the form
        driver.findElement(By.id("name")).sendKeys(faker.name().fullName());
        driver.findElement(By.id("age")).sendKeys(faker.number().numberBetween(18, 40)+"");
        Select department = new Select(driver.findElement(By.id("options")));
        department.selectByIndex(faker.number().numberBetween(1,4));
        driver.findElement(By.xpath("//input[@value='coding']")).click();
        driver.findElement(By.xpath("//input[@value='female']")).click();
        driver.findElement(By.xpath("//button[@type='button']")).click();

//        Generate Passcode
        String alertMsg = driver.switchTo().alert().getText();
        String passcode = alertMsg.substring(alertMsg.indexOf(":") + 2).trim();
        driver.switchTo().alert().accept();
        System.out.println("Passcode: " + passcode);

//        Use passcode to submit form
        driver.switchTo().alert().sendKeys(passcode);
        driver.switchTo().alert().accept();
    }
}
