package com.clinigen.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.openqa.selenium.By;

import com.clinigen.util.WebElementManager;

public class BaselineVitalSignNewPage extends PficPhysicalExamination {

	
public void bVSNP() throws Exception {
		
		WebElementManager elementManager = new WebElementManager();
		
		/**
		 * Baseline Vital Sign get labels from WebApp
		 */
		
		
		String BP = driver.findElement(By.cssSelector("div#bl_diastolicbp .label-element")).getText().trim();
		
		String cs1 = driver.findElement(By.cssSelector(".page-form > div:nth-of-type(2) .label-element")).getText().trim();

		String SBP = driver.findElement(By.cssSelector("div#bl_systolicbp .label-element")).getText().trim();
		
		String cs2 = driver.findElement(By.cssSelector("div:nth-of-type(4) .label-element")).getText().trim();
		
		String hR = driver.findElement(By.cssSelector("div#bl_heartrate .label-element")).getText().trim();
		
		String cs3 = driver.findElement(By.cssSelector("div:nth-of-type(6) .label-element")).getText().trim();
		
		String BT = driver.findElement(By.cssSelector("div#bl_bodytemp .label-element")).getText().trim();
		
		String cs4 = driver.findElement(By.cssSelector("div:nth-of-type(8) .label-element")).getText().trim();
		
		String rR = driver.findElement(By.cssSelector("div#bl_resprate .label-element")).getText().trim();
		
		String cs5 = driver.findElement(By.cssSelector("div:nth-of-type(10) .label-element")).getText().trim();
		
		/**
		 * Add all the String values in ArrayList 
		 */
		 ArrayList<String> List1= new ArrayList<String>(Arrays.asList(BP,cs1,SBP,cs2,hR,cs3,BT,cs4,rR,cs5));
		 
		 

			/**
			 * Getting labels in XL for BVS
			 */
			ArrayList<String> List = new ArrayList<String>();
			for(int i=13;i<28;i++) {
			String XlDta=obj.getCellData("BL_VITAL SIGNS", 6, "FIELD LABEL", i).trim();
			List.add(XlDta);
			}
			List.removeAll(Collections.singleton(""));
			/**
			 * Compare two WebApp title with XL title and set value in XL
			 */
			
			if(List1.equals(List)) {
				for (int i=13;i<28;i++) {
					obj.setCellData("BL_VITAL SIGNS", 6, "Field Label Verification", "Labels were verified", i);
				}
			}
		 
		 /**
		  * To fill the input in Baseline vital sign next page
		  */

			String conBP=elementManager.sendKeyInputcaptureQueryTextcss(driver, "input[name='bl_diastolicbp']", "151", "66",
			"div#bl_diastolicbp .label-element", "span > li",
			"BL_VITAL SIGNS", 6, "QUERY TEXT", 13, "Query Text Verification", "Query text Verified", 13, ".page-form > div:nth-of-type(2) .label-element");
					
		 
			driver.findElement(By.cssSelector("span:nth-of-type(2) > .radio-inline > input[name='bl_diastolicbp_CS']")).click();
			
			
			String conSBP=elementManager.sendKeyInputcaptureQueryTextcss(driver, "input[name='bl_systolicbp']", "32", "66",
					"div#bl_systolicbp .label-element", "span > li",
					"BL_VITAL SIGNS", 6, "QUERY TEXT", 16, "Query Text Verification", "Query text Verified", 16, "div:nth-of-type(4) .label-element");
								
		 
			driver.findElement(By.cssSelector("div:nth-of-type(4) > .input-container > span:nth-of-type(3) > .radio-inline")).click();
			
			String conHR=elementManager.sendKeyInputcaptureQueryTextcss(driver, "input[name='bl_heartrate']", "32", "66",
					"div#bl_heartrate .label-element", "span > li",
					"BL_VITAL SIGNS", 6, "QUERY TEXT", 19, "Query Text Verification", "Query text Verified", 19, "div:nth-of-type(10) .label-element");
								
			
			driver.findElement(By.cssSelector("span:nth-of-type(2) > .radio-inline > input[name='bl_heartrate_CS']")).click();
			
			
			driver.findElement(By.cssSelector(".multiselect__select")).click();
		
			
			driver.findElement(By.cssSelector("[test-id=\"test_ni_input_bl_bodytemp_options\"] .multiselect__content>li:nth-of-type(3)")).click();
			
			
			String conTemp=elementManager.sendKeyInputcaptureQueryTextcss(driver, "input[name='bl_bodytemp']", "32", "99",
					"div#bl_bodytemp .label-element", "span > li",
					"BL_VITAL SIGNS", 6, "QUERY TEXT", 23, "Query Text Verification", "Query text Verified", 23, "div:nth-of-type(10) .label-element");
								
			
			driver.findElement(By.cssSelector("span:nth-of-type(3) > .radio-inline > input[name='bl_bodytemp_CS']")).click();
			
			//driver.findElement(By.cssSelector("[test-id=\"test_ni_input_bl_bodytemp_options\"] .multiselect__content>li:nth-of-type(3)")).click();
			
			String conRR=elementManager.sendKeyInputcaptureQueryTextcss(driver, "input[name='bl_resprate']", "5", "22",
					"div#bl_resprate .label-element", "span > li",
					"BL_VITAL SIGNS", 6, "QUERY TEXT", 23, "Query Text Verification", "Query text Verified", 23, "div:nth-of-type(10) .label-element");
								
			
			driver.findElement(By.cssSelector("div:nth-of-type(10) > .input-container > span:nth-of-type(3) > .radio-inline")).click();
			
			
			String bvsBottomTitle = driver.findElement(By.cssSelector("div:nth-of-type(11) .label-element")).getText().trim();
			
		String xlbvsBottomTitle=obj.getCellData("BL_VITAL SIGNS", 6, "FIELD LABEL", 28).trim();
		if(bvsBottomTitle.equals(xlbvsBottomTitle)) {
			obj.setCellData("BL_VITAL SIGNS", 6, "Field Label Verification", "Verified", 28);
		}
			
		
			/**
			 * To Next Page
			 */
			
			driver.findElement(By.cssSelector("button#btnnext")).click();
			
			
			PficVitaminPanelPage objVit=new PficVitaminPanelPage();
			
			objVit.PVPL();
			
			
			
	}
}
		
		
		
		
	
	
	
	
	
	

