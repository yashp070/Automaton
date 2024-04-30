package dataEntry;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelDataEntry {

    public static void main(String[] args) throws IOException, Throwable {

        WebDriver driver = new ChromeDriver();
        driver.get("http://13.200.115.170/#/admin/City");

        // Set the path of the Excel file
        String excelFilePath = "D:\\dropdowns.xlsx";

        // Load the Excel workbook
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        // Iterate through rows and enter data
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            driver.findElement(By.xpath("//button[normalize-space()='Add City']")).click();
            
            driver.findElement(By.xpath("//div[@class='col-lg-10']//div[1]//select[1]")).click();
            
                                                                     //city name
            driver.findElement(By.xpath("//option[@value='65e17b6a614fb83d0c92fbd2']")).click();
            
            // Find the text field element (replace 'your_text_field_id' with the actual ID or XPath)
            WebElement textField = driver.findElement(By.xpath("//input[@id='input-username']"));

            // Iterate through cells and enter data into the text field
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                textField.sendKeys(cell.toString());
            }
            driver.findElement(By.id("select-category")).click();
            driver.findElement(By.xpath("(//option[@value='true'])[1]")).click();
            
            driver.findElement(By.xpath("//a[normalize-space()='Add']")).click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            
        }

        // Close the workbook and the browser
        workbook.close();
        driver.quit();
    }
}

