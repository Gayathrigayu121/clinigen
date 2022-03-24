package com.util;

import org.testng.annotations.DataProvider;

public class LearnDataProad {
	
	
	@DataProvider()
	public String[][] getData() throws Exception {
		
		String[][] excelData = Basic.getExcelData();
		
	//	String[][] data=new String[3][2];
		/*
		 * data[0][0]="gayu121"; data[0][1]="pwd";
		 * 
		 * data[1][0]="gaysdau121"; data[1][1]="pwdsad";
		 * 
		 * data[2][0]="lastdata"; data[2][1]="pwdsad";
		 */
		return excelData;
}}
