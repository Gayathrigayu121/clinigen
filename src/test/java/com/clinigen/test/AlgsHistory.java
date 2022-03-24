package com.clinigen.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.clinigen.util.WebElementManager;

public class AlgsHistory extends DemographyAlgs {

	@Test()
	public static void baselineALGShistory() throws Exception {
		WebElementManager elementManager = new WebElementManager();
		
		/**
		 * Baseline:PFIC History Diagnosis Date
		 */
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name=\"date\"]"))).click();
		String text2 = driver.findElement(By.cssSelector("div[class='mx-calendar-header']")).getText();
		String str = text2.substring(7);
		System.out.println("str=" + str);
		String month1 = str.split(" ")[0].trim();
		String year1 = str.split(" ")[1].trim();
		while (!(month1.equals("Feb") && year1.equals("2022"))) {
			WebElement element = driver
					.findElement(By.cssSelector(".mx-calendar.mx-calendar-panel-date>div>a.mx-icon-last-month"));
			element.click();
			text2 = driver.findElement(By.cssSelector(".mx-calendar.mx-calendar-panel-date>div.mx-calendar-header"))
					.getText();
			str = text2.substring(7);
			month1 = str.split(" ")[0].trim();
			year1 = str.split(" ")[1].trim();
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='S'])[2]/following::td[16]"))).click();

		/**
		 * CaptureText Diagnosis date
		 */
		
		
		String con=elementManager.captureQueryTextcss(driver, "div.input-container.calendar", "span > li", "ALGS_MH", 6, "QUERY TEXT",7, "QUERY TEXT VERIFICATION", "Query text verified", 7, "//div[@id='page-title']/div[2]/form/div[4]/div/label/span");
		
		elementManager.dateOfBaseline(driver, "input[name=\"date\"]", "div[class='mx-calendar-header']", "Dec", "2014"	, "a.mx-icon-last-month", "(.//*[normalize-space(text()) and normalize-space(.)='S'])[2]/following::td[25]");
		
		
		/**
		 * CaptureText
		 */

		elementManager.captureQueryTextcss(driver, "div.input-container.calendar", "span > li", "ALGS_MH", 6, "QUERY TEXT", 7, "QUERY TEXT VERIFICATION", "Query text verified", 8, "//div[@id='page-title']/div[2]/form/div[2]/div/label/span");
		
		elementManager.dateOfBaselineafterMonth(driver, "input[name=\"date\"]", "div[class='mx-calendar-header']",
				"Dec", "2018", "a.mx-icon-next-month",
				"(.//*[normalize-space(text()) and normalize-space(.)='S'])[2]/following::td[25]", "//div[@id='page-title']/div[2]/form/div[4]/div/label/span");

			
		WebElement strele=driver.findElement(By.xpath("//div[@id='page-title']/div[2]/form/div[2]/div/label/span"));
		Actions actions = new Actions(driver);
		actions.moveToElement(strele).perform();
		
		
		
			/**
				 * Specify Mutation
				 */
		
			/*
			 * driver.findElement(By.cssSelector("input[name='PFIC_mutation']")).click();
			 * driver.findElement(By.cssSelector(
			 * "[test-id='test_commonSelect_PFIC_mutation_specify'].multiselect>.multiselect__select"
			 * )).click(); String texts = elementManager.clickRamdomOptionxpathText(driver,
			 * "//div[@id='page-title']/div[2]/form/div[2]/div[2]/span", 1, 2);
			 * System.out.println(texts);
			 * 
			 * String familyHistory = elementManager.clickRamdomOptionxpathText(driver,
			 * "//div[@id='page-title']/div[2]/form/div[3]/div[2]/span", 1, 3);
			 * System.out.println(familyHistory); if (familyHistory.equals("yes")) {
			 * List<String> spcifyMutationList = elementManager.clickRandomOptionjs(driver,
			 * "div.multiselect__content-wrapper>.multiselect__content>li>span",
			 * "div.multiselect__select", 1, 5); }
			 * 
			 * String bileDuct = elementManager.clickRamdomOptionxpathText(driver,
			 * "//div[@id='page-title']/div[2]/form/div[4]/div[2]/span", 1, 3);
			 * System.out.println(bileDuct);
			 */
		 	
		
		/**
		 * Was the genetic mutation assessed? ALGS family history  Bile duct paucity 
		 */

			 driver.findElement(By.xpath("(//input[@id='2'])[1]")).click();
			 driver.findElement(By.xpath( "(//input[@id='2'])[2]" )).click(); 
			 driver.findElement(By.xpath( "(//input[@id='2'])[3]" )).click(); 

			
                 /**
                  * Label verification
                  */
			  
			  String text22 = driver.findElement(By.id("page-description")).getText().trim();
			  String tx5 = driver.findElement(By.xpath("//div[@id='page-header']/div")).getText().trim(); 
			  String titleData = obj.getTitleData("ALGS_MH", 0, 1).trim(); 
			  String titleData1 = obj.getTitleData("ALGS_MH", 2, 1).trim(); 
			  String titleData2 = obj.getTitleData("ALGS_MH", 3, 1).trim();
					  String titleData3=String.join(" : ",titleData1,titleData).trim();
					  if(titleData2.equals(text22)) {
						  if(titleData3.equals(tx5)) {
					  obj.setTitleData("ALGS_MH", 0, 6, " CRF Page Verified");
					  obj.setTitleData("ALGS_MH",3, 6, "Page Level Completion Instruction Verified");
					  }
					  }
			  
							  
			  String date = driver.findElement(By.cssSelector("span.label-element")).getText();
			  System.out.println("date="+date);
			  String mutation =driver.findElement(By.xpath("//div[@id='page-title']/div[2]/form/div[2]/div/label/span")).getText().trim();
			  
			 String history = driver.findElement(By.xpath("//div[@id='page-title']/div[2]/form/div[3]/div/label/span")).getText().trim( ); 
			 
			 String bile = driver.findElement(By.xpath("//div[@id='page-title']/div[2]/form/div[4]/div/label/span")).getText().trim();
			// String[] arr= {date,mutation,history,bile};
			 
			
			 ArrayList<String> List1= new ArrayList<String>(Arrays.asList(date,mutation,history,bile));
			 System.out.println("List1="+List1); 
			 obj=new ExcelColName("./Excel/Book.xlsx"); 
			 ArrayList<String>List2 = new ArrayList<String>();
			 for(int i=7;i<13;i++) { 
			 String cellDatan =obj.getCellData("ALGS_MH", 6, "FIELD LABEL",i); 
			 List2.add(cellDatan); }
			 List2.removeAll(Collections.singleton(""));
			 List2.remove("Specify Mutation");
			 System.out.println("excel avlue="+List2); 
			
			
			if(List1.equals(List2)) { 
			System.out.println("pass"); 
			for(int j=7;j<13;j++) {
			  
		     obj.setCellData("ALGS_MH", 6, "Field Label Verification", "verified",j); } }
			  
			  
			  
			  elementManager.waitWebDriver(driver, "#btnnext");
			  
			  /**
			   * Baseline ALGS History
			   */
			  String tx1=driver.findElement(By.cssSelector("span.label-element")).getText().trim();

			  String tx2=driver.findElement(By.xpath("//div[@id='page-title']/div[2]/form/div[2]/div/label/span")).getText().trim();
			  String tx3=driver.findElement(By.xpath("//div[@id='page-title']/div[2]/form/div[3]/div/label/span")).getText().trim();
			  String tx4=driver.findElement(By.xpath("//div[@id='page-title']/div[2]/form/div[4]/div/label/span")).getText().trim();
			  String tx55=driver.findElement(By.xpath("//div[@id='page-title']/div[2]/form/div[5]/div/label/span")).getText().trim();
			  String tx6=driver.findElement(By.xpath("//div[@id='page-title']/div[2]/form/div[6]/div/label/span")).getText().trim();
			  String tx7=driver.findElement(By.xpath("//div[@id='page-title']/div[2]/form/div[7]/div/label/span")).getText().trim();
			  String tx8=driver.findElement(By.xpath("//div[@id='page-title']/div[2]/form/div[8]/div/label/span")).getText().trim();
			  String tx9=driver.findElement(By.xpath("//div[@id='page-title']/div[2]/form/div[9]/div/label/span")).getText().trim();

			  ArrayList<String> webApphistoryList= new ArrayList<String>(Arrays.asList(tx1,tx2,tx3,tx4,tx55,tx6,tx7,tx8,tx9));
			  
			  ArrayList<String>historyList = new ArrayList<String>();
				 for(int i=13;i<22;i++) { 
					 String cellDatan =obj.getCellData("ALGS_MH", 6, "FIELD LABEL",i); historyList.add(cellDatan); }
			  
			  if(webApphistoryList.equals(historyList))
			  
			  {
				  for(int i=13;i<22;i++)
				  obj.setCellData("ALGS_MH", 6, "Field Label Verification", "verified", i);
			  }
			  
			 
			 /**
				 * Baseline:ALGS History
				 */
					  driver.findElement(By.xpath(
					  "(//div[@id='page-title']/div[2]/form/div[2]/div[2]/span)[3]")).click();
					  driver.findElement(By.xpath(
					  "(//div[@id='page-title']/div[2]/form/div[3]/div[2]/span)[3]")).click();
					  driver.findElement(By.xpath(
					  "(//div[@id='page-title']/div[2]/form/div[4]/div[2]/span)[2]")).click();
					  driver.findElement(By.xpath(
					  "(//div[@id='page-title']/div[2]/form/div[5]/div[2]/span)[3]")).click();
					  driver.findElement(By.xpath(
					  "(//div[@id='page-title']/div[2]/form/div[6]/div[2]/span)[2]")).click();
					  driver.findElement(By.xpath(
					  "(//div[@id='page-title']/div[2]/form/div[7]/div[2]/span)[2]")).click();
					  driver.findElement(By.xpath(
					  "(//div[@id='page-title']/div[2]/form/div[8]/div[2]/span)[2]")).click();
					  driver.findElement(By.xpath(
					  "(//div[@id='page-title']/div[2]/form/div[9]/div[2]/span)[2]")).click();
					  
					  
					driver.findElement(By.cssSelector("#btnnext")).click();

	}

}