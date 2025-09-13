package Assignments.Day06;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilitites.TestBase;
public class C01jQueryEmojiPicker extends TestBase{

    @Test
    void name() {

//Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

//1. Maximize the website
        //Already done in TestBase class

//2. Click on the second emoji
        driver.switchTo().frame(driver.findElement(By.id("emoojis")));
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

//3. Click on all second emoji items
        driver.findElement(By.xpath("//img[@alt='\uD83D\uDC27']")).click();

//4. Return to the parent iframe
        driver.switchTo().defaultContent();

        //5. Fill out the form and press the apply button
        Faker faker = new Faker();
        driver.findElement(By.id("text")).sendKeys(faker.book().title());
        driver.findElement(By.id("smiles")).sendKeys("");
        driver.findElement(By.id("nature")).sendKeys("Fun");
        driver.findElement(By.id("food")).sendKeys("Burger");
        driver.findElement(By.id("activities")).sendKeys("Swimming");
        driver.findElement(By.id("places")).sendKeys("Antarctica");
        driver.findElement(By.id("objects")).sendKeys("Antarctica");
        driver.findElement(By.id("symbols")).sendKeys("Antarctica");
        driver.findElement(By.id("flags")).sendKeys("Antarctica");
    }
}
