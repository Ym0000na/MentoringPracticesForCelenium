package Tests.Day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02WindowsComments {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // Go to www.linkedIn.com
        driver.navigate().to("https://www.linkedIn.com");


        // Maximize Window
        driver.manage().window().maximize();


        // Go to www.amazon.com
        driver.navigate().to("https://www.amazon.com");


        // Maximize Window
        driver.manage().window().maximize();


        // Navigate Back
        driver.navigate().back();


        // Navigate Forward
        driver.navigate().forward();


        // Refresh The Page
        driver.navigate().refresh();


        driver.quit();

    }
}
