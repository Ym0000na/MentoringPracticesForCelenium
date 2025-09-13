package Tests.Day05;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class T03DeleteChar extends utilitites.TestBase {
    @Test
    void name() {
        By delete = By.id("deletedMessage");

//Go to https://claruswaysda.github.io/deleteChars.html
        driver.get("https://claruswaysda.github.io/deleteChars.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//Enter your full name
        Faker faker = new Faker();
        driver.findElement(By.id("inputText")).sendKeys(faker.name().fullName());

//Delete the letters
        driver.findElement(By.id("enterButton")).click();

        while ( !driver.findElement(delete).isDisplayed()) {
            driver.findElement(By.id("deleteButton")).click();
        }
//Verify the message 'Deleted'
        wait.until(ExpectedConditions.visibilityOfElementLocated(delete));
        System.out.println(driver.findElement(delete).getText());

    }
}
