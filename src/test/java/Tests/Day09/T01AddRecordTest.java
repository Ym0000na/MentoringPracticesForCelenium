package Tests.Day09;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilitites.TestBase02;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;


public class T01AddRecordTest extends TestBase02 {


    @Test
    void name() {


//        Go to https://claruswaysda.github.io/addRecordWebTable.html
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        logger.info("claruswaysda web site is opened....");

//        Add 10 records.
        logger.info("Adding 10 records to the site...");
        for(int i =0; i<10; i++){
            actionHelper.sendKeys(By.id("nameInput"), Faker.instance().name().firstName());
            actionHelper.sendKeys(By.id("ageInput"), String.valueOf(Faker.instance().number().numberBetween(18, 60)));
            Select select = new Select(actionHelper.findElement(By.id("countrySelect")));
            int idx = Faker.instance().number().numberBetween(1,5);
            try{
                select.selectByIndex(idx);
                logger.info("Counter is selected with index: " +idx);
            }catch (Exception e){
                logger.error("Couldn't select by reference with idx: "+idx);
            }

            actionHelper.click(By.xpath("//button[.='Add Record']"));

        }

//        Store the name, age, and country columns in separate arrays (not ArrayList)
        List<WebElement> namesList = driver.findElements(By.xpath("//table//td[1]"));
        String[] namesArr = new String[namesList.size()];

        for(int i =0; i< namesList.size(); i++){
            namesArr[i] = namesList.get(i).getText();
        }
        System.out.println(Arrays.asList(namesArr));


        List<WebElement> ageList = driver.findElements(By.xpath("//table//td[2]"));
        String[] ageArr = new String[ageList.size()];

        for(int i =0; i< ageList.size(); i++){
            ageArr[i] = ageList.get(i).getText();
        }
        System.out.println(Arrays.asList(ageArr));


        List<WebElement> countryList = driver.findElements(By.xpath("//table//td[3]"));
        String[] countryArr = new String[countryList.size()];

        for(int i =0; i< countryList.size(); i++){
            countryArr[i] = countryList.get(i).getText();
        }
        System.out.println(Arrays.asList(countryArr));

    }


}
