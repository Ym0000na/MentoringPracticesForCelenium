package Tests.Day06;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilitites.TestBase;

public class T01JavaScriptExecutorwithElementStyling extends TestBase {

    @Test
    void name() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        Go to https://claruswaysda.github.io/signIn.html
        driver.get("https://claruswaysda.github.io/signIn.html");

//        enter username 'admin'
        String username = "admin";
        WebElement user = driver.findElement(By.id("username"));
        highlight(user);
        js.executeScript("document.getElementById('username').value = arguments[0];", username);

//        enter password '123'
        String password = "123";
        WebElement pass = driver.findElement(By.id("password"));
        highlight(pass);
        js.executeScript("document.getElementById('password').value = arguments[0];", password);

//        Click on Sign In
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        highlight(loginButton);
        js.executeScript("arguments[0].click();", loginButton);

//        Assert the 'Employee Table' is visible
        WebElement table = driver.findElement(By.id("employeeTable"));
        highlight(table);
        Assertions.assertTrue(driver.findElement(By.id("employeeTable")).isDisplayed());

//        Create a method to change border color and style of web elements.
//        Use the method on each element you interact with.
    }

    void highlight(WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String color = element.getCssValue("backgroundColor");
        for (int i = 0; i < 10; i++) {
            js.executeScript("arguments[0].style.backgroundColor='#FFFF00'", element);
            js.executeScript("arguments[0].style.border = '3px solid #ff0000';", element);            Thread.sleep(10);
        }
    }
}
