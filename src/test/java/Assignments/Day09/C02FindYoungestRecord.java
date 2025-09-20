package Assignments.Day09;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilitites.TestBase;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class C02FindYoungestRecord extends TestBase {

    /*
 Go to https://claruswaysda.github.io/addRecordWebTable.html
 Add 10 records using Faker.
 Find the name of the youngest record.
 */

    @Test
    void name() {
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        Faker faker = new Faker();
        List<String> countries = Arrays.asList("USA", "Canada", "UK", "Australia", "Germany");
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            WebElement nameInput = driver.findElement(By.id("nameInput"));
            WebElement ageInput = driver.findElement(By.id("ageInput"));
            WebElement countryDropdown = driver.findElement(By.id("countrySelect"));
            WebElement addBtn = driver.findElement(By.xpath("//button[text()='Add Record']"));

            nameInput.clear();
            nameInput.sendKeys(faker.name().fullName());

            ageInput.clear();
            ageInput.sendKeys(faker.number().numberBetween(10,70)+"");

            new Select(countryDropdown).selectByValue(countries.get(random.nextInt(countries.size())));

            addBtn.click();
        }



//        Find the name of the youngest record.
        List<WebElement> age = driver.findElements(By.xpath("//table//tbody//td[2]"));
        List<Integer> ageList = age.stream()
                .map(e -> Integer.parseInt(e.getText()))
                .sorted()
                .toList();


        System.out.println("ageList = " + ageList);
        int youngestAge =  Collections.min(ageList);
        String youngest = youngestAge + "";
        System.out.println("youngestAge = " + youngestAge);



        String youngestName = "";
        for (int i = 1; i <= ageList.size(); i++) {
            String d = driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[2]")).getText();
            if(d.equals(youngest)) {
                youngestName = driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[1]")).getText();
                break; // stop at first youngest
            } else{
                continue;

            }
        }
        System.out.println("youngestName = " + youngestName);
    }
}
