package Assignments.Day09;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilitites.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class C01ExportTableToExcel extends TestBase {

     /*
 Go to https://claruswaysda.github.io/webTable.html
 Write the entire Table 1 to a new Excel sheet.
 */


    @Test
    void name() throws IOException {
        driver.get("https://claruswaysda.github.io/webTable.html");

        String path = Path.of(".","resources","Homework01.xlsx").toString();
        FileInputStream fis =new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);

        WebElement table = driver.findElement(By.id("t1"));

        // Extract rows
        List<WebElement> rows = table.findElements(By.tagName("tr"));


        int rowNum = 0;

        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("th"));
            if (cols.isEmpty()) {
                cols = row.findElements(By.tagName("td")); // for data rows
            }

            Row excelRow = sheet.createRow(rowNum++);
            int colNum = 0;
            for (WebElement col : cols) {
                Cell cell = excelRow.createCell(colNum++);
                cell.setCellValue(col.getText());
            }
        }

        // Write Excel file
        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);
        fos.close();
        workbook.close();
    }
}
