package com.clinigen.test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.clinigen.util.WebElementManager;

public class PficHistory extends DemographyPfic {

	@Test
	public static void baselinePFIChistory() throws Exception {
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

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='S'])[2]/following::td[16]"))).click();

		/**
		 * CaptureText
		 */

		WebElement ele = driver.findElement(By.cssSelector("div.input-container.calendar"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		WebElement ele1 = driver.findElement(By.cssSelector("span > li"));
		action.moveToElement(ele1).perform();
		String text = ele1.getText().trim();
		System.out.println("text of diagnosis =" + text);

		String xlText = obj.getCellData("PFIC_MH", 6, "QUERY TEXT", 8);
		String con = String.join(" : ", xlText, text);

		obj.setCellData("PFIC_MH", 6, "QUERY TEXT VERIFICATION", " QUERY TEXT verified", 8);

		WebElement eles = driver.findElement(By.xpath("//div[@id='page-title']/div[2]/form/div[3]/div/label/span"));
		action.moveToElement(eles).perform();
		elementManager.dateOfBaseline(driver, "input[name=\"date\"]", "div[class='mx-calendar-header']", "Dec", "2014",
				"a.mx-icon-last-month",
				"(.//*[normalize-space(text()) and normalize-space(.)='S'])[2]/following::td[17]");

		/**
		 * CaptureText
		 */

		WebElement elet = driver.findElement(By.cssSelector("div.input-container.calendar"));
		action.moveToElement(elet).perform();
		WebElement eley = driver.findElement(By.cssSelector("span > li"));
		action.moveToElement(eley).perform();
		String texty = eley.getText().trim();
		System.out.println("texty =" + texty);

		elementManager.dateOfBaselineafterMonth(driver, "input[name=\"date\"]", "div[class='mx-calendar-header']",
				"Dec", "2018", "a.mx-icon-next-month",
				"(.//*[normalize-space(text()) and normalize-space(.)='S'])[2]/following::td[32]",
				"//div[@id='page-title']/div[2]/form/div[3]/div/label/span");

		StringBuffer sbf = new StringBuffer(texty);
		sbf.delete(57, 64);
		String xlTexty = obj.getCellData("PFIC_MH", 6, "QUERY TEXT", 7).trim();
		String con1 = String.join(" : ", xlTexty, sbf);

		obj.setCellData("PFIC_MH", 6, "QUERY TEXT VERIFICATION", " QUERY TEXT verified", 7);

		/**
		 * Specify Mutation
		 */

		WebElement elets = driver.findElement(By.xpath("//div[@id='page-title']/div[2]/form/div[3]/div/label/span"));
		action.moveToElement(elets).perform();
		driver.findElement(By.cssSelector("input[name='PFIC_mutation']")).click();
		driver.findElement(
				By.cssSelector("[test-id='test_commonSelect_PFIC_mutation_specify'].multiselect>.multiselect__select"))
				.click();

		String textw = elementManager.clickRamdomOptionxpathText(driver, "(//ul[@class='multiselect__content'])[2]/li",
				6, 1);

		/**
		 * In Specify mutation if it select the option other text box will appear Fill
		 * the text box
		 */

		if (textw.equalsIgnoreCase("other")) {
			driver.findElement(By.cssSelector(".input-text-field")).sendKeys("qwertyuiopasdfghjklzxcvbnmqwer");
		}

		/**
		 * Specify Zygosity
		 */

		List<String> randomOption = elementManager.clickRandomOption(driver,
				"(//ul[@class='multiselect__content'])[2]//li",
				"[test-id='test_commonSelect_PFIC_Zygosity_specify'].multiselect>.multiselect__select", 2, 1);
		/*
		 * wait.until(ExpectedConditions.elementToBeClickable( By.cssSelector(
		 * "[test-id='test_commonSelect_PFIC_Zygosity_specify'].multiselect>.multiselect__select"
		 * ))) .click(); List<WebElement> elements1 =
		 * driver.findElements(By.xpath("(//ul[@class='multiselect__content'])[2]//li"))
		 * ;
		 */

		/**
		 * PFIC History Page verification
		 */

		String t1 = driver.findElement(By.cssSelector("div.page-title.has-tooltip")).getText().trim();

		String t2 = driver.findElement(By.cssSelector("#page-description")).getText().trim();

		String t3 = driver.findElement(By.xpath("(//div[@id='page-title']/div[2]/form/div/div/label/span)[1]"))
				.getText().trim();
		String t4 = driver.findElement(By.xpath("(//div[@id='page-title']/div[2]/form/div/div/label/span)[2]"))
				.getText().trim();

		String t5 = driver.findElement(By.xpath("(//div[@id='page-title']/div[2]/form/div/div/label/span)[3]"))
				.getText().trim();

		String t6 = driver.findElement(By.xpath("(//div[@id='page-title']/div[2]/form/div[4]/div/label/span)[1]"))
				.getText().trim();
		String t7 = driver.findElement(By.xpath("(//div[@id='page-title']/div[2]/form/div/div/label/span)[4]"))
				.getText().trim();

		ArrayList<String> List1 = new ArrayList<String>(Arrays.asList(t1, t2, t3, t4, t5, t6, t7));
		ArrayList<String> Listxl = new ArrayList<String>();
		for (int i = 7; i < 13; i++) {
			String cellDatan = obj.getCellData("PFIC_MH", 6, "FIELD LABEL", i).trim();
			Listxl.add(cellDatan);
		}
		Listxl.removeAll(Collections.singleton(""));
		List1.removeAll(Collections.singleton(""));
		List1.remove("Baseline : PFIC History");
		List1.remove("Please complete the following details");
		Listxl.remove("Specify Mutation");
		Listxl.remove("Specify Other Mutation");
		
		if (Listxl.equals(List1)) {
			for (int i = 7; i < 13; i++) {
				
				obj.setCellData("PFIC_MH", 6, "Field Label Verification", "Verified", i);
			}

		}

		/**
		 * PFIC History page title label verification
		 */

		String text22 = driver.findElement(By.cssSelector("#page-description")).getText().trim();
		String tx5 = driver.findElement(By.xpath("//div[@id='page-header']/div")).getText().trim();
		String titleData = obj.getTitleData("PFIC_MH", 0, 1).trim();
		String titleData1 = obj.getTitleData("PFIC_MH", 2, 1).trim();
		String titleData2 = obj.getTitleData("PFIC_MH", 3, 1).trim();
		String titleData3 = String.join(" : ", titleData1, titleData).trim();
		if (titleData2.equals(text22)) {
			if (titleData3.equals(tx5)) {
				System.out.println("PFIC HIstory page Title Verified");
				obj.setTitleData("PFIC_MH", 0, 6, " PFIC History Verified");
				obj.setTitleData("PFIC_MH", 3, 6, "Page level completion Instruction Verified");
			}
		}

		driver.findElement(By.id("btnnext")).click();

		/**
		 * Baseline:PFIC History
		 */

		driver.findElement(By.xpath("(//input[@class='scale-input'])[1]")).click();
		driver.findElement(By.xpath("(//input[@class='scale-input'])[5]")).click();
		driver.findElement(By.xpath("(//input[@class='scale-input'])[8]")).click();
		driver.findElement(By.xpath("(//input[@class='scale-input'])[10]")).click();
		driver.findElement(By.xpath("(//input[@class='scale-input'])[13]")).click();
		driver.findElement(By.xpath("(//input[@class='scale-input'])[16]")).click();
		driver.findElement(By.xpath("(//input[@class='scale-input'])[19]")).click();
		driver.findElement(By.xpath("(//input[@class='scale-input'])[23]")).click();
		driver.findElement(By.xpath("(//input[@class='scale-input'])[25]")).click();
		driver.findElement(By.xpath("(//input[@class='scale-input'])[28]")).click();

		/**
		 * Baseline:PFIC History label verfication
		 */

		String h1 = driver.findElement(By.xpath("(//div[@id='page-title']/div[2]/form/div/div/label/span)[1]"))
				.getText().trim();

		String h2 = driver.findElement(By.xpath("(//div[@id='page-title']/div[2]/form/div/div/label/span)[3]"))
				.getText().trim();

		String h3 = driver.findElement(By.xpath("(//div[@id='page-title']/div[2]/form/div/div/label/span)[5]"))
				.getText().trim();

		String h4 = driver.findElement(By.xpath("(//div[@id='page-title']/div[2]/form/div/div/label/span)[7]"))
				.getText().trim();

		String h5 = driver.findElement(By.xpath("(//div[@id='page-title']/div[2]/form/div/div/label/span)[9]"))
				.getText().trim();
		String h6 = driver.findElement(By.xpath("(//div[@id='page-title']/div[2]/form/div/div/label/span)[11]"))
				.getText().trim();
		String h7 = driver.findElement(By.xpath("(//div[@id='page-title']/div[2]/form/div/div/label/span)[13]"))
				.getText().trim();
		String h8 = driver.findElement(By.xpath("(//div[@id='page-title']/div[2]/form/div/div/label/span)[15]"))
				.getText().trim();
		String h9 = driver.findElement(By.xpath("(//div[@id='page-title']/div[2]/form/div/div/label/span)[17]"))
				.getText().trim();
		String h10 = driver.findElement(By.xpath("(//div[@id='page-title']/div[2]/form/div/div/label/span)[19]"))
				.getText().trim();
		String h11 = driver.findElement(By.xpath("(//div[@id='page-title']/div[2]/form/div/div/label/span)[21]"))
				.getText().trim();

		ArrayList<String> List11 = new ArrayList<String>(Arrays.asList(h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11));
		ArrayList<String> Listx12 = new ArrayList<String>();
		for (int i = 13; i < 24; i++) {

			String cellDatan = obj.getCellData("PFIC_MH", 6, "FIELD LABEL", i).trim();
			Listx12.add(cellDatan);
		}
		Listx12.removeAll(Collections.singleton(""));

		System.out.println("Listxl is=" + Listx12);
		if (List11.equals(Listx12)) {
			for (int i = 13; i < 24; i++) {
				obj.setCellData("PFIC_MH", 6, "Field Label Verification", "Verified", i);
			}

		}

		driver.findElement(By.id("btnnext")).click();

		driver.findElement(By.cssSelector("button[value='Add']")).click();

		/**
		 * Medical History Medical Condition
		 */

		driver.findElement(By.cssSelector("input[name='MH_term']")).sendKeys("qwertyuiopasdf");

		/**
		 * Diagnosis Date
		 */

		elementManager.dateOfBaseline(driver, "[test-id='test_dateField_MH_diagnosis']>.mx-input-wrapper",
				".mx-calendar.mx-calendar-panel-date>.mx-calendar-header", "Jan", "2022", "a.mx-icon-last-month",
				"(.//*[normalize-space(text()) and normalize-space(.)='S'])[2]/following::td[18]");

		/**
		 * CaptureText
		 */

		WebElement elem = driver.findElement(By.cssSelector("div.input-container.calendar"));

		action.moveToElement(elem).perform();
		WebElement elem1 = driver.findElement(By.cssSelector("span > li"));
		action.moveToElement(elem1).perform();
		String texts = elem1.getText().trim();
		System.out.println("text of diagnosis =" + texts);

		String xlTexts = obj.getCellData("MH", 6, "QUERY TEXT", 8);
		String cons = String.join(" : ", xlTexts, text);

		obj.setCellData("MH", 6, "QUERY TEXT VERIFICATION IN Baseline Pfic MH", " Query text verified", 9);

		WebElement elest = driver
				.findElement(By.xpath("//div[@id='my-box']/div[3]/div/div[2]/div/div[2]/div/div[3]/div/label/span"));
		action.moveToElement(elest).perform();

		elementManager.dateOfBaseline(driver, "[test-id='test_dateField_MH_diagnosis']>.mx-input-wrapper",
				".mx-calendar.mx-calendar-panel-date>.mx-calendar-header", "Feb", "2014", "a.mx-icon-last-month",
				"(.//*[normalize-space(text()) and normalize-space(.)='S'])[2]/following::td[10]");

		/**
		 * CaptureText
		 */

		WebElement elems = driver.findElement(By.cssSelector("div.input-container.calendar"));

		action.moveToElement(elems).perform();
		WebElement elem12 = driver.findElement(By.cssSelector("span > li"));
		action.moveToElement(elem12).perform();
		String textx = elem12.getText().trim();
		System.out.println("text of diagnosis =" + textx);

		String xlTextx = obj.getCellData("MH", 6, "QUERY TEXT", 8);
		String conx = String.join(" : ", xlTextx, textx);

		obj.setCellData("MH", 6, "QUERY TEXT VERIFICATION IN Baseline Pfic MH", " Query text verified", 8);

		elementManager.dateOfBaselineafterMonth(driver, "[test-id='test_dateField_MH_diagnosis']>.mx-input-wrapper",
				".mx-calendar.mx-calendar-panel-date>.mx-calendar-header", "Feb", "2020", "a.mx-icon-next-month",
				"(.//*[normalize-space(text()) and normalize-space(.)='S'])[2]/following::td[10]",
				"(//div[@id='my-box']/div[3]/div/div[2]/div/div[2]/div/div[3]/div/label/span)[1]");

		WebElement elementd = driver
				.findElement(By.xpath("/html//div[@id='my-box']/div[3]//div[@class='full-message']/div[1]/div[@class='custom-label-container']//span[@class='label-element']"));
		action.moveToElement(elementd).perform();

		/**
		 * Resolution Date
		 */

		elementManager.dateOfBaseline(driver, "[test-id='test_dateField_MH_endDT'] [name='date']",
				".mx-calendar.mx-calendar-panel-date>.mx-calendar-header", "Mar", "2019",
				".mx-calendar.mx-calendar-panel-date>div>a.mx-icon-last-month",
				"(.//*[normalize-space(text()) and normalize-space(.)='S'])[4]/following::td[25]");

		
		
		/**
		 * CaptureText
		 */
		
		//elementManager.dateOfBaselineafterMonth(driver, year1, xlTextx, month1, year1, month1, textx, conx);

		elementManager.dateOfBaselineafterMonth(driver, "div:nth-of-type(3) > .calendar.input-container > .mx-datepicker  input[name='date']", 
				".mx-calendar.mx-calendar-panel-date>.mx-calendar-header", "May",  "2020", ".mx-calendar.mx-calendar-panel-date  .mx-icon-next-month", "/html/body/div[3]/div[@class='mx-calendar mx-calendar-panel-date']//table[@class='mx-panel mx-panel-date']//td[@title='20 May 2020']", 
				"/html//div[@id='my-box']/div[3]//div[@class='full-message']/div[1]/div[@class='custom-label-container']//span[@class='label-element']");
		
		
		String tr1 = driver.findElement(By.cssSelector("div.modal-title.draggable-header")).getText().trim();
		String tr2 = driver.findElement(By.xpath("(//div[@id='my-box']/div[3]/div/div[2]/div/div[2]/div/div/div/label/span)[1]")).getText().trim();
		String tr3 = driver.findElement(By.xpath("(//div[@id='my-box']/div[3]/div/div[2]/div/div[2]/div/div/div/label/span)[3]")).getText().trim();
		String tr4 = driver.findElement(By.xpath("(//div[@id='my-box']/div[3]/div/div[2]/div/div[2]/div/div/div/label/span)[5]")).getText().trim();

		ArrayList<String> eleList = new ArrayList<String>(Arrays.asList(tr2, tr3, tr4));

		ArrayList<String> eleList2 = new ArrayList<String>();
		for (int i = 7; i < 11; i++) {
			String cellDatan = obj.getCellData("MH", 6, "FIELD LABEL", i);
			eleList2.add(cellDatan);
		}

		eleList2.removeAll(Collections.singleton(""));

		if (eleList.equals(eleList2)) {
			for (int i = 7; i < 11; i++) {
				obj.setCellData("MH", 6, "Field Label verification", " verified", i);
			}
		
		}

		driver.findElement(By.cssSelector(".popup-footer > button:nth-of-type(1)")).click();
		driver.findElement(By.cssSelector("button#btnnext")).click();
		//PficPhysicalExamination pEobj=new PficPhysicalExamination();
		//pEobj.PifcPE();
	}

}
