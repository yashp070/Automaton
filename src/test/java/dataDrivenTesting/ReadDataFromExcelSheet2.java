package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet2 {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("./src/test/resources/Book1.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	Sheet sheet = workbook.getSheet("Sheet2");
	Row row1 = sheet.getRow(3);
	Cell cell1 = row1.getCell(1);
	long cellValue = (long)cell1.getNumericCellValue();
	System.out.println("cellValue ="+cellValue);
	Row row2 = sheet.getRow(2);
	Cell cell2 = row2.getCell(0);
	String cellValue2 = cell2.getStringCellValue();
	System.out.println("cellValue2 = "+cellValue2);
}
}
