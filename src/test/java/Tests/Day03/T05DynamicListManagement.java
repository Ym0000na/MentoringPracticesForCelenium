package Tests.Day03;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

/*
    Task:  Go to "http://webdriveruniversity.com/To-Do-List/index.html" and create a test that:

            Uses Faker to generate 5 random task names
            Adds all tasks to the todo list
            Marks every other task as completed (strikethrough)
            Deletes all completed tasks
            Verifies only incomplete tasks remain
    */
public class T05DynamicListManagement {

    WebDriver driver;
    String url = "http://webdriveruniversity.com/To-Do-List/index.html";

    @Test
    void test() {

        Faker faker = new Faker();
        driver.get(url);
        String task1= faker.lorem().word();
        String task2= faker.lorem().word();
        String task3= faker.lorem().word();
        String task4= faker.lorem().word();
        String task5= faker.lorem().word();

        driver.findElement(By.xpath("//input[@placeholder='Add new todo']")).sendKeys(task1+ Keys.ENTER);
        driver.findElement(By.xpath("//input[@placeholder='Add new todo']")).sendKeys(task2+ Keys.ENTER);
        driver.findElement(By.xpath("//input[@placeholder='Add new todo']")).sendKeys(task3+ Keys.ENTER);
        driver.findElement(By.xpath("//input[@placeholder='Add new todo']")).sendKeys(task4+ Keys.ENTER);
        driver.findElement(By.xpath("//input[@placeholder='Add new todo']")).sendKeys(task5+ Keys.ENTER);

        List <WebElement> tasks = driver.findElements(By.xpath("//li"));
        for (int i = 0; i < 3; i++) {
                tasks.get(i).click();
        }

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
