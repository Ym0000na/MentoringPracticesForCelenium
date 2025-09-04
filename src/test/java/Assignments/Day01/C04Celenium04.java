package Assignments.Day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04Celenium04 {
    public static void main(String[] args) throws InterruptedException {

        //open Url https://www.google.com/
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");

        //Maximize the window
        driver.manage().window().maximize();


        //Print the position and size of the page
        Point position = driver.manage().window().getPosition();
        Dimension size = driver.manage().window().getSize();
        System.out.println("Initial Position: " + position);
        System.out.println("Initial Size: " + size);


        //Minimize the window
        driver.manage().window().minimize();


        //Wait for 5 seconds in the icon state and maximize the page
        Thread.sleep(5000);
        driver.manage().window().maximize();


        //Print the position and dimensions of the page in the maximized state
        Point maxPosition = driver.manage().window().getPosition();
        Dimension maxSize = driver.manage().window().getSize();
        System.out.println("Maximized Position: " + maxPosition);
        System.out.println("Maximized Size: " + maxSize);


        //make the page fullscreen
        driver.manage().window().fullscreen();


        //close the browser
        driver.quit();
    }
}
