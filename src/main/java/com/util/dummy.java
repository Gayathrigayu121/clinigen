package com.util;
import java.io.File;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class dummy {
	public static void main(String[] args) throws Exception {
		File src=new File("./New folder/ReadData.xlsx");
		FileInputStream loadFile=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(loadFile);
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row=sheet.getRow(0);
		//XSSFCell cell=null;
		//int lastRowNum = sheet.getLastRowNum();
		//System.out.println(lastRowNum);
		
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		
		int colNum=-1;
		for(int i=0;i<lastCellNum;i++) {
			if(row.getCell(i).getStringCellValue().trim().equals("Result"))
			colNum=i;
			//System.out.println(i);
		}
		
		
		  sheet.createRow(1).createCell(colNum).setCellValue("asdf");
		//String value = sheet.getRow(1).getCell(colNum).getStringCellValue();
		//System.out.println(value);
		
		/*
		 * row=sheet.getRow(1); cell=row.getCell(colNum); String
		 * psw=String.valueOf(cell.getStringCellValue()); System.out.println(psw);
		 */
	
		  FileOutputStream	fos=new FileOutputStream("./New folder/ReadData.xlsx");
	wb.write(fos);
	fos.close();
	
	}

		}