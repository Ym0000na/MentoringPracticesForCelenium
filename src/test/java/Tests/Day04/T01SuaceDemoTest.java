package Tests.Day04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class T01SuaceDemoTest {
    WebDriver driver;
    String url = "https://www.saucedemo.com/";
    By userName = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");

    @Test
    void test() {
 //    Given: Go to https://www.saucedemo.com/
        driver.get(url);
//    When: Enter username as "standard_user"
        driver.findElement(userName).sendKeys("standard_user");

//    And: Enter password as "secret_sauce"
        driver.findElement(password).sendKeys("secret_sauce");
//    And: Click login button
        driver.findElement(loginButton).click();

//    And: Order products by "Price (low to high)"
        WebElement dropdown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Price (low to high)");

//    Then: Assert last product costs $49.99, first product costs $7.99
        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));

        String firstPrice = prices.get(0).getText();
        Assertions.assertEquals("$7.99", firstPrice);

        String lastPrice = prices.getLast().getText();
        Assertions.assertEquals("$49.99", lastPrice);

        System.out.println("First Price: " + firstPrice);
        System.out.println("Last Price: " + lastPrice);


    }


@BeforeEach
void setUp () {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();

}

    @AfterEach
    void tearDown () {
        driver.quit();
    }
}
