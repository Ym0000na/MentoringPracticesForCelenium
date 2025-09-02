package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05Homework01 {
    //create main method
    public static void main(String[] args) {

        //Create chrome driver
        WebDriver driver = new ChromeDriver();


        //Open google home page https://www.google.com/
        driver.navigate().to("https://www.google.com/");


        //Get title on page
        String title = driver.getTitle();
        System.out.println("Title: " + title);


        //get current URL on page
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);


        //close/quit the browser
        driver.close();
        driver.quit();
    }
}
