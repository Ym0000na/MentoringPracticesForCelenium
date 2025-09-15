package Tests.Day06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilitites.TestBase;

import java.util.Set;

public class T03CookieManagement extends TestBase {
    @Test
    void name() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

//        Go to https://claruswaysda.github.io/CookiesWait.html
        driver.get("https://claruswaysda.github.io/CookiesWait.html");

//        Accept the alert if it is present
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
            driver.findElement(By.id("acceptCookiesButton")).click();
        } catch (Exception e) {
            // No alert present, continue
        }

//        Print the cookies
        System.out.println("-------------All Cookies------------");
        Set<Cookie> cookieSet = driver.manage().getCookies();
        cookieSet.forEach(System.out::println);

//        Delete all cookies and assert
        driver.manage().deleteAllCookies();
        Set<Cookie> cookieSet02 = driver.manage().getCookies(); // get cookies after deletion
        Assertions.assertTrue(cookieSet02.isEmpty());
        System.out.println("-------------All Cookies after deleting------------");
        cookieSet02.forEach(System.out::println);


    }
}
