package com.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EnhanLearnWriteEXcel {

	public static void main(String[] args) throws Exception {
		
	
	XSSFWorkbook wb=new XSSFWorkbook();
	
	XSSFSheet sh=wb.createSheet();
	
	/*
	 * ArrayList<Object[]> empData=new ArrayList<Object[]>();
	 * 
	 * empData.add(new Object[] {"empid","name","rol"}); 
	 * empData.add(new Object[]{"156","gyu","dsf"}); 
	 * empData.add(new Object[] {"45","dsf","dd"});
	 */
	
	ArrayList<Object[][]> empData=new ArrayList<Object[][]>();
	
	empData.add(new Object[][] {{"empid","name","rol"},{"156","gyu","dsf"},{"45","dsf","dd"}});
	
	int rowCount=0;
	
	for(Object data[]:empData) {
		XSSFRow row = sh.createRow(rowCount++);
		int columnCount=0;
		for(Object value:data) {
			XSSFCell cell = row.createCell(columnCount++);
			String.format("GG", cell);
			DataFormatter dft=new DataFormatter();
			dft.createFormat(cell);
			cell.setCellValue((String)value);
		}
		
	}
	File des=new File(".\\New folder\\EnhanceForLoop.xlsx");
	FileOutputStream fos=new FileOutputStream(des);
	wb.write(fos);
	fos.close();
	
	
}
}