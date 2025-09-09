package Assignments.Day05;

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

public class C02MultiSelectOperations {

    WebDriver driver;
    String url = "https://demoqa.com/select-menu";
    By multiSelectById = By.id("cars");

    @Test
    void test() {
        //    Launch browser
//    Open https://demoqa.com/select-menu
        driver.get(url);

//    Select Standard Multi-Select using element id
        WebElement carsElements = driver.findElement(multiSelectById);
        Select select = new Select(carsElements);

//    Verify element is multi-select
        System.out.println("Is the dropdown multi-select? " + select.isMultiple());
        Assertions.assertTrue(select.isMultiple());

//    Select 'Opel' using index, then deselect using index
        select.selectByIndex(2);
        System.out.println("Selected option by index 2: " + select.getFirstSelectedOption().getText());

        select.deselectByIndex(2);
        Boolean isDeselected = select.getAllSelectedOptions().isEmpty();//Just to make sure option is deselected
        System.out.println("Is option deselected? " + isDeselected);

//    Select 'Saab' using value, then deselect using value
        select.selectByValue("saab");
        System.out.println("Selected option by value 'saab': " + select.getFirstSelectedOption().getText());

        select.deselectByValue("saab");
        isDeselected = select.getAllSelectedOptions().isEmpty();//Just to make sure option is deselected
        System.out.println("Is option deselected? " + isDeselected);

//    Deselect all options
        //It's already done after each selection above...

//    Close browser
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
