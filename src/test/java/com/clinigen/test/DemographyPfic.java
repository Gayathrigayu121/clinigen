package com.clinigen.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.clinigen.util.WebElementManager;

import java.time.Duration;

@Test(priority=1)
public class DemographyPfic extends Base {

	static ExcelColName obj = new ExcelColName("./Excel/Book.xlsx");

	/**
	 * After added the patient, need to fill out the BaseLine To fill the
	 * Indication,Date of Baseline Visit,Ethnicity,Race
	 * 
	 * @throws Exception
	 */
	@Test(priority=1)
	public static void baseLineDemography() throws Exception {

		WebElementManager elementManager=new WebElementManager();
		

		List<WebElement> findElements = driver.findElements(By.cssSelector(".VueTables__row "));
		int patientSize = findElements.size();
		findElements.get(patientSize - 1).click();
		
				
				
				/**
				 * To get the HomePage Content
				 * equals to Excel Sheet Page
				 */
				List<String> homePageContent=elementManager.getElementBycss(driver, ".action-section-list>div.pateint-summary>ul>li.list-group-item");
				elementManager.waitWebDriver(driver, "ul.list-group>li:nth-of-type(4)>div.handle-pointer>div>span.actionTitle");
					
				

				//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.list-group>li:nth-of-type(4)>div.handle-pointer>div>span.actionTitle"))).click();

				/**
				 * By using List select the Indication option by generating random number
				 */

				//List<String> addL=	elementManager.clickRandomOption(driver, "(//div[@class='multiselect__content-wrapper'])[2]//li", "div.input-container.select-container>.select>.multiselect>.multiselect__select", 2, 1);
				//elementManager.clickRamdomOptionxpathText(driver, "(//div[@class='multiselect__content-wrapper'])[2]//li", 2, 1);
				
				
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.input-container.select-container>.select>.multiselect>.multiselect__select"))).click();
				
				//int randomIntValue = (int)( Math.floor( Math.random() * (1 - 1))) + 1;
				List<WebElement> list2 = driver.findElements(By.xpath("(//div[@class='multiselect__content-wrapper'])[2]//li"));
				List<String> addL=new ArrayList<String>();
				for(WebElement copyElement:list2) {
					addL.add(copyElement.getText().trim());
				}
				
		 
				/**
				 * Indication PFIC
				 */
				//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.input-container.select-container>.select>.multiselect>.multiselect__select"))).click();
			WebElement e=driver.findElement(By.cssSelector("[test-id='test_dd_input_Indication1_options'] ul.multiselect__content>li:nth-of-type(3)"));
				e.click();
			
				
				/**
				 * To get Ethnicity options from webpage
				 */
				
				//elementManager.waitWebDriver(driver, "[test-id=\"test_commonSelect_Ethnicity\"]");
			//	List<String> stringList=elementManager.getElementByXpath(driver, "//div[4]/ul/li/span");
				
				List<String> stringList=elementManager.clickRandomOption(driver, "//div[4]/ul/li/span", "[test-id=\"test_commonSelect_Ethnicity\"]", 3, 1);
				
				/**
				 * To get race options from webpage
				 */

				List<String> raceList = elementManager.clickRandomOptionjs(driver, "div.ms-prompt>div",  "span.control-icon", 6, 1);
				elementManager.waitWebDriver(driver, "button.button-primary");				
				raceList.remove("Please select");
				
				
				
				/**
				 * Merged two list
				 */
				
				List<String> addAl=new ArrayList<String>();
				addAl.addAll(addL);
				addAl.addAll(stringList);
			    addAl.remove("Please select"); 
				addAl.remove("Please select"); 
				addAl.addAll(raceList);
				addAl.removeAll(Collections.singleton(""));
				  
				
				  /**
					 * To Read Excel data for Indication List,Ethnicity,race
					 */
					List<String> listIndi = new ArrayList<String>();
					String cellData = obj.getCellData("DEMOGRAPHY", 6, "List items", 7);
					String cellData1 = obj.getCellData("DEMOGRAPHY", 6, "List items", 10);
					String cellData2 = obj.getCellData("DEMOGRAPHY", 6, "List items", 11);
					String[] celldat=cellData.split("/");
					
					for(String a:celldat)
					{
						listIndi.add(a.trim());
					}
					String[] celldat1=cellData1.split("/");
					for(String a1:celldat1)
					{
						listIndi.add(a1.trim());		
						}
		         String[] celldat2=cellData2.split("/");
					
					for(String a:celldat2)
					{
						listIndi.add(a.trim());
					}
					if(listIndi.equals(addAl))
					{
						System.out.println("Item List");
						 for(int k=7;k<12;k++) {
						 obj.setCellData("DEMOGRAPHY", 6, "Item Lists verification", "ListItems Verified",k); 
								  }
					}
				
				
				
					/**
					 * HardCode of Indication
					 */
					// wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
					// "div.input-container.select-container>.select>.multiselect>.multiselect__select"))).click();
					// wait.until(ExpectedConditions.elementToBeClickable(By.
					// cssSelector("[test-id='test_dd_input_Indication1_options'] ul.multiselect__content>li:nth-of-type(3)"))).click();
					// driver.findElement(By.cssSelector("div.mx-input-wrapper>input.mx-input")).click();

				
				

				/**
				 * Date of Baseline Visit
				 */
					
					
					
				
					elementManager.dateOfBaseline(driver, "div.mx-input-wrapper>input", ".mx-calendar.mx-calendar-panel-date>div.mx-calendar-header", "Feb", "2014", ".mx-calendar.mx-calendar-panel-date>div>a.mx-icon-last-month","(//td[text()='14'])[1]");
			/**
			 * Capture text
			 */
					WebElement ele = driver.findElement(By.cssSelector("div.input-container.calendar"));
					Actions action = new Actions(driver);
					action.moveToElement(ele).perform();
					WebElement ele1 = driver.findElement(By.cssSelector("span > li"));
					action.moveToElement(ele1).perform();
					String text=ele1.getText().trim();
				
			    
			elementManager.dateOfBaselineafterMonth(driver, "div.mx-input-wrapper>input", ".mx-calendar.mx-calendar-panel-date>div.mx-calendar-header", "Feb", "2020", "a.mx-icon-next-month","(//td[text()='14'])[1]","//div[@id='page-title']/div[2]/form/div[4]/div/label/span");
				/**
				 * Query text verification
				 *
				 */
			
			System.out.println("text ="+text);		
			String xlText=	obj.getCellData("DEMOGRAPHY", 6, "QUERY TEXT", 8);
			String con=String.join(" : ", xlText,text);
				obj.setCellData("DEMOGRAPHY", 6, "QUERY TEXT VERIFICATION", " Query text verified", 8);
			
				
						
				
				
				/**
				 * To Select Ethnicity
				 */

//				elementManager.waitWebDriver(driver, "[test-id='test_commonSelect_Ethnicity'] div.multiselect__select");
//				elementManager.waitWebDriver(driver, "[test-id='test_dd_input_Ethnicity_options'] ul.multiselect__content>li:nth-of-type(3)>span");
//				elementManager.waitWebDriver(driver, "i.fas.fa-pencil-alt");
				
				
				/**
				 * To Select Race
				 */

//				elementManager.waitWebDriver(driver, "label.checkbox[name='Race_2'] [test-id='test_commonCheckbox_test_multiselector_Race_2']");
//				elementManager.waitWebDriver(driver, "button.button-primary[test-id='test_ms_btn_submit']");
				
				

				if (driver.getTitle().equals("Baseline Plus - Maralixibat")) {
					Assert.assertTrue(true);
					CaptureShotp.Snapshot(driver, "BaseLineDemographyPage");
				} 
				else {
					Assert.assertTrue(false);
					CaptureShotf.Snapshot(driver, "BaseLineDemographyPage");
				}

				
				  
				  String text22 = driver.findElement(By.id("page-description")).getText();
				  String tx5 = driver.findElement(By.cssSelector("div#page-header > .has-tooltip.page-title"
				  )).getText(); 
				  String tx = driver.findElement(By.cssSelector(".page-form > div:nth-of-type(1) .label-element")).getText();
				  
				  String tx1 =
				  driver.findElement(By.cssSelector(".page-form > div:nth-of-type(2) .label-element")).getText();
				  String tx2 = driver.findElement(By.cssSelector(".page-form > div:nth-of-type(3) .label-element")).getText();
				  String tx3 =  driver.findElement(By.cssSelector(".page-form > div:nth-of-type(4) .label-element")).getText();
					
				  
				  //String con=String.join("", tx,tx1,tx2,tx3); //
				 // String[] arr= {tx,tx1,tx2,tx3};
				  ArrayList<String> List1= new
				  ArrayList<String>(Arrays.asList(tx,tx1,tx2,tx3));
				  
				  ExcelColName obj=new ExcelColName("./Excel/Book.xlsx");
				  ArrayList<String> List2 = new ArrayList<String>(); 
				  for(int i=7;i<13;i++) { 
				  String cellDatan =obj.getCellData("DEMOGRAPHY", 6, "FIELD LABEL",i); 
				  List2.add(cellDatan); }
				  List2.remove(2); List2.remove(4); 
				  if(List1.equals(List2)) {
				  for(int j=7;j<13;j++) {
				  obj.setCellData("DEMOGRAPHY", 6, "Field Label Verification", "pass",j); 
				  }
				  }
				  
				  String titleData = obj.getTitleData("DEMOGRAPHY", 0, 1); String titleData1 =
				  obj.getTitleData("DEMOGRAPHY", 2, 1); String titleData2 =
				  obj.getTitleData("DEMOGRAPHY", 3, 1);
				  
				  String titleData3=String.join(" : ",titleData1,titleData);
				  
				  
				  if(titleData2.equals(text22)) { if(titleData3.equalsIgnoreCase(tx5)) {
				  obj.setTitleData("DEMOGRAPHY", 0, 6, "pass"); 
				  obj.setTitleData("DEMOGRAPHY",3, 6, "pass");
				  
				  
				  }
				  }
				  driver.findElement(By.id("btnnext")).click();
				  PficHistory ss=new PficHistory();
				  ss.baselinePFIChistory();
				
			}

		}