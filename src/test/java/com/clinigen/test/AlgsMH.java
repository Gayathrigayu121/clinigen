package com.clinigen.test;

import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.clinigen.util.WebElementManager;

public class AlgsMH extends AlgsHistory {
	WebElementManager elementManager = new WebElementManager();
	public void AlgsMedicalHistory() throws Exception {
		
		
		/**
		 * ALGS MH Page Title verification
		 */
		String tiltle=driver.findElement(By.cssSelector("div#page-header > .has-tooltip.page-title")).getText().trim();
		String subTitle=driver.findElement(By.cssSelector("div#page-description")).getText().trim();
		String crfTitle = obj.getTitleData("MH", 0, 1).trim();
		String blTilte =obj.getTitleData("MH", 2, 1).trim();
		String con=String.join(":", blTilte,crfTitle);
		String plcTitle = obj.getTitleData("MH", 3, 1).trim();
		if(con.equals(tiltle)) {
			if(subTitle.equals(plcTitle)) {
			}
			obj.setTitleData("MH", 0, 6, "CRFPageVerified");
			obj.setTitleData("MH", 3, 6, "Page Level Completion Instruction Verified");
			}
		
		driver.findElement(By.cssSelector("button[value='Add']")).click();
		
		/**
		 * Medical Condition, diagnosis date,Resolution date
		 */
		
		String mcText = driver.findElement(By.cssSelector("[for='MH_term'] .label-element")).getText().trim();
		
		String ddText = driver.findElement(By.cssSelector("div:nth-of-type(2) > .custom-label-container > .custom-label > .label-element")).getText().trim();
		
		String rdText = driver.findElement(By.cssSelector("div:nth-of-type(3) > .custom-label-container > .custom-label > .label-element")).getText().trim();
		
		 ArrayList<String> addTitle= new ArrayList<String>(Arrays.asList(mcText,ddText,rdText));
		
		 ArrayList<String> xladdTitle = new ArrayList<String>();
		 for(int i=7;i<10;i++) { 
		 String cellDatan =obj.getCellData("MH", 6, "FIELD LABEL",i).trim(); 
		 xladdTitle.add(cellDatan);
	     }
	
		 if(addTitle.equals(xladdTitle)) {
			 obj.setCellData("MH", 6, "Field Label Verification ALGS", "Verified", 7);
		 }
			 
		 /**
		  * Set data for Medical condition,Diagnosis Date,Resolution Date
		  */
		 
		 driver.findElement(By.cssSelector(".input-container > input[name='MH_term']")).sendKeys("gayathri");
		 
		 /**
		  * Select date for Diagnosis Date and verify Query Text
		  */
		 
		 elementManager.dateOfBaseline(driver, "div:nth-of-type(2) > .calendar.input-container > .mx-datepicker  input[name='date']",
				 "[test-id=\"test_dateField_MH_diagnosis\"].mx-calendar.mx-calendar-panel-none>div.mx-calendar-header ", "Feb", "2022", ".mx-calendar.mx-calendar-panel-date  .mx-icon-last-month", "(.//*[normalize-space(text()) and normalize-space(.)='S'])[2]/following::td[10]");
		 
		 
		elementManager.captureQueryTextcss(driver, ".hard-stop-error.input-wrapper > .custom-label-container > .custom-label > .label-element",
				"span > li", "MH", 6 , "QUERY TEXT", 9, "QUERY TEXT VERIFICATION IN Algs MH", "Query text verified", 9, "/html//div[@id='my-box']/div[3]//div[@class='full-message']/div[1]/div[@class='custom-label-container']//span[@class='label-element']");
		
		
		 elementManager.dateOfBaseline(driver, "div:nth-of-type(2) > .calendar.input-container > .mx-datepicker  input[name='date']",
				 "[test-id=\"test_dateField_MH_diagnosis\"].mx-calendar.mx-calendar-panel-none>div.mx-calendar-header ", "Feb", "2019", ".mx-calendar.mx-calendar-panel-date  .mx-icon-last-month", "(.//*[normalize-space(text()) and normalize-space(.)='S'])[2]/following::td[11]");
		 
		 WebElement hoverEle = driver.findElement(By.cssSelector(".hard-stop-error.input-wrapper > .custom-label-container > .custom-label > .label-element"));
		 Actions actions=new Actions (driver);
		 actions.moveToElement(hoverEle).perform();
		 /**
		  * Select date for Resolution Date and verify Query Text
		  */
		 elementManager.dateOfBaseline(driver, "div:nth-of-type(3) > .calendar.input-container > .mx-datepicker  input[name='date']", 
				 "div:nth-of-type(3) > .calendar.input-container > .mx-datepicker  input[name='date']", 
				 "Jan", "2019", "div.mx-calendar.mx-calendar-panel-date > div.mx-calendar-header > a.mx-icon-last-month", 
				 "(.//*[normalize-space(text()) and normalize-space(.)='S'])[4]/following::td[24]");
		 
		 
		 elementManager.captureQueryTextcss(driver, ".hard-stop-error.input-wrapper > .custom-label-container > .custom-label > .label-element",
				 rdText, mcText, 0, con, 0, con, ddText, 0, rdText);
		 
		 
		 }
	
	
}
