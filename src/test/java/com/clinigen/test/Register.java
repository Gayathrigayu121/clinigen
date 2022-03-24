package com.clinigen.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Register extends Base {

	/**
	 * To add the New Patient Registration:To fill the basic details of the patient
	 * To Fill out Gender,YOB,RWD Enrolment
	 * 
	 * @throws Exception
	 */

	@Test()
	public static void addNewPatient() throws Exception {
		driver.findElement(By.cssSelector("button[class='button-primary'][test-id='test_pl_addBtn']")).click();
		driver.findElement(By.cssSelector("form > div:nth-of-type(1)"));
		driver.findElement(By.cssSelector(".multiselect__single")).click();
		driver.findElement(By.cssSelector("ul.multiselect__content>li:nth-of-type(2)>span")).click();
		driver.findElement(By.cssSelector("input.mx-input")).click();
		driver.findElement(By.cssSelector("div.mx-datepicker-popup")).click();
		driver.findElement(By.cssSelector("div.mx-calendar-content")).click();
		driver.findElement(By.cssSelector(".mx-icon-last-year")).click();
		List<WebElement> findElements = driver.findElements(By.cssSelector("div.mx-panel.mx-panel-year"));
		//// To Choose the YOB using for each loop
		for (WebElement e : findElements) {
			System.out.println(e.getText());
			if (e.getText().equals("2015")) {
				e.click();
			}
			driver.findElement(By.cssSelector(".mx-panel.mx-panel-year>span:nth-of-type(6)")).click();
			WebElement ele = driver.findElement(By.cssSelector("span:nth-of-type(2)>.radio-inline>input.scale-input"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ele);
				
			/**
			 * Registration Page Verification through Assertion Resources
			 * 
			 */
			
			if (driver.getTitle().equals("Baseline Plus - Maralixibat")) {
				Assert.assertTrue(true);
				CaptureShotp.Snapshot(driver, "BaseLineRegistrationPage");
			} else {
				Assert.assertTrue(false);
				CaptureShotf.Snapshot(driver, "BaseLineRegistrationPage");
			}

//			 driver.findElement(By.cssSelector("#btnprevious")).click();
//			driver.findElement(By.cssSelector("button[class='button-primary'][test-id='test_mpdb_btn_confirm']")).click();
		}
	}
}
