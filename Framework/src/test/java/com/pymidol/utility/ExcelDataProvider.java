package com.pymidol.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;

	public ExcelDataProvider() {           //create constructor ExcelDataProvider
		
		File src=new File("./TestData/Data.xlsx");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
	
			System.out.println("Unable to read Excel Eile."+e.getMessage());
		}
		
	}
	
	//method overloading - below method name is same in 3 methods, no of parameter are same, but type of parameter have changed
	
	public String getStringData(int sheetIndex,int row ,int column)   //we are returning string data, so taken return type string
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();   //we will get data from excel using this one line statement
	}
	
	public String getStringData(String sheetName,int row ,int column)   //we are returning string data, so taken return type string
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();   //we will get data from excel using this one line statement
	}
	
	public double getNumericData(String sheetName,int row ,int column)  //numeric cell value will return double
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
}
