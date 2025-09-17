package Tests.Day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04 {
    public static void main(String[] args) {

    
    // Go to the w3school URL : https://www.w3schools.com/
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.w3schools.com/");


        // Print the position and size of the page
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());


        // Adjust the position and size of the page as desired.
        driver.manage().window().setPosition(new org.openqa.selenium.Point(200, 200));
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(600, 600));



        // Test that the page is in the position and size you want. // Close the page.
        driver.close();
        driver.quit();
        //
}
}