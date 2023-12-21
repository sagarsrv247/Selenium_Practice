package com.datadriven.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class ReadXLSdata {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		ReadXLSdata red = new ReadXLSdata();
		red.getData("RegTestData");
	}
	
	
	@DataProvider(name ="regdata")
	public String[][] getData(String excelsheetname) throws EncryptedDocumentException, IOException
	{
		File f = new File("D:\\testdata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelsheetname);
		
		int totalRows = sheetName.getLastRowNum();
		System.out.println(totalRows);
		
		Row rowCells  = sheetName.getRow(0);
		int totalCols = rowCells.getLastCellNum();		
		System.out.println(totalCols);
		
		DataFormatter format = new DataFormatter();
		
		String testData[][] = new String[totalRows][totalCols];
		
		for(int i=1; i<=totalRows;i++)
		{
			for(int j=0;j<=totalCols;j++)
			{
				testData[i-1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
			}
		}
		
	return testData;	
	}
	
	
}
