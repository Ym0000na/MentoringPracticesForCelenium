package Assignments.Day07;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilitites.TestBase;

public class C05FormHandlingWithJavaScriptExecutor extends TestBase {


    @Test
    void name() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

//        Go to https://claruswaysda.github.io/form.html
        driver.get("https://claruswaysda.github.io/form.html");

//        Create a method to flash the elements you are working on and use it.
        Faker faker = new Faker();
        String ssn = faker.idNumber().ssnValid();
        String fname = faker.name().firstName();
        String lname = faker.name().lastName();
        String address = faker.address().fullAddress();
        String phoneNum = faker.phoneNumber().cellPhone();
        String username = faker.name().username();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();


        WebElement ssnEle = driver.findElement(By.id("ssn"));
        WebElement fnameEle = driver.findElement(By.id("first-name"));
        WebElement lnameEle = driver.findElement(By.id("last-name"));
        WebElement addressEle = driver.findElement(By.id("address"));
        WebElement phoneNumEle = driver.findElement(By.id("phone"));
        WebElement usernameEle = driver.findElement(By.id("username"));
        WebElement emailEle = driver.findElement(By.id("email"));
        WebElement passwordEle = driver.findElement(By.id("password"));
        WebElement checkPassEle = driver.findElement(By.id("confirm-password"));


        flash(ssnEle);
        js.executeScript("document.getElementById('ssn').value = arguments[0];", ssn);

        flash(fnameEle);
        js.executeScript("document.getElementById('first-name').value = arguments[0];", fname);

        flash(lnameEle);
        js.executeScript("document.getElementById('last-name').value = arguments[0];",lname);

        flash(addressEle);
        js.executeScript("document.getElementById('address').value = arguments[0];",address);

        flash(phoneNumEle);
        js.executeScript("document.getElementById('phone').value = arguments[0];",phoneNum);

        flash(usernameEle);
        js.executeScript("document.getElementById('username').value = arguments[0];",username);

        flash(emailEle);
        js.executeScript("document.getElementById('email').value = arguments[0];",email);

        flash(passwordEle);
        js.executeScript("document.getElementById('password').value = arguments[0];",password);

        flash(checkPassEle);
        js.executeScript("document.getElementById('confirm-password').value = arguments[0];",password);


//        Register a user
        WebElement regButton = driver.findElement(By.className("button"));
        js.executeScript("arguments[0].click();", regButton);

//        Login
        WebElement loginButton = driver.findElement(By.className("login-button"));
        js.executeScript("arguments[0].click();", loginButton);
        js.executeScript("document.getElementById('username').value = arguments[0];", username);
        js.executeScript("document.getElementById('password').value = arguments[0];", password);
        WebElement loginButton02 = driver.findElement(By.xpath("//button[@type='submit']"));
        js.executeScript("arguments[0].click();", loginButton02);

//        Celebrate the login!
        WebElement celebrate = driver.findElement(By.id("clickMeButton"));
        js.executeScript("arguments[0].click();", celebrate);
    }

    void flash (WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String color = element.getCssValue("backgroundColor");
        for(int i=0; i<10; i++){
            js.executeScript("arguments[0].style.backgroundColor='#FFFF00'",element);
            Thread.sleep(10);
        }
    }
}
