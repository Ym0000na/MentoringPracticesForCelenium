package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C06Homework02 {
    public static void main(String[] args) {

        //Invoke Firefox Browser
        WebDriver driver = new FirefoxDriver();


        //Go to https://www.youtube.com/
        driver.navigate().to("https://www.youtube.com/");


        //Verify if the page title contains "video"
        String title = driver.getTitle();
        if (title.contains("video")) {
            System.out.println("Title contains the word 'video': Test Passed");
        } else {
            System.out.println("Title does not contain the word 'video': Test Failed");
        }
        //close the driver
        driver.close();

    }
}
