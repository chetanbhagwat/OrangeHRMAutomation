package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {
public static String readData(String Filename,String sheetname,int row, int column) throws IOException {
		
		File src= new File(System.getProperty("user.dir")+"//"+Filename+".xlsx");

		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh1 = wb.getSheet(sheetname);
//	    String value = sh1.getRow(row).getCell(column).getStringCellValue();
//	    System.out.println(value);
		DataFormatter df = new DataFormatter();
		String formattedvalue = df.formatCellValue(sh1.getRow(row).getCell(column));
		wb.close();
		return formattedvalue;
}
}
