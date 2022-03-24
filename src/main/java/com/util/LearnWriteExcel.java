package com.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.Format;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LearnWriteExcel{
	public static void main(String[] args) throws Exception {
		
		XSSFWorkbook wb=new XSSFWorkbook();
		
		XSSFSheet sheet = wb.createSheet();
		
		  Object empData[][]=
		  {{"name","id","role"},{"gay","55","aut"},{"ds","ffd","go"}}; 
		  int row = empData.length; 
		  int cell= empData[0].length;
		 
		for(int i=0;i<row;i++) {
			XSSFRow row2 = sheet.createRow(i);
			for(int j=0;j<cell;j++) {
				XSSFCell cell2 = row2.createCell(j);
				Object value=empData[i][j];
				DataFormatter dft=new DataFormatter();
				 dft.createFormat(cell2);
				cell2.setCellValue((String)value);
				
				
				XSSFCellStyle cellStyle = wb.createCellStyle();
				cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
				cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				cell2.setCellStyle(cellStyle);
				
			}
		}
		
		
		
		File des=new File(".\\New folder\\emp.xlsx");
		FileOutputStream ops=new FileOutputStream(des);
		wb.write(ops);
		ops.close();
	}
}