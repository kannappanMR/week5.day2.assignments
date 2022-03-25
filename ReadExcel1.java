package week5.day2.assignments;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel1 {

	public static String[][] getData(String excelFilePath) throws IOException {
XSSFWorkbook book = new XSSFWorkbook(excelFilePath);
XSSFSheet sheet = book.getSheetAt(0);
int rowCount = sheet.getLastRowNum();
System.out.println(rowCount);
short columnCount = sheet.getRow(0).getLastCellNum();
System.out.println(columnCount);
String[][] data = new String[rowCount][columnCount];
for (int i = 1; i <= rowCount; i++) {
	XSSFRow eachRow = sheet.getRow(i);
	for (int j = 0; j < columnCount; j++) {
		XSSFCell eachColumn = eachRow.getCell(j);
		String value = eachColumn.getStringCellValue();
		data[i-1][j] = value;
		System.out.println(value);
	}	
}
book.close();
return data;

	}
}
