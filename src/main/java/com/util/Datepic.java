package com.util;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Datepic {

	
	
	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		System.out.println(driver);
		driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("https://clin0021.review.cisiv.com");
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//driver.findElement(By.id("c_user_name")).clear();
		driver.findElement(By.id("c_user_name")).sendKeys("clin0021physician@mailinator.com");
		//driver.findElement(By.cssSelector("#c_user_psw")).clear();
		driver.findElement(By.cssSelector("#c_user_psw")).sendKeys("Testing_123");
		driver.findElement(By.cssSelector("#trans_btnSubmit")).click();
		
		
		List<WebElement> findElements = driver.findElements(By.cssSelector(".VueTables__row "));
		List<String> text = new ArrayList<String>();

		int patientSize = findElements.size();
		System.out.println(patientSize);
		for (int i = 0; i < patientSize; i++) {
			text.add(findElements.get(i).getText());
		}
		System.out.println(findElements.get(patientSize - 1).getText());

		//WebElement lastPatient = findElements.get(patientSize - 1);
		findElements.get(patientSize - 1).click();
		

		List<WebElement> findElements1 = driver	.findElements(By.cssSelector(".action-section-list>div.pateint-summary>ul>li.list-group-item"));

		List<String> text1 = new ArrayList<String>();

		int ElementDisplay = findElements1.size();
		for (int i = 0; i < ElementDisplay; i++) {
			text1.add(findElements1.get(i).getText());
			System.out.println(findElements1.get(i).getText());
		}
		

		//WebDriverWait waitq = new WebDriverWait(driver, Duration.ofSeconds(20));
	Thread.sleep(1000);
driver.findElement(By.cssSelector("ul.list-group>li:nth-of-type(4)>div.handle-pointer>div>span.actionTitle")).click(); 
	//Thread.sleep(1000);
	//driver.findElement(By.cssSelector( "div.input-container.select-container>.select>.multiselect>.multiselect__select")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div.mx-input-wrapper>input")).click();
		String text2 = driver.findElement(By.cssSelector(".mx-calendar.mx-calendar-panel-date>div.mx-calendar-header")).getText();
		
		
//		System.out.println(text3);
//		
//		
		String month1=text2.split(" ")[0].trim();
		String year1=text2.split(" ")[1].trim();
		
		
		
		while(!(month1.equals("Feb")&&year1.equals("2020"))) {
			
			 WebElement element = driver.findElement(By.cssSelector(".mx-calendar.mx-calendar-panel-date>div>a.mx-icon-last-month"));
			 element.click();
			  text2= driver.findElement(By.cssSelector(".mx-calendar.mx-calendar-panel-date>div.mx-calendar-header")).getText();
			 System.out.println(text2);
			 month1=text2.split(" ")[0].trim();
			 year1=text2.split(" ")[1].trim();
			
		}
		driver.findElement(By.xpath("(//td[text()='3'])[1]")).click();
		
		
	}
	
	
}
