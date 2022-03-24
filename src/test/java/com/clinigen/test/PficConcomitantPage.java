package com.clinigen.test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;

import com.clinigen.util.WebElementManager;

public class PficConcomitantPage extends PficGenLabPage {
public void PCM() throws Exception {
		
		WebElementManager elementManager = new WebElementManager();
	
		/**
		 * PIFC Concomitant medication Form
		 *  Get Title from Web APP
		 */
		
		String pageTitle = driver.findElement(By.cssSelector(".custom-label.full-width-label > .label-element")).getText().trim();
		String PageSubTitle = driver.findElement(By.cssSelector("div#page-description")).getText().trim();
		
		
		/**
		 * PIFC Concomitant medication Form
		 *  Get Title from XL Page
		 */
		
		
		 String xlpageTitle = obj.getTitleData("CONCOMITANT MEDICATIONS", 0, 1).trim();   
		 String xlPageSubTitle =obj.getTitleData("CONCOMITANT MEDICATIONS", 3, 1).trim();
		  
		/**
		 * Compare the WebApp Title with Xl Title
		 */
		
		if(pageTitle.equals(xlpageTitle)) {
			if(PageSubTitle.equals(xlPageSubTitle)) {
				obj.setTitleData("CONCOMITANT MEDICATIONS", 0, 6, "CRF Page name verified");
				obj.setTitleData("CONCOMITANT MEDICATIONS", 3, 6, "Page level completion instruction verified");
			}
		}
		
		/**
		 * Adding new Concomitant medication Form
		 */
		
		driver.findElement(By.cssSelector("button[value='Add']")).click();
		
		
		/**
		 * Getting labels in WebApp for CM-sD,CM,dose,unit,indication
		 */
		String CM = driver.findElement(By.cssSelector("[for='ConMed_term'] .label-element")).getText().trim();
		String sD = driver.findElement(By.cssSelector("div:nth-of-type(2) > .custom-label-container > .custom-label > .label-element")).getText().trim();
		
		String eD= driver.findElement(By.cssSelector("div:nth-of-type(3) > .custom-label-container > .custom-label > .label-element")).getText().trim();
		
		String uD= driver.findElement(By.cssSelector("div:nth-of-type(5) > .custom-label-container > .custom-label > .label-element")).getText().trim();
		
		String indication = driver.findElement(By.cssSelector("div:nth-of-type(6) > .custom-label-container > .custom-label > .label-element")).getText().trim();
		
		 ArrayList<String> List1= new ArrayList<String>(Arrays.asList(CM,sD,eD,uD,indication));
		
		     /**
			 * Getting labels in XL for CL-dT,TP,result
			 */
			ArrayList<String> List = new ArrayList<String>();
			for(int i=7;i<15;i++) {
			String XlDta=obj.getCellData("CONCOMITANT MEDICATIONS", 6, "FIELD LABEL", i).trim();
			List.add(XlDta);
			}
			List.remove("Specify Other");
			List.removeAll(Collections.singleton(""));
			/**
			 * Compare two WebApp title with XL title and set value in XL
			 */
			
			if(List1.equals(List)) {
				for (int i=7;i<15;i++) {
					obj.setCellData("CONCOMITANT MEDICATIONS", 6, Constants.Field_Label_Verification, Constants.Labels_were_verified, i);
				}
			}
			/**
			 * Concomitant Medication Form
			 */
		
			driver.findElement(By.cssSelector(".input-container > input[name='ConMed_term']")).sendKeys("qwertyuiop");
			
			
			/**
			 * Concomitant Medication start date
			 */
			
			
			elementManager.dateOfBaseline(driver, "div:nth-of-type(2) > .calendar.input-container > .mx-datepicker  input[name='date']", 
					"div.mx-calendar-header", "Feb", "2014", ".mx-calendar.mx-calendar-panel-date  .mx-icon-last-month",
					"/html/body/div[2]/div[@class='mx-calendar mx-calendar-panel-date']//table[@class='mx-panel mx-panel-date']//td[@title='11 Feb 2014']");
			
			elementManager.captureQueryTextcss(driver, ".hard-stop-error.input-wrapper > .custom-label-container > .custom-label > .label-element", 
					".tooltip-inner  li", "CONCOMITANT MEDICATIONS", 6, "QUERY TEXT", 8, Constants.Query_Text_Verification,
					Constants.Query_Text_Verified, 8, "//div[@id='ConMed_Dose']/div[@class='custom-label-container']//span[@class='label-element']");
			
			
			elementManager.dateOfBaselineafterMonth(driver, "div:nth-of-type(2) > .calendar.input-container > .mx-datepicker  input[name='date']", 
					"div.mx-calendar-header", "Feb", "2020", ".mx-calendar.mx-calendar-panel-date  .mx-icon-next-month",
					"/html//div[@class='mx-datepicker-popup']/div[@class='mx-calendar mx-calendar-panel-date']//table[@class='mx-panel mx-panel-date']//td[@title='14 Feb 2020']", 
					"//div[@id='ConMed_Dose']/div[@class='custom-label-container']//span[@class='label-element']");
			/**
			 * To enter Dose Value
			 */
			driver.findElement(By.cssSelector("input[name='ConMed_Dose']")).sendKeys("322");
			
			/**
			 * To enter Unit Value
			 */
			List<String> clickRandomOptionjs = elementManager.clickRandomOptionjs(driver, "[test-id=\"test_dd_input_ConMed_Units_options\"].multiselect__content-wrapper>ul>li", ".multiselect > .multiselect__select", 19, 2);
			clickRandomOptionjs.remove("Please select");
			
			/**
			 * To enter Indication
			 */
			
			
			driver.findElement(By.cssSelector(".input-container > input[name='Indication']")).sendKeys("qwertyuiopa");
			
			
			
			/**
			 * Concomitant Medication End date
			 */
			
			elementManager.dateOfBaseline(driver, "div:nth-of-type(3) > .calendar.input-container > .mx-datepicker  input[name='date']",
					".mx-calendar.mx-calendar-panel-date>div.mx-calendar-header", "Mar", "2019", ".mx-calendar.mx-calendar-panel-date  .mx-icon-last-month", 
					"/html/body/div[3]/div[@class='mx-calendar mx-calendar-panel-date']//table[@class='mx-panel mx-panel-date']//td[@title='19 Mar 2019']");
			
			
			elementManager.captureQueryTextcss(driver, ".hard-stop-error.input-wrapper > .custom-label-container > .custom-label > .label-element",
					"div[role='tooltip'] li", "CONCOMITANT MEDICATIONS", 6, "QUERY TEXT", 9, Constants.Query_Text_Verification,
					Constants.Query_Text_Verified, 9, "/html//div[@id='my-box']/div[3]//div[@class='full-message']/div[6]/div[@class='custom-label-container']//span[@class='label-element']");
			
			elementManager.dateOfBaselineafterMonth(driver, "div:nth-of-type(3) > .calendar.input-container > .mx-datepicker  input[name='date']",
					".mx-calendar.mx-calendar-panel-date>div.mx-calendar-header", "Mar", "2020", ".mx-calendar.mx-calendar-panel-date  .mx-icon-next-month", 
					"/html/body/div[3]/div[@class='mx-calendar mx-calendar-panel-date']//table[@class='mx-panel mx-panel-date']//td[@title='19 Mar 2020']", "//div[@id='ConMed_Dose']/div[@class='custom-label-container']//span[@class='label-element']");
		
			
			
			driver.findElement(By.cssSelector(".popup-footer > button:nth-of-type(1)")).click();
			
			driver.findElement(By.cssSelector("button#btnnext")).click();
			
		
}
}