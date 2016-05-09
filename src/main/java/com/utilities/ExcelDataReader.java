package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataReader {


	    @DataProvider
	    public static Object[][] excelReader() throws IOException {

	        File excelFile = new File("src\\test\\resources\\TestData.xlsx");
	        FileInputStream fileInputStream = new FileInputStream(excelFile);

	        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

	        XSSFSheet sheet = workbook.getSheet("data");

	        Object[][] excelData = new Object[sheet.getLastRowNum()][4];

	        for (int i=0; i<sheet.getLastRowNum(); i++){

	            excelData[i][0] = sheet.getRow(i+1).getCell(0).getStringCellValue();
	            excelData[i][1] = sheet.getRow(i+1).getCell(1).getStringCellValue();
	            excelData[i][2] = sheet.getRow(i+1).getCell(2).getStringCellValue();
	            excelData[i][3] = sheet.getRow(i+1).getCell(3).getStringCellValue();
	        }
	       return excelData;
	    }
	}
	
	
	

