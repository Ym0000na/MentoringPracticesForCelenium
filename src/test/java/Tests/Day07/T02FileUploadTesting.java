package Tests.Day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilitites.TestBase;

import java.nio.file.Path;

public class T02FileUploadTesting extends TestBase {

    @Test
    void name() {

//        Go to https://claruswaysda.github.io/downloadUpload.html
        driver.get("https://claruswaysda.github.io/downloadUpload.html");

//        Upload a PDF using single upload button
        Path path = Path.of(System.getProperty("user.home"),"Downloads", "8_Lexical Semantic.pdf");
        driver.findElement(By.id("uploadInput")).sendKeys(path.toString());

//        Verify that 'Files uploaded successfully!'
        driver.findElement(By.className("submit-btn")).click();
        Assertions.assertTrue(driver.findElement(By.id("successBox")).isDisplayed());

//        Do negative test (No file or other than PDF)
        Path path02 = Path.of(System.getProperty("user.home"),"Downloads", "Screenshot (1).png");
        driver.findElement(By.id("uploadInput")).sendKeys(path02.toString());
        driver.findElement(By.className("submit-btn")).click();

//        Verify that 'Please upload at least one PDF file. Only PDF files are allowed!'
        Assertions.assertTrue(driver.findElement(By.id("alertBox")).isDisplayed());

//        Test multiple PDFs as well
        Path path03 = Path.of(System.getProperty("user.home"),"Downloads", "8_Lexical Semantic.pdf");
        Path path04 = Path.of(System.getProperty("user.home"),"Downloads", "13_MachineTranslation.pdf");
        driver.findElement(By.id("uploadInput")).sendKeys(path03.toString());
        driver.findElement(By.id("uploadInput")).sendKeys(path04.toString());
        driver.findElement(By.className("submit-btn")).click();
        Assertions.assertTrue(driver.findElement(By.id("successBox")).isDisplayed());

    }
}
