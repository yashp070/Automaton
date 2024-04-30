package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProjectFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://www.shoppersstack.com/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		 driver.findElement(By.id("loginBtn")).submit();
		 driver.findElement(By.xpath("//span[text()=\"Create Account\"]")).click();
		FileInputStream fis = new FileInputStream("./src/test/resources/Projectfile.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        XSSFSheet sheet = workbook.getSheet("Sheet1");
	        int countrow= sheet.getLastRowNum();
	        int colomcount= sheet.getRow(1).getLastCellNum();
	        System.out.println("rowcount"+countrow +"columncount"+colomcount);
	        for(int i=0;i<=countrow;i++) {
	        	XSSFRow celldata = sheet.getRow(i);
	        	String firstname=celldata.getCell(0).getStringCellValue();
	        	String lastname=celldata.getCell(1).getStringCellValue();
	        	String phonenum=celldata.getCell(2).getStringCellValue();
	        	String mail=celldata.getCell(3).getStringCellValue();
	        	String createpwd=celldata.getCell(4).getStringCellValue();
	        	String confirmpsd=celldata.getCell(5).getStringCellValue();
	        	
	        	driver.findElement(By.id("First Name")).clear();
	        	driver.findElement(By.id("First Name")).sendKeys(firstname);
	        	driver.findElement(By.id("Last Name")).clear();
	        	driver.findElement(By.id("Last Name")).sendKeys(lastname);
	        	driver.findElement(By.id("Male")).click();	
	        	driver.findElement(By.id("Phone Number")).clear();
	        	driver.findElement(By.id("Phone Number")).sendKeys(phonenum);
	        	driver.findElement(By.id("Email Address")).clear();
	        	driver.findElement(By.id("Email Address")).sendKeys(mail);
	        	driver.findElement(By.id("Password")).clear();
	        	driver.findElement(By.id("Password")).sendKeys(createpwd);
	        	driver.findElement(By.id("Confirm Password")).clear();
	        	driver.findElement(By.id("Confirm Password")).sendKeys(confirmpsd);
	        	driver.findElement(By.id("Terms and Conditions")).click();
	        }
                                              
}
}