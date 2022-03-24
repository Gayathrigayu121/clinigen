package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LearnReadExcel {

	public static void main(String[] args) throws Exception {
		File src=new File("./New folder/ReadData.xlsx");
		FileInputStream loadFile=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(loadFile);
		XSSFSheet sh=wb.getSheetAt(0);
		int numRow = sh.getLastRowNum();
		short cellNum = sh.getRow(0).getLastCellNum();
		
		for(int i=0;i<numRow;i++) {
			XSSFRow row = sh.getRow(i);
			for (int j=0;j<cellNum;j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter dft=new DataFormatter();
				String value = dft.formatCellValue(cell);
				
				/*
				 * switch(cell.getCellType()) { case
				 * STRING:System.out.print(cell.getStringCellValue());break;
				 * 
				 * case NUMERIC:System.out.print(cell.getNumericCellValue());break; case
				 * BOOLEAN:System.out.print(cell.getBooleanCellValue());break; case
				 * FORMULA:System.out.print(cell.getCellFormula());break; }
				 */
				System.out.print(value);
				System.out.print("|");
				
			}
			System.out.println("");
		}
		
	}
	
}
