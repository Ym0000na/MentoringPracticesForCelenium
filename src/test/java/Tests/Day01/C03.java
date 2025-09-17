package Tests.Day01;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.com");

        // Expected Title
        String title = "Amazon";
        System.out.println("Title: " + title);
// Set Path of the Chrome driver

//        String path = driver.getCurrentUrl();

// Maximize Window
        driver.manage().window().maximize();
// Get Title of current Page 
        String realTitel = driver.getTitle();
        System.out.println("Real Titel: "+realTitel);
// Validate/Compare Page Title 
        if(realTitel.equals(title)){
            System.out.println("Titel is correct!!");
        }else{
            System.out.println("You're wrong :(");
        }
// Close Browser
    }
}
