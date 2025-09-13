package Tests.Day05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilitites.TestBase;

public class T04StarryNight extends TestBase {
    int add = 5;
    int delete = 3;

    @Test
    void name() {

//        Go to https://claruswaysda.github.io/addDeleteStar.html
        driver.get("https://claruswaysda.github.io/addDeleteStar.html");

//        Create a method to add given number of stars
        addStars(add);
        
//        Create a method to delete given numbers of stars
        deleteStars(delete);

//        Create a method to verify the given number of stars deleted
        verifyStars();
    }

    private void verifyStars() {
        int expectedStars = add - delete;
        int actualStars = driver.findElements(By.xpath("//div[@class='star']")).size();
        System.out.println("Expected Stars: " + expectedStars);
        System.out.println("Actual Stars: " + actualStars);
        Assertions.assertEquals(expectedStars, actualStars);
    }

    private void deleteStars(int i) {
        for (int j = 0; j < i; j++) {
            driver.findElement(By.id("delete-button")).click();
        }
    }

    private void addStars(int i) {
        for (int j = 0; j < i; j++) {
            driver.findElement(By.id("push-button")).click();
        }
    }
}
