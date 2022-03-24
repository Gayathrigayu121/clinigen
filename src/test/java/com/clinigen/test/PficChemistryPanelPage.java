package com.clinigen.test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.clinigen.util.WebElementManager;

public class PficChemistryPanelPage extends PficVitaminPanelPage {

	
	
	public void PCPL() throws Exception {
		
		
		WebElementManager elementManager = new WebElementManager();
		

		/**
		 * PIFC Vitamin Panel Lab
		 *  Get Title from Web APP
		 */
		
		String pageTitle = driver.findElement(By.cssSelector(".custom-label.full-width-label > .label-element")).getText().trim();
		String PageSubTitle = driver.findElement(By.cssSelector("div#page-description")).getText().trim();
		
		
		
		/**
		 * PIFC Chemistry Panel Lab
		 *  Get Title from XL Page
		 */
		
		
		 String xlpageTitle = obj.getTitleData("LAB DATA CHEMISTRY", 0, 1).trim();   
		 String xlPageSubTitle =obj.getTitleData("LAB DATA CHEMISTRY", 3, 1).trim();
		  
		/**
		 * Compare the WebApp Title with Xl Title
		 */
		
		if(pageTitle.equals(xlpageTitle)) {
			if(PageSubTitle.equals(xlPageSubTitle)) {
				obj.setTitleData("LAB DATA CHEMISTRY", 0, 6, "CRF Page name verified");
				obj.setTitleData("LAB DATA CHEMISTRY", 3, 6, "Page level completion instruction verified");
			}
		}
		
		/**
		 * Adding new VPL data
		 */
		
		driver.findElement(By.cssSelector("button[value='Add']")).click();
		
		
		/**
		 * Getting labels in WebApp for CPL-dT,TP,result
		 */
		
		String dT = driver.findElement(By.cssSelector("[for='bl_chemlabdate'] .label-element")).getText().trim();
		
		String TP= driver.findElement(By.cssSelector("div:nth-of-type(2) > .custom-label-container > .custom-label > .label-element")).getText().trim();
		
		//String sO= driver.findElement(By.cssSelector("div:nth-of-type(3) > .custom-label-container > .custom-label > .label-element")).getText().trim();
		
		String result = driver.findElement(By.cssSelector("div:nth-of-type(3) > .custom-label-container > .custom-label > .label-element")).getText().trim();
		
		 ArrayList<String> List1= new ArrayList<String>(Arrays.asList(dT,TP,result));
		
		     /**
			 * Getting labels in XL for CPL-dT,TP,result
			 */
			ArrayList<String> List = new ArrayList<String>();
			for(int i=7;i<15;i++) {
			String XlDta=obj.getCellData("LAB DATA CHEMISTRY", 6, "FIELD LABEL", i).trim();
			List.add(XlDta);
			}
			List.remove("Specify Other");
			List.removeAll(Collections.singleton(""));
			/**
			 * Compare two WebApp title with XL title and set value in XL
			 */
			
			if(List1.equals(List)) {
				obj.setCellData("LAB DATA CHEMISTRY", 6, Constants.Field_Label_Verification, Constants.Labels_were_verified, 7);
				for (int i=12;i<15;i++) {
					obj.setCellData("LAB DATA CHEMISTRY", 6,Constants.Field_Label_Verification, Constants.Labels_were_verified, i);
				}
			}
		

			/**
			 * Date Test
			 */
			
			elementManager.dateOfBaseline(driver, "input[name='date']", "div.mx-calendar-header", "Mar", "2021", "a.mx-icon-last-month",
					"(.//*[normalize-space(text()) and normalize-space(.)='S'])[2]/following::td[18]");
			
			
			/**
			 * Capture Query Text 						
			 * of Date Test
			 */
			elementManager.captureQueryTextcss(driver, ".input-wrapper.soft-stop-error > .custom-label-container > .custom-label > .label-element", 
					"span > li","LAB DATA CHEMISTRY", 6, "QUERY TEXT", 8, "Query Text Verification", "Query Text Verified", 8, 
					"/html//div[@id='my-box']/div[3]//div[@class='full-message']/div[3]/div[@class='custom-label-container']//span[@class='label-element']");
			
			

			/**
			 * mouse  hover to another element 
			 */
			Actions action=new Actions(driver);
			WebElement ele=driver.findElement(By.cssSelector("div:nth-of-type(3) > .custom-label-container > .custom-label > .label-element"));
			action.moveToElement(ele).perform();
			
			
		
			elementManager.dateOfBaseline(driver, "input[name='date']", "div.mx-calendar-header", "Feb", "2020", "a.mx-icon-last-month",
					"/html//div[@class='mx-datepicker-popup']/div[@class='mx-calendar mx-calendar-panel-date']//table[@class='mx-panel mx-panel-date']//td[@title='14 Feb 2020']");
			
			
			
			/**
			 * Test Performed Options
			 */
			
		List<String> testPerformedList = elementManager.clickRandomOptionjs(driver, "[test-id=\"test_dd_input_bl_chemlabtest_options\"].multiselect__content-wrapper>ul>li", ".full-message > div:nth-of-type(2) .multiselect > .multiselect__select",
				19, 2);

		testPerformedList.remove("Please select");

		/**
		 * Test Performed Options from Xl
		 */
		ArrayList<String> xlListnew = new ArrayList<String>();
		String LISTSOURCE = obj.getCellData("LAB DATA CHEMISTRY", 6, "LIST SOURCE-DD", 12).trim();
		xlListnew.add(LISTSOURCE);
		if(xlListnew.equals(testPerformedList)) {
		obj.setCellData("LAB DATA CHEMISTRY", 6, "LIST SOURCE-DD verification", "LIST SOURCE-DD verified", 12);
		}
	

		/**
		 * Result Performed Options
		 */
		
		
		List<String> resultList = elementManager.clickRandomOptionjs(driver,"[test-id='test_dd_input_bl_chemlabtest_result_options'].multiselect__content-wrapper>ul>li",
				".full-message > div:nth-of-type(3) .multiselect > .multiselect__select",4,1);
		
		
			

		/**
		 *Choose one from Result Performed Options
		 */
		
		
		String TPRandomText = elementManager.clickRamdomOptioncssText(driver, "[test-id='test_dd_input_bl_chemlabtest_result_options'].multiselect__content-wrapper>ul>li", 4, 1);
		
		if(TPRandomText.equals("Normal")) {
			driver.findElement(By.cssSelector(".popup-footer > button:nth-of-type(1)")).click();
			driver.findElement(By.cssSelector("button#btnnext")).click();
		}  
		else
		{
			  String value = driver.findElement(By.cssSelector("div#bl_chemvalue .label-element")).getText().trim();
			  String units= driver.findElement(By.cssSelector("div:nth-of-type(6) > .custom-label-container > .custom-label > .label-element")).getText().trim();
			  String LRange= driver.findElement(By.cssSelector("div#bl_chemlorange .label-element")).getText().trim();
			  String URange= driver.findElement(By.cssSelector("div#bl_chemuprange .label-element")).getText().trim();
				 ArrayList<String> bvsList= new ArrayList<String>(Arrays.asList(value,units,LRange,URange));
				
				/**
				 * Getting labels in XL for CPL-Value,Units,LR,UR
				 */
				ArrayList<String> xlList = new ArrayList<String>();
				for(int i=15;i<19;i++) {
				String XlData=obj.getCellData("LAB DATA CHEMISTRY", 6, "FIELD LABEL", i).trim();
				xlList.add(XlData);
				xlList.removeAll(Collections.singleton(""));
				}
				/**
				 * Compare two WebApp title with XL title and set value in XL
				 */
			
				if(bvsList.equals(xlList)) {
					for (int i=15;i<19;i++) {
						obj.setCellData("LAB DATA CHEMISTRY", 6, Constants.Field_Label_Verification, Constants.Labels_were_verified, i);
					}
				}	
			
		
				if(TPRandomText.equals("Abnormal Clinically Significant")) {
					String gettext=obj.getCellData("LAB DATA CHEMISTRY", 6, "FIELD LABEL", 14).trim();
					String text = driver.findElement(By.cssSelector("div:nth-of-type(4)  .custom-label > .label-element")).getText().trim();
					if(gettext.equals(text)) {
						obj.setCellData("LAB DATA CHEMISTRY", 6, Constants.Field_Label_Verification, Constants.Verified, 14);
				
				 driver.findElement(By.cssSelector("input[name='bl_chemvalue']")).sendKeys("8");
					
				 driver.findElement(By.cssSelector(".input-container > input[name='bl_chemunits']")).sendKeys("8");
					
				 driver.findElement(By.cssSelector("input[name='bl_chemlorange']")).sendKeys("4");
					
				 driver.findElement(By.cssSelector("input[name='bl_chemuprange']")).sendKeys("10");

				 driver.findElement(By.cssSelector(".popup-footer > button:nth-of-type(1)")).click();

				 driver.findElement(By.cssSelector("input[value='false']")).click();
				
				 driver.findElement(By.cssSelector("button[title='OK']")).click();
						 
				 elementManager.LabQueryText(driver, "div#bl_chemvalue .label-element", "div[role='tooltip'] li", "LAB DATA CHEMISTRY",
								 6, "QUERY TEXT",8, Constants.Query_Text_Verification, Constants.Query_Text_Verified, 8, "input[name='bl_chemvalue']", "55", "div#bl_chemuprange .label-element");
						 
						 
							
//							  JavascriptExecutor js1 = (JavascriptExecutor)driver;
//							  js1.executeScript("arguments[0].click();", element);
							 
							
							driver.findElement(By.cssSelector(".popup-footer > button:nth-of-type(1)")).click();
							driver.findElement(By.cssSelector("button#btnnext")).click();
					}		
				}
							
				if(TPRandomText.equals("Abnormal Non-Clinically Significant")) {
				
					driver.findElement(By.cssSelector("input[name='bl_chemvalue']")).sendKeys("8");
					
					 driver.findElement(By.cssSelector(".input-container > input[name='bl_chemunits']")).sendKeys("8");
						
					 driver.findElement(By.cssSelector("input[name='bl_chemlorange']")).sendKeys("4");
						
					 driver.findElement(By.cssSelector("input[name='bl_chemuprange']")).sendKeys("10");

					 driver.findElement(By.cssSelector(".popup-footer > button:nth-of-type(1)")).click();

					 driver.findElement(By.cssSelector("input[value='false']")).click();
					
					 driver.findElement(By.cssSelector("button[title='OK']")).click();
							 
							 
					 
					 elementManager.LabQueryText(driver, "div#bl_chemvalue .label-element", "div[role='tooltip'] li", "LAB DATA CHEMISTRY",
									 6, "QUERY TEXT",8, Constants.Query_Text_Verification, Constants.Query_Text_Verified, 8, "input[name='bl_chemvalue']", "55", "div#bl_chemuprange .label-element");
							 
							 
	
								driver.findElement(By.cssSelector(".popup-footer > button:nth-of-type(1)")).click();
								driver.findElement(By.cssSelector("button#btnnext")).click();
								
					}
		}	
							PficCBCLabPage cbcobj=new PficCBCLabPage();
							
							cbcobj.PCDLP();
				
			
}
}