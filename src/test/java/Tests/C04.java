import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04 {
    public static void main(String[] args) {

    
    // Go to the w3school URL : https://www.w3schools.com/
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.w3schools.com/");
// Print the position and size of the page. 
// Adjust the position and size of the page as desired. 
// Test that the page is in the position and size you want. // Close the page.
}
}