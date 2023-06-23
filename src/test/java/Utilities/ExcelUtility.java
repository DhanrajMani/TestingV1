package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
		public static int getRowcount(String xlfilePath, String xlsheet) throws IOException{
			
			FileInputStream input = new FileInputStream(xlfilePath);
			XSSFWorkbook workbook = new XSSFWorkbook(input);
			XSSFSheet sheet = workbook.getSheet(xlsheet);
			int rowcunt = sheet.getLastRowNum();
			workbook.close();
			return rowcunt;
		}
		
		public static int getCellcount(String xlfilePath, String xlsheet, int rowNum) throws IOException {
			
			FileInputStream input = new FileInputStream(xlfilePath);
			XSSFWorkbook workbook = new XSSFWorkbook(input);
			XSSFSheet sheet = workbook.getSheet(xlsheet);
			XSSFRow row = sheet.getRow(rowNum);
			int cellCount = row.getLastCellNum();
			workbook.close();
			return cellCount;
		}
		
		public static String getCellData(String xlfilePath, String xlsheet, int rowNum, int colNum) throws IOException {
			FileInputStream input = new FileInputStream(xlfilePath);
			XSSFWorkbook workbook = new XSSFWorkbook(input);
			XSSFSheet sheet = workbook.getSheet(xlsheet);
			XSSFRow row = sheet.getRow(rowNum);
			XSSFCell cell = row.getCell(colNum);
			String data;
			try {
				DataFormatter dataFormate = new DataFormatter();
				String cellData = dataFormate.formatCellValue(cell);
				return cellData;
			} 
			catch (Exception e) 
			{
				data = "";
			}
			workbook.close();
			return data;
		}
		
		public static void setCellData(String xlfilePath, String xlsheet, int rowNum, int colNum, String data) throws IOException {
			FileInputStream input = new FileInputStream(xlfilePath);
			XSSFWorkbook workbook = new XSSFWorkbook(input);
			XSSFSheet sheet = workbook.getSheet(xlsheet);
			XSSFRow row = sheet.getRow(rowNum);
			XSSFCell cell = row.createCell(colNum);
			cell.setCellValue(data);
			
			FileOutputStream output = new FileOutputStream(xlfilePath);
			workbook.write(output);
			workbook.close();
		}

}
