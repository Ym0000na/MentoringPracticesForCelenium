package Assignments;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class C03Celenium03 {
    public static void main(String[] args) {


        //Go to the Amazon URl: https://www.amazon.com/
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.com/");


        // Print the position and size of the page
        Point position = driver.manage().window().getPosition();
        Dimension size = driver.manage().window().getSize();
        System.out.println("Initial Position: " + position);
        System.out.println("Initial Size: " + size);


        //Adjust the position and size of the page as desired.
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(800, 600));


        // Test that the page is in the position and size you want.
        Point newPosition = driver.manage().window().getPosition();
        Dimension newSize = driver.manage().window().getSize();
        if(newPosition == position)
            System.out.println("Position is correct!");
        else
            System.out.println("Position is incorrect!");
        if(newSize == size)
            System.out.println("Size is correct!");
        else
            System.out.println("Size is incorrect!");


        // Close the page.
        driver.close();
        driver.quit();
    }
}
