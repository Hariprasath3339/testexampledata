package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private FileInputStream fis;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private DataFormatter formatter;

	public ExcelUtils(String filePath, String sheetName) throws IOException {
		fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		formatter = new DataFormatter();
	}

	public String getData(int row, int col) {
		return formatter.formatCellValue(sheet.getRow(row).getCell(col));
	}

	public void close() throws IOException {
		workbook.close();
	}
}
