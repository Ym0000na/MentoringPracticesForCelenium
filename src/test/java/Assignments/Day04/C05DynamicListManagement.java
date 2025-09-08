package Assignments.Day04;

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

public class C05DynamicListManagement {

    WebDriver driver;
    String url = "http://webdriveruniversity.com/To-Do-List/index.html";

     /*
    Task:  Go to "http://webdriveruniversity.com/To-Do-List/index.html" and create a test that:

            Uses Faker to generate 5 random task names
            Adds all tasks to the todo list
            Marks every other task as completed (strikethrough)
            Deletes all completed tasks
            Verifies only incomplete tasks remain
    */

    @Test
    void test() throws InterruptedException {

        Faker faker = new Faker();
        driver.get(url);

        List<WebElement> tasks = driver.findElements(By.xpath("//li"));

        for(int i=0;i<5;i++){
            driver.findElement(By.xpath("//input[@placeholder='Add new todo']"))
                    .sendKeys( "Buy " + faker.food().ingredient()+ Keys.ENTER);
        }


        for (int i = 0; i < tasks.size(); i++) {
            tasks.get(i).click();
        }

        if(!driver.findElements(By.xpath("//li[@class='completed']")).isEmpty()){
            List<WebElement> completedTasks = driver.findElements(By.xpath("//li[@class='completed']"));
            for (int i= 0; i < completedTasks.size(); i++) {

                driver.findElement(By.xpath(".//i[@class='fa fa-trash']")).click();
            }
        }


        List<WebElement> incompleteTasks = driver.findElements(By.xpath("//li[not(contains(@class, 'completed'))]"));
        for (WebElement task : incompleteTasks) {
            Thread.sleep(3000);
            System.out.println("Task: " + task.getText() + " is not completed.");
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
