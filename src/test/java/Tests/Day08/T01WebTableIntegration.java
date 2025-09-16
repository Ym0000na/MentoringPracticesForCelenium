package Tests.Day08;

import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilitites.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.apache.poi.ss.util.SheetUtil.getCell;

public class T01WebTableIntegration extends TestBase {
//    Objective: Go to
//    https://claruswaysda.github.io/addRecordWebTable.html and add 10 records to the
//    table by taking data (Name, Age, Country) from Excel.

    @Test
    public void Test01WebTableIntegrationTest() throws IOException {
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");

        FileInputStream fis =new FileInputStream(Path.of(".","resources","Task01.xlsx").toString());
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);

        WebElement nameElement = driver.findElement(By.id("nameInput"));
        WebElement ageElement = driver.findElement(By.id("ageInput"));
        WebElement countryElement = driver.findElement(By.id("countrySelect"));
        WebElement submit = driver.findElement(By.xpath("//button[@onclick='addRecord()']"));

        ArrayList<String> namesList = new ArrayList<>();
        ArrayList<Number> ageList=  new ArrayList<>();
        ArrayList<String> countryList= new ArrayList<>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            namesList.add(row.getCell(0).getStringCellValue());
            ageList.add((int) row.getCell(1).getNumericCellValue());
            countryList.add(row.getCell(2).getStringCellValue());
        }

        for (int i = 0; i <= namesList.size() - 1; i++) {
            nameElement.clear();
            ageElement.clear();

            nameElement.sendKeys(namesList.get(i));
            ageElement.sendKeys(ageList.get(i).toString());
            countryElement.sendKeys(countryList.get(i));
            submit.click();
        }

    }
}
