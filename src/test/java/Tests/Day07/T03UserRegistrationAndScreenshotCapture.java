package Tests.Day07;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilitites.TestBase;
import org.apache.commons.io.FileUtils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class T03UserRegistrationAndScreenshotCapture extends TestBase {

    @Test
    void name() throws AWTException, IOException, InterruptedException {
        Robot robot = new Robot();

        Faker faker = new Faker();
        String ssn = faker.idNumber().ssnValid();
        String fname= faker.name().firstName();
        String lname = faker.name().lastName();
        String address = faker.address().fullAddress();
        String phoneNum = faker.phoneNumber().cellPhone();
        String username = faker.name().username();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

//        Go to https://claruswaysda.github.io/homepage.html
        driver.get("https://claruswaysda.github.io/homepage.html");

        TakesScreenshot ss = (TakesScreenshot) driver;
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd:HH-mm-ss"));

//        Register a user
        driver.findElement(By.className("fa-regular")).click();
        driver.findElement(By.linkText("Register")).click();

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        driver.findElement(By.id("ssn")).sendKeys(ssn);
        driver.findElement(By.id("first-name")).sendKeys(fname);
        driver.findElement(By.id("last-name")).sendKeys(lname);
        driver.findElement(By.id("address")).sendKeys(address);
        driver.findElement(By.id("phone")).sendKeys(phoneNum);
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("confirm-password")).sendKeys(password);


        File screenShot1 = ss.getScreenshotAs(OutputType.FILE);
        Path path1 = Path.of(System.getProperty("user.dir"), "screenshot", "lastScreenshot1.png" );
        FileUtils.copyFile(screenShot1, path1.toFile());
        Thread.sleep(3000);

        driver.findElement(By.className("button")).click();

//        Sign in with the registered user

        driver.findElement(By.className("login-button")).click();
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        File screenShot2 = ss.getScreenshotAs(OutputType.FILE);
        Path path2 = Path.of(System.getProperty("user.dir"), "screenshot", "lastScreenshot2.png");
        FileUtils.copyFile(screenShot2, path2.toFile());
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

//        Take all pages' screenshots
//        Take 'Celebrate Login' button's screenshot.
        Thread.sleep(3000);
        File screenShot3 = ss.getScreenshotAs(OutputType.FILE);
        Path path3 = Path.of(System.getProperty("user.dir"), "screenshot", "lastScreenshot3.png");
        FileUtils.copyFile(screenShot3, path3.toFile());

        Thread.sleep(3000);
        driver.findElement(By.id("clickMeButton")).click();
        File screenShot4 = ss.getScreenshotAs(OutputType.FILE);
        Path path4 = Path.of(System.getProperty("user.dir"), "screenshot", "lastScreenshot4.png");
        FileUtils.copyFile(screenShot4, path4.toFile());
        Thread.sleep(3000);
//        Capture a screenshot of the page with confetti
    }
}
