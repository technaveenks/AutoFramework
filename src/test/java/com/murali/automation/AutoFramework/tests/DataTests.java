package com.murali.automation.AutoFramework.tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataTests {
	XSSFWorkbook excelWorkbook = null;
	XSSFSheet excelSheet = null;
	XSSFRow row = null;
	XSSFCell cell = null;
	
	@DataProvider 
	public Object[][] getData() throws IOException 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\Test Data 2.xlsx");
		excelWorkbook = new XSSFWorkbook(fis);
		excelSheet = excelWorkbook.getSheet("Sheet1");
		System.out.println("First Row Number/index:"+ excelSheet.getFirstRowNum() + " *** Last Row Number/index:"
				+ excelSheet.getLastRowNum());
		int rowCount = excelSheet.getLastRowNum() - excelSheet.getFirstRowNum()+1;
		int colCount = excelSheet.getRow(0).getLastCellNum();
		System.out.println("Row Count is: " + rowCount
				+ " *** Column count is: " + colCount);
		Object data[][] = new Object[rowCount-1][colCount];
		for (int rNum = 2; rNum <= rowCount; rNum++) 
		{
			for (int cNum = 0; cNum < colCount; cNum++) 
			{
				//System.out.print(getCellData("Sheet1", cNum, rNum) + " "); // Your sheet name
				//data[rNum - 2][cNum] = getCellData("Sheet1", cNum, rNum); //Your sheet name
			}
			System.out.println();
		}
		return data;
	}
}
