package Assignments.Day07;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilitites.TestBase;

public class C06DropdownHandling extends TestBase {

    @Test
    void name() {


//        Go to https://claruswaysda.github.io/Dropdowns.html
        driver.get("https://claruswaysda.github.io/Dropdowns.html");

//        In 1. Traditional Dropdown select 'Ford'
        WebElement trad = driver.findElement(By.id("carSelect"));
        Select tradSelect = new Select(trad);
        tradSelect.selectByValue("Ford");

//        In 2. Multi-Select Dropdown select 'Mercedes'
        WebElement multi = driver.findElement(By.id("multiCarSelect"));
        Select multiSelect = new Select(multi);
        multiSelect.selectByValue("Mercedes");

//        In 3. Custom Dropdown (Bootstrap-like) select 'BMW'
        WebElement customClick = driver.findElement(By.id("customDropdown"));
        customClick.click(); // open dropdown
        WebElement custom = driver.findElement(By.xpath("//div[text()='BMW']"));
        custom.click();

//        In 4. Static Auto-Suggest Dropdown select 'Tesla Model 3'
        WebElement staticInput = driver.findElement(By.id("staticInput"));
        staticInput.sendKeys("Tesla Model 3");

//        In 5. Dynamic Auto-Suggest Dropdown select 'Toyota'
        WebElement dynamicAuto = driver.findElement(By.id("dynamicInput"));
        dynamicAuto.sendKeys("Toyota");
    }
}
