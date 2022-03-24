package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook wb;
	public XSSFSheet sh;
	public XSSFRow row;
	public XSSFCell cell;
	String path=null;
	
	ExcelUtil(String path){
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
	
	public String getCellData(String SheetName,int rowNum,int colNum) throws Exception {
		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(SheetName);
		row=sh.getRow(rowNum);
		cell=row.getCell(colNum);
		
		DataFormatter dft=new DataFormatter();
		String value=dft.formatCellValue(cell);
		wb.close();
		fis.close();
		return value;
		
	}	
		public void setCellDta(String sheetName,int rowNum,int colNum,String value) throws Exception {
			fis=new FileInputStream(path);
			wb=new XSSFWorkbook(fis);
			sh=wb.getSheet(sheetName);
			row=sh.getRow(rowNum);
			cell=row.createCell(colNum);
			cell.setCellValue(value);
			fos=new FileOutputStream(path);
			wb.write(fos);
			wb.close();
			fis.close();
			fos.close();
		}
		
	}
		
		
	
	
