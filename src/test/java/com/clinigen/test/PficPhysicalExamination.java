package com.clinigen.test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clinigen.util.WebElementManager;

public class PficPhysicalExamination extends PficHistory {

	public void PifcPE() throws Exception {
		WebElementManager elementManager = new WebElementManager();
		/**
		 * PIFC Physical Examination
		 *  Get Title from Web APP
		 */
		
		String pageTitle = driver.findElement(By.cssSelector(".custom-label.full-width-label > .label-element")).getText().trim();
		String PageSubTitle = driver.findElement(By.cssSelector("div#page-description")).getText().trim();
		
		
		/**
		 * To get title labels from excel
		 */
		
		 String xlpageTitle = obj.getTitleData("PE", 0, 1).trim();   
		 String xlPageSubTitle =obj.getTitleData("PE", 3, 1).trim();
		  
		/**
		 * Compare the WebApp Title with Xl Title
		 */
		
		if(pageTitle.equals(xlpageTitle)) {
			if(PageSubTitle.equals(xlPageSubTitle)) {
				obj.setTitleData("PE", 0, 6, "CRF Page name verified");
				obj.setTitleData("PE", 3, 6, "Page level completion instruction verified");
			}
		}
		
		/**
		 * Adding new PE data
		 */
		
		driver.findElement(By.cssSelector("button[value='Add']")).click();
		
		/**
		 * Getting labels in WebApp for PE-DOA,BS,Result
		 */
		
		String dOA = driver.findElement(By.cssSelector("[for='PE_DT'] .label-element")).getText().trim();
		
		String bS= driver.findElement(By.cssSelector("div:nth-of-type(2) > .custom-label-container > .custom-label > .label-element")).getText().trim();
		
		//String sO= driver.findElement(By.cssSelector("div:nth-of-type(3) > .custom-label-container > .custom-label > .label-element")).getText().trim();
		
		String result = driver.findElement(By.cssSelector("div:nth-of-type(3) > .custom-label-container > .custom-label > .label-element")).getText().trim();
		
		 ArrayList<String> List1= new ArrayList<String>(Arrays.asList(dOA,bS,result));
		
		/**
		 * Getting labels in XL for PE-DOA,BS,Result
		 */
		ArrayList<String> List = new ArrayList<String>();
		for(int i=7;i<11;i++) {
		String XlDta=obj.getCellData("PE", 6, "FIELD LABEL", i).trim();
		List.add(XlDta);
		}
		List.remove("Specify Other");
		/**
		 * Compare two WebApp title with XL title and set value in XL
		 */
		
		if(List1.equals(List)) {
			for (int i=7;i<11;i++) {
				obj.setCellData("PE", 6, "Field Label Verification", "Labels were verified", i);
			}
		}
		
		
		/**
		 * In Next Page
		 * To fill Date of Assessment
		 */
	
	elementManager.dateOfBaseline(driver, "input[name='date']", "div.mx-calendar-header", "Mar", "2021", "a.mx-icon-last-month",
			"(.//*[normalize-space(text()) and normalize-space(.)='S'])[2]/following::td[18]");
		
		
		/**
		 * Capture Query Text 
		 * for Date of Assessment
		 */
		elementManager.captureQueryTextcss(driver, ".input-wrapper.soft-stop-error > .custom-label-container > .custom-label > .label-element", 
				"span > li", 
				"PE", 6, "QUERY TEXT", 7, "Query Text Verification", "Query Text Verified", 7, 
				"/html//div[@id='my-box']/div[3]//div[@class='full-message']/div[3]/div[@class='custom-label-container']//span[@class='label-element']");
		
		/**
		 * mouse  hover to another element 
		 */
		Actions action=new Actions(driver);
		WebElement ele=driver.findElement(By.cssSelector("div:nth-of-type(3) > .custom-label-container > .custom-label > .label-element"));
		action.moveToElement(ele).perform();
		
		
	
		elementManager.dateOfBaseline(driver, "input[name='date']", "div.mx-calendar-header", "Feb", "2020", "a.mx-icon-last-month",
				"/html//div[@class='mx-datepicker-popup']/div[@class='mx-calendar mx-calendar-panel-date']//table[@class='mx-panel mx-panel-date']//td[@title='14 Feb 2020']");
		
		
		
		
		//driver.findElement(By.cssSelector("body > div.multiselect__content-wrapper>.multiselect__content>li")).click();
		
		
		elementManager.clickRandomOptionjs(driver, "[test-id=\"test_dd_input_PE_Bodysystem_options\"].multiselect__content-wrapper>.multiselect__content>li",
				".full-message > div:nth-of-type(2) .multiselect > .multiselect__select", 
				10, 1);
		
		
		//driver.findElement(By.cssSelector(".full-message > div:nth-of-type(3) .multiselect > .multiselect__select")).click();
		//driver.findElement(By.cssSelector("div:nth-of-type(4) > .multiselect__content  .multiselect__option.multiselect__option--highlight > span")).click();
		
		elementManager.clickRandomOptionjs(driver, "[test-id=\"test_dd_input_PE_Result_options\"].multiselect__content-wrapper>.multiselect__content>li>span",
				".full-message > div:nth-of-type(3) .multiselect > .multiselect__select",
				4, 2);
		
		/**
		 * Click ok to move next Pagetest_dd_input_PE_Bodysystem_options
		 */
		
		driver.findElement(By.cssSelector(".popup-footer > button:nth-of-type(1)")).click();
		driver.findElement(By.cssSelector("button#btnnext")).click();
		
		
		//*****************PFIC Baseline Vital Signs****************************************************************************
		
		
		/**
		 * PFIC Baseline Vital Signs
		 */
		
		
		
		/**
		 * PIFC Baseline Vital Signs
		 *  Get Title from Web APP
		 */
		
		String bvsPageTitle = driver.findElement(By.cssSelector("div#page-header > .has-tooltip.page-title")).getText().trim();
		String bvsPageSubTitle = driver.findElement(By.cssSelector("div#page-description")).getText().trim();
		
		
		/**
		 * To get title labels from excel
		 */
		
		 String xlbvsPageTitle1 = obj.getTitleData("BL_VITAL SIGNS", 0, 1).trim(); 
		 String xlbvsPageTitle2 = obj.getTitleData("BL_VITAL SIGNS", 0, 1).trim();
		 String xlbvsPageTitle=String.join(":", xlbvsPageTitle2,xlbvsPageTitle1).trim();
		 String xlbvsPageSubTitle =obj.getTitleData("BL_VITAL SIGNS", 3, 1).trim();
		  
		/**
		 * Compare the WebApp Title with Xl Title
		 */
		
		if(xlbvsPageTitle.equals(bvsPageTitle)) {
			if(xlbvsPageSubTitle.equals(bvsPageSubTitle)) {
				obj.setTitleData("BL_VITAL SIGNS", 0, 6, "CRF Page name verified");
				obj.setTitleData("BL_VITAL SIGNS", 3, 6, "Page level completion instruction verified");
			}
		}
		
		
		/**
		 * Getting labels in WebApp for BVS-DOA,Height,weight
		 */
		
		String BVSdOA = driver.findElement(By.cssSelector(".page-form > div:nth-of-type(1) .label-element")).getText().trim();
		
		String height= driver.findElement(By.cssSelector("div#bl_height .label-element")).getText().trim();
		
		String weight= driver.findElement(By.cssSelector("div#bl_weight .label-element")).getText().trim();
		
		
		
		 ArrayList<String> bvsList= new ArrayList<String>(Arrays.asList(BVSdOA,height,weight));
		
		/**
		 * Getting labels in XL for BVS-DOA,Height,weight
		 */
		ArrayList<String> xlList = new ArrayList<String>();
		for(int i=7;i<11;i++) {
		String XlData=obj.getCellData("BL_VITAL SIGNS", 6, "FIELD LABEL", i).trim();
		xlList.add(XlData);
		xlList.removeAll(Collections.singleton(""));
		}
		/**
		 * Compare two WebApp title with XL title and set value in XL
		 */
		
		if(bvsList.equals(xlList)) {
			for (int i=7;i<11;i++) {
				obj.setCellData("BL_VITAL SIGNS", 6, Constants.Field_Label_Verification, Constants.Labels_were_verified, i);
			}
		}
		
		
		
		/**
		 * Date of Assessment BaseLine Vital Sign with edit check specification
		 */
		
		
		elementManager.dateOfBaseline(driver, "input[name='date']", 
				"div.mx-calendar-header", "Apr", "2020", "[test-id=\"test_dateField_bl_date\"] .mx-icon-last-month",
				"/html//div[@class='mx-datepicker-popup']/div[@class='mx-calendar mx-calendar-panel-date']//table[@class='mx-panel mx-panel-date']//td[@title='16 Apr 2020']");
		
		
		elementManager.captureQueryTextcss(driver, ".input-wrapper.soft-stop-error .label-element", "span > li",
				"BL_VITAL SIGNS", 6, "QUERY TEXT", 7, Constants.Query_Text_Verification,
				Constants.Query_Text_Verified, 7, "//div[@id='bl_weight']/div[@class='custom-label-container']//span[@class='label-element']");
		
		
		
		elementManager.dateOfBaselineafterMonth(driver, "input[name='date']", "div.mx-calendar-header", "Feb", "2020",
				"[test-id=\"test_dateField_bl_date\"] .mx-icon-last-month", "/html//div[@class='mx-datepicker-popup']/div[@class='mx-calendar mx-calendar-panel-date']//table[@class='mx-panel mx-panel-date']//td[@title='14 Feb 2020']",
				"//div[@id='bl_weight']/div[@class='custom-label-container']//span[@class='label-element']");
		
		
		
		
		/**
		 * To give Input to Height and Weight 
		 * Cpature Query text compare with excel
		 */
		
	
		
		/**
		 * Below limit of height
		 */
	String concodination=elementManager.sendKeyInputcaptureQueryTextcss(driver, "input[name='bl_height']", "5", "66",
			"#bl_height > div.input-container", "span > li",
			"BL_VITAL SIGNS", 6, "QUERY TEXT", 8, Constants.Query_Text_Verification, Constants.Query_Text_Verified, 8, "div#bl_weight .label-element");
	/**
	 * above limit of height
	 */
	String concodination1=elementManager.sendKeyInputcaptureQueryTextcss(driver, "input[name='bl_height']", "555", "66",
			"#bl_height > div.input-container", "span > li",
			"BL_VITAL SIGNS", 6, "QUERY TEXT", 9, Constants.Query_Text_Verification, Constants.Query_Text_Verified, 9, "div#bl_weight .label-element");
		/**
		 * Below limit of weight
		 */
	String conbelowweight=elementManager.sendKeyInputcaptureQueryTextcss(driver, "input[name='bl_weight']", "3", "66",
			"div#bl_weight .label-element", "span > li",
			"BL_VITAL SIGNS", 6, "QUERY TEXT", 10, Constants.Query_Text_Verification, Constants.Query_Text_Verified, 10, ".page-form > div:nth-of-type(1) .label-element");

		
	       /**
	         * Above limit of weight
	          */
         String conaboveweight=elementManager.sendKeyInputcaptureQueryTextcss(driver, "input[name='bl_weight']", "101", "66",
		"div#bl_weight .label-element", "span > li",
		"BL_VITAL SIGNS", 6, "QUERY TEXT", 11, Constants.Query_Text_Verification, Constants.Query_Text_Verified, 11, ".page-form > div:nth-of-type(1) .label-element");
		
		
		/**
		 * To go to next page
		 * Completion of BVS
		 */
		
		driver.findElement(By.cssSelector("button#btnnext")).click();
		
		
		/**
		 * Next Page BVS
		 */
		
		BaselineVitalSignNewPage bsvobj=new BaselineVitalSignNewPage();

		bsvobj.bVSNP();
		
	}
	
	
	
	
}
