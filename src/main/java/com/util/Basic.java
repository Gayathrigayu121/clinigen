package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Basic {
	
public static String[][] getExcelData() throws Exception {
	
	File src=new File("./New folder/ReadData.xlsx");
	FileInputStream loadFile=new FileInputStream(src);
	XSSFWorkbook wb=new XSSFWorkbook(loadFile);
	
	XSSFSheet sheet = wb.getSheetAt(0);
	
	int lastRowNum = sheet.getLastRowNum();
	System.out.println(lastRowNum);
	short lastCellNum = sheet.getRow(0).getLastCellNum();

	String[][] data=new String[lastRowNum][lastCellNum];
	
	for (int i = 0; i <lastRowNum; i++) {
		XSSFRow row = sheet.getRow(i);
		for (int j = 0; j< lastCellNum; j++) {
			XSSFCell cell = row.getCell(j);
			DataFormatter dft=new DataFormatter();
					String value = dft.formatCellValue(cell);
			String stringCellValue = cell.getStringCellValue();
			//System.out.println(formatCellValue);
					
					data[i][j]=value;
		} 
	}
wb.close();
return data;
}

}
