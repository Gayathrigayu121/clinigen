package com.clinigen.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.MediaEntityBuilder;


public class Login extends Base {
/**
 * To verify the LogIn Page using Assertion Resource
 * @throws Exception
 */
	@Test()
	public static void homePage() throws Exception {

		try {
			Assert.assertEquals(driver.getTitle(), "Cisiv");
			wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.cssSelector("button[class='button-primary'][test-id='test_pl_addBtn']")));
			CaptureShotp.Snapshot(driver, "LoginPage");

		} catch (AssertionError e) {
			Assert.assertTrue(false);
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("invalidCredentialError")));
			boolean status = ele.isDisplayed();
			if (status) {
				driver.getCurrentUrl();
				CaptureShotf.Snapshot(driver, "Invalid Page");
				System.out.println("Invalid Credential");
				Assert.assertTrue(false);
			}
		}
	}
}
