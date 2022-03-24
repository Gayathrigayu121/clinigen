package com.clinigen.test;
import java.awt.Desktop;
import java.io.File;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Base {
	// Initialisation
	
	public static ChromeDriver driver;
	
	static WebDriverWait wait;
	static String screenshotName;
	
	/**
	 * Browser setup 
	 *  Extent Report Initialisation
	 * @throws Exception 
	 */
	@BeforeSuite()
	public void preConditionSetUp() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
		
		// Extent Report path
	  
      /*
		 * //reporter = new
		 * ExtentReporter("C:\\Users\\admin\\eclipse-workspace\\Clinigen\\Execution Reports\\ExtentReport.html"
		 * ); extent = new ExtentReports(); extent.attachReporter(reporter);
		 */
	
	}

	
	
	
	/**
	 * Login to the HomePage
	 */
	@BeforeTest()
	public static void preCondition() {
		driver.get("https://clin0021.review.cisiv.com");
	    wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		driver.findElement(By.id("c_user_name")).clear();
		driver.findElement(By.id("c_user_name")).sendKeys("clin0021physician@mailinator.com");
		driver.findElement(By.cssSelector("#c_user_psw")).clear();
		driver.findElement(By.cssSelector("#c_user_psw")).sendKeys("Testing_123");
		driver.findElement(By.cssSelector("#trans_btnSubmit")).click();
		
	}


	/**
	 * TestNG Listener which creates html reports from the given test results
	 * A test result is described by an Assertion resource.
	 * @param result :To invoke a collection of test methods.
	 * 
	 * @throws Exception
	 */
	@AfterMethod
	public void getStatus(ITestResult result) throws Exception {

		if (ITestResult.FAILURE == result.getStatus()) {
			
		} else if (ITestResult.SUCCESS == result.getStatus()) {
		} else {
			

		}
	}

	
	
	/**
	 * To Write the changes in the File
	 * @throws Throwable 
	 */
	@AfterTest
	public void close() throws Throwable {
		
	}
	
	
	
/**
 * To quit the Browser
 */
	@AfterSuite()
	public void quit() {
		//driver.quit();
	}

}