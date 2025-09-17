package Tests.Day09;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilitites.TestBase02;

import java.util.List;

public class T02CalculateTableTotal extends TestBase02 {


    @Test
    void name() {

//        Go to https://claruswaysda.github.io/webTable.html
        driver.get("https://claruswaysda.github.io/webTable.html");
        logger.info("claruswaysda web site is opened....");

//        Calculate and assert the total price in Table 2.
        List<WebElement> priceList1 = driver.findElements(By.xpath("//table[2]//td[3]"));

        List<Integer> priceList2 = priceList1.stream()
                .map(e -> Integer.parseInt(e.getText().replace("$", "")))
                .toList();

        int sum = 0;
        for(int i = 0; i<priceList2.size(); i++){
            sum+=priceList2.get(i);
        }
        System.out.println("sum = " + sum);
        String sumS= sum +"";
        Assertions.assertEquals(sumS,"2275");


    }
}
