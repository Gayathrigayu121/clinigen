package com.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilnw {
	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook wb;
	public XSSFSheet sh;
	public XSSFRow row;
	public XSSFCell cell;
	String path=null;
	
	ExcelUtilnw(String path){
		this.path=path;
	
	}
	public int getRowCount(String SheetName) throws Exception {
		
		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(SheetName);
		int rowCount=sh.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;
	}
	
	public int getCellCount(String SheetName, int rowNum) throws Exception
	{
		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(SheetName);
		row=sh.getRow(rowNum);
		int cellCount=row.getLastCellNum();
		wb.close();
		fis.close();
		return cellCount;
	}
	
	public String getCellData(String SheetName,int rowNum,int colName) throws Exception {
		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(SheetName);
		row=sh.getRow(rowNum);
		int colNum=-1;
		
		for(int i=0;i<row.getLastCellNum();i++) {
			if(row.getCell(i).getStringCellValue().trim().equals("colName")) {
				colNum=i;
			}
			
		}
		cell=row.getCell(colNum);
		DataFormatter dft=new DataFormatter();
		String value=dft.formatCellValue(cell);
		String stringCellValue = cell.getStringCellValue();
		wb.close();
		fis.close();
		return stringCellValue;
		
	}
		public void setCellDta(String sheetName,int rowNum,String colName,String value) throws Exception {
			fis=new FileInputStream(path);
			wb=new XSSFWorkbook(fis);
			sh=wb.getSheet(sheetName);
			row=sh.getRow(rowNum);
			int colNum=-1;
			for(int i=0;i<row.getLastCellNum();i++) {
				if(row.getCell(i).getStringCellValue().trim().equals(colName)) {
					colNum=i;
				}
			}
			cell=row.createCell(colNum);
			cell.setCellValue(value);
			fos=new FileOutputStream(path);
			wb.write(fos);
			wb.close();
			fis.close();
			fos.close();
		}
	
}
