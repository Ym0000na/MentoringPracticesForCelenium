package Assignments.Day05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01OldStyleSelectMenu {

    WebDriver driver;
    String url = "https://demoqa.com/select-menu";
    By oldStyleSelectMenuById = By.id("oldSelectMenu");

    @Test
    void test() {



//    Launch browser
//    Open https://demoqa.com/select-menu
        driver.get(url);

//    Select Old Style Select Menu using element id
        WebElement dropdownElement = driver.findElement(oldStyleSelectMenuById);
        Select select = new Select(dropdownElement);

//    Print all dropdown options
        List<WebElement> options = select.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
        }

//    Select 'Purple' using index
        select.selectByIndex(4);
        System.out.println("Selected option by index 5: " + select.getFirstSelectedOption().getText());

//    Select 'Magenta' using visible text
        select.selectByVisibleText("Magenta");
        System.out.println("Selected option by visible text 'Magenta': " + select.getFirstSelectedOption().getText());

//    Select an option using value
        select.selectByValue("10");
        System.out.println("Selected option by value '10': " + select.getFirstSelectedOption().getText());

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
