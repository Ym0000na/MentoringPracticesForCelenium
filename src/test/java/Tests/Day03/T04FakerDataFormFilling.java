package Tests.Day03;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T04FakerDataFormFilling {

    WebDriver driver;
    String url = "https://demoqa.com/text-box";

    /*
       Task: Go to "https://demoqa.com/text-box"
           . Use Java Faker to:

       */


    @Test
    void fakerTest() {
        driver.get("https://demoqa.com/text-box");
        Faker faker = new Faker();

//        Generate and enter a fake full name
        String name = faker.name().fullName();
        System.out.println("Name: " + name);
        driver.findElement(By.id("userName")).sendKeys(name);

//      Generate and enter a fake email address
        String email = faker.internet().emailAddress();
        System.out.println("Email: " + email);
        driver.findElement(By.id("userEmail")).sendKeys(email);

//        Generate and enter a fake current address
        String currentAddress = faker.address().fullAddress();
        System.out.println("Address: " + currentAddress);
        driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);

//        Generate and enter a fake permanent address
        String permanentAddress = faker.address().fullAddress();
        System.out.println("Permanent Address: " + permanentAddress);
        driver.findElement(By.id("permanentAddress")).sendKeys(permanentAddress);

//        Submit the form and verify the output contains the entered data
        driver.findElement(By.id("submit")).click();

        WebElement output = driver.findElement(By.id("output"));
        Assertions.assertTrue(driver.findElement(By.xpath("//p[@class='mb-1'][1]")).getText().equals(name));

    }


    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
